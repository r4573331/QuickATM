import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    // Method checks if user input is actually in the array choices
    public static boolean linearSearch(int[] functions, int target) {
        for(int i = 0; i < functions.length; i++) {
            if(functions[i] == target) {
                return true;
            }
        }
        return false;
    }

    // Account Function
    public static void accountAction() {
        int[] functions = {1, 2, 3};
        boolean functionChecker = false;
        System.out.println("------------------------------------------------------------");
        System.out.println("What would you like to do?\n1. Check Balance\n2. Deposit\n3. Withdraw");
        int userChoice = Integer.parseInt(scanner.nextLine());

        // Checks if user input is actually valid
        functionChecker = linearSearch(functions, userChoice);
        while(functionChecker == false) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Invalid Input, please input a valid number.");
            System.out.println("------------------------------------------------------------");
            System.out.println("What would you like to do?\n1. Check Balance\n2. Deposit\n3. Withdraw");
            userChoice = Integer.parseInt(scanner.nextLine());
            functionChecker = linearSearch(functions, userChoice);
            System.out.println("------------------------------------------------------------");
        }
    }

    // Checks if user pin is correct
    public static boolean accountChecker(int userPin, int pinEntry) {
        int tries = 0;
        while(pinEntry != userPin){
            tries++;
            System.out.println("------------------------------------------------------------");
            System.out.println("Incorrect. You now have " + (4 - tries) + " tries allowed."); // 3 tries allowed
            System.out.println("------------------------------------------------------------");
            System.out.println("Please enter your bank account pin");
            pinEntry = Integer.parseInt(scanner.nextLine());
            if(tries == 3){
                return false;
            }
        }
        return true;
    }

    // Main Method
    public static void main(String[] args) {
        boolean checker;
        int userPin = 1234;

        // Asks user for pin
        System.out.println("Please enter your bank account pin (4-digits)");
        int pinEntry = Integer.parseInt(scanner.nextLine());

        // Checks if pin is negative, or greater than 4 digits
        while(pinEntry > 9999 || pinEntry < 0){
            System.out.println("Invalid, please enter a valid 4-digit pin");
            pinEntry = Integer.parseInt(scanner.nextLine());
        }

        // Checks if pin is actually correct
        checker = accountChecker(userPin, pinEntry);
        if(checker == true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Welcome!");
        }
        else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Your account has been shut down. Please contact us to reactivate.");
            System.out.println("------------------------------------------------------------");
        }

        // Get the user to do an action
        accountAction();
    }
}