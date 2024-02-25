package com.sumit.datastructures.sort.d_cyclicsort;

public class CyclicSort2_MissingNumber {

    // Leet code : https://leetcode.com/problems/missing-number/description/

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber_mathApproach(new int[]{3, 0, 1}));

        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber_mathApproach(new int[]{0, 1}));

        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber_mathApproach(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println(missingNumber(new int[]{3,2,1,4,5}));
        System.out.println(missingNumber_mathApproach(new int[]{3,2,1,4,5}));

        System.out.println(missingNumber(new int[]{1}));
        System.out.println(missingNumber_mathApproach(new int[]{1}));

        System.out.println(missingNumber(new int[]{1, 0, 3, 2}));
        System.out.println(missingNumber_mathApproach(new int[]{1, 0, 3, 2}));

    }

    // approach : sum of 1-N numbers is (n*(n+1))/2;
    private static int missingNumber_mathApproach(int[] arr){
        int actualSumShouldBe = (arr.length*(arr.length+1))/2;
        int currentSum=0;
        for(int num : arr){
            currentSum += num;
        }
        return actualSumShouldBe - currentSum;
    }

    private static int missingNumber(int[] arr){
        // STEP-1 : Sort the array
        cyclicSort(arr);

        // STEP-2 : in sorted array the missing number will be (index of value 0) + 1
        int missingNum = 0;
        for(int index = 0; index <= arr.length-1; index++){
            if(arr[index] == 0){
                missingNum = index+1;
                break;
            }
        }
        return missingNum;
    }


    private static void cyclicSort(int[] arr){
        int i=0;
        while(i <= arr.length-1){
            // Also skip if the value is 0, because our array should be value 1 -> value N
            // And we can not place value 0 ant index -1 index.
            if(i == arr[i]-1 || arr[i] == 0 )
                i++;
            else
                swap(arr, i, arr[i]-1);
        }
    }

    private static void swap(int[] arr, int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }


}