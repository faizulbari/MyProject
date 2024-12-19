package ProblemSolving.TopologicalSorting;

import java.util.*;

class TopologicalSortDFS {
    private void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, graph);
            }
        }
        stack.push(node);
    }

    public List<Integer> topologicalSort(int vertices, List<List<Integer>> graph) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
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
        
        TopologicalSortDFS obj = new TopologicalSortDFS();
        System.out.println("Topological Order: " + obj.topologicalSort(vertices, graph));
    }
}
