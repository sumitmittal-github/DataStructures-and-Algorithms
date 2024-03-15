package com.sumit.datastructures.numbersystem;

public class a_EvenOrOdd {

    public static void main(String[] args) {
        System.out.println("Is Odd : ");
        System.out.println("-100 : " + isOdd(-100));
        System.out.println("-99  : " + isOdd(-99));
        System.out.println("0    : " + isOdd(0));
        System.out.println("100  : " + isOdd(10));
        System.out.println("11   : " + isOdd(11));
        System.out.println("---------------");

        System.out.println("Is Even : ");
        System.out.println("-100 : " + isEven(-100));
        System.out.println("-99  : " + isEven(-99));
        System.out.println("0    : " + isEven(0));
        System.out.println("100  : " + isEven(10));
        System.out.println("11   : " + isEven(11));
    }

    public static boolean isOdd(int num){
        return (num & 1) == 1;
    }
    public static boolean isEven(int num){
        return (num & 1) == 0;
    }

}