package com.sumit.datastructures.arrays;

public class a_BinarySearch {

    public static void main(String[] args) {
        int[] intArr = new int[]{ 0,1,2,3,4,5,6,7,8,9 };

        System.out.println("Element - found - iterations");

        find(intArr, -100);
        find(intArr, -1);
        find(intArr, 0);
        find(intArr, 1);
        find(intArr, 2);
        find(intArr, 3);
        find(intArr, 4);
        find(intArr, 5);
        find(intArr, 6);
        find(intArr, 7);
        find(intArr, 8);
        find(intArr, 9);
        find(intArr, 10);
        find(intArr, 100);
    }

    private static void find(int[] intArr, int findElement) {
        int iterationCount = 1;
        boolean isFind = false;
        int startIndex = 0;
        int endIndex = intArr.length-1;

        while(true){
            int midIndex = (startIndex+endIndex)/2;
            int midElement = intArr[midIndex];

            // check if we found the element on mid index
            if(midElement==findElement)
                isFind=true;

            // if element was not available on mid index and start & end indexes are same means we have no more elements to search
            if (isFind || startIndex==endIndex) {
                break;
            }
            else {
                if(findElement<midElement)
                    endIndex = midIndex-1;
                else
                    startIndex = midIndex+1;
            }
            ++iterationCount;
        }
        System.out.println(findElement + " : " +isFind + " : " +iterationCount);
    }

}