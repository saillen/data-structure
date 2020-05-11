package com.saillen.study.algorithm.sorted;

/**
 * @author : qiesai
 * @date : 2019/1/9
 */
public interface ISortAbility<T extends Comparable> {

	/**
	 * 待排序数组,返回排序好的数组元素
	 * 
	 * @param src
	 *            待排序数组
	 * @return 排序好的元素
	 */
	T[] sort(T[] src);

}
