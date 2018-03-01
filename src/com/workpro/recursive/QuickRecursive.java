package com.workpro.recursive;

/**
 * 用递归实现快速排序
 *
 * @author lizhao
 * @date Created in 2018/3/1
 */
public class QuickRecursive {
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
     * @return 划分完成后的左指针位置, 即枢纽值的下标
     */
    public static int partitionIt(int left, int right, int pivot) {
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
        /*
         * 为了将枢纽值的数据项放在左子数组和右子数组之间,交换枢纽值数据项与右子数组最左边的数据项
         * 这是因为在快速排序算法中,默认选取子数组右端的值为枢纽值
         */
        swap(leftPtr, right);
        return leftPtr;
    }

    /**
     * 用递归实现快速排序
     *
     * @param left
     *         要排序的数组的左边界
     * @param right
     *         压迫排序的数组的右边界
     */
    public static void recQuickSort(int left, int right) {
        if (left >= right) {
            return;
        } else {
            //选择数组最右边的项作为枢纽
            int pivot = arr[arr.length - 1];
            //把数组或子数组划分成小于关键字的一组和大于关键字的一组
            int partition = partitionIt(left, right, pivot);
            //调用自身对左边进行排序
            recQuickSort(left, partition - 1);
            //调用自身对右边进行排序
            recQuickSort(partition + 1, right);
        }
    }

    public static void main(String[] args) {
        recQuickSort(0, arr.length - 1);
        for(int i : arr){
            System.out.print(i+"  ");
        }
    }
}
