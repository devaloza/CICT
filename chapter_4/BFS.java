package chapter_4;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int V;
    private LinkedList<Integer>[] adjList;

    public BFS(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    private boolean isRouteBetweenNodesBFS(int start, int target) {
        if (start == target) {
            return true;
        }
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour:adjList[current]) {
                if (neighbour == target) {
                    return true;
                }
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BFS graph = new BFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        int startNode = 0;
        int targetNode = 5;

        boolean hasRoute = graph.isRouteBetweenNodesBFS(startNode, targetNode);

        if (hasRoute) {
            System.out.println("There is a route from Node " + startNode + " to Node " + targetNode);
        } else {
            System.out.println("There is no route from Node " + startNode + " to Node " + targetNode);
        }
    }
}
