package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion9_CountZeros {

    public static void main(String[] args) {
        System.out.println(countZeros(12345));
        System.out.println(countZeros2(12345));

        System.out.println(countZeros(0));
        System.out.println(countZeros2(0));

        System.out.println(countZeros(30204));
        System.out.println(countZeros2(30204));

        System.out.println(countZeros(0012));
        System.out.println(countZeros2(0012));

    }


    // Approach-1 : Zeros in last digit + Zeros in rest of the number
    private static int countZeros(int num){
        if(num < 10) {
            if(num == 0)
                return 1;           // handling if we're only passing 0 as input, then output should be 1
            else
                return 0;
        }

        int lastDigit = num%10;
        return (lastDigit==0 ? 1 : 0) + countZeros(num/10);
    }


    // Approach-2 : Taking helper function and count as an argument
    private static int countZeros2(int num) {
        int count = 0;
        return countZeros2Helper(num, count);
    }

    private static int countZeros2Helper(int num, int count) {
        if(num < 10) {
            if(num == 0)
                return ++count;           // handling if we're only passing 0 as input, then output should be 1
            else
                return count;
        }

        int lastDigit = num%10;
        return countZeros2Helper(num/10, (lastDigit == 0 ? ++count : count));  // is last digit is zero then incrementing the count, else not.
    }

}