package com.sumit.datastructures.j_recursion.e_arrays;

public class Array5_IsSorted {

    // Question: Check whether given array is sorted or not.

    public boolean isSorted(int[] arr){
        if(arr.length <= 1)
            return true;

        return isSortedHelper(arr,1);
    }

    private boolean isSortedHelper(int[] arr, int index){
        if(index == arr.length)
            return true;

        if(arr[index-1] > arr[index])
            return false;

        return isSortedHelper(arr, index+1);
    }


    public static void main(String[] args) {
        Array5_IsSorted obj = new Array5_IsSorted();

        System.out.println(obj.isSorted(new int[]{5, 3, 5, 5, 6, 13, 41}));
        System.out.println(obj.isSorted(new int[]{-5, 3, 5, 5, 6, 13, 41}));
        System.out.println(obj.isSorted(new int[]{34, -23, -16, -14, -13, -5, -1}));
        System.out.println(obj.isSorted(new int[]{-34, -23, -16, -14, -13, -5, -1}));
   }

}