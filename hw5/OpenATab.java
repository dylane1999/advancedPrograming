import java.util.Scanner;

public class OpenATab {

    // Write a program that opens a tab for your user and continuously asks for
    // drinks until the user is done. First, you would ask and record the user’s
    // name. For each item the user orders, print out what it is in a message. There
    // is a 10% discount if the user orders more than 10 drinks (including 10). Have
    // the program print the total cost of the tab when the user enters “done”. You
    // may assume that the user will not enter anything other than “done” to end the
    // program.

    // Welcome to the bar. What is your name?
    // Luke
    // Hi, Luke! You may place orders now. Each item costs $10. When you are done,
    // please enter done.
    // truffle fries
    // Enjoy your truffle fries. Can I get you anything else?
    // beer
    // Enjoy your beer. Can I get you anything else?
    // margarita
    // Enjoy your margarita. Can I get you anything else?
    // done
    // Thank you, Luke! Your total amount is $30

    public static void OpenTab() {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer numItemsOrdered = 0;
            System.out.println(
                    "\nWelcome to the bar. What is your name? \n");
            String username = scanner.nextLine();
            System.out.println(String.format("Hi, %s! You may place orders now. Each item costs $10. When you are done, please enter done.", username));
            while (true) {
                String order = scanner.nextLine();
                if (order.equals("done")) {
                    System.out.println(String.format("Thank you, %s! Your total amount is $%d", username, 10*numItemsOrdered));
                    return;
                }
                else{
                    numItemsOrdered++;
                    System.out.println(String.format("Enjoy your %s. Can I get you anything else?", order, 10*numItemsOrdered));
                }
            }
        }

    }

}
