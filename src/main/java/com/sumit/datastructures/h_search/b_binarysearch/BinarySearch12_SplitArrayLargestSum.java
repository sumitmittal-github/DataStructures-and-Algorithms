package com.sumit.datastructures.h_search.b_binarysearch;

import java.util.Arrays;

public class BinarySearch12_SplitArrayLargestSum {

    // LeetCode-410 : https://leetcode.com/problems/split-array-largest-sum/description/

    public static void main(String[] args) {
        int[] arr1 = {7, 2, 5, 10, 8};
        int noOfPartitions1 = 2;
        System.out.println("Partitions : " + noOfPartitions1 + ", Arr : "+ Arrays.toString(arr1)+" => Largest sum : ");
        System.out.println(new BinarySearch12_SplitArrayLargestSum().splitArray(arr1, noOfPartitions1));
    }

    public int splitArray(int[] arr, int noOfPartitions){
        int[] range = findRange(arr);
        return binarySearch(arr, noOfPartitions, range[0], range[1]);
    }

    public int[] findRange(int[] arr) {
        int maxValOfSum = 0;        // will be "end" for our binary search
        int minValOfSum = 0;        // will be "start" for our binary search
        for(int n : arr) {
            // maxValOfSum = sum of all the numbers in this array
            maxValOfSum += n;

            // minValOfSum = largest number of this array
            if(minValOfSum < n)
                minValOfSum = n;
        }
        return new int[]{minValOfSum, maxValOfSum};
    }

    public int binarySearch(int[] arr, int noOfPartitions, int start, int end) {

        while(start < end) {
            int mid = start + (end-start)/2;    // max sum of each partition

            // find number of partitions we can make if max sum of each partition can be mid
            int noOfPartitionsWithMaxSum = numberOfPartitionsWithMaxSum(arr, mid);

            if(noOfPartitionsWithMaxSum > noOfPartitions)
                start = mid+1;
            else
                end = mid;
        }

        return start;  // here start ==  end. so we can return either start or end.
    }

    // if max sum of each partition can be "maxSum", then how many partitions it will have
    public int numberOfPartitionsWithMaxSum(int[] arr, int maxSum){
        int partitionCount=0;

        int tempSum=0;
        for(int num : arr){
            tempSum += num;
            if(tempSum > maxSum) {
                partitionCount++;
                tempSum = num;      // tempSum exceeded the range, it means this number shall go in next partition.
            }
        }

        // after for loop completed, and tempSum still has the value means this will create 1 more partition (last partition)
        if(tempSum > 0)
            partitionCount++;

        return partitionCount;
    }

}