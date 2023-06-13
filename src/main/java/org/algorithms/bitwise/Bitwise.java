package org.algorithms.bitwise;

public class Bitwise {
    public static int bitwiseSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    public static int numOf1Bits(int num) {
        /*int counter = 0;
        for(int i=0; i<32; i++) {
            int mask = num & (1 << i);
            if(mask > 0) counter = counter+1;
        }
        return counter;*/
        if(num ==0) return 0;
        int result = (num%2 == 0? 0 : 1) + numOf1Bits(num/2);
        return result;
    }
    public static int missingNumber(int[] nums) {
        int xo = nums.length;
        for(int i=0; i<nums.length; i++) {
            xo^=i^nums[i];
        }
        return xo;
    }
    public static int reverseBits(int num) {
        int rev = 0;
        while(num != 0) {
            rev <<= 1;
            if((num & 1) == 1) rev ^= 1;
            num >>= 1;
        }
        return rev;
    }
    
    public static void main(String[] args) {
        //System.out.printf("total: %d",bitwiseSum(20, 50));
        //System.out.printf("num: %s\n", intToString(121));
        //System.out.println(1%2);
        //System.out.printf("numOf1Bits: %d\n", numOf1Bits(121));
        //System.out.printf("missing number : %d\n", missingNumber(new int[]{3,0,1}));

        int a = 101;
        System.out.printf("input bits: %s\n",intToString(a));
        System.out.printf("resul bits: %s",intToString(reverseBits(a)));
    }
    public static String intToString(int num) {
        StringBuilder result = new StringBuilder();
        for(int i=31; i>=0; i--) {
            int mask = 1 << i;
            result.append((num & mask) != 0 ? "1":"0");
            if(i % 8 == 0) result.append(" ");
        }
        return result.toString();
    }
}
