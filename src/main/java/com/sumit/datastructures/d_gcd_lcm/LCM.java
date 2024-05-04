package com.sumit.datastructures.d_gcd_lcm;

// LCM : Least Common Multiple
public class LCM {

    public static void main(String[] args) {
        LCM obj = new LCM();
        System.out.println("LCM of 2, 5 is   : " + obj.lcm(2, 5));
        System.out.println("LCM of 3, 7 is   : " + obj.lcm(3, 7));
        System.out.println("LCM of 2, 4 is   : " + obj.lcm(2, 4));
        System.out.println("LCM of 24, 15 is : " + obj.lcm(24, 15));
    }

    public int lcm(int x, int y) {
        return (x*y)/gcd(x, y);
    }

    private int gcd(int x, int y) {
        if(y == 0)
            return x;
        return gcd(y,x%y);
    }


}