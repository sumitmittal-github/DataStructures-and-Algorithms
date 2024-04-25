package com.sumit.datastructures.m_stack_queue.questions;

public class SQ_Q3_Histogram {

    //LeetCode-84 : https://leetcode.com/problems/largest-rectangle-in-histogram/description/

    // TODO : failing on 93rd test case on leetcode.
    // Will complete when see the College Wallah video
    public int largestRectangleArea(int[] heights) {
        if (heights.length <= 1)
            return heights[0];

        int largestRectangleArea = 0;
        // for each index see how much left and right we can go
        for (int i = 0; i < heights.length; i++) {
            int sizeAtMainIndex = heights[i];
            int maxRectangleAreaInThisIteration = 0;

            int leftAndRightBlocksCount = leftBlocksCount(heights, i) + rightBlocksCount(heights, i);
            //System.out.println( i + " - " + leftAndRightBlocksCount);

            maxRectangleAreaInThisIteration = sizeAtMainIndex * (leftAndRightBlocksCount+1);
            //System.out.println( i + " - " + maxRectangleAreaInThisIteration);

            largestRectangleArea = Math.max(largestRectangleArea, maxRectangleAreaInThisIteration);
            //System.out.println( i + " - " + largestRectangleArea);
        }
        return largestRectangleArea;
    }

    public int leftBlocksCount(int[] heights, int index) {
        // if we are at start of the array, then there are no more blocks on the left
        if (index == 0)
            return 0;

        int leftCount = 0;
        int sizeAtMainIndex = heights[index];
        for (int i = index - 1; i >= 0; i--) {
            int sizeOfPreviousBlock = heights[i];
            if (sizeAtMainIndex <= sizeOfPreviousBlock)
                leftCount++;
            else
                break;
        }
        return leftCount;
    }

    public int rightBlocksCount(int[] heights, int index) {
        // if we are at thr end of the array, then there are no more blocks on the right
        if (index == heights.length - 1)
            return 0;

        int rightCount = 0;
        int sizeAtMainIndex = heights[index];
        for (int i = index + 1; i < heights.length; i++) {
            int sizeOfNextBlock = heights[i];
            if (sizeAtMainIndex <= sizeOfNextBlock)
                rightCount++;
            else
                break;
        }
        return rightCount;
    }
}