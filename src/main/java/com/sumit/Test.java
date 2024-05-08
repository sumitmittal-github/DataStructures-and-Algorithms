package com.sumit;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();

    }


    public int maxJump(int[] a) {
        int res = a[1] - a[0], n = a.length;

        for (int i = 2; i < n; i++)
            res = Math.max(res, a[i] - a[i-2]);

        return res;
    }





}