import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Implementation of Karger's Randomized Contraction Algorithm to compute the Minimum Cut of an undirected graph.
 */
public class RandomizedContraction {

    /**
     * Reads an undirected graph from a file in adjacency list format.
     *
     * @param filename the name of the input file
     * @return a map representing the graph
     * @throws IOException if file reading fails
     */
    public static Map<Integer, List<Integer>> readGraph(String filename) throws IOException {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\t");
            int vertex = Integer.parseInt(tokens[0]);
            List<Integer> neighbors = new ArrayList<>();
            for (int i = 1; i < tokens.length; i++) {
                neighbors.add(Integer.parseInt(tokens[i]));
            }
            graph.put(vertex, neighbors);
        }
        reader.close();
        return graph;
    }

    /**
     * Performs Karger's contraction algorithm on a deep copy of the input graph.
     *
     * @param originalGraph the input graph
     * @return the cut size found in this run
     */
    public static int kargerMinCut(Map<Integer, List<Integer>> originalGraph) {
        Map<Integer, List<Integer>> graph = deepCopy(originalGraph);
        Random random = new Random();

        while (graph.size() > 2) {
            // Choose a random edge (u, v)
            List<Integer> vertices = new ArrayList<>(graph.keySet());
            int u = vertices.get(random.nextInt(vertices.size()));
            List<Integer> uAdj = graph.get(u);
            int v = uAdj.get(random.nextInt(uAdj.size()));

            // Merge v into u
            List<Integer> vAdj = graph.get(v);
            uAdj.addAll(vAdj);

            // Replace all appearances of v with u
            for (int neighbor : vAdj) {
                List<Integer> adj = graph.get(neighbor);
                for (int i = 0; i < adj.size(); i++) {
                    if (adj.get(i) == v) {
                        adj.set(i, u);
                    }
                }
            }

            // Remove self-loops
            uAdj.removeIf(vertex -> vertex == u);

            // Remove vertex v
            graph.remove(v);
        }

        // Return number of crossing edges between the two remaining supernodes
        return graph.values().iterator().next().size();
    }

    /**
     * Repeats the Karger's algorithm multiple times to increase probability of finding the true min cut.
     *
     * @param graph the input graph
     * @param trials the number of iterations
     * @return the smallest cut found across all trials
     */
    public static int repeatedMinCut(Map<Integer, List<Integer>> graph, int trials) {
        int minCut = Integer.MAX_VALUE;
        for (int i = 0; i < trials; i++) {
            int cut = kargerMinCut(graph);
            if (cut < minCut) {
                minCut = cut;
            }
        }
        return minCut;
    }

    /**
     * Creates a deep copy of the graph.
     */
    private static Map<Integer, List<Integer>> deepCopy(Map<Integer, List<Integer>> original) {
        Map<Integer, List<Integer>> copy = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : original.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}
