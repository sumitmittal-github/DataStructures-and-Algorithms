package com.sumit.datastructures.j_recursion.questions;

import java.util.LinkedList;
import java.util.List;

// Ex - Dice has 15 faces :  1 -> 15
public class Recur_Q3_MoreFacesDiceTotalSum {

    public static void main(String[] args) {
        System.out.println(new Recur_Q3_MoreFacesDiceTotalSum().getDiceCountToGetTotalSumAsN(15, 6, ""));
        System.out.println(new Recur_Q3_MoreFacesDiceTotalSum().getAllDiceCombinationsToGetTotalSumAsN(15, 6, ""));
    }

    public int getDiceCountToGetTotalSumAsN(int totalFaces, int target, String answer) {
        int count = 0;

        // base condition
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }


        for(int i = 1; i <= totalFaces; i++) {
            Integer countFromBelowTree = getDiceCountToGetTotalSumAsN(totalFaces,target-i, answer+i);
            count = count + countFromBelowTree;
        }
        return count;
    }


    public List<String> getAllDiceCombinationsToGetTotalSumAsN(int totalFaces, int target, String answer) {
        List<String> diceCombinations = new LinkedList<>();

        // base condition
        if(target == 0) {
            diceCombinations.add(answer);
            return diceCombinations;
        }
        if(target < 0) {
            return null;
        }


        for(int i = 1; i <= totalFaces; i++) {
            List<String> previousDiceCombinations = getAllDiceCombinationsToGetTotalSumAsN(totalFaces, target-i, answer+i);
            if(previousDiceCombinations != null)
                diceCombinations.addAll(previousDiceCombinations);
        }
        return diceCombinations;
    }
}