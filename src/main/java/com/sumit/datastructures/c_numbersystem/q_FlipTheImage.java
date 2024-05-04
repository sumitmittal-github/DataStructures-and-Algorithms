package com.sumit.datastructures.c_numbersystem;

public class q_FlipTheImage {

    // LeetCode-832 : https://leetcode.com/problems/flipping-an-image/description/

    public static void main(String[] args) {

        int[][] image1 = {   {1, 1, 0},
                            {1, 0, 1},
                            {0, 0, 0}
                        };
        printArray(image1);
        flipAndInvertImage(image1);
        printArray(image1);
        /* Input :          1 1 0
                            1 0 1
                            0 0 0
            Output :        1 0 0
                            0 1 0
                            1 1 1
        */

        int[][] image2 = {  {1, 1, 0, 0},
                            {1, 0, 0, 1},
                            {0, 1, 1, 1},
                            {1, 0, 1, 0}
                         };
        printArray(image2);
        flipAndInvertImage(image2);
        printArray(image2);
        /* Input :          1 1 0 0
                            1 0 0 1
                            0 1 1 1
                            1 0 1 0
           Output :         1 1 0 0
                            0 1 1 0
                            0 0 0 1
                            1 0 1 0
        */
    }

    private static void flipAndInvertImage(int[][] image) {
        for(int row = 0; row < image.length; row++) {

            // IMPORTANT POINT : if row length is even then we will iterate each row half times, else half+1 times
            for(int col = 0; col < (image[row].length+1)/2; col++) {
                swapAndInvert(image, row, col, image[row].length-col-1);
            }
        }
    }

    private static void swapAndInvert(int[][] arr, int row, int col1, int col2){
        int temp = arr[row][col1];
        arr[row][col1] = invert(arr[row][col2]);
        arr[row][col2] = invert(temp);
    }

    private static int invert(int digit){
        // because X-OR with 1 with revert the digit, 0 -> 1   and    1 -> 0
        return digit^1;
    }

    private static void printArray(int[][] arr){
        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}