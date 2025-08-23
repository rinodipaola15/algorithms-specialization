// ------------------------------
// GraphWeighted.java
// ------------------------------

import java.util.*;

public class GraphWeighted {
    private final Map<Integer, List<Edge>> adj = new HashMap<>();

    public void addEdge(int u, int v, int w) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
    }

    public List<Edge> getAdj(int u) {
        return adj.getOrDefault(u, new ArrayList<>());
    }

    public Set<Integer> getAllNodes() {
        return adj.keySet();
    }
}
