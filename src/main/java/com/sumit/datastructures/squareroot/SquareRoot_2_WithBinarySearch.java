package com.sumit.datastructures.squareroot;

public class SquareRoot_2_WithBinarySearch {

    // as we are searching in sorted sequence numbers hence we can leverage the advantage of binary search.

    public static void main(String[] args) {
        System.out.println("Square root of 81 is : " + findSquareRoot(81));
        System.out.println("Square root of 82 is : " + findSquareRoot(82));
        System.out.println("Square root of 4 is : " + findSquareRoot(4));
    }

    private static int findSquareRoot(int n) {
        int start = 2;
        int end = n;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(n == mid*mid)
                return mid;
            else if(n < mid*mid)
                end = mid-1;
            else
                start = mid+1;
        }
        return Integer.MIN_VALUE;
    }

}