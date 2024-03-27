package com.sumit.datastructures.i_sort.d_cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class CyclicSort3_DisappearedNumbers {

    // Leet code : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

    /** STEP-1 : Sort all numbers, if duplicates comes then skip that number and i++
     *   EX :   values : {1, 1, 3, 2, 5}
     *         indexes :  0, 1, 2, 3, 4
     *   As per our code -       arr[0] = 1 perfect => i++
     *                           arr[1] = 1 => then match if arr[0] already has 1, if YES then skip this element => i++
     *   At the end of sorting iteration all the valid  numbers will be present at (value-1) index
     *   and on indexes where arr[index] != index+1 those index are the missing indexes and (index+1) will be missing values
     *
     *   STEP-2 : Array after sorting will look like -
     *          values : {1, 2, 3, 1, 5}
     *         indexes :  0, 1, 2, 3, 4
     * => index 3 should contain value = 4, but don't have it, means answer of this question will be 4
     */

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{1, 1, 3, 2, 5}));
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{1,1}));
    }

    private static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();

        // STEP-1 : Sort all numbers, if duplicates comes then skip that number and i++
        int i=0;
        while(i <= arr.length-1){
            if(i+1 == arr[i] || arr[i] == arr[arr[i]-1])
                i++;
            else
                swap(arr, i, arr[i]-1);
        }

        // STEP-2 : iterate through all indexes and filter the missing numbers
        for (int index = 0; index <= arr.length-1; index++) {
            if(arr[index] != index+1)
                list.add(index+1);
        }

        return list;
    }

    private static void swap(int[] arr, int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }


}