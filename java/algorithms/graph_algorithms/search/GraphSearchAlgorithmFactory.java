import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GraphSearchAlgorithmFactory {
    private static final Map<String, Supplier<GraphSearchAlgorithm>> algorithms = new HashMap<>();

    static {
        algorithms.put("BFS", BFS::new);
        algorithms.put("BFSConnectedComponents", BFSConnectedComponents::new);
        algorithms.put("BFSShortestPaths", BFSShortestPaths::new);
        algorithms.put("DFS", DFS::new);
        algorithms.put("DFSTopologicalSort", DFSTopologicalSort::new);
        algorithms.put("DFSSCC", DFSSCC::new);
    }

    public static GraphSearchAlgorithm getAlgorithm(String name) {
        Supplier<GraphSearchAlgorithm> supplier = algorithms.get(name);
        return (supplier != null) ? supplier.get() : null;
    }
}
