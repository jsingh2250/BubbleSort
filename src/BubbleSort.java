import java.util.Random;
import java.util.Scanner;

/** This class implements bubble sort.
 * 
 * @author Jaskaran Singh
 */
public class BubbleSort {
    /**
     * Print a message to the user to ask them to specify the length of the array of random integers and returns the user-inputted value.
     * 
     * @param scanner The scanner object to use to get user-input.
     * @return The user-specified array length.
     */
    public static int getArrayLengthFromUser(Scanner scanner) {
        // Print a message to the user to ask them to specify the length of the array of random integers.
        System.out.println();
        System.out.print("Please enter the length of the array of random integers: ");

        // Store the user-specified array length.
        int randomIntsLength = scanner.nextInt();

        // Print new line.
        System.out.println();

        // Return the user-specified array length.
        return randomIntsLength;
    }

    /**
     * Create an array with random integers between 0 and 100.
     * 
     * @param randomIntsLength The length of the array of random integers.
     * @return The created array of random integers.
     */
    public static int[] createRandomArray(int randomIntsLength) {
        // Create the array that will store random integers.
        int[] randomInts = new int[randomIntsLength];

        // Create a random object.
        Random random = new Random();

        // Fill the array with random integers between 0 and 100.
        for (int randomInt = 0; randomInt < randomInts.length; randomInt++) {
            // Get a random integer between 0 and 100.
            randomInts[randomInt] = random.nextInt(101);
        }

        // Return the array of random integers.
        return randomInts;
    }

    /**
     * Print the array.
     * 
     * @param arrayToPrint The array to print.
     */
    public static void printArray(int[] arrayToPrint) {
        for (int element : arrayToPrint) {
            System.out.println(element);
        }
    }

    /**
     * Main method of this class.
     * 
     * @param args Unused input argument.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Declare a variable that will store the user-specified length of the array of random integers.
        int randomIntsLength;

        // Use the Scanner to let the user specify the length of the array with random integers.
        try (Scanner scanner = new Scanner(System.in)) {
            randomIntsLength = getArrayLengthFromUser(scanner);
        } 
        // If an exception was thrown, print information about the exception and set the length of the array to zero.
        catch (Exception exception) {
            // Print information about the exception.
            exception.printStackTrace();

            // Set the length of the array to zero.
            randomIntsLength = 0;
        }

        // Create an array with random integers between 0 and 100.
        int[] randomInts = createRandomArray(randomIntsLength);

        // Print array to test user input and creation of array with random integers.
        printArray(randomInts);
    }
}
