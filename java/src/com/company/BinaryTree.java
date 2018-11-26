package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTree {
    class Node {
        Node left;
        Node right;
        int level;
        int value;
        Node(int val) {
            value = val;
        }
    }

    public static void main(String[] args) {
        new BinaryTree();
    }

    BinaryTree(){
        Node root = new Node(1);
        Node a1 = new Node(2);
        Node a2 = new Node(3);
        Node b1 = new Node(4);
        Node b2 = new Node(5);
        Node b3 = new Node(5);
        root.left = a1;
        root.right = a2;
        a1.left = b1;
        a2.left = b2;
        a2.left = b3;
    }

    public void BFS(Node root) {
        Queue<Node> queue = new PriorityQueue<Node>();
        int currentLevel = 1;
        root.level = currentLevel;
        queue.add(root);
        while (queue.size() > 0) {
            Node curr = queue.remove();
            if (curr.level > currentLevel) {
                currentLevel++;
                System.out.println("\n");
            }
            System.out.println(curr.value);
            if (curr.left != null) {
                curr.left.level = currentLevel;
                queue.add(curr.left);
            }
            if (curr.right != null) {
                curr.right.level = currentLevel;
                queue.add(curr.right);
            }
        }
    }
}
