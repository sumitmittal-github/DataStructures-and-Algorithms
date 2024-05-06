package com.sumit.datastructures.a_arrays.a_1DArray;

public class Array1D_17_LongestCommonPrefix {

    // LeetCode-14 : https://leetcode.com/problems/longest-common-prefix/description/

    public static String longestCommonPrefix(String[] arr) {
        String prefix = arr[0];
        for(int index=1;index<arr.length;index++) {

            // check if arr[1] contains prefix (arr[0])
            while(arr[index].indexOf(prefix) != 0){
                // remove last character from prefix (arr[0]) and recheck if this prefix matches with arr[1]
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }

}
