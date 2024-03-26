package com.sumit.datastructures.recursion;

public class Recursion7_ReverseNumber {

    private static int reverseNum = 0;

    public static void main(String[] args) {
        // general approach
        System.out.println(reverseNumberByGeneralApproach(3124));
        // recursion approach way-1
        reverseNum = 0;
        reverseNumberByRecursion_1(3124);
        System.out.println(reverseNum);
        // recursion approach way-2
        System.out.println(reverseNumberByRecursion_2(3124));
        // recursion approach way-3
        System.out.println(reverseNumberByGeneralApproach(3124));

        // general approach
        System.out.println(reverseNumberByGeneralApproach(120));
        // recursion approach way-1
        reverseNum = 0;
        reverseNumberByRecursion_1(120);
        System.out.println(reverseNum);
        // recursion approach way-2
        System.out.println(reverseNumberByRecursion_2(120));
        // recursion approach way-3
        System.out.println(reverseNumberByGeneralApproach(120));

        // general approach
        System.out.println(reverseNumberByGeneralApproach(120035));
        // recursion approach way-1
        reverseNum = 0;
        reverseNumberByRecursion_1(120035);
        System.out.println(reverseNum);
        // recursion approach way-2
        System.out.println(reverseNumberByRecursion_2(120035));
        // recursion approach way-3
        System.out.println(reverseNumberByGeneralApproach(120035));
    }


    // Way-1 : general approach
    private static int reverseNumberByGeneralApproach(int n) {
        int ans = 0;
        while(n>0){
            ans = (ans * 10) + (n%10);
            n = n/10;
        }
        return ans;
    }


    // Way-2 : not good approach, because we need to maintain 1 variable outside recursion function
    private static void reverseNumberByRecursion_1(int n) {
        if(n <= 0)
            return;

        reverseNum = (reverseNum * 10) +  (n%10);
        reverseNumberByRecursion_1(n/10);
    }


    // Way-3 : better than Way-2, because in this approach we are counting the number of digits in the iteration itself
    // and we do not need the outside variable
    private static int reverseNumberByRecursion_2(int n) {
        if(n < 10)
            return n;

        int numOfDigitsInN = (int)Math.log10(n) + 1;
        int lastDigit = (n%10);
        int multiply = (int)Math.pow(10, numOfDigitsInN-1);

        return (lastDigit * multiply) + reverseNumberByRecursion_2(n/10);
    }


    // Way-4 : better than Way-3, because in this approach we are counting the number of digits only 1
    private static int reverseNumberByRecursion_3(int n) {
        int numOfDigitsInN = (int)Math.log10(n) + 1;
        return helper(n,numOfDigitsInN-1);
    }

    private static int helper(int n, int numOfDigitsInN){
        if(n < 10)
            return n;

        return (n) * (int)Math.pow(n, numOfDigitsInN) + helper(n/10, --numOfDigitsInN);
    }

}