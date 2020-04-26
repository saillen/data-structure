package com.saillen.study.base.sort.move;

import com.saillen.algorithms.base.sort.ISortAbility;

/**
 * 插入排序,移位排序里面性能相对来说最好的一种排序<br>
 * 最坏O(n2),最好和平均O(n)<br>
 * 思路:遍历待排序元素,将未排序元素A[i],插入到{0,A[i-1]}个已经排序好的元素中<br>
 * 
 * @author : qiesai
 * @date : 2019/1/9
 */
public class InsertSort<T extends Comparable> implements ISortAbility<T> {

	public T[] sort(T[] src) {
		if (src == null || src.length <= 2) {
			return src;
		}

		int len = src.length;
		for (int i = 1; i < len; i++) {
			insert(src, i, src[i]);
		}
		return src;
	}

	/**
	 * 这个方法是核心关键,给定已经排序好的部分,为了避免空间浪费,我们不会再创建一个数组<br>
	 * 我们将原来数据和已经排序好的位置i传入,表示array[0]-array[pos-1]是已经排序好的<br>
	 * array[pos]是n,算法思路:
	 * <ul>
	 * <li>依次比较n和array[i],找到合适的n的位置i</li>
	 * <li>将n放到i的位置</li>
	 * <li>将后面的元素王侯移动一位: {array[i+1] - array[pos-1]} copy到 {array[i+2] -
	 * array[pos]}</li>
	 * <li>将原来的array[i]元素放到array[i+1]</li>
	 * </ul>
	 */
	private void insert(T[] sortedArray, int pos, T n) {
		for (int i = 0; i < pos; i++) {
			T n1 = sortedArray[i];
			if (isSmaller(n, n1)) {
				// 将元素插入进去,并移动后面的元素
				// 移动完成后将被替换的元素放到后面一格
				sortedArray[i] = n;
				// 用jdk提供的原生API效率更高
				// System.arraycopy(sortedArray, i, sortedArray, i + 2, pos -
				// i);
				for (int j = pos; j > i; j--) {
					sortedArray[j] = sortedArray[j - 1];
				}
				sortedArray[i + 1] = n1;
				// 一定要记得跳出循环,否则还会继续判断n的位置
				break;
			}
		}
	}

	/**
	 * 这个的代码更简洁,思路不变:<br>
	 * <ul>
	 * <li>1.从后往前</li>
	 * </ul>
	 */
	public T[] sort2(T[] arr) {

		int len = arr.length;
		for (int j = 1; j < len; j++) {
			int i = j - 1;
			T value = arr[j];
			// 从后往前找n的位置,两个停止条件,n的位置合适了或者i到最前面了
            // 这个移动过程中
			while (i >= 0 && isSmaller(value, arr[i])) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = value;
		}
		return arr;
	}

	private boolean isSmaller(T x1, T x2) {
		return x2.compareTo(x1) > 0;
	}

}
