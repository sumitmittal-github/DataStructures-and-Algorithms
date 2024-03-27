package com.sumit.datastructures.f_squareroot;

public class SquareRoot_3_ForNotPerfectSqrtNums {

    // as we are searching in sorted sequence numbers hence we can leverage the advantage of binary search.
    //now the number is not a perfect square root, ex - 40, its Math.sqrt(40) = 6.32

    public static void main(String[] args) {
        int n = 40;
        int d = 6;      // till how many decimal places

        double root = findSquareRootWithPrecision(n, d);
        System.out.printf("%.6f", root);
    }

    private static double findSquareRootWithPrecision(int num, int d) {
        double root = 0;

        // STEP-1 : finding the integer part of the answer
        int start = 2;
        int end = num;
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(num == mid*mid)
                return mid;             // number is perfect square root. found the answer
            else if(num < mid*mid)
                end = mid-1;
            else
                start = mid+1;
        }
        root = end;  // at the end of the loop then end variable will point to the integer part of the answer


        // STEP-2 : finding the fractional part. run loop 3 times if we want to get answer till 3 decimal places
        double fraction = 0.1;
        for (int i = 0; i < d; i++) {
            while(root*root < num){
                root = root + fraction;
            }
            root = root - fraction;     // because when while loop broke, we were on the answer + fraction number, hence subtract fraction to get the answer
            fraction = fraction/10;     // look for next decimal place
        }

        return root;
    }


}