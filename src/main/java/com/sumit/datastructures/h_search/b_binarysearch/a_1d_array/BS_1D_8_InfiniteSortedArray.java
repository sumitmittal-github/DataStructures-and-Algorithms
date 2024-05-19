package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;


public class BS_1D_8_InfiniteSortedArray {

    /*
    * Program : Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
    * Concept  : Infinite array means never use array.length
    * */

    public static void main(String[] args) {
                    // Index : 0  1  2  3  4   5   6    7    8    9    10   11   12   13   14   15   16   17   18   19   20
        int nums[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 172, 190, 195, 199, 211, 215, 265, 298, 300, 351};

        int target1 = 100;
        int[] positions1 = findStartAndEndPositions(nums, target1);
        System.out.println("Target : " + target1 + " => " + binarySearchTheElement(nums, target1, positions1[0], positions1[1]));

        int target2 = 195;
        int[] positions2 = findStartAndEndPositions(nums, target2);
        System.out.println("Target : " + target2 + " => " + binarySearchTheElement(nums, target2, positions2[0], positions2[1]));
    }

    private static int[] findStartAndEndPositions(int[] nums, int target) {
        int start = 0;
        int end = 1;

        // because the array is infinite array, so we will never get ArrayIndexOutOfBound
        while(target > nums[end]) {
            int oldSearchWindow = end - start + 1;     // in previous search the # of elements we searched
            int newSearchWindow = oldSearchWindow * 2; // double the search window in every iteration => lon(n) complexity
            start = end + 1;
            end = end + newSearchWindow;
        }
        return new int[] {start, end};
    }


    private static int binarySearchTheElement(int[] nums, int target, int start, int end){
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target)
                return end;
            else if(nums[mid] < target)
                start = mid +1;
            else
                end = mid-1;
        }
        return -1;
    }

}