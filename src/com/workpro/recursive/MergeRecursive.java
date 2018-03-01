package com.workpro.recursive;

import java.util.Arrays;

/**
 * 测试递归算法:归并排序(从小到大)
 *
 * @author lizhao
 * @date Created in 2018/2/28
 */
public class MergeRecursive {

    private static int[] arr = new int[100];

    //使用静态代码块初始化数组
    static {
        for (int i = 99; i >= 0; i--) {
            arr[99 - i] = i;
        }
    }

    /**
     * 切分并归并数组.使用分治算法
     *
     * @param workspace
     *         工作空间.用来临时存储静态变量arr经过排序后有序的部分
     * @param lowerBound
     *         子数组下界
     * @param upperBound
     *         子数组上界
     * @return
     */
    public static void divideAndMerge(int[] workspace, int lowerBound, int upperBound) {
        //如果上界等于下界,说明子数组只含有一个数据项,不必再切分
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            //切分并归并下半部分
            divideAndMerge(workspace, lowerBound, mid);
            //切分并归并上半部分
            divideAndMerge(workspace, mid + 1, upperBound);
            //完成了切分,归并切分出来的子数组
            merge(workspace, lowerBound, mid + 1, upperBound);
        }
    }

    /**
     * 归并排序子数组
     *
     * @param workspace
     *         工作空间
     * @param lowerBound
     *         下半部分起始下标,同时也是子数组下界
     * @param upperStartPoint
     *         上半部分起始下标
     * @param upperBound
     *         上半部分结束下标,同时也是子数组上界
     */
    public static void merge(int[] workspace, int lowerBound, int upperStartPoint, int upperBound) {
        //中间点,即下半部分的上界
        int mid = upperStartPoint - 1;
        //下半部分子数组的下标
        int index1 = lowerBound;
        //上半部分子数组的下标
        int index2 = upperStartPoint;
        //workspace的临时下标
        int tempIndex = 0;
        //两边数组都有剩余值
        while (index1 <= mid && index2 <= upperBound) {
            if (arr[index1] < arr[index2]) {
                workspace[tempIndex++] = arr[index1++];
            } else {
                workspace[tempIndex++] = arr[index2++];
            }
        }
        //右半部分已遍历完毕,左半部分有剩余
        while (index1 <= mid) {
            workspace[tempIndex++] = arr[index1++];
        }
        //左半部分已遍历完毕,右半部分有剩余
        while (index2 <= upperBound) {
            workspace[tempIndex++] = arr[index2++];
        }
        //将workspace临时数组中的有序数据写回到arr中
        for (int i = 0; i < tempIndex; i++) {
            arr[lowerBound++] = workspace[i];
        }
    }

    public static void main(String[] args) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("****************************");
        //切分并归并数组
        divideAndMerge(new int[arr.length], 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
