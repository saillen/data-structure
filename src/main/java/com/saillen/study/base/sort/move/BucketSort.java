package com.saillen.study.base.sort.move;

import com.saillen.algorithms.base.sort.ISortAbility;

/**
 * 桶排序(hash排序),是一种不基于比较的排序算法<br>
 * 桶排序利用一个hash函数将待排序元素分布到一个桶列表中<br>
 * hash函数能保证桶具有如下特性:
 * <ul>
 * <li>1. 左边桶中元素小于右边的桶的元素</li>
 * <li>2. 桶内元素尽量均匀分布</li>
 * </ul>
 * <p>
 * 桶排序的思路:
 * <ul>
 * <li>1. 遍历元素,使用hash函数将元素放入桶中</li>
 * <li>2. 导出桶内元素到数组中,桶内元素多余一个时导出时要使用插入排序对桶内元素做排序</li>
 * </ul>
 * <p>
 * 最坏时间复杂度:O(n^2),桶排序适合[0,1)范围内的浮点数排序,[0,1)内浮点数的hash函数比较容易设计而且效率比较高
 *
 * @author : qiesai
 * @date : 2019/1/10
 */
public class BucketSort<T extends Comparable> implements ISortAbility<T> {

	@Override
	public T[] sort(T[] src) {
		sortPointers(src, src.length);
		return src;
	}

	private void sortPointers(T[] arr, int arrSize) {
		// 初始化桶数组
		Bucket[] buckets = initBuckets(arrSize);
		int bucketSize = buckets.length;

		// 遍历待排序数组填充桶数组
		for (int i = 0; i < arrSize; i++) {
			// 计算元素要放的桶内下标
			int idx = bucketHash(arr[i], bucketSize);
			Entry ele = new Entry(arr[i]);
			Bucket bucket = buckets[idx];

			if (bucket == null) {
				bucket = new Bucket();
				buckets[idx] = bucket;
			}

			// 将元素放入桶中,桶内维护一个链表
			if (bucket.head == null) {
				bucket.head = ele;
			} else {
				ele.next = bucket.head;
				bucket.head = ele;
			}
			// 增加桶长度计数
			bucket.size++;
		}

		// 导出桶内元素
		extract(buckets, arr, arrSize);
	}

	private void extract(Bucket<T>[] buckets, T[] arr, int len) {
		// 表示当前插入的元素数量
		int idx = 0;

		int bucketLen = buckets.length;
		// 遍历桶内元素
		for (int i = 0; i < bucketLen; i++) {
			Bucket<T> bucket = buckets[i];

			// 空桶
			if (bucket == null || bucket.size == 0) {
				continue;
			}

			// 单一元素桶,不需要比较排序
			Entry<T> ptr = bucket.head;
			if (bucket.size == 1) {
				arr[idx++] = ptr.value;
				continue;
			}

			// 桶内有多个元素,执行插入排序
			int beginIdx = idx;
			arr[idx] = ptr.value;
			ptr = ptr.next;

			// 遍历链表
			// while(i < len) for(int i = 0 ; i < len ; i++)
			while (ptr != null) {
				// idx是插入范围的末尾索引(指针)
				int j = idx;
				// 遍历已经排序好的arr[beginIdx,idx]
				// for(int j = idx ; j>= beginIdx; j--)
				// if(less) arr[j++] = arr[j]
				//
				while (j >= beginIdx && arr[j].compareTo(ptr.value) >= 0) {
					arr[j++] = arr[j];
					j--;
				}
				// j的位置就是要插入的元素位置
				arr[j] = ptr.value;
				ptr = ptr.next;
				idx++;
			}

		}

	}

	/**
	 * 核心是这里,hash函数要求满足:如果 ai < aj 那么 hash(ai) < hash(aj)
	 */
	private int bucketHash(T t, int bucketSize) {
		if (t instanceof Float) {

		}
		throw new IllegalArgumentException("仅支持浮点数排序,且浮点数范围在[0,1)之间");
	}

	/**
	 * 使用给定的size初始化桶列表
	 */
	private Bucket<T>[] initBuckets(int n) {
		return new Bucket[n];
	}

	static class Bucket<T> {
		int size;
		Entry<T> head;
	}

	static class Entry<T> {
		T value;
		Entry<T> next;

		public Entry(T value) {
			this.value = value;
		}
	}

}
