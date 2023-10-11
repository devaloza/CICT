package chapter_4;
import CtCILibrary.LinkedListNode;

import java.util.*;
public class DFS {
    private int V;
    private LinkedList<Integer>[] adjList;

    public DFS(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public boolean isRouteBetweenNodes(int start, int target) {
        boolean[] visited = new boolean[V];
        return isRouteBetweenNodesDFS(start, target, visited);
    }

    private boolean isRouteBetweenNodesDFS(int current, int target, boolean[] visited) {
        if (current == target) {
            return true; // Found a route to the target node
        }

        visited[current] = true;

        for (int neighbor : adjList[current]) {
            if (!visited[neighbor] && isRouteBetweenNodesDFS(neighbor, target, visited)) {
                return true;
            }
        }

        return false; // No route found to the target node
    }
    public static void main(String[] args) {
        DFS graph = new DFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        int startNode = 0;
        int targetNode = 5;

        boolean hasRoute = graph.isRouteBetweenNodes(startNode, targetNode);

        if (hasRoute) {
            System.out.println("There is a route from Node " + startNode + " to Node " + targetNode);
        } else {
            System.out.println("There is no route from Node " + startNode + " to Node " + targetNode);
        }
    }
}

