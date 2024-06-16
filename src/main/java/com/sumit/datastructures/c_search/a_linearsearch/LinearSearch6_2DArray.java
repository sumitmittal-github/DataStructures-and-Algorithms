package com.sumit.datastructures.c_search.a_linearsearch;

import java.util.Arrays;

public class LinearSearch6_2DArray {

    public static void main(String[] args) {
        int[][] arr = {
                {1,   45,  9},
                {981, -12, 45, 1, 7},
                {111, 122, 13, 804},
                {2, 78}
        };

        int[] coordinate = linearSearch(arr, 122);
        System.out.println(Arrays.toString(coordinate));
    }


    /*
     * Linear Search : search element in the 2D array,
     * - if element found then return its position,
     * - else return [-1, -1]
     **/
    private static int[] linearSearch(int[][] arr, int element){
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == element)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

}