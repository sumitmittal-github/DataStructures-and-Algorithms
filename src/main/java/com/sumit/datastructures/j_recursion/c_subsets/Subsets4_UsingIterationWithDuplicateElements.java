package com.sumit.datastructures.j_recursion.c_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Subsets4_UsingIterationWithDuplicateElements {

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subsets(arr));
        System.out.println(subsets2(arr));
    }



    // Approach-1 : before adding the new subset in allSubsetsList,
    //         check if similar kind of subset is already present in the allSubsetsList
    //         if not, only then add this subset in allSubsetsList
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

                // before adding the new subset, check if similar kind of subset is already present in the allSubsetsList
                // if not already present, only then add it.
                boolean isAlreadyPresent = isAlreadyPresent(allSubsetsList, acceptSubset);
                if(!isAlreadyPresent)
                    allSubsetsList.add(acceptSubset);
            }
        }
        return allSubsetsList;
    }

    private static boolean isAlreadyPresent(List<List<Integer>> allSubsetsList, List<Integer> acceptSubset){
        boolean isAlreadyPresent = false;
        for(List<Integer> tempAllSubsets : allSubsetsList) {
            if(tempAllSubsets.equals(acceptSubset)){
                isAlreadyPresent = true;
                break;
            }
        }
        return isAlreadyPresent;
    }


    // Approach-2 : better approach -
    //         when created new subsets with duplicate element,
    //         then only add it in above steps accepted subsets
    public static List<List<Integer>> subsets2(int[] inputArr) {

        // sort the array, to make the duplicate elements adjacent.
        Arrays.sort(inputArr);

        List<List<Integer>> allSubsetsList = new CopyOnWriteArrayList<>();
        allSubsetsList.add(new CopyOnWriteArrayList<>());       // initialize the allSubsetsList

        // to keep track if the element duplicate or new
        List<Integer> processedElements = new ArrayList<>();
        List<List<Integer>> allPreviousStepsAcceptSubsetsList = new CopyOnWriteArrayList<>();


        // for each number in array -> iterate all previous subsets -> and create new subsets by adding this number in all those subsets
        for (int num : inputArr) {

            if(!processedElements.contains(num)){
                // it means it is fresh element, hence make new subsets with all existing subsets.
                allPreviousStepsAcceptSubsetsList = new CopyOnWriteArrayList<>();
                for (List<Integer> allSubsets : allSubsetsList) {
                    // create new subset = all previous + current element
                    List<Integer> acceptSubset = new CopyOnWriteArrayList<>();
                    acceptSubset.addAll(allSubsets);
                    acceptSubset.add(num);
                    allSubsetsList.add(acceptSubset);
                    allPreviousStepsAcceptSubsetsList.add(acceptSubset);
                }
                processedElements.add(num);
            }
            else {
                // it means it is a duplicate element, hence make new subsets only with above steps accepted subsets
                for (List<Integer> allSubsets : allPreviousStepsAcceptSubsetsList) {
                    // create new subset = all previous steps active subsets + current element
                    List<Integer> acceptSubset = new CopyOnWriteArrayList<>();
                    acceptSubset.addAll(allSubsets);
                    acceptSubset.add(num);
                    allSubsetsList.add(acceptSubset);
                }
            }
        }
        return allSubsetsList;
    }

}