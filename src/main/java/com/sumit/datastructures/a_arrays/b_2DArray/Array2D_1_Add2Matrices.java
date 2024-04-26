package com.sumit.datastructures.a_arrays.b_2DArray;

public class Array2D_1_Add2Matrices {

    private static int[][] add(int[][] arr1, int[][] arr2) {
        int[][] sum = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++) {
                sum[i][j] = arr1[i][j] +arr2[i][j];
            }
        }
        return sum;
    }

    private static void display(int[][] sum) {
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
        int[][] sum = add(arr1, arr2);
        display(sum);
    }

}