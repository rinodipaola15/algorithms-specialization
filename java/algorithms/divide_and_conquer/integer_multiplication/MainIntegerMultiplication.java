import java.math.BigInteger;

public class MainIntegerMultiplication {
    private static final String INTEGER_MULTIPLICATION_ALGORITHM = "KaratsubaMultiplication";

    public static void main(String[] args) {

        BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        
        // Print input numbers
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        IntegerMultiplicationAlgorithm integerMultiplicationAlgorithm = IntegerMultiplicationAlgorithmFactory.getAlgorithm(INTEGER_MULTIPLICATION_ALGORITHM);

        if(integerMultiplicationAlgorithm == null) {
            System.out.println("Integer multiplication algorithm not found.");
            return;
        }
        
        // multiply input numbers
        BigInteger product = integerMultiplicationAlgorithm.multiply(x, y);
        
        // Print multiplication result
        System.out.println("Result of " + x + " * " + y + " = " + product);
    }
}
