package com.sumit.datastructures.search.a_linearsearch;

public class LinearSearch2_String {

    public static void main(String[] args) {
        String str = "My name is Sumit Mittal !";
        System.out.println(linearSearch(str, 'p'));
    }

    /*
     * Case in-sensitive Linear Search :
     * search character in the input string -
     * - if the character found then return its index,
     * - else return -1
     **/
    private static int linearSearch(String str, char element) {
        for(int i=0; i<str.length(); i++) {
            if(str.toLowerCase().charAt(i) == Character.toLowerCase(element))
                return i;
        }
        return -1;
    }

}