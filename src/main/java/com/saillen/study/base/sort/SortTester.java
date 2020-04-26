package com.saillen.study.base.sort;

import com.saillen.algorithms.base.sort.move.BucketSort;
import com.saillen.algorithms.base.sort.move.HeapSort;
import com.saillen.algorithms.base.sort.move.InsertSort;
import com.saillen.algorithms.base.sort.move.QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : qiesai
 * @date : 2019/1/9
 */
public class SortTester {

	public static void main(String[] args) {
		// insertSortTest();
		// heapSortTest();
        //quickSortTest();
        bucketSortTest();
	}

	private static void insertSortTest() {
		Integer[] array = genArray(10);
		log("排序前: ", array);

		InsertSort<Integer> sorter = new InsertSort<>();
		Integer[] after = sorter.sort(array);
		log("排序后: ", after);
	}

	private static void heapSortTest() {
		Integer[] array = genArray(10);
		log("排序前: ", array);
		HeapSort<Integer> sorter = new HeapSort<>();
		Integer[] after = sorter.sort(array);
		log("排序后: ", after);
	}

	private static void quickSortTest(){
		Integer[] array = genArray(10);
		log("排序前: ", array);
		QuickSort<Integer> sorter = new QuickSort<>();
		Integer[] after = sorter.sort(array);
		log("排序后: ", after);
	}

    private static void bucketSortTest(){
        Integer[] array = genArray(10);
        log("排序前: ", array);
        BucketSort<Integer> sorter = new BucketSort<>();
        Integer[] after = sorter.sort(array);
        log("排序后: ", after);
    }

	private static void log(String pre, Integer[] array) {
		System.out.println(pre + Arrays.toString(array));
	}

	private static Integer[] genArray(int size) {
		return genArray(size, 100);
	}

	private static Integer[] genArray(int size, int randomSize) {
		Integer[] array = new Integer[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(randomSize);
		}
		return array;
	}
}
