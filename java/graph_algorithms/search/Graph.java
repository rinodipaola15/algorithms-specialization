import java.util.*;

public class Graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // non orientato
    }

    public List<Integer> getAdj(int node) {
        return adj.getOrDefault(node, new ArrayList<>());
    }

    public Set<Integer> getAllNodes() {
        return adj.keySet();
    }
}
