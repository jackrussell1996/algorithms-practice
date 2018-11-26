package com.company;

import java.awt.*;
import java.util.*;

public class FloodFill {
    int matrixSize;
    int[][] matrix;
    FloodFill(int size){
        matrixSize = size;
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Math.toIntExact((long)Math.ceil(Math.random() * 3));
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public int findLargestFill(){
        int largestFill = 0;
        boolean [][] visited = new boolean[matrixSize][matrixSize];
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int currentFill = 0;
                if (visited[j][i] == true) {
                    continue;
                }

                visited[j][i] = true;
                stack.push(new Point(j, i));

                while (stack.empty() == false) {
                    Point p = stack.pop();
//                    currentFill += visitPointIfValid(p, p.x - 1, p.y, visited, matrixSize, stack);
//                    currentFill += visitPointIfValid(p, p.x + 1, p.y, visited, matrixSize, stack);
//                    currentFill += visitPointIfValid(p, p.x, p.y - 1, visited, matrixSize, stack);
//                    currentFill += visitPointIfValid(p, p.x, p.y + 1, visited, matrixSize, stack);
                }
//                if ()
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
        return largestFill;
    }

    public static boolean isValidPoint(int x, int y, boolean[][] visited, int matrixSize) {
        return x >= 0 && x < matrixSize && y >= 0 && y < matrixSize && visited[x][y] != true;
    }

    public static int visitPointIfValid(int x, int y, boolean[][] visited, int matrixSize, Stack<Point> stack) {
        if (isValidPoint(x, y, visited, matrixSize)) {
            visited[x][y] = true;
            stack.push(new Point(x, y));
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        FloodFill ff = new FloodFill(3);
        System.out.println(ff.findLargestFill());

    }
}
