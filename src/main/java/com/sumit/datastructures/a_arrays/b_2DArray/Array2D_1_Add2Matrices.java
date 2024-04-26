package com.sumit.datastructures.a_arrays.b_2DArray;

public class Array2D_1_Add2Matrices {

    private int[][] add(int[][] arr1, int[][] arr2) {
        int matrix1RowCount = arr1.length;
        int matrix1ColCount = arr1[0].length;
        int matrix2RowCount = arr2.length;
        int matrix2ColCount = arr2[0].length;

        if( (matrix1RowCount != matrix2RowCount)  &&  (matrix1ColCount != matrix2ColCount)){
            System.out.println("Addition is not possible, because both matrices sizes are incompatible");
            return null;
        }

        int[][] sum = new int[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++) {
                sum[i][j] = arr1[i][j] +arr2[i][j];
            }
        }
        return sum;
    }

    private void display(int[][] sum) {
        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] arr1 = {    {1,2,3},
                            {4,5,6}
                       };
        int[][] arr2 = {    {11,22,33},
                            {44,55,66}
                       };

        Array2D_1_Add2Matrices obj = new Array2D_1_Add2Matrices();
        int[][] sum = obj.add(arr1, arr2);
        obj.display(sum);
    }

}