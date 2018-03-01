package com.workpro.sorted;

import org.junit.Test;

/**
 * 测试选择排序算法:
 * 扫描数组,将其中最小/大的一项取出并放到一侧,然后
 * 从那一侧的位置右移,扫描剩余项,再取出最小/大的一
 * 项并放到同一侧,依次遍历数组.
 */
public class SelectSort extends ToBeSorted {

    @Test
    public void test01() {
        int count = 0;
        for (int out = arr.length - 1; out > 0; out--) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int in = 0; in <= out; in++) {
                if (arr[in] > max) {
                    max = arr[in];
                    maxIndex = in;
                    count++;
                }
            }
            swap(maxIndex, out);
        }
        showArr();
        System.out.println("算法执行次数: " + count);
    }
}
