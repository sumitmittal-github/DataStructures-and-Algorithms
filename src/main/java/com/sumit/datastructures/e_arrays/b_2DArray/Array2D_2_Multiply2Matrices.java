package com.sumit.datastructures.e_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

public class Array2D_2_Multiply2Matrices {

    private int[][] multiply(int[][] arr1, int[][] arr2) {
        int matrix1RowCount = arr1.length;
        int matrix1ColCount = arr1[0].length;
        int matrix2RowCount = arr2.length;
        int matrix2ColCount = arr2[0].length;

        if(matrix1ColCount != matrix2RowCount){
            System.out.println("Multiplication is not possible, because both matrices sizes are incompatible");
            return null;
        }

        int[][] output = new int[matrix1RowCount][matrix2ColCount];

        for(int r=0; r<matrix1RowCount; r++){
            for(int c=0; c<matrix2ColCount; c++) {
                // addition of multiplication of : (each element of row[r] of matrices1) * (each element of column[c] of matrices2)
                for(int temp=0; temp<matrix1ColCount; temp++){    // also can use matrix2RowCount, because both are same
                    output[r][c] +=  (arr1[r][temp] * arr2[temp][c]);
                }
            }
        }
        return output;
    }



    public static void main(String[] args) {
        int[][] arr1 = {    {1, 2, 3, 4},
                            {5, 6, 7, 8}
                       };
        int[][] arr2 = {    {1,  2,  3},
                            {4,  5,  6},
                            {7,  8,  9},
                            {10, 11, 12}
                       };

        Array2D_2_Multiply2Matrices obj = new Array2D_2_Multiply2Matrices();
        int[][] sum = obj.multiply(arr1, arr2);
        DSAUtils.printInt2DArray(sum);
    }

}