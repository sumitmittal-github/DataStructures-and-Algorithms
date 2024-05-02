package com.sumit;

public class Test {

    public static void main(String[] args) {
        //System.out.println(new Test().sumOfDigits(123, 0));
        System.out.println(new Test().sumOfDigits(650043210));
    }



    public int sumOfDigits(int n, int ans){
        if(n <= 0)
            return ans;

        ans = ans + n%10;
        return sumOfDigits(n/10, ans);
    }


    public int sumOfDigits(int n){
        if(n < 10)
            return n;

        return n%10 + sumOfDigits(n/10);
    }

}