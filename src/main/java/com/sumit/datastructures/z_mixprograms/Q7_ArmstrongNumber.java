package com.sumit.datastructures.z_mixprograms;

import java.util.ArrayList;
import java.util.List;

public class Q7_ArmstrongNumber {

    public static void main(String[] args) {
        List<Integer> list = getAll3DigitArmstrongNumbers();
        System.out.println(list);
    }

    private static List<Integer> getAll3DigitArmstrongNumbers(){
        List<Integer> list = new ArrayList<>();
        for(int i=100; i<=999; i++){
            if(isArmstrong(i))
                list.add(i);
        }
        return list;
    }

    private static boolean isArmstrong(int number){
        int output=0, input=number;
        while(number > 0){
            int reminder = number%10;
            output += reminder*reminder*reminder;
            number /= 10;
        }
        return input == output;
    }

}