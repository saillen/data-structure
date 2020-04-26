package com.saillen.study.base.search;

/**
 * 折半搜索,O(log n)的性能,要求数组为排序数组,需要维护数组的有序性,可使用二叉树优化存储
 * <p>
 * <ul>
 * <li>1. 从 (high -low) /2 的位置开始比较元素</li>
 * <li>2. 元素为目标元素则终止查找</li>
 * <li>3. 元素比目标元素小则low变为 low重新计算mid位置查找</li>
 * <li>4. 元素比目标元素大则high设定为mid位置,重新查找</li>
 * </ul>
 * 每次<br>
 *
 * @author : qiesai
 * @date : 2019/1/11
 */
public class BinarySearch<T extends Comparable> implements ISearchAbility<T> {

    @Override
    public int search(T[] arr, T global) {
        int low = 0, high = arr.length;

        while(low <= high) {
            //找到中间位置
            int mid = (high + low) / 2;
            int rs = arr[mid].compareTo(global);
            if(rs == 0) {
                return mid;
            } else if(rs > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // -idx就是元素应该被插入的位置
        // return -(low + 1);
        return -1;
    }
}
