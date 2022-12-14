package org.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
        return chars.length - left;
    }
    public static String minimumWindow(String s, String t) {
        int[] count = new int[128];
        for(char c: t.toCharArray()) count[c]++;
        System.out.println(Arrays.toString(count));
        /*for(int l=0,r=0; r<s.length(); r++) {


        }*/
        return "";
    }
    public static boolean isValidAnagram(String s, String t) {
        int[] chars = new int[126];
        if(s.length() != t.length()) return false;
        for(int i=0; i<s.length(); i++) {
            chars[s.charAt(i)] ++;
            chars[t.charAt(i)] --;
        }
        for(int i=0; i<chars.length; i++) {
            if(chars[i] != 0) return false;
        }
        return true;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            }else{
                List<String> list = new LinkedList<>(); list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
    public static boolean isValidParentheses(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')'); map.put('{', '}'); map.put('[', ']'); 
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            }else if(map.containsValue(c)) {
                if(!stack.isEmpty() && map.get(stack.peek()) == c){
                    stack.pop();
                }else return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c: str.toLowerCase().toCharArray()) {
            if(Character.isLetterOrDigit(c)) sb.append(c);
        }
        System.out.println(sb.toString());
        for(int i=0; i<sb.length()/2; i++) {
            int j = sb.length() - i - 1;
            if(sb.charAt(i) != sb.charAt(j)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        //System.out.println(longestSubstring("abcaefgh"));
        //System.out.println(characterReplacement("ABABAFGH", 1));
        //characterReplacement("AABABBA", 1);
        //System.out.println(minimumWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(isValidAnagram("raw", "car"));

        /*List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> list: result) {
            for(String s: list) {
                System.out.printf("%s ", s);
            }
            System.out.println();
        }*/

        //System.out.println(isValidParentheses("(())"));
        System.out.println(isPalindrome(" "));
    }
}
