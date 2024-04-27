package com.sumit.datastructures.a_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

public class Array2D_5_Rotate {

    //LeetCode-48 : https://leetcode.com/problems/rotate-image/description/
    // rotate the image by 90 degrees (clockwise).
    // n == matrix.length == matrix[i].length    :    means n*n matrix

    public void rotate(int[][] arr) {

        // STEP-1 : inplace transpose because #row = #column
        for(int r=0; r<arr.length; r++){
            for(int c=r+1; c<arr[0].length; c++) {
                // swap the elements
                int temp = arr[r][c];
                arr[r][c] = arr[c][r];
                arr[c][r] = temp;
            }
        }

        // STEP-2 : reverse each row
        for(int r=0; r<arr.length; r++){
            reverse(arr[r]);
        }
    }

    public void reverse(int[] arr1D){
        int start = 0;
        int end = arr1D.length-1;
        while(start < end){
            int temp = arr1D[start];
            arr1D[start] = arr1D[end];
            arr1D[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        Array2D_5_Rotate obj = new Array2D_5_Rotate();

        int[][] arr = {     {1,  2,  3,  4},
                            {5,  6,  7,  8},
                            {9,  10, 11, 12},
                            {13, 14, 15, 16}
                      };

        System.out.println("Rotate : ");
        obj.rotate(arr);
        DSAUtils.printInt2DArray(arr);
    }

}