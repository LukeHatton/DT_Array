package com.workpro.sorted;

import org.junit.Test;

/**
 * 插入排序算法:从小到大排序
 *
 * @author lizhao
 * @date Created in 2018/2/7
 */
public class InsertSort extends ToBeSorted {

    @Test
    public void test01() {
        int count = 0;
        /**
         * 选择一个数据项标记,将这个数据项与左侧数据依次比较,
         * 如果左侧数据大于被标记的数据,则右移1,被标记项插入
         * 移动后空出来的位置,否则将其赋予被标记项的值,即,将
         * 被标记项插入这个位置
         */
        for (int out = 1; out < arr.length; out++) {
            int value = arr[out];
            for (int in = out - 1; in >= 0; in--) {
                if (arr[in] > value) {
                    arr[in + 1] = arr[in];
                    arr[in] = value;
                    count++;
                }
            }
        }
        showArr();
        System.out.println("算法执行次数: " + count);
    }
}
