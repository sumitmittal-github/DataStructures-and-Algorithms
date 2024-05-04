package com.sumit.datastructures.a_arrays.b_2DArray;

public class Array2D_13_RangeSumQuery_WithRowColumnPrefixSum {

    // LeetCode-304 : https://leetcode.com/problems/range-sum-query-2d-immutable/description/

    // LeetCode submission response :
    //  Runtime = 95ms
    //            Beats 99.69% of users with Java
    //  Best approach because for q iteration we need to calculate the prefix matrix only once
    //  and with just few addition and subtraction we can find the answer

    int[][] matrix;

    public Array2D_13_RangeSumQuery_WithRowColumnPrefixSum(int[][] matrix) {
        this.matrix = matrix;
        convertInRowColumnPrefixSumMatrix();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumTillRow2Col2 = 0;
        int sumTillPreviousRowOfRow1 = 0;
        int sumTillPreviousColOfCol1 = 0;
        int sumTillPreviousRowCol = 0;

        sumTillRow2Col2 = matrix[row2][col2];

        if(row1 > 0)                sumTillPreviousRowOfRow1 = matrix[row1-1][col2];
        if(col1 > 0)                sumTillPreviousColOfCol1 = matrix[row2][col1-1];
        if(row1 > 0 && col1 > 0)    sumTillPreviousRowCol = matrix[row1-1][col1-1];

        return sumTillRow2Col2 - sumTillPreviousRowOfRow1 - sumTillPreviousColOfCol1 + sumTillPreviousRowCol;
    }

    public void convertInRowColumnPrefixSumMatrix() {
        // converting into row prefix matrix
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                matrix[r][c] = matrix[r][c - 1] + matrix[r][c];
            }
        }

        // converting into +column prefix matrix
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 1; r < matrix.length; r++) {
                matrix[r][c] = matrix[r-1][c] + matrix[r][c];
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {     {3,0,1,4,2},
                            {5,6,3,2,1},
                            {1,2,0,1,5},
                            {4,1,0,1,7},
                            {1,0,3,0,5}
                       };
        Array2D_13_RangeSumQuery_WithRowColumnPrefixSum obj = new Array2D_13_RangeSumQuery_WithRowColumnPrefixSum(arr);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
        System.out.println("--------------------");
    }

}