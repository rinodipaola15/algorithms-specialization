public class KaratsubaMultiplication extends IntegerMultiplicationAlgorithm {

    // Constructor
    public KaratsubaMultiplication() {
        super("Karatsuba");
    }

    @Override
    public int multiply(int x, int y) {
        // Base case: if either number is less than 10, multiply directly
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Determine the number of digits of the larger number
        int xLength = countDigits(x);
        int yLength = countDigits(y);
        int maxLength = Math.max(xLength, yLength);

        // Split position: half of maxLength (rounded down)
        int halfLength = maxLength / 2;
        int powerOfTen = (int) Math.pow(10, halfLength);

        // Split x into two parts: firstHalf (most significant digits) and secondHalf (least significant)
        int xFirstHalf = x / powerOfTen;
        int xSecondHalf = x % powerOfTen;

        // Split y similarly
        int yFirstHalf = y / powerOfTen;
        int ySecondHalf = y % powerOfTen;

        // Recursive multiplications
        int productLow = multiply(xSecondHalf, ySecondHalf);
        int productHigh = multiply(xFirstHalf, yFirstHalf);
        int productCross = multiply(xFirstHalf + xSecondHalf, yFirstHalf + ySecondHalf);

        int productMiddle = productCross - productHigh - productLow;

        // Combine results using Karatsuba's formula
        return productHigh * (int) Math.pow(10, 2 * halfLength)
             + productMiddle * powerOfTen
             + productLow;
    }

    // Utility method to count digits in a number
    private int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
