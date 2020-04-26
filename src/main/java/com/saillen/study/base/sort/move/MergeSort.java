package com.saillen.study.base.sort.move;

import com.saillen.study.base.sort.ISortAbility;

/**
 * 归并排序,最典型的分治思想的排序算法,快排也算是分治,但是归并的分治更彻底<br>
 * 
 * @author : qiesai
 * @date : 2019/1/11
 */
public class MergeSort<T extends Comparable> implements ISortAbility<T> {
	@Override
	public T[] sort(T[] src) {
		return src;
	}

    private void merger(T[] origin, T[] result, int start, int end){
        int len = end - start;
        if(len == 1){
            return ;
        }else if(len == 2){
            if(result[start].compareTo(result[end]) >= 0){
                T tmp = result[start];
                result[start] = result[end];
                result[end]= tmp;
                return;
            }
        }

        int mid = (start + end) /2;
        merger(origin,result,start,mid);
        merger(origin,result,mid,end);



    }

}
