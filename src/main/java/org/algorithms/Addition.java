package org.algorithms;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello Anvita, welcome to addition world!");
        System.out.println("Enter number 1: ");
        long n1 = in.nextLong();
        System.out.println("Enter number 2:");
        long n2 = in.nextLong();
        long result = n1 + n2;
        System.out.println("Result is : " + result);
    }
    
}
