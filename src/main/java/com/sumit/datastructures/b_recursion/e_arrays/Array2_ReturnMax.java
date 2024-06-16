package com.sumit.datastructures.b_recursion.e_arrays;

public class Array2_ReturnMax {

    // Question: Returning max value from an array


    // Approach-1
    public int returnMax_1(int[] arr){
        return returnMaxHelper_1(arr, 0, Integer.MIN_VALUE);
    }

    private int returnMaxHelper_1(int[] arr, int index, int max){
        if(index == arr.length)
            return max;

        max = Math.max(max, arr[index]);
        /*      OR
        if(arr[index] > max)
            max = arr[index];
        */
        return returnMaxHelper_1(arr, index+1, max);
    }


    // Approach-2
    public int returnMax_2(int[] arr) {
        return returnMaxHelper_2(arr, 0);
    }

    private int returnMaxHelper_2(int[] arr, int index){
        if(index == arr.length-1)
            return arr[arr.length-1];

        return Math.max(arr[index], returnMaxHelper_2(arr, index+1));
    }



    public static void main(String[] args) {
        Array2_ReturnMax obj = new Array2_ReturnMax();

        System.out.println(obj.returnMax_1(new int[]{1, 5, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnMax_2(new int[]{1, 5, 3, 4, 6, 3, 4}));

        System.out.println(obj.returnMax_1(new int[]{1, 15, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnMax_2(new int[]{1, 15, 3, 4, 6, 3, 4}));

        System.out.println(obj.returnMax_1(new int[]{111, 5, 3, 4, 6, 3, 4}));
        System.out.println(obj.returnMax_2(new int[]{111, 5, 3, 4, 6, 3, 4}));

        System.out.println(obj.returnMax_1(new int[]{-1, -5, -3, -4, -6, -3, -4}));
        System.out.println(obj.returnMax_2(new int[]{-1, -5, -3, -4, -6, -3, -4}));
    }

}