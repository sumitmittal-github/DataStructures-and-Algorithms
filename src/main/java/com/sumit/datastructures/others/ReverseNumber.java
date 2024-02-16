package com.sumit.datastructures.others;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter any number : ");
        int num = scanner.nextInt();

        while(num > 0){
            System.out.println(reverseNumber_approach2(num));
            System.out.print("Please enter any number : ");
            num = scanner.nextInt();
        }
    }

    private static int reverseNumber_approach1(int num){
        String strNum = String.valueOf(num);
        StringBuilder outputStrNum = new StringBuilder();
        for(int i = strNum.length()-1; i>=0; i--) {
            outputStrNum.append(strNum.charAt(i));
        }
        return Integer.parseInt(outputStrNum.toString());
   }

    private static int reverseNumber_approach2(int num){
        int output = 0;
        while(num > 0){
            int reminder = num % 10;
            output = output*10 + reminder;
            num = num/10;
        }
        return output;
    }


}