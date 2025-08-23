import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainMinCut {
    public static void main(String[] args) {
        try {
            String filename = "./java/algorithms/graph_algorithms/min_cut/kargerMinCut.txt"; // your graph file
            Map<Integer, List<Integer>> graph = RandomizedContraction.readGraph(filename);
            int minCut = RandomizedContraction.repeatedMinCut(graph, 200); // 200 iterations
            System.out.println("Minimum Cut found: " + minCut);
        } catch (IOException e) {
            System.out.println("Error reading graph file: " + e.getMessage());
        }
    }
}
