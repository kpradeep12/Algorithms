package org.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public static int subSumOfArray(int[] arr) {
        int maxSum = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int subSum = 0;
                for(int k=i; k<j; k++) {
                    subSum = subSum + arr[k];
                }
                if(subSum > maxSum) maxSum = subSum;
            }
        }
        return maxSum;
    }
    public static int maxVolumnContainer(int[] arr) {
        int maxVolume = Integer.MIN_VALUE;
        int first = 0, end = arr.length -1;
        while(first < end) {
            int min = Math.min(arr[first], arr[end]);
            int volume = min * (end-first);
            maxVolume = Math.max(volume, maxVolume);
            if(arr[first] < arr[end]) first ++; else end--;
        }
        return maxVolume;
    }
    public static List<Integer[]> threeSum(int[] arr, int target) {
        List<Integer[]> list = new ArrayList<>();
        for(int i=0; i<arr.length-2; i++) {
            int currentTarget = target - arr[i];
            Set<Integer> set = new HashSet<>();
            for(int j=i+1; j<arr.length; j++) {
                if(set.contains(currentTarget-arr[j])) {
                    list.add(new Integer[] {arr[i], arr[j], currentTarget-arr[j]});
                }else
                set.add(arr[j]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(ArrayProblems.twoSumsWithMap(new int[]{11,8,3,2,15,7,10}, 9)));
        //System.out.println(bestTimeToBuy(new int[]{7,6,4,3,1}));
        //System.out.println(containsDuplicate(new int[]{1,2,3,4,3}));
        //System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        //System.out.println(subSumOfArray(new int[]{-4, 5, 7, -6, 10, -15, 3}));
        //System.out.println(subSumOfArray(new int[]{-3, 2, -1, 4, -2}));
        //System.out.println(maxVolumnContainer(new int[] {1,8,6,2,5,4,8,3,7}));

        List<Integer[]> list = threeSum(new int[]{-1,0,1,2,-1,-4}, 0);
        for(Integer[] item: list) {
            System.out.println(Arrays.toString(item));
        }
    }
}
