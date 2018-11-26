package com.company;

import java.util.Arrays;

public class LargestSquare {
    public static void main(String[] args) {
        int matrixSize = 10;
        int[][] matrix1 = new int[matrixSize][matrixSize];
        System.out.println("Original matrix:");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix1[i][j] = Math.toIntExact(Math.round(Math.random() * 1.49));
            }
            System.out.println(Arrays.toString(matrix1[i]));
        }
        System.out.println();
        System.out.println("Mutated matrix:");
        int largestSquareLength = findLargestSquare(matrix1);
        System.out.println("Largest contiguous square: ");
        System.out.println("Length: " + largestSquareLength);
        System.out.println("Area: " + largestSquareLength * largestSquareLength);

    }

    public static int findLargestSquare(int[][] matrix) {
        int matrixSize = matrix.length;
        int[] largestSquareCoords = new int[2];
        int largestSquare = 0;
        for (int row = 0; row < matrixSize; row++) {
            int innerMatrixSize = matrix[row].length;
            for (int col = 0; col < innerMatrixSize; col++) {
                if (row > 0 && col > 0 && matrix[row][col] > 0) {
                    int l = matrix[row][col - 1];
                    int t = matrix[row - 1][col];
                    int tl = matrix[row - 1][col - 1];
                    int smallest = l;
                    if (smallest > t) {
                        smallest = t;
                    }
                    if (smallest > tl) {
                        smallest = tl;
                    }
                    matrix[row][col] += smallest;
                }
                if (matrix[row][col] > largestSquare) {
                    largestSquare = matrix[row][col];
                    largestSquareCoords[0] = row;
                    largestSquareCoords[1] = col;
                }
            }
        }
        for (int col = 0; col < matrixSize; col++) {
            int innerMatrixSize = matrix[col].length;
            System.out.print("[");
            for (int row = 0; row < innerMatrixSize; row++) {
                int x = largestSquareCoords[0] - col;
                int y = largestSquareCoords[1] - row;
                if (x >= 0 && x < largestSquare && y >= 0 && y < largestSquare) {
                    System.out.print("\u001B[35m" + matrix[col][row] + "\u001B[0m");
                }
                else {
                    System.out.print(matrix[col][row]);
                }

                if (row != innerMatrixSize - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        return largestSquare;
    }
}
