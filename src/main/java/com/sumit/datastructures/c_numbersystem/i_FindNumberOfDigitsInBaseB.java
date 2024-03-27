package com.sumit.datastructures.c_numbersystem;

public class i_FindNumberOfDigitsInBaseB {


    public static void main(String[] args) {
        System.out.println("# digits in 10 in base 2 : " + findNumberOfDigitsInBaseB(10, 2));
        System.out.println("# digits in 127 in base 2 : " + findNumberOfDigitsInBaseB(127, 2));

        System.out.println("# digits in 10 in base 8 : " + findNumberOfDigitsInBaseB(10, 8));
        System.out.println("# digits in 127 in base 8 : " + findNumberOfDigitsInBaseB(127, 8));

        System.out.println("# digits in 10 in base 10 : " + findNumberOfDigitsInBaseB(10, 10));
        System.out.println("# digits in 127 in base 10 : " + findNumberOfDigitsInBaseB(127, 10));

        System.out.println("# digits in 10 in base 16 : " + findNumberOfDigitsInBaseB(10, 16));
        System.out.println("# digits in 127 in base 16 : " + findNumberOfDigitsInBaseB(127, 16));
    }

    private static int findNumberOfDigitsInBaseB(int num, int base) {
        // logb(n) = loge(n) / loge(b)
        return (int)(Math.log(num) / Math.log(base)) + 1;
    }

}
