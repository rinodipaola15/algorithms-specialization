public abstract class SortingAlgorithm {
    protected String name;

    // Constructor
    public SortingAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int[] sort(int[] array);
}
