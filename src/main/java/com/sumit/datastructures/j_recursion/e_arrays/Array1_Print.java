package com.sumit.datastructures.j_recursion.e_arrays;

public class Array1_Print {

    // Question-1 : Printing from index=0
    public void print(int[] arr){
        printHelper(arr, 0);
    }

    public void printHelper(int[] arr, int index){
        if(index == arr.length)
            return;

        System.out.println(arr[index]);
        printHelper(arr, index+1);
    }


    // Question-2 : Printing in reverse
    public void printReverse(int[] arr){
        printReverseHelper(arr, arr.length-1);
    }

    public void printReverseHelper(int[] arr, int index){
        if(index == -1)
            return;

        System.out.println(arr[index]);
        printReverseHelper(arr, index-1);
    }



    public static void main(String[] args) {
        Array1_Print obj = new Array1_Print();

        int[] arr = {1, 5, 3, 4, 6, 3, 4};
        obj.print(arr);
        System.out.println("---");

        obj.printReverse(arr);
    }

}