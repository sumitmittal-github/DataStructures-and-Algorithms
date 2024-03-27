package com.sumit.datastructures.z_mixprograms;

import java.util.Scanner;

public class CountOccurrence_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number and the integer to find in that number : ");
        long number = scanner.nextLong();
        long findNum = scanner.nextLong();

        while(number >= 0) {
            System.out.println(CountOccurrenceInNumber(number, findNum));
            System.out.print("Please enter the number and the integer to find in that number : ");
            number = scanner.nextLong();
            findNum = scanner.nextLong();
        }

        System.out.print("Algorithm finished !!");
    }


    private static int CountOccurrenceInNumber(Long number, Long findNum) {
        int count = 0;
        for(String eachNum : number.toString().split("")) {
            if(eachNum.equals(findNum.toString()))
                count++;
        }
        return count;
    }


}
