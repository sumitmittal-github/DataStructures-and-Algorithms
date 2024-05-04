package com.sumit.datastructures.d_hcf_lcm;

// HCF : Highest Common Factor
// GCD : Greatest Common Divisor
public class HCF {

    public static void main(String[] args) {
        HCF obj = new HCF();

        System.out.println(obj.hcf_1(15, 24));
        System.out.println(obj.hcf_2(15, 24));
        System.out.println(obj.hcf_3(15, 24));

        System.out.println(obj.hcf_1(24, 15));
        System.out.println(obj.hcf_2(24, 15));
        System.out.println(obj.hcf_3(24, 15));
    }


    // Approach-1 : brute force approach
    //              GCD(x, y) <= min(x, y)
    public int hcf_1(int x, int y){
        int min = Math.min(x, y);
        for(int i=min; i>0; i--) {
            if(x%i == 0 && y%i == 0)
                return i;
        }
        return 1;
    }


    // Approach-2 : Long Division Approach
    public int hcf_2(int x, int y){
        while(x%y != 0){
            int reminder = x%y;
            x = y;
            y = reminder;
        }
        return y;
    }


    // Approach-3 : Euclid's Algorithm
    private static int hcf_3(int x, int y){
        if(y == 0)
            return x;
        return hcf_3(y, x%y);
    }

}