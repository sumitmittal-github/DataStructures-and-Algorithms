package com.sumit.datastructures.c_search.a_linearsearch;

public class LinearSearch3_String {

    public static void main(String[] args) {
        String str = "My name is Sumit Mittal !";
        System.out.println(linearSearch(str, 'n'));
        System.out.println(linearSearch2(str, 'n'));
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

    private static int linearSearch2(String str, char element) {
        int index=-1;
        for(char c : str.toLowerCase().toCharArray()) {
            index++;
            if(c == Character.toLowerCase(element))
                return index;
        }
        return -1;
    }

}