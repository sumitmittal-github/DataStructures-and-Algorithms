package com.sumit.datastructures.c_search.b_binarysearch.b_2d_array;

import com.sumit.utils.DSAUtils;

import java.util.Arrays;

public class BS_2D_2_Search2 {

    // LeetCode-240 : https://leetcode.com/problems/search-a-2d-matrix-ii/


    public boolean searchMatrix_boolean(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length-1 && col >= 0) {
            if (target == matrix[row][col])
                return true;

            if (target > matrix[row][col])   row++;
            else                             col--;
        }
        return false;
    }


    // Approach-1 : taught by College Wallah : BEST and easiest approach
    public int[] searchMatrix_index_1(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length-1 && col >= 0) {
            if (target == matrix[row][col])
                return new int[]{row, col};

            if (target > matrix[row][col])   row++;
            else                             col--;
        }
        return new int[]{-1, -1};
    }


    // Approach-2 : taught by Kunal Kushwaha : a bit hard to understand
    public int[] searchMatrix_index_2(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0)
            return new int[]{-1, -1};

        if(matrix.length == 1)
            return binarySearch(matrix, 0, 0, matrix.length-1, target);

        // STEP-1 : Binary search in middle column elements
        int startRow = 0;
        int endRow = matrix.length-1;
        int midCol = (matrix[0].length - 1)/2;


        // run until wer have 2 rows remaining
        while(startRow < endRow-1){
            // while will be true until we have more than 2 rows
            int midRow = startRow + (endRow-startRow)/2;
            int element = matrix[midRow][midCol];
            if(element == target) {
                return new int[]{midRow, midCol};
            } else if(element > target){
                // skip the rows below
                endRow = midRow;
            } else if(element < target){
                // skip the rows above
                startRow = midRow;
            }
        }


        // STEP-2 :
        // If the cursor has reached till this point,
        // then it means, we have not found the target in middle column
        // means the target is present in the remaining last 2 rows
        // check if the target is in the middle columns
        if(target == matrix[startRow][midCol])
            return new int[]{startRow, midCol};
        if(target == matrix[startRow+1][midCol])
            return new int[]{startRow+2, midCol};


        // STEP-3 :
        // target was not available in the middle elements
        // means the target is present in the left or right side of the middle elements => which are 4 sorted arrays
        // apply binary search in these 4 sorted arrays
        if(target < matrix[startRow][midCol]){
            return binarySearch(matrix, startRow, 0, midCol-1, target);
        }
        else if(target > matrix[startRow][midCol] && target <= matrix[startRow][matrix[startRow].length-1]) {
            return binarySearch(matrix, startRow, midCol+1, matrix[startRow].length-1, target);
        }
        else if(target < matrix[startRow+1][midCol]) {
            return binarySearch(matrix, startRow+1, 0, midCol-1, target);
        }
        else if(target > matrix[startRow+1][midCol] && target <= matrix[startRow+1][matrix[startRow+1].length-1]) {
            return binarySearch(matrix, startRow+1, midCol+1, matrix[startRow+1].length-1, target);
        }

        return new int[]{-1, -1};
    }

    private int[] binarySearch(int[][] matrix, int row, int startCol, int endCol, int target){
        while(startCol <= endCol){
            int midCol = startCol + (endCol-startCol)/2;
            int element = matrix[row][midCol];
            if(element == target) {
                return new int[]{row, midCol};
            } else if(element > target){
                endCol = midCol-1;
            } else if(element < target){
                startCol = midCol+1;
            }
        }
        return new int[]{-1, -1};
    }








    public static void main(String[] args) {
        BS_2D_2_Search2 obj = new BS_2D_2_Search2();
        int[][] matrix = DSAUtils.getRowColSortedMatrix();

        int target1 = 37;
        System.out.println("target : "+ target1 +" => indexes : " + obj.searchMatrix_boolean(matrix, target1));
        System.out.println("target : "+ target1 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_1(matrix, target1)));
        System.out.println("target : "+ target1 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_2(matrix, target1)));
        System.out.println();

        int target2 = 10;
        System.out.println("target : "+ target2 +" => indexes : " + obj.searchMatrix_boolean(matrix, target2));
        System.out.println("target : "+ target2 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_1(matrix, target2)));
        System.out.println("target : "+ target2 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_2(matrix, target2)));
        System.out.println();

        int target3 = 100;
        System.out.println("target : "+ target3 +" => indexes : " + obj.searchMatrix_boolean(matrix, target3));
        System.out.println("target : "+ target3 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_1(matrix, target3)));
        System.out.println("target : "+ target3 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_2(matrix, target3)));
        System.out.println();

        int target4 = -100;
        System.out.println("target : "+ target4 +" => indexes : " + obj.searchMatrix_boolean(matrix, target4));
        System.out.println("target : "+ target4 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_1(matrix, target4)));
        System.out.println("target : "+ target4 +" => indexes : " + Arrays.toString(obj.searchMatrix_index_2(matrix, target4)));
    }


}