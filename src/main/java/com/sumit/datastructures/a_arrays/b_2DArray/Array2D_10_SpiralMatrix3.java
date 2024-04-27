package com.sumit.datastructures.a_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;
import java.util.LinkedList;
import java.util.List;

public class Array2D_10_SpiralMatrix3 {

    //Question : print m*n matrix in reverse spiral order

    public List<Integer> getReverseSpiral(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        int row1 = 0;
        int row2 = matrix.length-1;
        int col1 = 0;
        int col2 = matrix[0].length-1;

        int totalElements = matrix.length * matrix[0].length;
        while(totalElements > 0) {

            // get col1
            for(int r = row1; r <= row2 && totalElements > 0; r++){
                result.add(matrix[r][col1]);
                totalElements--;
            }
            col1++;


            // get row2
            for(int c = col1; c <= col2 && totalElements > 0; c++){
                result.add(matrix[row2][c]);
                totalElements--;
            }
            row2--;


            // get col2
            for(int r = row2; r >= row1 && totalElements > 0; r--){
                result.add(matrix[r][col2]);
                totalElements--;
            }
            col2--;


            // get row1
            for(int c = col2; c >= col1 && totalElements > 0; c--){
                result.add(matrix[row1][c]);
                totalElements--;
            }
            row1++;


        }

        return result;
    }


    public static void main(String[] args) {
        Array2D_10_SpiralMatrix3 obj = new Array2D_10_SpiralMatrix3();

        int[][] arr1 = {    {1,  2,  3,  4},
                            {5,  6,  7,  8},
                            {9,  10, 11, 12},
                            {13, 14, 15, 16}
                       };
        DSAUtils.printIntList(obj.getReverseSpiral(arr1));
        System.out.println("--------------------");


        int[][] arr2 = {    {1,  2,  3,  4},
                            {5,  6,  7,  8},
                            {9,  10, 11, 12}
                       };
        DSAUtils.printIntList(obj.getReverseSpiral(arr2));
        System.out.println("--------------------");
    }

}