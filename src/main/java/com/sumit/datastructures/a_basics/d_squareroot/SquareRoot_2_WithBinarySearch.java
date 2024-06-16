package com.sumit.datastructures.a_basics.d_squareroot;

public class SquareRoot_2_WithBinarySearch {

    // as we are searching in sorted sequence numbers hence we can leverage the advantage of binary search.



    // Question-1 : square root of a non-negative number
    int findSquareRoot(int n) {
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


    // Question-2 : Find the square root of a non-negative integer number.
    // Round it off to the nearest floor integer value
    // Ex:      Input = 24     =>      Output = 4
    public int squareRootNearestFloor(int num){
        int start = 1, end = num/2;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid*mid == num)
                return mid;
            else if(mid*mid < num)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }



    // Question-3 : Find the square root of a non-negative integer number.
    // Round it off to the nearest floor integer value
    // Ex:      Input = (24, 3)     =>      means square root of 24, up to 3 precision
    // https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/
    public double squareRootWithPrecision(int num, int precision){
        double ans = -1;

        // step-1 : find the integer square root
        int start1 = 1;
        int end1 = num;
        while(start1 <= end1){
            int mid = start1 + (end1-start1)/2;

            if(mid*mid == num)
                return mid;
            else if(mid*mid < num)
                start1 = mid+1;
            else
                end1 = mid-1;
        }
        ans = end1;


        // step-2 : find the answer up to given precision
        double start2 = ans;
        double end2 = ans + 1 - Math.pow(0.1, precision);
        while(start2 <= end2){
            double mid = start2 + (end2-start2)/2;

            if(mid*mid == num)
                return mid;
            else if(mid*mid < num)
                start2 = mid + Math.pow(0.1, precision);
            else
                end2 = mid - Math.pow(0.1, precision);
        }
        ans = end2;

        return ans;
    }

    public static void main(String[] args) {
        SquareRoot_2_WithBinarySearch obj = new SquareRoot_2_WithBinarySearch();

        System.out.println("Square root of 81 is : " + obj.findSquareRoot(81));
        System.out.println("Square root of 82 is : " + obj.findSquareRoot(82));
        System.out.println("Square root of 4 is : " + obj.findSquareRoot(4));

        System.out.println("Nearest Floor Square root of 24 is : " + obj.squareRootNearestFloor(24));
        System.out.println("Nearest Floor Square root of 25 is : " + obj.squareRootNearestFloor(25));
        System.out.println("Nearest Floor Square root of 26 is : " + obj.squareRootNearestFloor(26));

        System.out.println("Nearest Floor Square root of 24 is : " + obj.squareRootWithPrecision(50, 3));
        System.out.println("Nearest Floor Square root of 25 is : " + obj.squareRootWithPrecision(10, 4));
    }
}