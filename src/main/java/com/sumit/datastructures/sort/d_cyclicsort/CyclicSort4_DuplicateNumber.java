package com.sumit.datastructures.sort.d_cyclicsort;

public class CyclicSort4_DuplicateNumber {

    /** STEP-1 : Sort all numbers, if 0 comes then skip that number (i++) because our array should be 1 -> N
     *   EX :   values : {1, 3, 4, 2, 2}
     *         indexes :  0, 1, 2, 3, 4
     *   As per our code -       arr[0] = 1 perfect => i++
     *                           arr[1] = 3 => it should be 2, but we have 3, which should be value of index 2. Therefor swap with index=2 element
     *                              =>  {1, 4, 3, 2, 2}
     *                           arr[1] = 4 => it should be 2, but we have 4, which should be value of index 3. Therefor swap with index=3 element   =>  {1, 4, 3, 2, 2}
     *                              =>  {1, 2, 3, 4, 2}
     *                           arr[1] = 2  perfect => i++
     *                           arr[2] = 3  perfect => i++
     *                           arr[3] = 4  perfect => i++
     *                           arr[4] = 2  then match if arr[1] already has 2, if YES then skip this element => i++
     *   At the end of sorting iteration all the valid  numbers will be present at (value-1) index
     *   and on indexes where arr[index] != index+1 those values are the invalid (duplicates)
     *    => Answer is 2 (duplicate)
     */


    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{1, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{1}));
        System.out.println(findDuplicate(new int[]{}));
        System.out.println(findDuplicate(new int[]{5, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        // STEP-1 : sort the array and skip the index if duplicate integer comes
        // Ex - {1, 2, 4, 2, 3}
        // nums[i] == nums[nums[i]-1]
        // ex: nums[3] = 2 then we need to check if num[2-1] already contains 2,
        // if no then swap else this is duplicate number and we can skip it

        int i = 0;
        while(i <= nums.length-1) {
            if(nums[i] == i+1 || nums[i] == nums[nums[i]-1])
                i++;
            else
                swap(nums, i, nums[i]-1);
        }

        // STEP-2 : all the valid integers has been places on the correct indexes
        //          invalid(duplicate) number will be placed at invalid index (on last index)
        for(int index = 0; index <= nums.length-1; index++) {
            if(nums[index] != index+1)
                return nums[index];
        }
        return -1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}