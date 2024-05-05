package com.sumit.datastructures.j_recursion.e_arrays;

public class Array6_LastIndex {

    // Question: Find last index of target in arr.

    public int findLastIndex(int[] arr, int target){
        return findLastIndexHelper(arr,0, target);
    }

    private int findLastIndexHelper(int[] arr, int index, int target){
        if(index == arr.length)
            return -1;

        if(arr[index] == target)
            return Math.max(index, findLastIndexHelper(arr, index+1, target));
        else
            return Math.max(-1, findLastIndexHelper(arr, index+1, target));
    }


    public static void main(String[] args) {
        Array6_LastIndex obj = new Array6_LastIndex();

        System.out.println(obj.findLastIndex(new int[]{5, 3, 5, 5, 6, 13, 41}, 5));
        System.out.println(obj.findLastIndex(new int[]{-5, 3, 5, 5, 6, 13, 41}, 5));
        System.out.println(obj.findLastIndex(new int[]{34, -23, -16, -14, -13, -5, -1}, 23));
        System.out.println(obj.findLastIndex(new int[]{-34, -23, -16, -14, -13, -5, -1}, -34));
   }

}