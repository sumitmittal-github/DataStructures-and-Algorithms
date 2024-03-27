package com.sumit.datastructures.h_search.a_linearsearch;

public class LinearSearch4_InRange {

    public static void main(String[] args) {
        int[] arr = {1,98,345,2423,47567,124,235,34,645,73,58,358,356};
        System.out.println(linearSearchInRange(arr, 2, 11, 356));
    }

    /*
     * Case in-sensitive Linear Search :
     * search character in the input string -
     * - if the character found then return its index,
     * - else return -1
     **/
    private static int linearSearchInRange(int[] arr, int startIndex, int endIndex, int element) {
        for(int i=startIndex; i<=endIndex; i++){
            if(arr[i] == element)
                return i;
        }
        return -1;
    }

}