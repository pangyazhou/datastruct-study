package org.yzpang.chapter03.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author pangy
 * @desc 自定义顺序表实现
 * @date 2025/6/27 10:39
 */
public class CustomArrayList<AnyType> implements CustomList<AnyType>{
    // 默认容器大小
    private static final int DEFAULT_CAPACITY = 10;

    // 当前容器元素个数
    private int theSize;

    // 数组
    private AnyType[] items;

    public CustomArrayList() {
        clear();
    }

    @Override
    public AnyType get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    @Override
    public AnyType set(int index, AnyType value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        AnyType old = items[index];
        items[index] = value;
        return old;
    }

    @Override
    public AnyType remove(int index) {
        AnyType removedItem = items[index];

        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        theSize--;

        return removedItem;
    }

    @Override
    public void add(int index, AnyType value) {
        if (items.length == theSize) {
            ensureCapacity(theSize * 2);
        }
        // 从后向前移动数组元素
        for (int i = theSize; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = value;

        theSize++;
    }

    @Override
    public ListIterator<AnyType> listIterator() {
        return null;
    }

    @Override
    public int size() {
        return theSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public boolean contains(AnyType element) {
        return false;
    }

    @Override
    public boolean add(AnyType element) {
        add(size(), element);
        return true;
    }

    @Override
    public boolean remove(AnyType element) {
        return false;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 扩展容器容量
     * newCapacity 小于现有容量,不变.
     * newCapacity 大于现有容量,创建新数组,大小为newCapacity,将老数组复制到新数组
     * @param newCapacity 新数组大小
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) {
            return;
        }
        AnyType[] oldItems = items;
        items = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = oldItems[i];
        }
    }

    private class ArrayListIterator implements ListIterator<AnyType> {
        // 当前迭代位置
        private int current;

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public AnyType previous() {
            return null;
        }

        @Override
        public void add(AnyType element) {

        }

        @Override
        public void set(AnyType element) {

        }

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            CustomArrayList.this.remove(--current);
        }
    }

}
