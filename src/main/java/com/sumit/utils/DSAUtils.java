package com.sumit.utils;

import java.util.List;

public class DSAUtils {

    public static int[][] getUniqueElementsMatrix(int row, int column){
        int element = 1;

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = element++;
            }
        }
        return matrix;
    }

    public static void printInt2DArray(int[][] sum) {
        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printIntList(List<Integer> row) {
        for(Integer element : row) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public static void printIntListOfList(List<List<Integer>> triangle) {
        for(List<Integer> row : triangle){
            for(Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}