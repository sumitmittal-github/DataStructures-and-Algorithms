package com.sumit.datastructures.b_recursion.a_basics;

import java.util.LinkedList;
import java.util.List;

public class Recursion12_DiceTotalSum {

    public static void main(String[] args) {
        System.out.println(new Recursion12_DiceTotalSum().getDiceCountToGetTotalSumAsN(6, ""));
        System.out.println(new Recursion12_DiceTotalSum().getAllDiceCombinationsToGetTotalSumAsN(6, ""));
    }

    public int getDiceCountToGetTotalSumAsN(int target, String answer) {
        int count = 0;

        // base condition
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }


        for(int i = 1; i <= 6; i++) {
            Integer countFromBelowTree = getDiceCountToGetTotalSumAsN(target-i, answer+i);
            count = count + countFromBelowTree;
        }
        return count;
    }


    public List<String> getAllDiceCombinationsToGetTotalSumAsN(int target, String answer) {
        List<String> diceCombinations = new LinkedList<>();

        // base condition
        if(target == 0) {
            diceCombinations.add(answer);
            return diceCombinations;
        }
        if(target < 0) {
            return null;
        }


        for(int i = 1; i <= 6; i++) {
            List<String> previousDiceCombinations = getAllDiceCombinationsToGetTotalSumAsN(target-i, answer+i);
            if(previousDiceCombinations != null)
                diceCombinations.addAll(previousDiceCombinations);
        }
        return diceCombinations;
    }
}