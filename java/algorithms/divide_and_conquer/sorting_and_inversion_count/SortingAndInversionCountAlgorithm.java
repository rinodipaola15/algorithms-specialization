public abstract class SortingAndInversionCountAlgorithm {
    protected String name;
    protected long inversionCount; // number of inversions

    // Constructor
    public SortingAndInversionCountAlgorithm(String name) {
        this.name = name;
        this.inversionCount = 0;
    }

    // Get the name of the algorithm
    public String getName() {
        return name;
    }

    // Get the number of inversions found during sorting
    public long getInversionCount() {
        return inversionCount;
    }

    // Set the number of inversions (used to reset before sorting)
    public void setInversionCount(long inversionCount) {
        this.inversionCount = inversionCount;
    }

    // Abstract method to sort the array and count inversions
    public abstract int[] sortAndCount(int[] array);
}
