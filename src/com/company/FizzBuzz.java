package com.company;

public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz(1, 100);
    }

    public static void fizzBuzz(int start, int end) {
        for (int i = start; i <= end; i++) {
            boolean fizz =  i % 3 == 0;
            boolean buzz = i % 5 == 0;

            System.out.print(i + " ");
                if (fizz) {
                    System.out.print("fizz");
                }
                if (buzz) {
                    System.out.print("buzz");
                }
            System.out.println();
        }
    }
}
