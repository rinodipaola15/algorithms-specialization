import java.util.*;

public class DijkstraStandard extends GraphWeightedSearchAlgorithm {
    // Stores the shortest known distance from the source to each node
    private final Map<Integer, Integer> dist = new HashMap<>();
    
    // Stores the parent of each node in the shortest path tree
    private final Map<Integer, Integer> parent = new HashMap<>();

    public DijkstraStandard() {
        super("DijkstraStandard");
    }

    @Override
    public void run(GraphWeighted graph, int source) {
        // Set of nodes that have been visited (i.e., finalized shortest distances)
        Set<Integer> visited = new HashSet<>();
        
        // Retrieve all nodes from the graph
        Set<Integer> allNodes = graph.getAllNodes();

        // Initialize all distances to infinity (represented by Integer.MAX_VALUE)
        for (int v : allNodes) {
            dist.put(v, Integer.MAX_VALUE);
        }

        // Distance from source to itself is 0
        dist.put(source, 0);

        // Repeat until all nodes have been visited
        while (visited.size() < allNodes.size()) {
            int minNode = -1;
            int minDist = Integer.MAX_VALUE;

            // Linear scan to find the unvisited node with the smallest distance
            for (int v : allNodes) {
                if (!visited.contains(v) && dist.get(v) < minDist) {
                    minDist = dist.get(v);
                    minNode = v;
                }
            }

            // If no reachable unvisited node remains, exit the loop
            if (minNode == -1) break;

            // Mark the chosen node as visited
            visited.add(minNode);

            // Relax all edges from the current node
            for (Edge e : graph.getAdj(minNode)) {
                int v = e.target;     // target node of the edge
                int weight = e.weight; // weight of the edge

                // Relaxation step: update distance if a shorter path is found
                if (dist.get(minNode) + weight < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, dist.get(minNode) + weight);
                    parent.put(v, minNode); // Update the parent for path reconstruction
                }
            }
        }
    }

    @Override
    public int getDistanceTo(int v) {
        // Return the distance to node v, or a large number if it's unreachable
        return dist.getOrDefault(v, Integer.MAX_VALUE) == Integer.MAX_VALUE ? 1_000_000 : dist.get(v);
    }
}
