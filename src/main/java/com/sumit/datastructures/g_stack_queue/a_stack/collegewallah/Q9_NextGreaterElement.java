package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.*;

public class Q9_NextGreaterElement {

    // LeetCode-496 : https://leetcode.com/problems/next-greater-element-i/description/


    // Approach-1 : Actual approach by creating the next greater element array
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length <= 1)
            return new int[] { -1 };

        int[] nextGreaterArr = getNextGreaterElementArr(nums2);

        int[] ansArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ansArr[i] = nextGreaterArr[j];
                }
            }
        }
        return ansArr;
    }
    private int[] getNextGreaterElementArr(int[] arr){
        int[] ansArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // push last element in the stack and -1 in the nextGreaterArr because last
        // element can not have next greater element
        ansArr[arr.length - 1] = -1;
        stack.push(arr[arr.length - 1]);

        // iterate from 2nd last element
        for (int i = arr.length - 2; i >= 0; i--) {

            // keep poping the element untill we get a greater element in stack
            while (stack.size() > 0 && stack.peek() < arr[i])
                stack.pop();

            if (stack.size() == 0)  ansArr[i] = -1;
            else                    ansArr[i] = stack.peek();

            stack.push(arr[i]);
        }
        return ansArr;
    }


    // Approach-2 : shortcut approach, but may not work all the time
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums2.length == 0)    return nums1;

        int[] nextGreaterArr = new int[10000];
        nextGreaterArr[nums2[nums2.length - 1]] = -1;
        for (int i = nums2.length-2; i >= 0; i--) {
            int currentElement = nums2[i];
            int nextElement = nums2[i + 1];
            while (nextElement < currentElement && nextElement != -1) {
                nextElement = nextGreaterArr[nextElement];
            }
            nextGreaterArr[currentElement] = nextElement;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterArr[nums1[i]];
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }


}