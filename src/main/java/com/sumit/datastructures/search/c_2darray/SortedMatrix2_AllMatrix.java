package com.sumit.datastructures.search.c_2darray;

import java.util.Arrays;

public class SortedMatrix2_AllMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4,  5,  6,  7},
                {8,  9,  10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 28, 29},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 41, 42}
        };

        System.out.println("target : "+ 6 +" => indexes : " + Arrays.toString(search(matrix, 6)));
        System.out.println("target : "+ 36 +" => indexes : " + Arrays.toString(search(matrix, 36)));
        System.out.println("target : "+ 4 +" => indexes : " + Arrays.toString(search(matrix, 4)));
        System.out.println("target : "+ -6 +" => indexes : " + Arrays.toString(search(matrix, -6)));
        System.out.println("target : "+ 27 +" => indexes : " + Arrays.toString(search(matrix, 27)));
        System.out.println("target : "+ 100 +" => indexes : " + Arrays.toString(search(matrix, 100)));
    }

    private static int[] search(int[][] matrix, int target) {

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

    private static int[] binarySearch(int[][] matrix, int row, int startCol, int endCol, int target){
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


}