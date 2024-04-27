package com.sumit.datastructures.a_arrays.b_2DArray;

public class Array2D_12_RangeSumQuery_WithRowPrefixSum {

    //LeetCode-304 : https://leetcode.com/problems/range-sum-query-2d-immutable/description/
    //LeetCode submission response :
    //  Runtime = 117ms
    //            Beats 19.20% of users with Java
    //  Better than before because for q iteration we need to calculate the prefix matrix once,
    //  but have to iterate each row to add the total sum
    //  there is even better approach where we can skip the 2nd part of iterating the rows again
    int[][] matrix;

    public Array2D_12_RangeSumQuery_WithRowPrefixSum(int[][] matrix) {
        this.matrix = matrix;
        convertInRowPrefixSumMatrix();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            int currentRowSum = 0;

            if (col1 > 0)
                currentRowSum = matrix[r][col2] - matrix[r][col1 - 1];
            else
                currentRowSum = matrix[r][col2];

            sum = sum + currentRowSum;
        }
        return sum;
    }

    public void convertInRowPrefixSumMatrix() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                matrix[r][c] = matrix[r][c - 1] + matrix[r][c];
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
        Array2D_12_RangeSumQuery_WithRowPrefixSum obj = new Array2D_12_RangeSumQuery_WithRowPrefixSum(arr);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
        System.out.println("--------------------");
    }

}