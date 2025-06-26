package org.yzpang.chapter03.list;

import org.yzpang.chapter03.coll.CustomCollection;

/**
 * 线性表接口
 */
public interface CustomList<AnyType> extends CustomCollection<AnyType> {
    /**
     * 返回指定索引处的元素
     * @param index 索引 0~size-1
     * @return 元素值
     */
    AnyType get(int index);

    /**
     * 设置指定索引的元素值
     * @param index 索引
     * @param value 元素
     */
    void set(int index, AnyType value);

    /**
     * 移除指定索引处的元素
     * @param index 索引
     */
    void remove(int index);

    /**
     * 在指定索引处添加元素
     * @param index 索引
     * @param value 元素
     */
    void add(int index, AnyType value);

    /**
     * 生成列表遍历器
     * @return 列表遍历器
     */
    ListIterator<AnyType> listIterator();
}
