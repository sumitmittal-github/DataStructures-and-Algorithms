package com.sumit.datastructures.h_search.c_2darray;

public class SortedMatrix2_Search2 {

    // LeetCode-240 : https://leetcode.com/problems/search-a-2d-matrix-ii/

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] < target)   row++;
            else                             col--;
        }
        return false;
    }


}