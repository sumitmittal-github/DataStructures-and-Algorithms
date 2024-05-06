package com.sumit.datastructures.j_recursion.b_strings;

public class String4_RemoveAllOccurrences {

    // Question : Remove all occurrences of 'a' from String s ="abcax"

    public String removeAllOccurrences_1(String str, char target){
        if(str == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != target)
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public String removeAllOccurrences_2(String str, char target){
        if(str.length() == 0)     return "";

        if(str.charAt(0) == target)
            return removeAllOccurrences_2(str.substring(1), target);
        else
            return str.substring(0,1) + removeAllOccurrences_2(str.substring(1), target);
    }


    public String removeAllOccurrences_3(String str, char target){
        if(str == null)
            return null;

        return removeAllOccurrences_3_helper(str, 0, target);
    }
    private String removeAllOccurrences_3_helper(String str, int index, char target){
        if(index == str.length())
            return "";

        if(str.charAt(index) == target)
            return removeAllOccurrences_3_helper(str, ++index, target);
        else
            return str.charAt(index) + removeAllOccurrences_3_helper(str, ++index, target);
    }



    public static void main(String[] args) {
        String4_RemoveAllOccurrences obj = new String4_RemoveAllOccurrences();

        System.out.println(obj.removeAllOccurrences_1("abcax", 'a'));
        System.out.println(obj.removeAllOccurrences_2("abcax", 'a'));
        System.out.println(obj.removeAllOccurrences_3("abcax", 'a'));

        System.out.println(obj.removeAllOccurrences_1("abcax", 'b'));
        System.out.println(obj.removeAllOccurrences_2("abcax", 'b'));
        System.out.println(obj.removeAllOccurrences_3("abcax", 'b'));

        System.out.println(obj.removeAllOccurrences_1("abcax", 'c'));
        System.out.println(obj.removeAllOccurrences_2("abcax", 'c'));
        System.out.println(obj.removeAllOccurrences_3("abcax", 'c'));

        System.out.println(obj.removeAllOccurrences_1("abcax", 'x'));
        System.out.println(obj.removeAllOccurrences_2("abcax", 'x'));
        System.out.println(obj.removeAllOccurrences_3("abcax", 'x'));

        System.out.println(obj.removeAllOccurrences_1("abcax", 'z'));
        System.out.println(obj.removeAllOccurrences_2("abcax", 'z'));
        System.out.println(obj.removeAllOccurrences_3("abcax", 'z'));

        System.out.println(obj.removeAllOccurrences_1("aaaaaa", 'a'));
        System.out.println(obj.removeAllOccurrences_2("aaaaaa", 'a'));
        System.out.println(obj.removeAllOccurrences_3("aaaaaa", 'a'));
    }

}