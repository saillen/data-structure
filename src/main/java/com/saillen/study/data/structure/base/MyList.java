package com.saillen.study.data.structure.base;

/**
 * ADT：表一组数据的集合，n[i - 1] 称为 n[i] 的前驱， n[i + 1] 称为 n[i] 的后继；
 *
 * @author saillen
 * @date 2020年3月21日
 */
public interface MyList<T> {

    /**
     * 获取表大小，如果包含的数据超过了 Integer.MAX_VALUE ，那么就返回 Integer.MAX_VALUE
     *
     * @return -1 表示
     */
    int size();

    boolean contains(T t);

    T add(T newData);

    T set(int idx, T newData);

    T remove(int idx);

    T get(int idx);
}
