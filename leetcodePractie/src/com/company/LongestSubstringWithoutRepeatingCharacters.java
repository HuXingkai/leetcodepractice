package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length()-max; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int l=0;
            int j=i;
            while (j<s.length()&&!map.containsKey(s.charAt(j))) {
                l++;
                map.put(s.charAt(j), j);
                j++;
            }
            i=map.get(s.charAt(j));
            max = l > max ? l : max;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));

    }
}
