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
        System.out.print("Please enter a positive integer to specify the length of the array of random integers: ");

        // Store the user-specified array length.
        int randomIntsLength = scanner.nextInt();

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
        System.out.println();
        for (int element : arrayToPrint) {
            System.out.println(element);
        }
    }

    /**
     * Sort the array in-place with bubble sort.
     * 
     * @param arrayToSort The array to sort.
     */
    public static void bubbleSort(int[] arrayToSort) {
        for (int i = (arrayToSort.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // If the element in the array with the larger index is smaller than the element in the array with the larger index, swap the elements.
                if (arrayToSort[i] < arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
    }

    /**
     * Check if the array is sorted.
     * 
     * @param arrayToCheck The array to check.
     * @return Return true if the array is sorted in ascending order. Return false otherwise.
     */
    public static boolean isArraySorted(int[] arrayToCheck) {
        // Return false if an element with a lower index is greater than an element with a higher index.
        for (int i = 1; i < (arrayToCheck.length); i++) {
            if (arrayToCheck[i - 1] > arrayToCheck[i]) {
                return false;
            }
        }

        // The array is sorted in ascending order. Return true.
        return true;
    }

    /**
     * Check whether an array is sorted and print a message to indicate whether the array is sorted.
     * 
     * @param arrayToCheck The array to check.
     */
    public static void printIsArraySorted(int[] arrayToCheck) {
        // Print a boolean value to indicate whether the array is sorted in ascending order.
        System.out.println();
        System.out.println("Array is sorted: " + isArraySorted(arrayToCheck));
    }

    /**
     * Main method of this class.
     * 
     * @param args Unused input argument.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Declare a variable that will store the user-specified length of the array of random integers.
        // Initialize the variable to zero to indicate that the user hasn't specified a valid array length yet.
        int randomIntsLength = 0;

        // Use the Scanner to let the user specify the length of the array with random integers.
        try (Scanner scanner = new Scanner(System.in)) {
            // Get the length of the array from the user until they specify a positive number for the array length.
            while (randomIntsLength <= 0) {
                randomIntsLength = getArrayLengthFromUser(scanner);
            }
        }
        // If an exception was thrown, print information about the exception and set the length of the array to zero.
        catch (Exception exception) {
            // Print information about the exception.
            exception.printStackTrace();

            // Exit out of the program.
            System.exit(0);
        }

        // Create an array with random integers between 0 and 100.
        int[] ints = createRandomArray(randomIntsLength);

        // Print array to test user input and creation of array with random integers.
        printArray(ints);

        // Check whether an array is sorted and print a message to indicate whether the array is sorted.
        printIsArraySorted(ints);
        
        // Sort the array with bubble sort.
        bubbleSort(ints);
        
        // Print array to verify that the array was sorted.
        printArray(ints);
        
        // Check whether an array is sorted and print a message to indicate whether the array is sorted.
        printIsArraySorted(ints);
    }
}
