package com.company;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static HashMap<Integer, Integer> fibs = new HashMap<Integer, Integer>();

    public static int fib(int n) {
        Integer fibOfN = fibs.get(n);
        if (fibOfN != null) {
            return fibOfN;
        }
        if (n <= 1) fibOfN = n;
        else fibOfN = fib(n-1) + fib(n-2);
        fibs.put(n, fibOfN);
        return fibOfN;
    }
}
