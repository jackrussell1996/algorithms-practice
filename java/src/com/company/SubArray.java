package com.company;

public class SubArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 0, 2, 1, 9, 9, 6};
        printAllSubArrays(arr1);
    }

    public static void printAllSubArrays(int[] arr) {
        for (int subArraySize = 0; arr.length >= subArraySize; subArraySize++) {
            int subArrayHead = 0;
            while (arr.length >= subArrayHead + subArraySize) {
                for (int i = subArrayHead; i < subArrayHead + subArraySize; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                subArrayHead++;
            }
        }
    }
}
