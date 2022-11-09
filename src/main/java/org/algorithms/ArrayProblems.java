package org.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static int[] twoSumsWithLoops(int[] input, int total) {
        int[] result = new int[2];
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input.length; j++) {
                if(i!=j && (input[i] + input[j] == total)) {
                    result[0]=i; result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
    public static int[] twoSumsWithMap(int[] input, int total) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            int complement = total - input[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }else map.put(input[i], i);
        }
        return new int[]{};
    }
    public static int bestTimeToBuy(int[] input) {
        int result = 0;
        int min = input[0];
        for(int i=1; i<input.length; i++) {
            result = Math.max(result, input[i]-min);
            min = Math.min(min, input[i]);
        }
        return result;
    }
    public static boolean containsDuplicate(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i <input.length; i++) {
            if(map.containsKey(input[i])) return true;
            map.put(input[i], 1);
        }
        return false;
    }
    public static int[] productExceptSelf(int[] input) {
        int[] pa = new int[input.length]; pa[0] = 1;
        int[] sa = new int[input.length]; sa[input.length-1] = 1;
        int[] result = new int[input.length];
        for(int i=1;i<pa.length;i++) pa[i] = pa[i-1] * input[i-1];
        for(int i=sa.length-2;i>=0;i--) sa[i] = sa[i+1] * input[i+1];
        for(int i=0;i<pa.length;i++) result[i] = pa[i] * sa[i];
        return result;
    }
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(ArrayProblems.twoSumsWithMap(new int[]{11,8,3,2,15,7,10}, 9)));
        //System.out.println(bestTimeToBuy(new int[]{7,6,4,3,1}));
        //System.out.println(containsDuplicate(new int[]{1,2,3,4,3}));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
