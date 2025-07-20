// ------------------------------
// BFSShortestPaths.java
// ------------------------------

import java.util.*;

public class BFSShortestPaths extends GraphSearchAlgorithm {
    private final Map<Integer, Integer> distance = new HashMap<>();
    private final Map<Integer, Integer> parent = new HashMap<>();

    public BFSShortestPaths() {
        super("BFSShortestPaths");
    }

    @Override
    public void run(Graph graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        distance.put(startNode, 0);
        parent.put(startNode, null);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.getAdj(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1);
                    parent.put(neighbor, current);
                }
            }
        }
    }

    @Override
    public void printResults() {
        System.out.println("Distances from source:");
        System.out.println(distance);
        System.out.println("Parent map:");
        System.out.println(parent);
    }
}
