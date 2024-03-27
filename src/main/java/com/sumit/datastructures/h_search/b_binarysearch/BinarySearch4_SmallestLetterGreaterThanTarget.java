package com.sumit.datastructures.h_search.b_binarysearch;

import java.util.Arrays;

public class BinarySearch4_SmallestLetterGreaterThanTarget {

    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

    public static void main(String[] args) {

        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println("Target : " + target1 + ", Letters : " + Arrays.toString(letters1) + " => " + nextGreatestLetter(letters1, target1));

        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println("Target : " + target2 + ", Letters : " + Arrays.toString(letters2) + " => " + nextGreatestLetter(letters2, target2));

        char[] letters3 = {'c', 'f', 'j'};
        char target3 = 'e';
        System.out.println("Target : " + target3 + ", Letters : " + Arrays.toString(letters3) + " => " + nextGreatestLetter(letters3, target3));

        char[] letters4 = {'x', 'x', 'y', 'y'};
        char target4 = 'z';
        System.out.println("Target : " + target4 + ", Letters : " + Arrays.toString(letters4) + " => " + nextGreatestLetter(letters4, target4));

        char[] letters5 = {'e','e','e','e','e','e','n','n','n','n'};
        char target5 = 'e';
        System.out.println("Target : " + target5 + ", Letters : " + Arrays.toString(letters5) + " => " + nextGreatestLetter(letters5, target5));

        char[] letters6 = {'e','e','e','e','e','e','n','n','n','n'};
        char target6 = 'n';
        System.out.println("Target : " + target6 + ", Letters : " + Arrays.toString(letters6) + " => " + nextGreatestLetter(letters6, target6));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int startIndex = 0, midIndex = 0, endIndex = letters.length-1;

        // if the target is bigger (or same) than the greatest element of our array then return the 1st element of the array
        if(letters[letters.length-1] <= target)
            return letters[0];

        // Logic is similar to Ceiling Number problem
        // just we removed the equal check if(arr[midIndex] == target)
        // because otherwise in last test case where we have repeated character, it may give next repeated character which can be same.
        // dry run last test case for clear understanding
        while(startIndex <= endIndex) {
            midIndex = startIndex + (endIndex-startIndex)/2;

            if(letters[midIndex] > target)
                endIndex = midIndex-1;
            else
                startIndex = midIndex+1;
        }
        return letters[startIndex];

        // we can remove the 1st if condition of this method -   if(letters[letters.length-1] <= target)
        // and then we have to change return statement as
        // return letters[startIndex % letters.length];       -- to handle the last element condition
    }

}