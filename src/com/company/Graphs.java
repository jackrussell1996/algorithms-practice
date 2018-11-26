package com.company;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.HashMap;
import java.util.ArrayList;

class Graphs {

    class Node {
        String label;
        ArrayList<Node> adjacencyList;
    }

    public static void main(String args[]) {
        HashMap<String, Node> graph = new HashMap<String, Node>();
        doDFS(graph);
    }
    public static void doDFS(HashMap<String, Node> graph) {


    }
}