package com.sumit.datastructures.a_basics.a_patterns;

public class Pattern_8 {

/**
    4 4 4 4 4 4 4
    4 3 3 3 3 3 4
    4 3 2 2 2 3 4
    4 3 2 1 2 3 4
    4 3 2 2 2 3 4
    4 3 3 3 3 3 4
    4 4 4 4 4 4 4
 */

    public static void main(String[] args) {
        pattern(4);
    }

    private static void pattern(int n) {

        int totalRowAndCol = 2*n-1;

        for (int row = 1; row <= totalRowAndCol ; row++) {
            for (int col = 1; col <= totalRowAndCol ; col++) {

                int distanceFromLeft = col;
                int distanceFromRight = totalRowAndCol - distanceFromLeft + 1;
                int distanceFromTop = row;
                int distanceFromBottom = totalRowAndCol - distanceFromTop + 1;

                int minDistance = minDistance(distanceFromLeft, distanceFromRight, distanceFromTop, distanceFromBottom);

                /** Above minDistance will print below matrix
                    1 1 1 1 1 1 1
                    1 2 2 2 2 2 1
                    1 2 3 3 3 2 1
                    1 2 3 4 3 2 1
                    1 2 3 3 3 2 1
                    1 2 2 2 2 2 1
                    1 1 1 1 1 1 1
                 => Subtract minDistance from n-1 to get the desired output -
                */

                int output = n - minDistance + 1;
                System.out.print(output+" ");
            }

            System.out.println();
        }
    }

    private static int minDistance(int distanceFromLeft, int distanceFromRight, int distanceFromTop, int distanceFromBottom){
        int minDistance = distanceFromLeft;
        if(distanceFromRight < minDistance)
            minDistance = distanceFromRight;
        if(distanceFromTop < minDistance)
            minDistance = distanceFromTop;
        if(distanceFromBottom < minDistance)
            minDistance = distanceFromBottom;
        return minDistance;
    }

}