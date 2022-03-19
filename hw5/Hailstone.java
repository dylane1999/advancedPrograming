import java.util.Scanner;

public class Hailstone {

    // Write a program that asks the user to enter a positive integer n and then
    // calculates a new value for n based on whether it is even or odd:
    // If n is even, n = n/2;
    // If n is odd, n = 3*n + 1
    // You would continuously calculate until n becomes 1. At the end, print the
    // number of steps it took to reach 1.

    // If the user does not enter a positive integer, you need to print an error
    // message and continuously ask until a valid positive integer is entered. In
    // this case, you need to check to make sure the input type is not an integer
    // and if it is an integer, it has to be positive.

    // Your program should print similar output as follows:

    // Welcome to Hailstone number calculator. Please enter a positive integer:
    // hello
    // Wrong input. Please enter a positive integer:
    // -100
    // Wrong input. Please enter a positive integer:
    // 0
    // Wrong input. Please enter a positive integer:
    // 10
    // 10 (even, next value is + 10/2)
    // 5 (odd, next value is + 5*3 + 1)
    // 16 (even, next value is + 16/2)
    // 8 (even, next value is + 8/2)
    // 4 (even, next value is + 4/2)
    // 2 (even, next value is + 2/2)
    // 1 (done)

    // It takes 6 steps to reach 1.

    public static void hailstone() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    "\nWelcome to Hailstone number calculator. Please enter a positive integer: \n");
            while (true) {
                Integer posInt;
                String userInput = scanner.nextLine();
                try {
                    posInt = Integer.parseInt(userInput);
                    if (posInt < 0) {
                        System.out.println("Wrong input. Please enter a positive integer");
                    } else {
                        while (posInt != 1) {
                            if (posInt % 2 == 0) {
                                System.out.println(String.format("%d (even, next value is %d/2)", posInt, posInt));
                                posInt = posInt / 2;
                            } else {
                                System.out.println(String.format("%d (odd, next value is 3*n + 1)", posInt, posInt));
                                posInt = 3 * posInt + 1;
                            }
                        }
                        System.out.println("1 (done)");
                        return;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input. Please enter a positive integer");
                }
            }

        }

    }

}
