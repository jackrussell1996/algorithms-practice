package com.company;

public class CyclicalArray {
    public static void main (String[] args) {
        int[] arr1 = {2, 1, 2, 1};
        int[] arr2 = {-1, -1, -1};
        System.out.println(isPerfectCycle(arr1));
        System.out.println(isPerfectCycle(arr2));
    }

    public static boolean isPerfectCycle (int[] arr) {
        int arrLen = arr.length;
        boolean[] visited = new boolean[arrLen];
        int visit = 0;
        for (int i = 0; i < arrLen; i++) {
            if (visited[visit] || arr[visit] == 0) {
                return false;
            }
            visited[visit] = true;
            // adds next hop to visit index
            visit += arr[visit];
            // reduces visit down to units between 0 and arrLen (wrapping)
            visit %= arrLen;
            // adds arrLen to visit if negative, to get the correct positive index
            if (visit < 0) {
                visit += arrLen;
            }
        }
        return true;
    }
}
