package com.sumit.datastructures.j_recursion.c_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets1_Integer {

    // Question : Given an array of Integers, return sum of all the subsets in it.
    //      Ex  :  Input = arr-= = {2,3}
    //      O/p :  Output = [0, 2, 3, 5]

    public static void main(String[] args) {
        Subsets1_Integer obj = new Subsets1_Integer();

        int[] arr = {2, 3};
        System.out.println(obj.getSubsets_1(arr, 0));
        System.out.println();

        System.out.println(obj.getSubsets_2(arr, 0, 0));
    }



    // Approach-1 : getting copy of existing array by excluding 0th index element
    public List<Integer> getSubsets_1(int[] arr, int ans){
        List<Integer> list = new ArrayList<>();
        if(arr.length == 0){
            list.add(ans);
            return list;
        }

        int[] subArr = Arrays.copyOfRange(arr, 1, arr.length);
        List<Integer> answersFromLeftTree = getSubsets_1(subArr, ans+arr[0]);
        List<Integer> answersFromRightTree = getSubsets_1(subArr, ans);

        list.addAll(answersFromLeftTree);
        list.addAll(answersFromRightTree);
        return list;
    }



    // Approach-2 : using index
    public List<Integer> getSubsets_2(int[] arr, int currentIndex, int ans){
        List<Integer> list = new ArrayList<>();
        if(currentIndex == arr.length){
            list.add(ans);
            return list;
        }

        List<Integer> answersFromLeftTree = getSubsets_2(arr, currentIndex+1, ans+arr[currentIndex]);
        List<Integer> answersFromRightTree = getSubsets_2(arr, currentIndex+1, ans);

        list.addAll(answersFromLeftTree);
        list.addAll(answersFromRightTree);
        return list;
    }




}