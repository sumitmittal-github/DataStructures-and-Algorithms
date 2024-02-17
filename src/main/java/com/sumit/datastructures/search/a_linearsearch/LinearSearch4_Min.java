package com.sumit.datastructures.search.a_linearsearch;

public class LinearSearch4_Min {

    public static void main(String[] args) {

        int[] arr = {12, 545, 65, -12, 45, -111, 0, -9999};

        System.out.println(min(arr));
    }

    private static int min(int[] arr) {
        int minElement = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < minElement)
                minElement = arr[i];
        }
        return minElement;
    }
}
