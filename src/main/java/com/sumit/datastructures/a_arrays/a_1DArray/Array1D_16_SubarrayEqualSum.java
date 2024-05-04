package com.sumit.datastructures.a_arrays.a_1DArray;

public class Array1D_16_SubarrayEqualSum {

    // Program : Check if we can partition the array into two sub arrays with equal sum.


    // Approach-1 : we used both prefix sum and suffix sum
    public boolean canPartition_WithBoth_Prefix_Suffix(int[] arr){

        int[] prefixSumArray = new int[arr.length];
        int[] suffixSumArray = new int[arr.length];

        // STEP-1 : create prefix sum array and suffix sum array
        prefixSumArray[0] = arr[0];
        suffixSumArray[arr.length-1] = arr[arr.length-1];
        for(int i=1; i<arr.length; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + arr[i];

            int indexFromLast = arr.length - i - 1;
            suffixSumArray[indexFromLast] = suffixSumArray[indexFromLast+1] + arr[indexFromLast];
        }

        // STEP-2 : if at any point prefixSum[i] == suffixSum[i+1] then we have the location from where we can split the array
        for (int i = 0; i < arr.length-1; i++) {
            if(prefixSumArray[i] == suffixSumArray[i+1]){
                System.out.println("We have a point where split is possible with equal sum : ");
                System.out.println("Subarray-1 index range , from index = 0 -> to index = " + i);
                System.out.println("Subarray-2 index range , from index = " + (i+1) + " -> to index = " +  (arr.length-1) );
                return true;
            }
        }
        return false;
    }



    // Approach-2 : better approach : we can do the same task without suffix sum.
    // we can calculate the suffix sum on the flow with the help of prefix sum.
    public boolean canPartition_WithOnly_Prefix(int[] arr){

        int[] prefixSumArray = new int[arr.length];

        // STEP-1 : create prefix sum array
        prefixSumArray[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + arr[i];
        }

        int total = prefixSumArray[arr.length-1];

        // STEP-2 : if at any point prefixSum[i] == suffixSum[i+1] then we have the location from where we can split the array
        for (int i = 0; i < arr.length-1; i++) {
            int prefixSumAtThisIndex = prefixSumArray[i];
            int suffixSumAtNextIndex = total - prefixSumArray[i];   // suffixSumAtNextIndex = sum of all the remaining elements
            // because at any index :   prefixSum + suffixSum = totalSum

            if(prefixSumAtThisIndex == suffixSumAtNextIndex){
                System.out.println("We have a point where split is possible with equal sum : ");
                System.out.println("Subarray-1 index range , from index = 0 -> to index = " + i);
                System.out.println("Subarray-2 index range , from index = " + (i+1) + " -> to index = " +  (arr.length-1) );
                return true;
            }
        }
        return false;
    }



    // Approach-3 : even better : we do not need extra space of prefixSum array.
    // we can calculate prefixSum of any index i at rum time.
    public boolean canPartition_Without_Prefix_Suffix_Array(int[] arr){

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int prefixSumAtThisIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSumAtThisIndex += arr[i];
            int suffixSumAtThisIndex = total - prefixSumAtThisIndex;

            if (prefixSumAtThisIndex == suffixSumAtThisIndex){
                System.out.println("We have a point where split is possible with equal sum : ");
                System.out.println("Subarray-1 index range , from index = 0 -> to index = " + i);
                System.out.println("Subarray-2 index range , from index = " + (i+1) + " -> to index = " +  (arr.length-1) );
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Array1D_16_SubarrayEqualSum obj = new Array1D_16_SubarrayEqualSum();
        System.out.println(obj.canPartition_WithBoth_Prefix_Suffix(new int[]{5, 3, 2, 6, 3, 1}));      // true
        System.out.println(obj.canPartition_WithOnly_Prefix(new int[]{5, 3, 2, 6, 3, 1}));      // true
        System.out.println(obj.canPartition_Without_Prefix_Suffix_Array(new int[]{5, 3, 2, 6, 3, 1}));      // true
        System.out.println("---------------------");

        System.out.println(obj.canPartition_WithBoth_Prefix_Suffix(new int[]{15, 5, 6, 4, 8, 2}));     // true
        System.out.println(obj.canPartition_WithOnly_Prefix(new int[]{15, 5, 6, 4, 8, 2}));     // true
        System.out.println(obj.canPartition_Without_Prefix_Suffix_Array(new int[]{15, 5, 6, 4, 8, 2}));     // true
        System.out.println("---------------------");

        System.out.println(obj.canPartition_WithBoth_Prefix_Suffix(new int[]{1, 1, 1, 1, 1, 5}));      // true
        System.out.println(obj.canPartition_WithOnly_Prefix(new int[]{1, 1, 1, 1, 1, 5}));      // true
        System.out.println(obj.canPartition_Without_Prefix_Suffix_Array(new int[]{1, 1, 1, 1, 1, 5}));      // true
        System.out.println("---------------------");

        System.out.println(obj.canPartition_WithBoth_Prefix_Suffix(new int[]{1, 3, 2, 5, 4}));         // false
        System.out.println(obj.canPartition_WithOnly_Prefix(new int[]{1, 3, 2, 5, 4}));         // false
        System.out.println(obj.canPartition_Without_Prefix_Suffix_Array(new int[]{1, 3, 2, 5, 4}));         // false
        System.out.println("---------------------");
    }


}