package com.workpro.recursive;

/**
 * 测试递归算法:三角数字
 *
 * @author lizhao
 * @date Created in 2018/2/28
 */
public class RecurisiveTest {

    /**
     * 递归调用自身
     *
     * @param n
     * @return
     */
    public static int triangle(int n) {
        if (n > 0) {
            return n + triangle(n - 1);
        } else
            return n;
    }

    public static void main(String[] args) {
        int n = triangle(5);
        System.out.println(n);
    }
}
