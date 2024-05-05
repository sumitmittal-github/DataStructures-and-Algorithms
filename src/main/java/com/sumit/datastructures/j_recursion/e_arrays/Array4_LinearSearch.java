package com.sumit.datastructures.j_recursion.e_arrays;

import java.util.ArrayList;

public class Array4_LinearSearch {

    // Question: Given an array of n integers and a target value x. Print whether x exists in the array or not.


    // Question-1 : search
    public boolean search(int[] arr, int target){
        return searchHelper(arr,0, target);
    }

    private boolean searchHelper(int[] arr, int index, int target){
        if(index == arr.length)
            return false;

        if(arr[index] == target)
            return true;

        return searchHelper(arr, index+1, target);
    }



    // Question-2 : search, if exists return index, else return -1
    public int searchAndGetIndex(int[] arr, int target){
        return searchAndGetIndexHelper(arr,0, target);
    }

    private int searchAndGetIndexHelper(int[] arr, int index, int target){
        if(index == arr.length)
            return -1;

        if(arr[index] == target)
            return index;

        return searchAndGetIndexHelper(arr, index+1, target);
    }



    // Question-3 : search, if exists return all indexes, else return -1
    public ArrayList<Integer> searchAndGetAllIndex(int[] arr, int target){
        return searchAndGetAllIndexHelper(arr,0, target);
    }

    private ArrayList<Integer> searchAndGetAllIndexHelper(int[] arr, int index, int target){
        ArrayList<Integer> output = new ArrayList<>();
        if(index == arr.length){
            return output;
        }

        if(arr[index] == target)
            output.add(index);

        output.addAll(searchAndGetAllIndexHelper(arr, index+1, target));
        return output;
    }




    public static void main(String[] args) {
        Array4_LinearSearch obj = new Array4_LinearSearch();

        System.out.println(obj.search(new int[]{1, 5, 3, 4, 6, 3, 4}, 5));
        System.out.println(obj.searchAndGetIndex(new int[]{1, 5, 3, 4, 6, 3, 4}, 5));
        System.out.println(obj.searchAndGetAllIndex(new int[]{1, 5, 3, 4, 6, 3, 4}, 5));
        System.out.println();

        System.out.println(obj.search(new int[]{1, 15, 3, 4, 6, 3, 4}, 100));
        System.out.println(obj.searchAndGetIndex(new int[]{1, 15, 3, 4, 6, 3, 4}, 100));
        System.out.println(obj.searchAndGetAllIndex(new int[]{1, 15, 3, 4, 6, 3, 4}, 100));
        System.out.println();

        System.out.println(obj.search(new int[]{111, 5, 3, 4, 6, 3, 4}, -3));
        System.out.println(obj.searchAndGetIndex(new int[]{111, 5, 3, 4, 6, 3, 4}, -3));
        System.out.println(obj.searchAndGetAllIndex(new int[]{111, 5, 3, 4, 6, 3, 4}, -3));
        System.out.println();

        System.out.println(obj.search(new int[]{-1, -5, -3, -4, -6, -3, -4}, -4));
        System.out.println(obj.searchAndGetIndex(new int[]{-1, -5, -3, -4, -6, -3, -4}, -4));
        System.out.println(obj.searchAndGetAllIndex(new int[]{-1, -5, -3, -4, -6, -3, -4}, -4));
        System.out.println();
   }

}