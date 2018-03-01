package com.workpro.recursive;

/**
 * 归并排序
 *
 * @author lizhao
 * @date Created in 2018/2/28
 */
public class Merge {
    private static int[] a = {23, 47, 81, 95};
    private static int[] b = {7, 14, 39, 55, 62, 74};

    /**
     * 将两个从小到大排列的有序数组归并成一个新的从小到大排列的有序数组
     *
     * @param res1
     * @param res2
     */
    public static int[] merge(int[] res1, int[] res2) {
        //目标数组
        int[] target = new int[res1.length + res2.length];
        int index1 = 0;     //源数组1索引
        int index2 = 0;     //源数组2索引
        int index3 = 0;     //目标数组索引
        //两个数组都没有完成遍历,则执行循环
        while (index1 < res1.length && index2 < res2.length) {
            if (res1[index1] < res2[index2]) {
                target[index3++] = res1[index1++];
            } else {
                target[index3++] = res2[index2++];
            }
        }
        //当数组res1还有剩余值
        while (index1 < res1.length) {
            target[index3++] = res1[index1++];
        }
        //当数组res2还有剩余值
        while (index2 < res2.length) {
            target[index3++] = res2[index2++];
        }
        return target;
    }

    public static void main(String[] args) {
        int[] dest = merge(a, b);
        for (int i : dest) {
            System.out.println(i);
        }
    }

}
