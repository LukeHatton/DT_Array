package com.workpro.sorted;

import org.junit.Test;

/**
 * 测试冒泡排序算法:
 * 将数组中所有相邻的数据项依次比较,将较小/较大的放在左边,
 * 将较大/较小的放在右边,向右进一,比较上次比较过程后捡出的较
 * 大/较小者和它右边的数据项,直到遍历完数组.
 */
public class BubbleSort extends ToBeSorted {

    @Test
    public void test01() {
        int count = 0;
        int in, out;
        for (out = arr.length - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[out]) {
                    swap(in, out);
                    count++;
                }
            }
        }
        showArr();
        System.out.println("算法执行次数: " + count);
    }


}
