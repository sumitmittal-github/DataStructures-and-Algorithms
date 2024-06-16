package com.sumit.datastructures.b_recursion.e_arrays;

public class Array3_Sum {

    // Question: Returning sum of all the elements of an array


    // Approach-1
    public int returnSum(int[] arr){
        return returnSumHelper(arr, 0);
    }

    private int returnSumHelper(int[] arr, int index){
        if(index == arr.length)
            return 0;

        return arr[index] + returnSumHelper(arr, index+1);
    }




    public static void main(String[] args) {
        Array3_Sum obj = new Array3_Sum();

        System.out.println(obj.returnSum(new int[]{1, 5, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnSum(new int[]{1, 15, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnSum(new int[]{111, 5, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnSum(new int[]{-1, -5, -3, -4, -6, -3, -4}));
   }

}