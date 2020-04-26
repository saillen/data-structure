package com.saillen.study.base.search;

/**
 * 顺序搜索,采用暴力思想,遍历数组<br>
 * O(n)
 *
 * 对数组无要求,无排序维护成本
 *
 * @author : qiesai
 * @date : 2019/1/11
 */
public class SequentialSearch<T extends Comparable> implements ISearchAbility<T> {

	@Override
	public int search(T[] arr, T global) {
		int idx = 0;
		for (T t : arr) {
			if (t.equals(global)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
}
