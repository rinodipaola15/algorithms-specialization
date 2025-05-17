public class MainSorting
{
    private static final String SORTING_ALGORITHM = "MergeSort";

	public static void main(String[] args) {

		int[] inputArray = {8, 4, 2, 7, 5, 3, 1, 9};
		
		// Print input array
		System.out.println("Input array: ");
		printArray(inputArray);
		System.out.println();

        SortingAlgorithm sortingAlgorithm = SortingAlgorithmFactory.getAlgorithm(SORTING_ALGORITHM);

        if(sortingAlgorithm == null) {
            System.out.println("Sorting algorithm not found.");
            return;
        }
		
        // Sort the array
		int[] sortedArray = sortingAlgorithm.sort(inputArray);
		
		// Print sorted array
		System.out.println("Sorted array: ");
		printArray(sortedArray);
		
	}	

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}