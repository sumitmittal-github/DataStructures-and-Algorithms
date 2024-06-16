package com.sumit.datastructures.e_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

public class Array2D_3_ReverseEachRow {

    public void reverseEachRow(int[][] arr) {
        int columnLength = arr[0].length;
        if(columnLength <= 1)
            return;

        for(int r=0; r<arr.length; r++){
            reverseArr(arr[r]);
        }

    }

    public void reverseArr(int[] arr1D) {
        int start = 0;
        int end = arr1D.length - 1;

        while (start < end) {
            int temp = arr1D[start];
            arr1D[start] = arr1D[end];
            arr1D[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[][] arr = {    {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9}
                      };

        Array2D_3_ReverseEachRow obj = new Array2D_3_ReverseEachRow();
        obj.reverseEachRow(arr);
        DSAUtils.printInt2DArray(arr);
    }

}