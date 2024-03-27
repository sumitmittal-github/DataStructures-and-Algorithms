package com.sumit.datastructures.z_mixprograms;

import java.util.Scanner;

public class CountOccurrence_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number and the integer to find in that number : ");
        long number = scanner.nextLong();
        int findNum = scanner.nextInt();

        while(number >= 0) {
            System.out.println(CountDigitOccurrence(number, findNum));
            System.out.print("Please enter the number and the integer to find in that number : ");
            number = scanner.nextLong();
            findNum = scanner.nextInt();
        }

        System.out.print("Algorithm finished !!");
    }

    private static int CountDigitOccurrence(long number, int digit){
        int count = 0;
        while(number > 0) {
            int reminder = (int) number % 10;
            if(reminder == digit)
                count++;

            number = number / 10;
        }
        return count;
    }


}
