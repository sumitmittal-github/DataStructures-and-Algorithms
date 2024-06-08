package com.sumit.datastructures.z_mixprograms;

public class Q14_CompressString {

    // LeetCode-443 : https://leetcode.com/problems/string-compression/description/
    
    public int compress(char[] chars) {
        char previousChar = chars[0];
        int count=1;
        StringBuilder sb = new StringBuilder();

        // STEP-1 : iterate through input array
        for(int i=1; i<chars.length; i++){
            char currentChar = chars[i];

            // STEP-2 : if current char is matched with previous char, then increase the count
            if(previousChar == currentChar){
                count++;
            }
            // STEP-3 : else add the character and count in the answer String builder
            else {
                sb.append(previousChar);
                if(count > 1) sb.append(count);
                previousChar = currentChar;
                count=1;
            }
        }
        sb.append(previousChar);
        if(count > 1) sb.append(count);

        // STEP-4 : copy answer from StringBuilder to input array
        for(int i=0; i<sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

}