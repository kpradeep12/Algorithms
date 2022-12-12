package org.algorithms;

import java.util.Arrays;

public class StringProblems {
    public static int longestSubstring(String input) {
        if(input.length() == 1)  return 1;
        int maxLength = -1;
        String temp = "";
        for(char c: input.toCharArray()) {
            String current = String.valueOf(c);
            if(temp.contains(current)) {
                temp = temp.substring(temp.indexOf(current)+1);
            }
            temp = temp + current;
            maxLength = Math.max(maxLength, temp.length());           
        }
        return maxLength;
    }
    public static int characterReplacement(String s, int k) {
        int[] letters = new int[26];
        if(s == null || s.length() == 0) return 0;
        int right=0,left=0,charMax=0;
        char[] chars = s.toCharArray();
        for(right =0; right<chars.length; right++) {
            int index = chars[right] - 'A';
            letters[index]++;
            charMax = Math.max(charMax, letters[index]);
            System.out.println();
            System.out.println(chars[right]);
            System.out.println(Arrays.toString(letters));
            System.out.println("charMax:"+charMax);
            if(right - left + 1 > charMax + k) {
                System.out.printf("condition true %d - %d\n",left, right);
                letters[chars[left] - 'A']--;
                left++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //System.out.println(longestSubstring("abcaefgh"));
        characterReplacement("AABABBA", 2);
    }
}
