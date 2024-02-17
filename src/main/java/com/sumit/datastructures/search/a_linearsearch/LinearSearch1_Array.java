package com.sumit.datastructures.search.a_linearsearch;

public class LinearSearch1_Array {

    public static void main(String[] args) {
        int[] arr = {1,4,7,1,4,9,56,1,0,56774};
        System.out.println(linearSearch(arr, 11));
    }

    /*
    * Linear Search : search element in the array,
    * - if element found then return its index,
    * - else return -1
    **/
    private static int linearSearch(int[] arr, int element){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element)
                return i;
        }
        return -1;
    }

}
