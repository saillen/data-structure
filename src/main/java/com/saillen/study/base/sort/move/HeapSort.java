package com.saillen.study.base.sort.move;

import com.saillen.algorithms.base.sort.ISortAbility;

/**
 * 堆排序,属于移位排序的一种<br>
 * 传递的移位排序(插入排序,冒泡排序,选择排序)都需要将元素依次和其他元素比较,一般都是O(n2)的性能<br>
 * 堆排序合理利用堆的特性,降低元素比较次数,时间复杂度O(logn)<br>
 * 堆排序的难点要理解堆这种数据结构<br>
 * 堆:<br>
 * <ul>
 * <li>1. 它是一颗二叉树,但不要求为满二叉树</li>
 * <li>2. 根的深度为0,当且仅当k-1的节点上存在2的k-1次方个节点时,深度k上才会存在叶子节点</li>
 * <li>3. 深度k的节点填充上,是从左到右填充的</li>
 * <li>4. 树中每个节点的值都大于它的两个子节点的值</li>
 * </ul>
 *
 * 堆构建的前提:<br>
 * <ul>
 * <li>1. 对数组使用堆排序,为了避免空间浪费,我们不会再维护一个堆数组或使用链表来存储堆,而是在原数组上操作</li>
 * <li>2. 堆的外形性质使堆可以按照如下规则保存在一个array中:</li>
 * <li>2.1 索引为i的节点,其两个子节点的索引分别为:2i+1和2i+2</li>
 * <li>2.2 堆构建的核心是维持以A[i]为根的节点后面的数组构成一个合法堆,即 A[i,max)是合法堆</li>
 * </ul>
 *
 * 堆的构建过程:<br>
 * <ul>
 * <li>1. 从数组的中间位置开始向前遍历数组</li>
 * </ul>
 *
 * 
 * @author : qiesai
 * @date : 2019/1/9
 */
public class HeapSort<T extends Comparable> implements ISortAbility<T> {

	@Override
	public T[] sort(T[] src) {
		buildHeap(src);
		// 针对已经构建好的堆,将顶端元素和末尾元素交互并重新调整堆
		int len = src.length;
		for (int i = len - 1; i >= 0; i--) {
			T tmp = src[i];
			src[i] = src[0];
			src[0] = tmp;
			// 对于一个最初已经合法的堆来说,从0调整并不影响后续调整
			heapify(src, 0, i);
		}
		return src;
	}

	/**
	 * 构建堆,构建的过程就是选择合适的位置开始调整堆<br>
	 * <ul>
	 * <li>1.
	 * 从0开始构堆,假设A[0,1,2]是个合法堆,但是如果对A[1,3,4]这个堆做调整后,A[0,1,2]可能就非法了,这个时候每一次的堆调整都要从0开始重新调整,这种效率很低;</li>
	 * <li>2. 合理的做法是从后往前构建堆,这样能够避免已经调整成功的堆再次被调整</li>
	 * <li>2. 根据堆的性质,一个n个元素的堆,其深度为:logN + 1,叶子节点数量在2^m + 1个,</li>
	 * </ul>
	 */
	public void buildHeap(T[] arr) {
		int len = arr.length;
		// for (int i = len - 1; i >= 0; i--) {
		// heapify(arr, i, len);
		// }
		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(arr, i, len);
		}
	}

	/**
	 * 核心方法,调用这个方法保证arr[idx,max)是一个合法的堆<br/>
	 * 这里先给出简单的递归实现<br>
	 */
	public void heapify(T[] arr, int idx, int max) {
		// largest 最开始默认就是idx的位置
		int largest = idx;

		int left = 2 * largest + 1;
		int right = 2 * largest + 2;

		// left的位置合法,并且left的值大于根
		if (left < max && arr[left].compareTo(arr[largest]) > 0) {
			largest = left;
		}

		// right的位置合法,并且right的值大于根(or left)
		if (right < max && arr[right].compareTo(arr[largest]) > 0) {
			largest = right;
		}

		// 需要调整下
		if (largest != idx) {
			T tmp = arr[largest];
			arr[largest] = arr[idx];
			arr[idx] = tmp;
			// 调整完根后要递归的调整下后面的数组
			heapify(arr, largest, max);
		}
		// 如果没有调整,则表示这个根是合法的
	}

}
