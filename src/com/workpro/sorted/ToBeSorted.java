package com.workpro.sorted;

/**
 * 提供被排序的数组,并提供一些基础方法
 *
 * @author lizhao
 */
public abstract class ToBeSorted {

    protected static int[] arr = {2, 5, 65, 72, 31, 21, 3213, 55, 872, 1};

    /**
     * @param i 被交换的索引1
     * @param j 被交换的索引2
     */
    public static void swap(int i, int j) {
        int m;
        m = arr[i];
        arr[i] = arr[j];
        arr[j] = m;
    }

    public static void showArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("数组的第" + i + "个元素为: " + arr[i]);
        }
    }
}
