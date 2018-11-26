package com.company;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {

        int matrixSize = 5;
        int[][] matrix1 = new int[matrixSize][matrixSize];
        int x = 1;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
//                matrix1[i][j] = Math.toIntExact(Math.round(Math.random() * 100));
                matrix1[i][j] = x;
                x++;
            }
            System.out.println(Arrays.toString(matrix1[i]));
        }
        System.out.println();
        rotateMatrix(matrix1);
        for (int i = 0; i < matrixSize; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }
    public static void rotateMatrix(int[][] matrix) {
        int matrixSize = matrix.length;
        int layer = 0;
        while (Math.ceil((double)matrixSize / 2) >= layer) {
            for (int col = layer; col + 1 < matrixSize - layer; col++) {
                int tl = matrix[layer][col];
                matrix[layer][col] = matrix[col][matrixSize - 1 - layer];
                matrix[col][matrixSize - 1 - layer] = matrix[matrixSize - 1 - layer][matrixSize - 1 - col];
                matrix[matrixSize - 1 - layer][matrixSize - 1 - col] = matrix[matrixSize - 1 - col][layer];
                matrix[matrixSize - 1 - col][layer] = tl;
            }
            layer++;
        }
    }
}
