package com.sumit.datastructures.recursion.b_array;

import java.util.List;
import java.util.ArrayList;

public class Recursion3_LinearSearchWithDuplicates {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 18, 9, 9};
        System.out.println(linearSearch(arr, 3));
        System.out.println(linearSearchWithRecursion(arr, 3));
        System.out.println(linearSearchWithRecursion2(arr, 3));

        System.out.println(linearSearch(arr, 0));
        System.out.println(linearSearchWithRecursion(arr, 0));
        System.out.println(linearSearchWithRecursion2(arr, 0));

        System.out.println(linearSearch(arr, 9));
        System.out.println(linearSearchWithRecursion(arr, 9));
        System.out.println(linearSearchWithRecursion2(arr, 9));

        System.out.println(linearSearch(arr, 999));
        System.out.println(linearSearchWithRecursion(arr, 999));
        System.out.println(linearSearchWithRecursion2(arr, 999));
    }


    // Way-1 : linear search
    private static List<Integer> linearSearch(int[] arr, int target){
        List<Integer> indexes = new ArrayList<>();
        if(arr == null && arr.length == 0)
            return indexes;

        for(int i=0; i < arr.length; i++){
            if(arr[i] == target)
                indexes.add(i);
        }
        return indexes;
    }


    // Way-2 : linear search with Recursion
    private static List<Integer> linearSearchWithRecursion(int[] arr, int target){
        List<Integer> indexes = new ArrayList<>();

        if(arr != null && arr.length > 0) {
            helper(arr, target, indexes, 0);
        }
        return indexes;
    }

    private static void helper(int[] arr, int target, List<Integer> indexes, int currentIndex) {
        if(currentIndex == arr.length)
            return;

        if(arr[currentIndex] == target)
            indexes.add(currentIndex);

        helper(arr, target, indexes, currentIndex+1);
    }


    // Way-2 : linear search with Recursion : without passing list as an argument of helper method
    // NOTE : This is not a good approach because we are creating new list in every recursion call
    //        Just keep this concept in your mind where we are adding result in previous method calls response
    private static List<Integer> linearSearchWithRecursion2(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return new ArrayList<Integer>();

        List<Integer> indexes = helper2(arr, target, 0);
        return indexes;
    }

    private static List<Integer> helper2(int[] arr, int target, int currentIndex) {
        List<Integer> indexes = new ArrayList<>();
        if(currentIndex == arr.length)
            return indexes;

        List<Integer> response = helper2(arr, target, currentIndex+1);

        if(arr[currentIndex] == target) {
            response.add(currentIndex);
        }
        return response;
    }
}