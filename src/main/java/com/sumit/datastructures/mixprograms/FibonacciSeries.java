package com.sumit.datastructures.mixprograms;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the position : ");
        int position = scanner.nextInt();

        while(position >= 0) {
            System.out.println(getNthFibonacciNumber(position));
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

}
