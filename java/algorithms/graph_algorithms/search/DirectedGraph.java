import java.util.*;

public class DirectedGraph extends Graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    @Override
    public void addEdge(int from, int to) {
        adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adj.computeIfAbsent(to, k -> new ArrayList<>()); // per assicurare che il nodo 'to' esista
    }

    @Override
    public List<Integer> getAdj(int node) {
        return adj.getOrDefault(node, Collections.emptyList());
    }

    @Override
    public Set<Integer> getAllNodes() {
        return adj.keySet();
    }
}
