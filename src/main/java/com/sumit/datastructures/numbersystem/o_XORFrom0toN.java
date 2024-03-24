package com.sumit.datastructures.numbersystem;

public class o_XORFrom0toN {

    public static void main(String[] args) {
        System.out.println("XOR from 0 to 0 is : " + calculateXOR(0));
        System.out.println("XOR from 0 to 0 is : " + calculateXOR2(0));

        System.out.println("XOR from 0 to 1 is : " + calculateXOR(1));
        System.out.println("XOR from 0 to 1 is : " + calculateXOR2(1));

        System.out.println("XOR from 0 to 2 is : " + calculateXOR(2));
        System.out.println("XOR from 0 to 2 is : " + calculateXOR2(2));

        System.out.println("XOR from 0 to 3 is : " + calculateXOR(3));
        System.out.println("XOR from 0 to 3 is : " + calculateXOR2(3));

        System.out.println("XOR from 0 to 4 is : " + calculateXOR(4));
        System.out.println("XOR from 0 to 4 is : " + calculateXOR2(4));

        System.out.println("XOR from 0 to 5 is : " + calculateXOR(5));
        System.out.println("XOR from 0 to 5 is : " + calculateXOR2(5));

        System.out.println("XOR from 0 to 6 is : " + calculateXOR(6));
        System.out.println("XOR from 0 to 6 is : " + calculateXOR2(6));
    }

    private static int calculateXOR(int n) {
        int result=0;
        while(n > 0) {
            result = result ^ n;
            n--;
        }
        return result;
    }

    private static int calculateXOR2(int n) {
        int modulo = n%4;

        if(modulo == 0) return n;
        else if(modulo == 1) return 1;
        else if(modulo == 2) return n+1;
        else return 0;
    }

}