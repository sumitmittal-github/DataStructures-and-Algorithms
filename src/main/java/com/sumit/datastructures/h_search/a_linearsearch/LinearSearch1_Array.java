package com.sumit.datastructures.h_search.a_linearsearch;

public class LinearSearch1_Array {

    public static void main(String[] args) {
        int[] arr = {1,4,7,1,4,9,56,1,0,56774};
        System.out.println(linearSearch(arr, 11));
        System.out.println(linearSearchWithRecursion(arr, 11));
        System.out.println(linearSearchWithRecursion2(arr, 11));


        int[] arr1 = {3, 2, 1, 18, 9};
        System.out.println(linearSearch(arr1, 3));
        System.out.println(linearSearchWithRecursion(arr1, 3));
        System.out.println(linearSearchWithRecursion2(arr1, 3));

        System.out.println(linearSearch(arr1, 0));
        System.out.println(linearSearchWithRecursion(arr1, 0));
        System.out.println(linearSearchWithRecursion2(arr1, 0));

        System.out.println(linearSearch(arr1, 9));
        System.out.println(linearSearchWithRecursion(arr1, 9));
        System.out.println(linearSearchWithRecursion2(arr1, 9));

        System.out.println(linearSearch(arr1, 999));
        System.out.println(linearSearchWithRecursion(arr1, 999));
        System.out.println(linearSearchWithRecursion2(arr1, 999));
    }


    // Way-1 : basic approach
    /*
    * Linear Search : search element in the array,
    * - if element found then return its index,
    * - else return -1
    **/
    public static int linearSearch(int[] arr, int element){
        if(arr == null || arr.length == 0)
            return -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element)
                return i;
        }
        return -1;
    }


    // Way-2 : linear search with recursion
    public static int linearSearchWithRecursion(int[] arr, int target) {
        if(arr == null || arr.length==0)
            return -1;

        return helper(arr, target, 0);
    }

    private static int helper(int[] arr, int target, int currentIndex) {
        if(currentIndex == arr.length)
            return -1;

        if(arr[currentIndex] == target)
            return currentIndex;

        return helper(arr, target, currentIndex+1);
    }



    // Way-3 : linear search with recursion and OR operator
    public static boolean linearSearchWithRecursion2(int[] arr, int target) {
        if(arr == null || arr.length==0)
            return false;

        return helper2(arr, target, 0);
    }

    private static boolean helper2(int[] arr, int target, int currentIndex) {
        if(currentIndex == arr.length)
            return false;

        return ((arr[currentIndex] == target) || helper2(arr, target, currentIndex+1));
    }

}
