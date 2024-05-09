package com.sumit.datastructures.z_mixprograms;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String str) {
        int ans = 0, length = str.length()-1;
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i + 1)) <= map.get(str.charAt(i)))
                ans += map.get(str.charAt(i));
            else
                ans -= map.get(str.charAt(i));
        }
        return ans + map.get(str.charAt(length));
    }


}
