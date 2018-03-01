package com.workpro.recursive;

/**
 * 使用递归算法实现二分法查找
 *
 * @author lizhao
 * @date Created in 2018/2/28
 */
public class RecursiveBisection {
    private static int[] arr = new int[100];

    //静态代码块在静态变量加载后执行
    static {
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
    }

    /**
     * 递归法实现二分查找
     *
     * @param value
     *         要查找的值
     * @param upperBound
     *         数组上界
     * @param lowerBound
     *         数组下界
     * @return
     */
    public static int findBisection(int value, int upperBound, int lowerBound) {
        int current = (upperBound + lowerBound) / 2;
        //找到了
        if (arr[current] == value) {
            return current;
        } else if (lowerBound > upperBound) {   //没找到
            return -1;
        } else {
            if (value < arr[current]) {         //查找的值在数组的下半部分
                return findBisection(value, current - 1, lowerBound);
            } else {                            //查找的值在数组的上半部分
                return findBisection(value, upperBound, current + 1);
            }
        }
    }

    public static void main(String[] args) {
        int i = findBisection(23, arr.length - 1, 0);
        System.out.println("值为" + i + "的数字在数组中的下表为:" + i);
    }
}