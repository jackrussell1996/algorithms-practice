package com.company;

public class MergeSort {
    public static void main (String[] args) {
        int[] arr1 = {3, 4, 2, 10, 32, 23, 44, 3, 2, 1, 4, 10};
        arr1 = mergeSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    public static int[] mergeSort(int[] arr) {
        return recursiveMergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static int[] recursiveMergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return arr;
        }
        int middle = (leftStart + rightEnd) / 2;
        recursiveMergeSort(arr, temp, leftStart, middle);
        recursiveMergeSort(arr, temp, middle + 1, rightEnd);
        mergeHalves(arr, temp, middle + 1, rightEnd);
        return arr;
    }

    public static int[] mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            }
            else {
                temp[index] = arr[left];
                left++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
        return temp;
    }
}
