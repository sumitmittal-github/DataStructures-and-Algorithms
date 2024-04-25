package com.sumit.datastructures.z_mixprograms;

public class UniqueNumberInArray {

    // Program: Find the unique number is an array, where all numbers are coming twice, except 1 number.

    public static void main(String[] args) {
        UniqueNumberInArray obj = new UniqueNumberInArray();

        int[] arr1 = {1, 2, 4, 4, 2, 3, 3};
        System.out.println(obj.uniqueNumber_approach1(arr1));
        System.out.println(obj.uniqueNumber_approach2(arr1));

        int[] arr2 = {1, 2, 4, 4, 2, 3, 1};
        System.out.println(obj.uniqueNumber_approach1(arr2));
        System.out.println(obj.uniqueNumber_approach2(arr2));
    }



    public int uniqueNumber_approach1(int[] arr) {
        int unique = 0;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] == num){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
            if(arr[i] != -1)
                return arr[i];
        }
        return -1;
    }

    public int uniqueNumber_approach2(int[] arr) {
        int unique = 0;
        for(int num : arr){
            unique = unique ^ num;
        }
        return unique;
    }


}