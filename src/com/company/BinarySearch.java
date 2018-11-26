package com.company;

public class BinarySearch {
    public static void main (String[] args) {
        int[] integers = {1, 2, 3, 4, 5, 10, 12, 14};
        boolean recursive = binarySearch(integers, 6);
        boolean iterative = iterativeBinarySearch(integers, 6);
        System.out.println(recursive);
        System.out.println(iterative);
    }

    public static boolean binarySearch(int[] array, int searchVal) {
        return recursiveBinarySearch(array, searchVal, 0, array.length - 1);
    }

    public static boolean recursiveBinarySearch(int[] array, int searchVal, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return false;
        }

        int midIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        int midVal = array[midIndex];
        if (midVal == searchVal) {
            return true;
        } else if (midVal > searchVal) {
            return recursiveBinarySearch(array, searchVal, leftIndex, midIndex - 1);
        } else {
            return recursiveBinarySearch(array, searchVal, midIndex + 1, rightIndex);
        }
    }

    public static boolean iterativeBinarySearch(int[] array, int searchVal) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + ((rightIndex - leftIndex) / 2);
            int midVal = array[midIndex];
            if (midVal == searchVal) {
                return true;
            } else if (midVal > searchVal) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        return false;
    }
}
