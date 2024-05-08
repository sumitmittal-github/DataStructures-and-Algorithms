package com.sumit.datastructures.z_mixprograms;

public class FrogJump2 {

    // LeetCode-2498 : https://leetcode.com/problems/frog-jump-ii/description/

    /**
       Intuition 1 :
           Travel to the last stone and then return to the first stone.
           It means there are two path from first to last stone,
           and two path have no intersection in the middle.
           We can image there are two frog jump from first to the last.
       Intuition 2
           If one stone not in path one and path 2,
           we can greedily add it to either of the path.
           So it exists arr best solution, that all stones are used.
       Explanation
           So we are going to assign stones to two frogs alternatively:
           A[0] A[1] A[2] A[3] ...
           start frog1 frog2 frog1 ...
       If we assign them not alternatively like:
           frog1 frog2 frog2 frog1
       The distance for frog 1 is huge and it's no better than
        frog1 frog2 frog1 frog2

       So in this problem,
           we need to calculate the maximunm distance between A[i] and A[i+2].

       Complexity
           Time O(n)
           Space O(1)
     * */

    public int maxJump(int[] arr) {
        if(arr.length == 2){
            return arr[1]-arr[0];
        }

        // Take difference of every alternate index
        int max = 0;
        for (int i = 0; i < arr.length-2; i++){
            int costOfThisJump = arr[i+2] - arr[i];
            max = Math.max(max, costOfThisJump);
        }
        return max;
    }

    public static void main(String[] args) {
        FrogJump2 obj = new FrogJump2();
        System.out.println(obj.maxJump(new int[]{0,2,5,6,7}));
    }

}