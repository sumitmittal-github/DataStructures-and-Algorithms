package com.sumit.datastructures.h_search.a_linearsearch;

public class LinearSearch8_MiximumWealth {

    // https://leetcode.com/problems/richest-customer-wealth/description/

    public static void main(String[] args) {
        int[][] arr = {
                {11, 45},
                {35, 3},
                {19, 5}
        };
        System.out.println("Max wealth : " + maximumWealth(arr));
    }

    private static int maximumWealth(int[][] accounts){
        int maxWealth = 0;

        for(int[] customerAcc : accounts) {
            int totalBal = 0;
            for(int bal : customerAcc){
                totalBal += bal;
            }
            if(totalBal > maxWealth)
                maxWealth = totalBal;
        }

        return maxWealth;
    }

}