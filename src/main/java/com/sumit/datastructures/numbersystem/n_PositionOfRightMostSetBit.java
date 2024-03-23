package com.sumit.datastructures.numbersystem;

public class n_PositionOfRightMostSetBit {

    public static void main(String[] args) {
        System.out.println("Position of right most set bit for 18 : " + findPositionOfRightMostSetBit(18));      // 0001 0010
        System.out.println("Position of right most set bit for 18 : " + findPositionOfRightMostSetBit2(18));     // 0001 0010

        System.out.println("Position of right most set bit for 19 : " + findPositionOfRightMostSetBit(19));      // 0001 0011
        System.out.println("Position of right most set bit for 19 : " + findPositionOfRightMostSetBit2(19));     // 0001 0011

        System.out.println("Position of right most set bit for 48 : " + findPositionOfRightMostSetBit(48));      // 0011 0000
        System.out.println("Position of right most set bit for 48 : " + findPositionOfRightMostSetBit2(48));     // 0011 0000

        System.out.println("Position of right most set bit for 53 : " + findPositionOfRightMostSetBit(53));      // 0011 0101
        System.out.println("Position of right most set bit for 53 : " + findPositionOfRightMostSetBit2(53));     // 0011 0101

        System.out.println("Position of right most set bit for 54 : " + findPositionOfRightMostSetBit(54));      // 0011 0110
        System.out.println("Position of right most set bit for 54 : " + findPositionOfRightMostSetBit2(54));     // 0011 0110
    }

    // Logic : (n&~(n-1)) always return the binary number containing the rightmost set bit as 1
    private static int findPositionOfRightMostSetBit(int num){
        int rightmostSetBinary = num & ~(num-1);

        int position=0;
        while(rightmostSetBinary > 0){
            position++;

            int lsb = rightmostSetBinary & 1;
            if(lsb == 1){
                break;
            }
            rightmostSetBinary = rightmostSetBinary >> 1;
        }
        return position;
    }

    private static int findPositionOfRightMostSetBit2(int num){
        // if num = 0011 0000
        int rightmostSetBinary = num & ~(num-1);                    // rightmostSetBinary = 0001 0000

        // now the number of digits in base 2 will be the answer
        int numbersOfDigits = (int)(Math.log(rightmostSetBinary) / Math.log(2)) + 1;
        return numbersOfDigits;
    }
}