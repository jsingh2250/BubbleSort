import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** This class implements bubble sort.
 * 
 * @author Jaskaran Singh
 */
public class BubbleSort {
    // Store the text input cursor that will be used in this program.
    private static final String TEXT_INPUT_CURSOR = "> ";

    /**
     * Print a message to the user to ask them to specify the length of the array.
     * 
     * @param userInputScanner The scanner object to use to get user-input.
     * @return The user-specified array length.
     */
    public static int getArrayLengthFromUser(Scanner userInputScanner) {
        // Declare a variable that will store the user-specified length of the array.
        // Initialize the variable to zero to indicate that the user hasn't specified a valid array length yet.
        int randomIntsLength = 0;

        while (randomIntsLength <= 0) {
            try {
                // Get the length of the array from the user until they specify a positive integer for the array length.
                // Print a message to the user to ask them to specify the length of the array of random integers.
                System.out.println();
                System.out.println(
                        "Please enter a positive integer to specify the length of the array of random integers.");

                // Print the text input cursor.
                System.out.println();
                System.out.print(TEXT_INPUT_CURSOR);

                // Store the user-specified array length.
                randomIntsLength = Integer.parseInt(userInputScanner.next());

                // If the user didn't enter a positive integer, throw an exception.
                if (randomIntsLength <= 0) {
                    throw new Exception();
                }

            } catch (Exception exception) {
                // Print a message to the user the let them know that their input was invalid.
                System.out.println();
                System.out.println("Your input was invalid. Please try again.");
            }
        }

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
            System.out.print(element + " ");
        }
    }

    /**
     * Write the array to a file with each line in the file containing one integer from the array.
     * 
     * @param arrayToWriteToFile The array that needs to be written to a file.
     * @param fileName The name of the file to write to.
     */
    public static void writeArrayToFile(int[] arrayToWriteToFile, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            // Write each element in the array to the file. Each element should be followed by a new line.
            for (int element : arrayToWriteToFile) {
                fileWriter.write(element + "\n");
            }
        }
    }

    /**
     * Read a file that has one integer per line. Put the integers in an array.
     * 
     * @param fileName The name of the file that needs to be read.
     * @return The array that the numbers in the file are going to to be written to.
     */
    public static int[] readFileToArray(String fileName) throws Exception {
        // Create a file object with the file name.
        File file = new File(fileName);

        // Create an ArrayList to store the integers from the file.
        ArrayList<Integer> integers = new ArrayList<Integer>();

        // Use Scanner to read the integers into an array list.
        try (Scanner scanner = new Scanner(file)) {
            // While there is an integer in the file that hasn't been read into the ArrayList, add the next integer into the ArrayList.
            while (scanner.hasNext()) {
                integers.add(scanner.nextInt());
            }
        }

        // Create the int array that will store the integers from the file.
        int[] arrayReadFromFile = new int[integers.size()];

        // Put the integers from the ArrayList into the int array.
        for (int element = 0; element < arrayReadFromFile.length; element++) {
            arrayReadFromFile[element] = integers.get(element);
        }

        // Return the int array that contains the numbers from the file.
        return arrayReadFromFile;
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
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
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
        System.out.println("The above array is sorted: " + isArraySorted(arrayToCheck));
    }

    /**
     * Print information about the exception and exit out of the program.
     * 
     * @param exception The exception to print information about.
     */
    public static void printExceptionInformationAndExit(Exception exception) {
        // Print information about the exception.
        exception.printStackTrace();

        // Exit out of the program.
        System.exit(0);
    }

    /**
     * Create an array with random integers between 0 and 100.
     * 
     * @param userInputScanner A reference to the scanner object used to obtain user-input.
     * @return The created array of random integers.
     */
    public static int[] createRandomArrayAndPrint(Scanner userInputScanner) {
        // Use the Scanner to let the user specify the length of the array.
        int randomIntsLength = getArrayLengthFromUser(userInputScanner);

        // Create an array with random integers between 0 and 100.
        int[] randomInts = createRandomArray(randomIntsLength);
        // Print the array to test the user-input and to test the creation of the array with random integers.
        System.out.println();
        System.out.print("Created the array of random integers between 0 and 100.\n" +
                "These are the elements in the array:");
        printArray(randomInts);

        // Check whether the array is sorted and print a message to indicate whether the array is sorted.
        printIsArraySorted(randomInts);

        // If the array is already sorted, tell the user that it was created in a sorted order accidentally.
        if (isArraySorted(randomInts)) {
            System.out.println(
                    "The above array was accidentally created in a sorted order when it was created randomly.");
        }

        // Return the array of random integers.
        return randomInts;
    }

    /**
     * Write the array to a file with each line in the file containing one integer from the array.
     * 
     * @param arrayToWriteToFile The array that needs to be written to a file.
     * @param userInputScanner A reference to the scanner object used to obtain user-input.
     */
    public static void writeArrayToFileAndPrint(int[] arrayToWriteToFile, Scanner userInputScanner) {
        // Declare a variable that will store the user-specified file name.
        // Initialize the variable to null to indicate that the user hasn't specified a valid file name yet.
        String fileName = null;

        // Get the file name from the user until they specify a valid file name.
        while (fileName == null) {
            try {
                // Print a message to the user to ask them to specify the filename.
                System.out.println();
                System.out.println(
                        "Please specify a file name without a file extension to save the array in the specified file.\n"
                                +
                                "The file will be saved as a \".txt\" file.");

                // Print the text input cursor.
                System.out.println();
                System.out.print(TEXT_INPUT_CURSOR);

                // Store the user-specified file name with the ".txt" extension appended to it.
                fileName = userInputScanner.next() + ".txt";

                // Write the array to a file. Each line in the file should contain one integer from the array.
                writeArrayToFile(arrayToWriteToFile, fileName);
                System.out.println();
                System.out.println("Wrote the array to the file:\n" +
                        fileName);

            } catch (Exception exception) {
                // Print a message to the user the let them know that their input was invalid.
                System.out.println();
                System.out.println("Your input was invalid. Please try again.");

                // Set the file name to null to allow the user to try again.
                fileName = null;
            }
        }
    }

    /**
     * Read a file that has one integer per line. Put the integers in an array.
     * 
     * @param fileName The name of the file that needs to be read.
     * @param userInputScanner A reference to the scanner object used to obtain user-input.
     * @return The array that the numbers in the file are going to to be written to.
     */
    public static int[] readFileToArrayAndPrint(Scanner userInputScanner) {
        // Initialize the variable to null to indicate that the user hasn't specified a valid file name yet.
        // Declare a variable that will store the reference to the array that contains the numbers in the file.
        int[] arrayReadFromFile = null;

        // Declare a variable that will store the user-specified file name.
        String fileName = null;

        // Get the file name from the user until they specify a valid file name.
        while (arrayReadFromFile == null) {
            try {
                // Print a message to the user to ask them to specify the filename.
                System.out.println();
                System.out.println(
                        "Please specify a file name without a file extension to read an array from the specified file.\n"
                                +
                                "A \".txt\" file with the file name will be read if it exists.");

                // Print the text input cursor.
                System.out.println();
                System.out.print(TEXT_INPUT_CURSOR);

                // Store the user-specified file name with the ".txt" extension appended to it.
                fileName = userInputScanner.next() + ".txt";

                // Read a file that has one integer per line. Put the integers in an array.
                arrayReadFromFile = readFileToArray(fileName);

                // Print the array to test whether the numbers from the file were correctly read into the array.
                System.out.println();
                System.out.print("Read the integers from the file, \"" + fileName
                        + "\", into an int array.\n" +
                        "These are the elements in the array:");
                printArray(arrayReadFromFile);

                // Check whether the array is sorted and print a message to indicate whether the array is sorted.
                printIsArraySorted(arrayReadFromFile);

            } catch (Exception exception) {
                // Print a message to the user the let them know that their input was invalid.
                System.out.println();
                System.out.println("Your input was invalid. Please try again.");
            }
        }

        // Return the int array that contains the numbers from the file.
        return arrayReadFromFile;
    }

    /**
    * Sort the array in-place with bubble sort.
    * 
    * @param arrayToSort The array to sort.
    */
    public static void bubbleSortAndPrint(int[] arrayToSort) {
        // Sort the array in-place with bubble sort.
        bubbleSort(arrayToSort);

        // Print the array to verify that it was sorted.
        System.out.println();
        System.out.print("Sorted the array of integers with bubble sort.\n" +
                "These are the elements in the array:");
        printArray(arrayToSort);

        // Check whether the array is sorted and print a message to indicate whether the array is sorted.
        printIsArraySorted(arrayToSort);
    }

    /**
     * Main method of this class.
     * 
     * @param args Unused input argument.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Store the name of this program as a string.
        final String PROGRAM_NAME = "Bubble Sort";

        // Print a welcome message.
        System.out.println();
        System.out.println("Welcome to the " + PROGRAM_NAME + " program!\n" +
                "This program sorts arrays with bubble sort.");

        // Create a scanner object to read user-input.
        Scanner userInputScanner = new Scanner(System.in);

        // Run the main part of the program repeatedly until the user wants to exit out of the program.
        while (true) {
            // Store the valid commands the user can input as strings.
            final String EXIT_COMMAND = "0";
            final String GENERATE_ARRAY_COMMAND = "1";
            final String SORT_ARRAY_COMMAND = "2";

            // Prompt user with options to figure out what they want to do.
            System.out.println();
            System.out.println("Enter \"" + EXIT_COMMAND + "\" to exit out of the program.\n" +

                    "Enter \"" + GENERATE_ARRAY_COMMAND
                    + "\" to generate an array of random integers and store the integers in a file.\n" +

                    "Enter \"" + SORT_ARRAY_COMMAND
                    + "\" to read an existing file containing a list of integers (one integer per line), sort the integers, and store the integers in a file.");

            // Print the text input cursor.
            System.out.println();
            System.out.print(TEXT_INPUT_CURSOR);

            // Get and store input from the user.
            String userInput = userInputScanner.next();

            // Declare an array reference variable to work with the array of integers.
            int[] ints = null;

            // Do what the user requested if they gave a valid command.
            if (userInput.equals(EXIT_COMMAND)) {
                // Exit out of the main loop.
                break;
            } else if (userInput.equals(GENERATE_ARRAY_COMMAND)) {
                // Create an array with random integers between 0 and 100.
                ints = createRandomArrayAndPrint(userInputScanner);
            } else if (userInput.equals(SORT_ARRAY_COMMAND)) {
                // Read a file that has one integer per line. Put the integers in an array.
                ints = readFileToArrayAndPrint(userInputScanner);

                // Sort the array in-place with bubble sort.
                bubbleSortAndPrint(ints);
            } else {
                // Tell the user that their input was invalid.
                System.out.println();
                System.out.println("Your input was not a valid command.\n" +
                        "Please try again.");

                // Restart the loop.
                continue;
            }

            // Write the array to a file. Each line in the file should contain one integer from the array.
            writeArrayToFileAndPrint(ints, userInputScanner);
        }

        // Close the scanner.
        userInputScanner.close();

        // Print a farewell message.
        System.out.println();
        System.out.println("Thank you for using the " + PROGRAM_NAME + " program!\n" + "Goodbye.");
    }
}
