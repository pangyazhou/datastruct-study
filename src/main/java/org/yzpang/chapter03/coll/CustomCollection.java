package org.yzpang.chapter03.coll;

import java.util.Iterator;

/**
 * 集合接口
 */
public interface CustomCollection<AnyType> extends Iterable<AnyType> {
    /**
     * 集合大小
     * @return size
     */
    int size();

    /**
     * 集合是否为空
     * @return true/false
     */
    boolean isEmpty();

    /**
     * 清空集合
     */
    void clear();

    /**
     * 判断集合包含指定元素
     * @param element 指定元素
     * @return 包含结果
     */
    boolean contains(AnyType element);

    /**
     * 添加元素
     * @param element 元素
     * @return 添加结果
     */
    boolean add(AnyType element);

    /**
     * 移除元素
     * @param element 元素
     * @return 移除结果
     */
    boolean remove(AnyType element);

    /**
     * 生成集合元素遍历器
     * @return 遍历器
     */
    Iterator<AnyType> iterator();
}
