import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainSortingAndInversionCountFromFile {
    private static final String SORTING_AND_INVERSION_COUNT_ALGORITHM = "MergeSortAndCount";
    private static final String INPUT_FILE_PATH = "./java/algorithms/divide_and_conquer/sorting_and_inversion_count/array.txt";

    public static void main(String[] args) {
        // Read the array from the input file
        int[] inputArray = readArrayFromFile(INPUT_FILE_PATH);
        if (inputArray == null) {
            System.out.println("Error reading the file or file is empty.");
            return;
        }

        // Print the input array
        /*System.out.println("Input array:");
        printArray(inputArray);
        System.out.println();*/

        SortingAndInversionCountAlgorithm sortingAndInversionCountAlgorithm = SortingAndInversionCountAlgorithmFactory.getAlgorithm(SORTING_AND_INVERSION_COUNT_ALGORITHM);

        if (sortingAndInversionCountAlgorithm == null) {
            System.out.println("Inversion Count algorithm not found.");
            return;
        }

        // Sort the array and count inversions
        int[] sortedArray = sortingAndInversionCountAlgorithm.sortAndCount(inputArray);

        // Print the sorted array
        /*System.out.println("Sorted array:");
        printArray(sortedArray);
        System.out.println();*/

        long inversions = sortingAndInversionCountAlgorithm.getInversionCount();
        System.out.println("Number of inversions: " + inversions);
    }

    /**
     * Reads integers from a file, one per line, and returns them as an int array.
     * @param filePath path to the input file
     * @return int array of numbers read, or null if error occurs
     */
    private static int[] readArrayFromFile(String filePath) {
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trim whitespace and ignore empty lines
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Integer.valueOf(line));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error during file reading or parsing: " + e.getMessage());
            return null;
        }

        // Convert ArrayList<Integer> to int[]
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Prints the elements of an array to the console.
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            // To avoid flooding the console for large arrays, consider limiting output here
            // Example:
            // if (i > 100) { System.out.print("..."); break; }
        }
        System.out.println();
    }
}