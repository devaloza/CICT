package chapter_4;

import java.util.*;

public class buildOrder {

    public static List<String> findBuildOrder(String[] projects, String[][] dependencies) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Integer> edges = new HashMap<>();
        for(String project : projects) {
            graph.put(project, new ArrayList<>());
            edges.put(project, 0);
        }
        for (String[] dependency: dependencies) {
            String dependentProject = dependency[1];
            String dependencyProject = dependency[0];
            graph.get(dependencyProject).add(dependentProject);
            edges.put(dependentProject, edges.get(dependentProject) + 1);
        }
        List<String> buildOrder = new ArrayList<>();

        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        for (String project: projects) {
            if (edges.get(project) == 0) {
                queue.offer(project);
            }
        }
        while (!queue.isEmpty()) {
            String project = queue.poll();
            buildOrder.add(project);
            for (String dependentProject : graph.get(project)) {
                edges.put(dependentProject, edges.get(dependentProject) -1);
                if (edges.get(dependentProject) == 0) {
                    queue.offer(dependentProject);
                }
            }
        }
        if (buildOrder.size() != projects.length) {
            return null;
        }
        return buildOrder;
    }

    public static void main(String[] args) {
        // Define the list of projects and their dependencies
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

        // Find the build order
        List<String> buildOrder = findBuildOrder(projects, dependencies);

        // Check if a valid build order was found and print it
        if (buildOrder == null) {
            System.out.println("Error: The project dependencies contain a cycle.");
        } else {
            System.out.println("Build Order:");
            for (String project : buildOrder) {
                System.out.print(project + " ");
            }
        }
    }
}
