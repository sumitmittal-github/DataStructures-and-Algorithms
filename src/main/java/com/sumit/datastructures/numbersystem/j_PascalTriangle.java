package com.sumit.datastructures.numbersystem;

public class j_PascalTriangle {

    public static void main(String[] args) {
        System.out.println("Sum of 1st row of Pascal Triangle : " + findSumOfNthRowByPowerFunction(1));
        System.out.println("Sum of 1st row of Pascal Triangle : " + findSumOfNthRowByLeftShift(1));

        System.out.println("Sum of 2nd row of Pascal Triangle : " + findSumOfNthRowByPowerFunction(2));
        System.out.println("Sum of 2nd row of Pascal Triangle : " + findSumOfNthRowByLeftShift(2));

        System.out.println("Sum of 3rd row of Pascal Triangle : " + findSumOfNthRowByPowerFunction(3));
        System.out.println("Sum of 3rd row of Pascal Triangle : " + findSumOfNthRowByLeftShift(3));

        System.out.println("Sum of 4th row of Pascal Triangle : " + findSumOfNthRowByPowerFunction(4));
        System.out.println("Sum of 4th row of Pascal Triangle : " + findSumOfNthRowByLeftShift(4));
    }

    private static int findSumOfNthRowByPowerFunction(int n){
        return (int)Math.pow(2, n-1);
    }

    private static int findSumOfNthRowByLeftShift(int n){
        return 1<<(n-1);
    }

}
