package com.sumit.datastructures.e_arrays.a_1DArray;

import java.util.HashMap;

public class Array1D_5_TargetSumOfPair {

    // https://www.geeksforgeeks.org/count-pairs-with-given-sum/
    // Program : Find the total number of pairs in the array, whose sum is equal to the given value x

    public static void main(String[] args) {
        Array1D_5_TargetSumOfPair obj = new Array1D_5_TargetSumOfPair();

        int[] arr1 = {4, 6, 3, 5, 8, 2, 1};
        int target1 = 7;

        /*int[] arr2 = {1, 1, 1, 1, 1, 1};
        int target2 = 2;*/

        System.out.println(obj.targetSum_approach1(arr1, target1));
        System.out.println(targetSum_approach2(arr1, target1));
    }


    // T.C : O(n*n)
    // S.C : O(1)
    public int targetSum_approach1(int[] arr, int target){
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    System.out.println("Pair : "+ arr[i] + " + " + arr[j]);
                    count++;
                }
            }
        }
        return count;
    }


    // Better approach : because time complexity is O(n)
    // Drawback        : Space complexity is also O(n) because created HashMap
    static int targetSum_approach2(int arr[], int k)
    {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int value1 = arr[i];
            int diff = k - arr[i];  //diff is value2 we are looking for (sum - value1)

            // we are looking for value2
            // if value2 is present in the map then : count = count + frequency
            if (frequencyMap.containsKey(diff)){
                int frequencyOfDiff = frequencyMap.get(diff);
                count = count + frequencyOfDiff;
                System.out.println(frequencyOfDiff + " Pairs of : "+ value1 + " + " + diff);
            }

            // if value1 is present in the map then increase the frequency, else create with frequency=1
            if (frequencyMap.containsKey(value1))
                frequencyMap.put(value1, frequencyMap.get(value1) + 1);
            else
                frequencyMap.put(value1, 1);

        }
        return count;
    }

}