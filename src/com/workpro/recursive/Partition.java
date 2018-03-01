package com.workpro.recursive;

/**
 * 划分算法
 *
 * @author lizhao
 * @date Created in 2018/3/1
 */
public class Partition {
    //初始化数组
    private static int[] arr = new int[]{149, 192, 47, 152, 159, 195, 64, 66, 17, 167, 118, 64, 27, 80, 30, 105};

    /**
     * 交换数组数据项
     *
     * @param index1
     *         下标1
     * @param index2
     *         下标2
     */
    public static void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 划分数组.左边为小于枢纽值的数据项,右边为大于枢纽值的数据项
     *
     * @param left
     *         左指针起始位置
     * @param right
     *         右指针起始位置
     * @param pivot
     *         枢纽值
     */
    public static void partitionIt(int left, int right, int pivot) {
        //左端指针.必须先减1,因为在下面的算法执行之前会先加1
        int leftPtr = left - 1;
        //右端指针.必须先加1,因为在下面的算法执行之前会先减1
        int rightPtr = right + 1;
        while (true) {
            //当左指针小于右边界,且数据项的值小于枢纽值时,什么都不做
            //换句话说,当以下两个while循环跳出循环时,说明遇到了需要交换的数据项
            while (leftPtr < right && arr[++leftPtr] < pivot) ;
            //当右指针大于左边界,且数据项的值大于枢纽值时,什么都不做
            while (rightPtr > left && arr[--rightPtr] > pivot) ;
            //当左指针大于等于右指针时,跳出循环
            //使用这个判断,保证了左右指针不会遍历整个数组
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
    }

    public static void main(String[] args) {
        partitionIt(0, arr.length - 1, 99);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }
}
