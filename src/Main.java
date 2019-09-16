// Create a program using arrays that sorts a list of integers in descending order.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] scannedIntegers = getIntegers(5); // Scanning int values from keyboard
        System.out.println("Scanned array: ");
        printArray(scannedIntegers);
        int[] sortedIntegers = sortIntegers(scannedIntegers); // Sorting scanned values in descending order
        System.out.println("Sorted array: ");
        printArray(sortedIntegers);
    }

    public static void printArray(int[] array)
    {
        int i = 0;
        while (i < array.length)
        {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static int[] getIntegers(int amount) // Method that scans int values from keyboard
    {
        Scanner scanner = new Scanner(System.in); // Creating scanner object for reading keyboard values
        int[] scannedIntegers = new int[amount]; // Creating an array that will store scanned values
        int input, i = 0; // input reads int values from keyboard, i counts how many numbers the user has entered
        while (i < amount)
        {
            System.out.println("Enter number #" + (i+1));
            if (scanner.hasNextInt()) // If user entered int value, it's being read and put in the array
            {
                input = scanner.nextInt();
                scannedIntegers[i] = input;
                i++;
            }
            else // If user entered invalid value, program will ask them to try again
            {
                System.out.println("Invalid value, please try again");
            }
            scanner.nextLine();
        }
        scanner.close();
        return scannedIntegers;
    }

    public static int[] sortIntegers(int[] array) // Method that sorts integers in descending order
    {
        int[] sortedIntegers = new int[array.length]; // Creating a new array
        int copiedValue;
        boolean isSmaller = false;
        for (int i = 0; i < sortedIntegers.length; i++) // Copying values from one array to another before starting to sort values
        {
            sortedIntegers[i] = array[i];
        }
        for (int i = 0; i < sortedIntegers.length; i++) // Sorting values in the right order
        {
            for (int j = 0; j < sortedIntegers.length - 1; j++)
            {
                isSmaller = sortedIntegers[j] < sortedIntegers[j + 1];
                if (isSmaller) // If current element's value is smaller than the value of the next one, they get swapped
                {
                    copiedValue = sortedIntegers[j];
                    sortedIntegers[j] = sortedIntegers[j + 1];
                    sortedIntegers[j + 1] = copiedValue;
                }
            }
        }
        return sortedIntegers;
    }

}
