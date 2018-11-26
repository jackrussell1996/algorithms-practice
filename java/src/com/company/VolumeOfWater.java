package com.company;

public class VolumeOfWater {
    public static void main (String[] args) {
        int[] arr1 = {3, 2, 4, 1, 4};
        //   * *
        // * * *
        // *** *
        // *****
        System.out.println(calculateWater(arr1));
        int[] arr2 = {0, 2, 1, 3, 2, 1};
        //
        //    *
        //  * **
        // .*****
        System.out.println(calculateWater(arr2));
        int[] arr3 = {1, 2, 3, 3, 2, 1, 4};
        //       *
        //   **  *
        //  **** *
        // *******
        System.out.println(calculateWater(arr3));
    }

    public static int calculateWater(int[] arr) {
        int arrLen = arr.length;
        if (arrLen == 0) {
            return 0;
        }
        int totalWater = 0;
        int borderIndex = 0;
        for (int i = 0; i < arrLen; i++) {
            int currVal = arr[i];
            if (i == 0) {
                continue;
            }
            if (currVal >= arr[borderIndex] || i == arrLen - 1) {
                totalWater += calculateSectionWater(arr, borderIndex, i);
                borderIndex = i;
            }
        }
        return totalWater;
    }

    public static int calculateSectionWater(int[] arr, int leftIndex, int rightIndex) {
        int leftVal = arr[leftIndex];
        int rightVal = arr[rightIndex];
        int minVal = leftVal > rightVal ? rightVal : leftVal;
        int sectionWater = 0;
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            int columnWater = minVal - arr[i];
            if (columnWater < 0) {
                columnWater += arr[i];
            }
            sectionWater += columnWater;
        }
        return sectionWater;
    }
}
