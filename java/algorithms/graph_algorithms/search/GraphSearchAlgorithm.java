// ------------------------------
// GraphSearchAlgorithm.java
// ------------------------------

public abstract class GraphSearchAlgorithm {
    protected String name;

    public GraphSearchAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(Graph graph, int startNode);

    public abstract void printResults();
}
