public class MainSortingAndInversionCount {
    private static final String SORTING_AND_INVERSION_COUNT_ALGORITHM = "MergeSortAndCount";

    public static void main(String[] args) {

        int[] inputArray = {8, 4, 2, 7, 5, 3, 1, 9};

        // Print input array
        System.out.println("Input array:");
        printArray(inputArray);
        System.out.println();

        SortingAndInversionCountAlgorithm sortingAndInversionCountAlgorithm = SortingAndInversionCountAlgorithmFactory.getAlgorithm(SORTING_AND_INVERSION_COUNT_ALGORITHM);

        if (sortingAndInversionCountAlgorithm == null) {
            System.out.println("Inversion Count algorithm not found.");
            return;
        }

        // Sort the array
        int[] sortedArray = sortingAndInversionCountAlgorithm.sortAndCount(inputArray);

        // Print sorted array
        System.out.println("Sorted array:");
        printArray(sortedArray);
        System.out.println();

        long inversions = sortingAndInversionCountAlgorithm.getInversionCount();
        System.out.println("Number of inversions: " + inversions);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
