package com.sumit.datastructures.e_arrays.a_1DArray;

import java.util.LinkedList;
import java.util.List;

public class Array1D_4_FirstRepeatedNumber {

    // Program : return 1st repeated number from an array

    public static void main(String[] args) {
        Array1D_4_FirstRepeatedNumber obj = new Array1D_4_FirstRepeatedNumber();

        int[] arr = {1, 5, 3, 4, 6, 3, 4};
        System.out.println(obj.firstRepeatedNum_approach1(arr));
        System.out.println(obj.firstRepeatedNum_approach2(arr));

    }

    public int firstRepeatedNum_approach1(int[] arr){
        List<Integer> list = new LinkedList<>();
        for(int num : arr){
            if(list.contains(num))
                return num;
            else
                list.add(num);
        }
        return Integer.MIN_VALUE;
    }

    public int firstRepeatedNum_approach2(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return Integer.MIN_VALUE;
    }

}