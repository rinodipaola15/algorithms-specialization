import java.util.*;

public class DijkstraHeap extends GraphWeightedSearchAlgorithm {
    // Stores the shortest known distance from the source to each node
    private final Map<Integer, Integer> dist = new HashMap<>();
    
    // Stores the parent of each node in the shortest path tree
    private final Map<Integer, Integer> parent = new HashMap<>();

    public DijkstraHeap() {
        super("DijkstraHeap");
    }

    @Override
    public void run(GraphWeighted graph, int source) {
        // Priority queue (min-heap) that stores (distance, node) pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize distances: infinity for all nodes
        Set<Integer> allNodes = graph.getAllNodes();
        for (int v : allNodes) {
            dist.put(v, Integer.MAX_VALUE);
        }

        // Distance to source is 0
        dist.put(source, 0);
        pq.offer(new int[]{0, source}); // Add source node to the priority queue

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the node with the smallest distance
            int currentDist = current[0];
            int u = current[1];

            // If this distance is outdated (i.e., not the best known), skip
            if (currentDist > dist.get(u)) continue;

            // Explore all neighbors of the current node
            for (Edge e : graph.getAdj(u)) {
                int v = e.target;      // Target node
                int weight = e.weight; // Edge weight

                // Relaxation: if a shorter path is found
                if (dist.get(u) + weight < dist.get(v)) {
                    dist.put(v, dist.get(u) + weight); // Update distance
                    parent.put(v, u);                  // Update parent
                    pq.offer(new int[]{dist.get(v), v}); // Add neighbor to the priority queue
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
