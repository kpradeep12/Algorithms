package org.algorithms;

public class Practice {
    public static boolean isAvailable(int target, int nums[]) {
        int fi =-1, ci=nums.length;
        while(fi+1 < ci){
            int mi = fi + (ci-fi)/2;
            int mv = nums[mi];
            System.out.println(mv);
            if(mv == target) return true;
            if(mv < target) fi = mi;
            else ci = mi;
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {3,4,5,7,8,9};
        System.out.println(isAvailable(3, nums));
    }
}
