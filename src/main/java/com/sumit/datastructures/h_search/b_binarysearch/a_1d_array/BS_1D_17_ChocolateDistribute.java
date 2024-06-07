package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_17_ChocolateDistribute {

    // https://www.geeksforgeeks.org/chocolate-distribution-problem/
    // https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

    public static void main(String[] args) {
        BS_1D_17_ChocolateDistribute obj = new BS_1D_17_ChocolateDistribute();

        int[] chocolateBoxesArr1 = {5, 3, 1, 4, 2};
        int noOfStudents1 = 3;
        System.out.println("ChocolateBoxes arr : " + Arrays.toString(chocolateBoxesArr1) + ", noOfStudents : "+ noOfStudents1 + " => MinimalMaxima = " + obj.distributeChocolate(chocolateBoxesArr1, noOfStudents1));

        int[] chocolateBoxesArr2 = {12, 34, 67, 90};
        int noOfStudents2 = 2;
        System.out.println("ChocolateBoxes arr : " + Arrays.toString(chocolateBoxesArr2) + ", noOfStudents : "+ noOfStudents2 + " => MinimalMaxima = " + obj.distributeChocolate(chocolateBoxesArr2, noOfStudents2));
    }

    public int distributeChocolate(int[] arr, int noOfStudents){
        int start = 1, end = (int) 1e9;                        // because max boxes = 10^5 and each box has 10^4 chocolates
        int possibleAns = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            boolean isPossible = isDivisionPossible(arr, noOfStudents, mid);
            if(isPossible){
                possibleAns = mid;
                end = mid-1;
            } else
                start = mid+1;
        }
        return possibleAns;
    }


    // check if we can distribute all the chocolates by giving each child maxChocolateEachKid
    private boolean isDivisionPossible(int[] arr, int noOfStudents, int maxChocAllowed) {
        int chocolateSum = 0;
        for(int i=0; i< arr.length; i++) {

            if(noOfStudents == 0)  return false;                    // if no more students left, but we have chocolate boxes left
            if(arr[i] > maxChocAllowed) return false;          // Ex: if box has 10 chocolate but max we can give only 3 chocolate to a kid

            chocolateSum = chocolateSum + arr[i];
            if(chocolateSum > maxChocAllowed){
                i--;    // to reconsider this current iteration chocolate box
                noOfStudents--;
                chocolateSum = 0;
            }
        }
        return true;
    }


}