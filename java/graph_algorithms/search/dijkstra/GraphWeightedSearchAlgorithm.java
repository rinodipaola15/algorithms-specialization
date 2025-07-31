// ------------------------------
// GraphSearchAlgorithm.java
// ------------------------------

public abstract class GraphWeightedSearchAlgorithm {
    protected final String name;

    public GraphWeightedSearchAlgorithm(String name) {
        this.name = name;
    }

    public abstract void run(GraphWeighted graph, int source);

    public abstract int getDistanceTo(int v);

    public String getName() {
        return name;
    }
}