package com.sumit.datastructures.b_recursion.c_subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets5_FrogJump {

    // https://www.geeksforgeeks.org/minimum-cost-for-hopping-frog-to-reach-stair-n/

    /**
     * There are N stairs, numbered 1,2,…, N.
     * For each i (1≤i≤N), the height of stair i is arr[i].
     * There is a frog who is initially on stair 1.
     * He will repeat the following action some number of times to reach stair N.
     * If the frog is currently on stair i -
     *      1. jump to Stone i+1
     *      2. or jump to Stone i+2.
     * Here, a cost of ∣hi −hj∣ is incurred, where j is the stone to land on.
     * Find the minimum possible total cost incurred before the frog reaches stair N.
     *
     * Ex:-
     * Input  : n = 4, heights = [20, 30, 40, 20]
     * Output : 20
     * Reason :             move1 =    stair-1 -> stair-2      :    cost = |30-20| = 10
     *                      move2 =    stair-2 -> stair-4      :    cost = |20-30| = 10
     *                                                        TOTAL COST = 10 + 10 = 20
     * */


    // Approach-1 : Taking list to store all the results and then taking the minimum
    public Integer frogJump_1(int[] arr){
        if(arr == null || arr.length == 0 || arr.length == 1)
            return 0;
        if(arr.length == 2)
            return arr[0] > arr[1] ? arr[0]-arr[1] : arr[1]-arr[0];

        List<Integer> list = frogJumpHelper_1(arr, 0, 0);
        return Collections.min(list);
    }

    public List<Integer> frogJumpHelper_1(int[] arr, int currentIndex, int totalCost){
        List<Integer> list = new ArrayList<>();
        if(currentIndex == arr.length-1){
            list.add(totalCost);
            return list;
        }

        // frog jumps 1 stair
        int newCostJump1 = totalCost +Math.abs(arr[currentIndex] - arr[currentIndex+1]);
        list.addAll(frogJumpHelper_1(arr, currentIndex+1, newCostJump1));

        // frog jumps 2 stair
        if(currentIndex < arr.length-2){
            int newCostJump2 = totalCost + Math.abs(arr[currentIndex] - arr[currentIndex+2]);
            list.addAll(frogJumpHelper_1(arr, currentIndex+2, newCostJump2));
        }

        return list;
    }



    // Approach-2 : Do not take list, directly keep on calculating the min
    public Integer frogJump_2(int[] arr){
        if(arr == null || arr.length == 0 || arr.length == 1)
            return 0;
        if(arr.length == 2)
            return Math.abs(arr[0] - arr[1]);

        return frogJumpHelper_2(arr, 0);
    }

    public int frogJumpHelper_2(int[] arr, int currentIndex){
        if(currentIndex == arr.length-1){
            return 0;   // because no cost if we are at last stone
        }

        // frog jumps 1 stair
        int jump1Cost = Math.abs(arr[currentIndex] - arr[currentIndex+1]) + frogJumpHelper_2(arr, currentIndex+1);

        int jump2Cost = 0;
        // frog jumps 2 stair
        if(currentIndex < arr.length-2){
            jump2Cost = Math.abs(arr[currentIndex] - arr[currentIndex+2]) + frogJumpHelper_2(arr, currentIndex+2);
        }

        return Math.min(jump1Cost, jump2Cost);
    }


    public static void main(String[] args) {
        Subsets5_FrogJump obj = new Subsets5_FrogJump();

        int[] arr = new int[]{20, 30, 40, 20};
        System.out.println(obj.frogJump_1(arr));   // O/p: 20
        System.out.println(obj.frogJump_1(arr));   // O/p: 20
        System.out.println();

        int[] arr2 = new int[]{10, 20, 30, 10};
        System.out.println(obj.frogJump_1(arr2));   // O/p: 20
        System.out.println(obj.frogJump_1(arr2));   // O/p: 20
        System.out.println();

        int[] arr3 = new int[]{10, 30, 40, 20};
        System.out.println(obj.frogJump_1(arr3));   // O/p: 30
        System.out.println(obj.frogJump_1(arr3));   // O/p: 30
        System.out.println();
    }
}