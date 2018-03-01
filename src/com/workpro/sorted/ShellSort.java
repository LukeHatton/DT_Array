package com.workpro.sorted;

/**
 * 测试希尔排序算法
 *
 * @author lizhao
 * @date Created in 2018/3/1
 */
public class ShellSort {
    private static int[] arr = new int[100];

    static {
        for (int i = 99; i >= 0; i--) {
            arr[99 - i] = i;
        }
    }

    /**
     * 希尔排序:从小到大
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        //增量,初始值为1
        int h = 1;
        //计算最大增量
        while (h <= arr.length / 3) {
            h = h * 3 + 1;//在arr中,h=40
        }
        //进行增量排序
        while (h > 0) {
            //外层循环
            for (int outer = h; outer < arr.length; outer++) {
                //存储被标记的值
                int temp = arr[outer];
                //内层循环起始位置
                int inner = outer;
                //当inner在区间内,且被比较的项大于temp时,执行循环体, 交换数据
                while (inner >= h && arr[inner - h] >= temp) {
                    //当下标为inner的数据项的值大于temp时,将这个数据项后移(因为是从小到大排序)
                    arr[inner] = arr[inner - h];
                    inner = inner - h;
                }
                //插入被标记的值
                arr[inner] = temp;
            }
            //逐渐减小增量
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
