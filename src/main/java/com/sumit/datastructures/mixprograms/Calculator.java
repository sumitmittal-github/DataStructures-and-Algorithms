package com.sumit.datastructures.mixprograms;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Please enter the operator : ");
            char operation = scanner.next().trim().charAt(0);
            if(operation == 'X' || operation == 'x')
                break;
            System.out.print("");

            System.out.println("Please enter 2 numbers : ");
            double firstNum = scanner.nextDouble();
            double secondNum = scanner.nextDouble();
            System.out.print("");

            if(operation == '+')
                System.out.println(firstNum+secondNum);
            else if(operation == '-')
                System.out.println(firstNum-secondNum);
            else if(operation == '*')
                System.out.println(firstNum*secondNum);
            else if(operation == '/' && secondNum != 0)
                System.out.println(firstNum/secondNum);
            else if(operation == '%')
                System.out.println(firstNum%secondNum);
            else
                System.out.println("Invalid Operation");
        }
    }

}