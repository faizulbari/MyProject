package ProblemSolving.TopologicalSorting;

import java.util.*;

class TopologicalSortBFS {
    public List<Integer> topologicalSort(int vertices, List<List<Integer>> graph) {
        int[] indegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (result.size() != vertices) {
            throw new IllegalArgumentException("Graph has a cycle!");
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        // Add edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        
        TopologicalSortBFS obj = new TopologicalSortBFS();
        System.out.println("Topological Order: " + obj.topologicalSort(vertices, graph));
    }
}
