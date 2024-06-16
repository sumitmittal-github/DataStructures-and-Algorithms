package com.sumit.datastructures.b_recursion.a_basics;

public class Recursion7_ReverseNumber {

    public static void main(String[] args) {
        System.out.println(reverseNumber_1(123456789));
        System.out.println(reverseNumber_2(123456789));
        System.out.println(reverseNumber_3(123456789));
        System.out.println(reverseNumber_4(123456789));
        System.out.println(reverseNumber_5(123456789));
    }


    // Approach-1 : by converting in string
    private static int reverseNumber_1(int num){
        String strNum = String.valueOf(num);
        StringBuilder outputStrNum = new StringBuilder();
        for(int i = strNum.length()-1; i>=0; i--) {
            outputStrNum.append(strNum.charAt(i));
        }
        return Integer.parseInt(outputStrNum.toString());
    }



    // Approach-2 : iteration
    public static int reverseNumber_2(int n) {
        int ans = 0;
        while(n>0){
            ans = (ans * 10) + (n%10);
            n = n/10;
        }
        return ans;
    }



    // Approach-3 : recursion
    // not good approach, because we need to maintain 1 variable in recursion function
    public static int reverseNumber_3(int n) {
        if(n <= 10)
            return n;

        return reverseNumber_3_helper(n, 0);
    }
    private static int reverseNumber_3_helper(int n, int ans) {
        if(n == 0)  return ans;

        ans = (ans * 10) +  (n % 10);
        return reverseNumber_3_helper(n/10, ans);
    }



    // Approach-4 : better than approach-3
    // because, in this approach we are counting the number of digits only once
    // drawback : 1 extra variable, therefore helper method
    public static int reverseNumber_4(int n) {
        int numOfDigitsInN = (int)Math.log10(n) + 1;
        return reverseNumber_4_helper(n,numOfDigitsInN-1);
    }
    private static int reverseNumber_4_helper(int n, int numOfDigitsInN){
        if(n < 10)
            return n;

        int lastDigit = n % 10;
        int multiply = (int)Math.pow(10, numOfDigitsInN);

        return   (lastDigit * multiply)  +  reverseNumber_4_helper(n/10, --numOfDigitsInN);
    }



    // Approach-5 : Best approach, better than approach-4
    // because no helper method, we can count numOfDigits in same iteration
    // also we do not need the extra variable
    private static int reverseNumber_5(int n) {
        if(n < 10)
            return n;

        int numOfDigitsInN = (int)Math.log10(n) + 1;
        int lastDigit = (n%10);
        int multiply = (int)Math.pow(10, numOfDigitsInN-1);

        return (lastDigit * multiply) + reverseNumber_5(n/10);
    }


}