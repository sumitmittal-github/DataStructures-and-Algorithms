package com.sumit.datastructures.d_hcf_lcm;

// LCM : Least Common Multiple
public class LCM {

    public static void main(String[] args) {
        System.out.println("LCM of 2, 5 is   : " + lcm(2, 5));
        System.out.println("LCM of 3, 7 is   : " + lcm(3, 7));
        System.out.println("LCM of 2, 4 is   : " + lcm(2, 4));
        System.out.println("LCM of 24, 15 is : " + lcm(24, 15));
    }

    private static int lcm(int a, int b) {
        return (a*b)/hcf(a, b);
    }

    private static int hcf(int a, int b) {
        if(a == 0)
            return b;

        return hcf(b%a, a);
    }


}