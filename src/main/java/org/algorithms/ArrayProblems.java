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
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(ArrayProblems.twoSumsWithMap(new int[]{11,8,3,2,15,7,10}, 9)));
        System.out.println(bestTimeToBuy(new int[]{7,6,4,3,1}));
    }
}
