package com.sumit.datastructures.mixprograms;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the position : ");
        int position = scanner.nextInt();

        while(position >= 0) {
            System.out.println("With For Loop : " + getNthFibonacciNumber(position));
            System.out.println("With Formula  : " + getNthFibonacciNumberWithFormula(position));
            System.out.print("Please enter the position : ");
            position = scanner.nextInt();
        }

        System.out.print("Algorithm finished !!");
    }


    private static int getNthFibonacciNumber(int position){
        int a=0, b=1, fabNum=0;
        if(position==0)
            fabNum = a;
        else if(position==1)
            fabNum = b;
        else {
            for(int i=2; i<=position; i++){
                fabNum=a+b;
                a=b;
                b=fabNum;
            }
        }
        return fabNum;
    }

    private static long getNthFibonacciNumberWithFormula(int position){
        double squareRoot5 = Math.sqrt(5);
        double part1 = Math.pow( ((1+squareRoot5)/2), position);
        double part2 = Math.pow( ((1-squareRoot5)/2), position);        // we can also remove this part2 as it is less dominating term

        return (long)((part1-part2)/squareRoot5);
    }

}
