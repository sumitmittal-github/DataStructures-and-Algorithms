package com.sumit.datastructures.a_arrays.b_2DArray;

public class Array2D_11_RangeSumQuery_BruteForce {

    //LeetCode-304 : https://leetcode.com/problems/range-sum-query-2d-immutable/description/

    //LeetCode submission response :
    //  Runtime = 1529ms
    //            Beats 5.07% of users with Java
    //  Therefore not a good approach because for q such queries it will calculate sum q times

    int[][] matrix;
    public Array2D_11_RangeSumQuery_BruteForce(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2 ; r++) {
            for (int c = col1; c <= col2 ; c++) {
                sum = sum + matrix[r][c];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {    {3,0,1,4,2},
                            {5,6,3,2,1},
                            {1,2,0,1,5},
                            {4,1,0,1,7},
                            {1,0,3,0,5}
                       };
        Array2D_11_RangeSumQuery_BruteForce obj = new Array2D_11_RangeSumQuery_BruteForce(arr);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
        System.out.println("--------------------");
    }

}