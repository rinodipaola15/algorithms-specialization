import java.io.*;
import java.util.*;

public class TwoSumAlgorithm {

    public static void main(String[] args) throws IOException {
        String path = "./java/data_structures/hash_table/input.txt";

        // Step 1: Read all numbers into a HashSet
        Set<Long> numbers = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Long.parseLong(line.trim()));
            }
        }

        // Step 2: Create a HashSet to store all valid target sums
        Set<Long> validTargets = new HashSet<>();

        // Step 3: Define the interval of target sums [-10000, 10000]
        long minTarget = -10000;
        long maxTarget = 10000;

        // Step 4: For each number x in the set
        for (long x : numbers) {
            // Iterate over all possible target sums t in the interval
            for (long t = minTarget; t <= maxTarget; t++) {
                long y = t - x;  // Compute the number y that would sum with x to give t

                // Step 5: Ensure the two numbers are distinct
                if (y != x && numbers.contains(y)) {
                    // If y exists in the set and is different from x, t is a valid target
                    validTargets.add(t);
                }
            }
        }

        // Step 6: Output the total number of valid target sums
        System.out.println("Number of valid target sums: " + validTargets.size());
    }
}
