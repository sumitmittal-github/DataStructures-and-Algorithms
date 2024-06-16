package com.sumit.datastructures.b_recursion.c_subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Subsets3_UsingIteration {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
        System.out.println(subsets2(arr));
    }



    // Approach-1 : use CopyOnWriteArrayList, to prevent CME (Concurrent Modification Exception)
    public static List<List<Integer>> subsets(int[] inputArr) {
        List<List<Integer>> allSubsetsList = new CopyOnWriteArrayList<>();

        // initialize the allSubsetsList
        allSubsetsList.add(new CopyOnWriteArrayList<>());

        // for each number in array -> iterate all previous subsets -> and create new subsets by adding this number in all those subsets
        for (int num : inputArr) {

            for (List<Integer> allSubsets : allSubsetsList) {

                // create new subset = all previous + current element
                List<Integer> acceptSubset = new CopyOnWriteArrayList<>();
                acceptSubset.addAll(allSubsets);
                acceptSubset.add(num);
                allSubsetsList.add(acceptSubset);
            }
        }
        return allSubsetsList;
    }


    // Approach-2 : use ArrayList, instead of CopyOnWriteArrayList
    //         clone the list to prevent the CME
    public static List<List<Integer>> subsets2(int[] inputArr) {
        List<List<Integer>> allSubsetsList = new ArrayList<>();

        // initialize the allSubsetsList
        allSubsetsList.add(new ArrayList<>());

        // for each number in array -> iterate all previous subsets -> and create new subsets by adding this number in all those subsets
        for (int num : inputArr) {

            // to prevent CME : iterating on other list(tempList) instead of actual list (allSubsetsList),
            // because in the same iteration we are adding elements in allSubsetsList.
            List<List<Integer>> tempList = new ArrayList<>();
            tempList.addAll(allSubsetsList);

            for (List<Integer> allSubsets : tempList) {

                // create new subset = all previous + current element
                List<Integer> acceptSubset = new ArrayList<>();
                acceptSubset.addAll(allSubsets);
                acceptSubset.add(num);
                allSubsetsList.add(acceptSubset);
            }
        }
        return allSubsetsList;
    }
}