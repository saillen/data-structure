package com.saillen.study.algorithm.sorted.move;

import com.saillen.study.algorithm.sorted.ISortAbility;

/**
 * 快速排序:基于分治思想的排序算法,与贪心算法不同,快速排序能获得较好的性能<br>
 * 快速排序的思路是在待排序数组A中选取一个中位数,将A切分为两个子数组,中位数左边的值都比它小,右边的都比它大,然后递归的排序两个子数组<br>
 * 算法描述可以如下:<br>
 * <ul>
 * <li>1. 采用中位数(pivot)选择策略选取一个切割数(实时证明随机数的性能最好)</li>
 * <li>2. 将所以比中位数小的元素移到数组前端(pivot left)</li>
 * <li>3. 将所以别中位数大的元素移动到数组末端(pivot right)</li>
 * <li>4. 递归的针对left array和right array调用算法</li>
 * </ul>
 * 
 * 算法的优化:
 * <ul>
 * <li>1. 采用更好的策略选择中位数,中位数的选取决定了快速排序的性能,极端情况下为O(n^2)</li>
 * <li>2. 设定minSize,当数组长度小于minSize变换排序策略为插入排序(小数组插入排序性能比较好),JDK 1.8设定为7</li>
 * <li>3. 使用栈消除递归调用(递归的现场保存成本较高)</li>
 * <li>4. 优先处理小数组</li>
 * </ul>
 *
 * 内观排序:
 * <ul>
 * <li>1. 对于快速排序的优化不仅限于使用插入排序算法</li>
 * <li>2. 快速排序的递归会成为性能瓶颈,内观排序观察递归排序的栈深度如果超过log(n)那么就切换到堆排序中</li>
 * </ul>
 *
 * @author : qiesai
 * @date : 2019/1/10
 */
public class QuickSort<T extends Comparable> implements ISortAbility<T> {

	public static final int MIN_SIZE = 7;

	private InsertSort insertion = new InsertSort();

	@Override
	public T[] sort(T[] src) {
		if (src == null || src.length < 2) {
			return src;
		}
		// 这里就选择第一个作为中枢值
		qsort(src, 0, src.length - 1);
		return src;
	}

	/**
	 * partition方法保证的是快速排序的数组特性,真正的递归在这个函数中<br>
	 * 采用一个小优化手段
	 */
	private void qsort(T[] arr, int left, int right) {
		if (right <= left) {
			return;
		}

		// 使用策略选择一个中位数
		int pivotIdx = selectPivotIdx(arr, left, right);
		pivotIdx = partition(arr, left, right, pivotIdx);
		//
		int leftArrMaxIdx = pivotIdx - 1;
		int rightArrMinIdx = pivotIdx + 1;

		qsort(arr, left, leftArrMaxIdx);
		qsort(arr, rightArrMinIdx, right);
	}

	private int selectPivotIdx(T[] arr, int left, int right) {
		int idx = (right - left) / 2 + left;
		return idx > right ? right : idx;
	}

	/**
	 * 这个是算法的核心,方法将给定的函数和中枢值区分开,<br>
	 * 方法保证arr[left,pivotIdx)的元素都比<br>
	 * arr[pivotIdx]小,arr(pivotIdx,right]的元素都比arr[pivotIdx]大<br>
	 * 
	 */
	private int partition(T[] arr, int left, int right, int pivotIdx) {

		// 中述职移动到末尾
		T pivot = arr[pivotIdx];
		arr[pivotIdx] = arr[right];
		arr[right] = pivot;

		// 精髓1:建立一个final index,记录最终中枢值应该移动回来的位置
		int pivotFinal = left;

		for (int i = left; i < right; i++) {
			// 如果元素比中枢值小则往前移动
			// 这里优化异步,如果i的位置就是
			// 这里要注意,当大量的和中枢值元素相同的元素存在的时候会让left和right数组不平衡
			// 减少这种不平衡的的方案:可以轮流的将等于中枢值的元素插入到left和right两个数组中
			if (arr[i].compareTo(pivot) <= 0) {
				if (i != pivotFinal) {// 这里优化一步,如果i和pivotFinal指向了同一个位置则不需要做一遍交换
					T tmp = arr[i];
					arr[i] = arr[pivotFinal];
					arr[pivotFinal] = tmp;
				}
				pivotFinal++;
			}
		}

		// 记得最后将中枢值放到它改防的地方
		// 前面的for循环会保证 pivotFinal指向的位置会比pivot大或者就是pivot
		if (pivotFinal != right) {
			T tmp = arr[pivotFinal];
			arr[pivotFinal] = arr[right];
			arr[right] = tmp;
		}

		return pivotFinal;
	}

}
