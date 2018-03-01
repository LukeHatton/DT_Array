package com.workpro.recursive;

/**
 * 简单二分法查找
 *
 * @author lizhao
 * @date Created in 2018/2/28
 */
public class Bisection {
    private static int[] arr = new int[100];

    //静态代码块在静态变量加载后执行
    static {
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
    }

    /**
     * 二分法查找
     *
     * @param value
     *         要查找的值
     * @return
     */
    public static int findBisection(int value) {
        //上边界
        int upperBound = arr.length - 1;
        //下边界
        int lowerBound = 0;
        //当前下标
        int current;
        while (true) {
            current = (upperBound + lowerBound) / 2;
            if (arr[current] == value) {            //找到了
                return current;
            } else if (lowerBound > upperBound) {  //没找到
                return -1;
            } else {
                //调整边界
                if (value < arr[current]) {      //下半部分
                    upperBound = current - 1;
                } else {
                    lowerBound = current + 1;       //上半部分
                }
            }
        }
    }

    public static void main(String[] args) {
        int i = findBisection(23);
        System.out.println(i);
    }
}
