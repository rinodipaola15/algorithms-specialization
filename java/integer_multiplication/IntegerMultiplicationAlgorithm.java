public abstract class IntegerMultiplicationAlgorithm {
    protected String name;

    // Constructor
    public IntegerMultiplicationAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int multiply(int x, int y);
}
