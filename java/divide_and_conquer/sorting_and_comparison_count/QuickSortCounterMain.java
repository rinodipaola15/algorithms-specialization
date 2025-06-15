
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortCounterMain {
    private static final String INPUT_FILE_PATH = "./java/divide_and_conquer/sorting_and_comparison_count/QuickSort.txt";

    public static void main(String[] args) {
        int[] inputArray = readArrayFromFile(INPUT_FILE_PATH);
        if (inputArray == null) {
            System.out.println("Error reading the file or file is empty.");
            return;
        }

        QuickSortCounter sorter = new QuickSortCounter();

        // First version: using the first element as pivot
        int[] arrayFirstPivot = Arrays.copyOf(inputArray, inputArray.length);
        int comparisonsFirstPivot = sorter.sort(arrayFirstPivot, QuickSortCounter.PivotRule.FIRST_ELEMENT);
        System.out.println("1. Comparisons (first element as pivot): " + comparisonsFirstPivot);

        // Second version: using the last element as pivot
        int[] arrayLastPivot = Arrays.copyOf(inputArray, inputArray.length);
        int comparisonsLastPivot = sorter.sort(arrayLastPivot, QuickSortCounter.PivotRule.LAST_ELEMENT);
        System.out.println("2. Comparisons (last element as pivot): " + comparisonsLastPivot);

        // Third version: using the median-of-three pivot rule
        int[] arrayMedianPivot = Arrays.copyOf(inputArray, inputArray.length);
        int comparisonsMedianPivot = sorter.sort(arrayMedianPivot, QuickSortCounter.PivotRule.MEDIAN_OF_THREE);
        System.out.println("3. Comparisons (median-of-three pivot): " + comparisonsMedianPivot);

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
}
