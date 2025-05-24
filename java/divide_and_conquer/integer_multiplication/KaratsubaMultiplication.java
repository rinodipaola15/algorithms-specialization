import java.math.BigInteger;

public class KaratsubaMultiplication extends IntegerMultiplicationAlgorithm {

    // Constructor
    public KaratsubaMultiplication() {
        super("KaratsubaMultiplication");
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        // Base case: if either number is less than 10, multiply directly
        BigInteger ten = BigInteger.TEN;
        if (x.compareTo(ten) < 0 || y.compareTo(ten) < 0) {
            return x.multiply(y);
        }

        // Determine the number of digits of the larger number
        int xLength = x.toString().length();
        int yLength = y.toString().length();
        int maxLength = Math.max(xLength, yLength);

        // Split position: half of maxLength (rounded down)
        int halfLength = maxLength / 2;
        BigInteger powerOfTen = BigInteger.TEN.pow(halfLength);

        // Split x into two parts: firstHalf (most significant digits) and secondHalf (least significant)
        BigInteger xFirstHalf = x.divide(powerOfTen);
        BigInteger xSecondHalf = x.mod(powerOfTen);

        // Split y similarly
        BigInteger yFirstHalf = y.divide(powerOfTen);
        BigInteger ySecondHalf = y.mod(powerOfTen);

        // Recursive multiplications
        BigInteger productLow = multiply(xSecondHalf, ySecondHalf);
        BigInteger productHigh = multiply(xFirstHalf, yFirstHalf);
        BigInteger productCross = multiply(xFirstHalf.add(xSecondHalf), yFirstHalf.add(ySecondHalf));

        BigInteger productMiddle = productCross.subtract(productHigh).subtract(productLow);

        // Combine results using Karatsuba's formula
        return productHigh.multiply(BigInteger.TEN.pow(2 * halfLength))
                .add(productMiddle.multiply(powerOfTen))
                .add(productLow);
    }
}
