package com.saillen.study.base.search;

/**
 * @author : qiesai
 * @date : 2019/1/11
 */
public interface ISearchAbility<T extends Comparable> {

    int search(T[] arr, T global);

}
