package org.algorithms.dynamic;

public class Fibonacci {
    
    public static int fibonacci(int i) {
        if(i == 0) return 0;
        if(i == 1) return 1;
        return fibonacci(i -1) + fibonacci(i - 2);
    }
    public static int fibonacci(int i, int[] mem) {
        if(i == 0 || i == 1) return i;
        if(mem[i] == 0) { 
            mem[i] = fibonacci(i-1, mem) + fibonacci(i-2, mem);
        }
        return mem[i];
    }
    public static int fibonacciByBottomUp(int n) {
        if(n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        int result = a+b;
        for(int i=2;i<n;i++) {
            a = b;
            b = result;
            result = a + b;
        }
        return result;
    }
    public static void main(String[] args) {
        //System.out.println(Fibonacci.fibonacci(50,new int[51]));
        System.out.println(Fibonacci.fibonacciByBottomUp(6));
        //System.out.println("test");
    }
}
