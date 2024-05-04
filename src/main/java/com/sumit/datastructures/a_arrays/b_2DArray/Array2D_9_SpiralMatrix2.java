package com.sumit.datastructures.a_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

public class Array2D_9_SpiralMatrix2 {

    // LeetCode-59 : https://leetcode.com/problems/spiral-matrix-ii/description/

    public int[][] generateMatrix(int n) {
        int[][] output = new int[n][n];

        int element = 1;
        int row1 = 0;
        int row2 = n-1;
        int col1 = 0;
        int col2 = n-1;

        while(element <= n*n){

            // fill row1
            for(int c = col1; c <= col2 & element <= n*n; c++){
                output[row1][c] = element;
                element++;
            }
            row1++;

            // fill col2
            for(int r = row1; r <= row2 & element <= n*n; r++){
                output[r][col2] = element;
                element++;
            }
            col2--;

            // fill row2
            for(int c = col2; c >= col1 & element <= n*n; c--){
                output[row2][c] = element;
                element++;
            }
            row2--;

            // fill col1
            for(int r = row2; r >= row1 & element <= n*n; r--){
                output[r][col1] = element;
                element++;
            }
            col1++;
        }
        return output;
    }


    public static void main(String[] args) {
        Array2D_9_SpiralMatrix2 obj = new Array2D_9_SpiralMatrix2();

        DSAUtils.printInt2DArray(obj.generateMatrix(1));
        System.out.println("--------------------");

        DSAUtils.printInt2DArray(obj.generateMatrix(2));
        System.out.println("--------------------");

        DSAUtils.printInt2DArray(obj.generateMatrix(5));
        System.out.println("--------------------");
    }

}