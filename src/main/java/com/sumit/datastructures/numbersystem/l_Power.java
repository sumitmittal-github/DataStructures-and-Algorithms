package com.sumit.datastructures.numbersystem;

public class l_Power {

    public static void main(String[] args) {
        System.out.println(calculatePower_1(3, 6));
        System.out.println(calculatePower_2(3, 6));

        System.out.println(calculatePower_1(7, 5));
        System.out.println(calculatePower_2(7, 5));
    }

    // Complexity -> O(base)
    private static int calculatePower_1(int base, int power) {
        int answer = 1;
        while(power > 0){
            answer = answer * base;
            power--;
        }
        return answer;
    }

    // Complexity -> O(log(base))
    private static int calculatePower_2(int base, int power) {
        int answer = 1;

        while(power > 0) {
            int lsbOfPower = power & 1;
            if(lsbOfPower == 1){
                answer = answer * base;
            }

            base = base * base;
            power = power>>1;
        }
        return answer;
    }
}
