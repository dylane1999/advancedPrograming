import java.util.Arrays;
import java.util.Scanner;

public class MathParty {

    // Write a program that asks the user to create two arrays of doubles and then
    // performs some math operations between the two arrays. You may assume all the
    // user inputs are valid and there is no need to validate. First, ask the user
    // the amount of numbers (N) they want to enter. Then prompt the user to enter N
    // numbers for both arrays. Once two arrays are populated, ask the user to enter
    // the operator. You may assume that the user will only enter one of the four
    // operators (+, -, * and /). Once the operator is entered, do the operation
    // between the two arrays and print the result.

    // Your program should print similar output as follows:

    // Welcome to the Math Party! How many numbers do you want to enter?
    // 4
    // Now enter 4 numbers for the first array!
    // Enter your number:
    // 1.4
    // Enter your number:
    // 0.4
    // Enter your number:
    // 9
    // Enter your number:
    // 2.5
    // The numbers you entered are [1.4, 0.4, 9.0, 2.5]

    // Now enter 4 numbers for the second array!
    // Enter your number:
    // 9
    // Enter your number:
    // 0.4
    // Enter your number:
    // -3
    // Enter your number:
    // 2.2
    // The numbers you entered are [9.0, 0.4, -3.0, 2.2]

    // Now what operation do you want to do between two arrays?
    // -
    // The result is [-7.6, 0.0, 12.0, 0.2999999999999998]

    public static void mathParty() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nWelcome to the Math Party! How many numbers do you want to enter? \n");
            Integer arraySize = Integer.parseInt(scanner.nextLine());
            Double[] firstArray = new Double[arraySize];
            Double[] secondArray = new Double[arraySize];
            System.out.println(String.format("Now enter %d numbers for the first array!", arraySize));
            for (int i = 0; i < firstArray.length; i++) {
                System.out.println("Enter your number:");
                Double nextNumber = Double.parseDouble(scanner.nextLine());
                firstArray[i] = nextNumber;
            }
            System.out.println(String.format("The numbers you entered are %s", Arrays.toString(firstArray)));

            System.out.println(String.format("Now enter %d numbers for the second array!", arraySize));
            for (int i = 0; i < secondArray.length; i++) {
                System.out.println("Enter your number:");
                Double nextNumber = Double.parseDouble(scanner.nextLine());
                secondArray[i] = nextNumber;
            }
            System.out.println(String.format("The numbers you entered are %s", Arrays.toString(secondArray)));
            System.out.println("Now what operation do you want to do between two arrays? (+, -, * and /)");
            String userChoice = scanner.nextLine();
            if (userChoice.equals("+")) {
                Double[] result = new Double[arraySize];
                for (int i = 0; i < secondArray.length; i++) {
                    result[i] = firstArray[i] + secondArray[i];

                }
                System.out.println(String.format("the result is: %s", Arrays.toString(result)));

            } else if (userChoice.equals("-")) {
                Double[] result = new Double[arraySize];
                for (int i = 0; i < secondArray.length; i++) {
                    result[i] = firstArray[i] - secondArray[i];

                }
                System.out.println(String.format("the result is: %s", Arrays.toString(result)));

            } else if (userChoice.equals("*")) {
                Double[] result = new Double[arraySize];
                for (int i = 0; i < secondArray.length; i++) {
                    result[i] = firstArray[i] * secondArray[i];

                }
                System.out.println(String.format("the result is: %s", Arrays.toString(result)));

            } else if (userChoice.equals("/")) {
                Double[] result = new Double[arraySize];
                for (int i = 0; i < secondArray.length; i++) {
                    result[i] = firstArray[i] / secondArray[i];

                }
                System.out.println(String.format("the result is: %s", Arrays.toString(result)));

            } else {
                System.out.println("Invalid operation");

            }

        }

    }

}
