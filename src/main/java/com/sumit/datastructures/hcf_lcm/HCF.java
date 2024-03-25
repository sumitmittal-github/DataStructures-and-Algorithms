package com.sumit.datastructures.hcf_lcm;

// HCF : Highest Common Factor
// GCD : Greatest Common Divisor
public class HCF {

    public static void main(String[] args) {
        System.out.println("HCF of 4, 18 is : " + hcf(4, 18));
        System.out.println("HCF of 3, 18 is : " + hcf(3, 18));
        System.out.println("HCF of 13, 41 is : " + hcf(13, 41));
    }

    private static int hcf(int a, int b){
        if(a == 0)
            return b;
        return hcf(b%a, a );
    }

}