package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Graph {
    HashMap<String, Node> nodes = new HashMap<String, Node>();
    class Node {
        private String id;
        private LinkedList<Node> adjacents = new LinkedList<Node>();
        boolean addAdjacent (Node dest) {
            return this.adjacents.add(dest);
        }
        LinkedList<Node> getAllAdjacents () {
            return this.adjacents;
        }
        String getId () {
            return this.id;
        }
        Node(String id) {
            this.id = id;
        }
    }

    void addNode(String id) {
        nodes.put(id, new Node(id));
    }

    Node getNode(String id) {
        return nodes.get(id);
    }

    boolean addEdge(String source, String destination) {
        Node s = getNode(source);
        if (s == null) {
            return false;
        }
        Node d = getNode(destination);
        if (d == null) {
            return false;
        }
        return s.addAdjacent(d);
    }

    public static void main(String args[]) {
        Graph graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("d", "e");
        System.out.println(graph.hasPathDFS("a", "c"));
        System.out.println(graph.hasPathDFS("a", "d"));

        int[] x = {3,2,1};
    }

    boolean hasPathDFS(String source, String destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<String> visited = new HashSet<String>();
        return hasPathDFS(s, d, visited);
    }

    boolean hasPathDFS(Node source, Node destination, HashSet<String> visited) {
        if (source == destination) {
            return true;
        }
        if (visited.contains(source.getId())) {
            return false;
        }
        visited.add(source.id);
        for (Node child : source.getAllAdjacents()) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
