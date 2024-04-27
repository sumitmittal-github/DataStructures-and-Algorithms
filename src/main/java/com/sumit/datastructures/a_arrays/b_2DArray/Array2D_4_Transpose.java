package com.sumit.datastructures.a_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

public class Array2D_4_Transpose {

    //LeetCode-867 : https://leetcode.com/problems/transpose-matrix/description/

    // Approach-1 : Creating new transpose matrix
    public int[][] transpose(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;

        int[][] transposeMatrix = new int[colSize][rowSize];
        for(int r=0; r<rowSize; r++){
            for(int c=0; c<colSize; c++) {
                transposeMatrix[c][r] = arr[r][c];
            }
        }
        return transposeMatrix;
    }


    // Approach-2 : inplace transpose
    // Note : Only if number of rows = number of columns
    public void transposeInplace(int[][] arr) {
        for(int r=0; r<arr.length; r++){
            for(int c=r+1; c<arr[0].length; c++) {
                // swap the elements
                int temp = arr[r][c];
                arr[r][c] = arr[c][r];
                arr[c][r] = temp;
            }
        }
    }




    public static void main(String[] args) {
        Array2D_4_Transpose obj = new Array2D_4_Transpose();

        int[][] arr = {     {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                      };

        System.out.println("Transpose : ");
        int[][] transposeMatrix = obj.transpose(arr);
        DSAUtils.printInt2DArray(transposeMatrix);
        System.out.println("------------------------");


        System.out.println("In place transpose : ");
        obj.transposeInplace(arr);
        DSAUtils.printInt2DArray(arr);
    }

}