package com.sumit.datastructures.d_gcd_lcm;

// GCD : Greatest Common Divisor
// HCF : Highest Common Factor
public class GCD {

    public static void main(String[] args) {
        GCD obj = new GCD();

        System.out.println(obj.gcd_1(15, 24));
        System.out.println(obj.gcd_2(15, 24));
        System.out.println(obj.gcd_3(15, 24));

        System.out.println(obj.gcd_1(24, 15));
        System.out.println(obj.gcd_2(24, 15));
        System.out.println(obj.gcd_3(24, 15));
    }


    // Approach-1 : brute force approach
    //              GCD(x, y) <= min(x, y)
    public int gcd_1(int x, int y){
        int min = Math.min(x, y);
        for(int i=min; i>0; i--) {
            if(x%i == 0 && y%i == 0)
                return i;
        }
        return 1;
    }


    // Approach-2 : Long Division Approach
    public int gcd_2(int x, int y){
        while(x%y != 0){
            int reminder = x%y;
            x = y;
            y = reminder;
        }
        return y;
    }


    // Approach-3 : Euclid's Algorithm
    private static int gcd_3(int x, int y){
        if(y == 0)
            return x;
        return gcd_3(y, x%y);
    }

}