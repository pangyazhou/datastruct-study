package org.yzpang.chapter03.list;

import java.util.Iterator;

/**
 * @desc
 * @author pangy
 * @date 2025/6/26 23:59
 */
public interface ListIterator<AnyType> extends Iterator<AnyType> {
    /**
     * 判定是否有前驱
     * @return 如果迭代有前驱, 返回 true
     */
    boolean hasPrevious();

    /**
     * 返回前驱
     * @return 迭代的前驱
     */
    AnyType previous();

    /**
     * 当前位置添加元素
     * @param element 插入列表的元素
     */
    void add(AnyType element);

    /**
     * 更新当前位置的元素
     * @param element 更新的元素
     */
    void set(AnyType element);
}
