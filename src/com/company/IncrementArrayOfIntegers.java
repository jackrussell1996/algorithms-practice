package com.company;

import java.util.Arrays;

public class IncrementArrayOfIntegers {
    public static void main (String[] args) {
        int[] intArray1 = {1, 2, 3, 4};
        int[] intArray2 = {2, 6, 7, 9};
        int[] intArray3 = {9, 9, 9, 9};
        incrementArrayOfIntegers(intArray1);
        incrementArrayOfIntegers(intArray2);
        incrementArrayOfIntegers(intArray3);
    }

    public static int[] incrementArrayOfIntegers(int[] intArray) {
        int arrLen = intArray.length;
        int i = arrLen - 1;
        boolean incremented = false;
        while (!incremented && i >= 0) {
            if (intArray[i] == 9) {
                intArray[i] = 0;
                if (i == 0) {
                    int[] newIntArray = new int[arrLen + 1];
                    newIntArray[0] = 1;
                    for (int x = 0; x < arrLen; x++) {
                        newIntArray[x + 1] = intArray[x];
                    }
                    intArray = newIntArray;
                }
            }
            else {
                intArray[i]++;
                incremented = true;
            }
            i--;
        }
        System.out.println(Arrays.toString(intArray));
        return intArray;
    }
}
