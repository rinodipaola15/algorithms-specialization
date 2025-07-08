import java.util.Arrays;

public class MainSelection
{
	public static void main(String[] args) {
        int[] array = {7, 3, 1, 9, 5};

        int i = 3; // We want the 3rd order statistic
        int result = RandomizedSelection.select(array, i);

        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("The " + i + "rd order statistic is: " + result);
    }

}
