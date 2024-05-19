package com.sumit.datastructures.h_search.c_2darray;

import com.sumit.utils.DSAUtils;

public class SortedMatrix1_Search {

    // LeetCode-74 : https://leetcode.com/problems/search-a-2d-matrix/description/

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int start = 0, end = row*column-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int elementAtMid = matrix[mid/column][mid%column];
            if(elementAtMid == target)
                return true;

            if(elementAtMid < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }


    public static void main(String[] args) {
        SortedMatrix1_Search obj = new SortedMatrix1_Search();

        int[][] matrix = DSAUtils.getSortedMatrix(3, 4);
        for(int i=-2; i<15; i++){
            System.out.println(i + " " + obj.searchMatrix(matrix, i));
        }
    }


}