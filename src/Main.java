import java.util.Scanner;

public class Main {
    // Create a static scanner object for capturing user input
    static Scanner scanner = new Scanner(System.in);

    /**
     * This method checks if the user's input is present in the array of valid choices.
     * @param functions An array containing valid options for user actions.
     * @param target The user's input that needs to be checked.
     * @return true if the input exists in the array, false otherwise.
     */
    public static boolean linearSearch(int[] functions, int target) {
        for (int i = 0; i < functions.length; i++) {
            if (functions[i] == target) {
                return true;
            }
        }
        return false;
    }


    /**
     * This method handles account-related actions such as checking balance, depositing, or withdrawing.
     * It ensures that the user inputs a valid option and keeps prompting until valid input is given.
     */
    public static void accountAction() {
        int[] functions = {1, 2, 3}; // Array of valid choices for account actions
        double userBalance = 0.00;
        boolean functionChecker; // Tracks if the user input is valid
        boolean actionRepeater = false;

        // Display account action menu
        System.out.println("------------------------------------------------------------");
        System.out.println("What would you like to do?\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
        int userChoice = Integer.parseInt(scanner.nextLine());

        // Validate user input
        functionChecker = linearSearch(functions, userChoice);
        while (!functionChecker) { // Loop until a valid input is provided
            System.out.println("------------------------------------------------------------");
            System.out.println("Invalid Input, please input a valid number.");
            System.out.println("------------------------------------------------------------");
            System.out.println("What would you like to do?\n1. Check Balance\n2. Deposit\n3. Withdraw");
            userChoice = Integer.parseInt(scanner.nextLine());
            functionChecker = linearSearch(functions, userChoice);
            System.out.println("------------------------------------------------------------");
        }

        while (!actionRepeater) {
            switch(userChoice){
                case 1:
                    System.out.println("Your balance is now $" + userBalance);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Would you like to do anything else?\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("How much would you like to Withdraw?");
                    userBalance -= Double.parseDouble(scanner.nextLine());
                    System.out.println("Your balance is now $" + userBalance);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Would you like to do anything else?\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                    userChoice = Integer.parseInt(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("How much would you like to Withdraw?");
                    userBalance -= Double.parseDouble(scanner.nextLine());
                    System.out.println("Your balance is now $" + userBalance);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Would you like to do anything else?\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                    userChoice = Integer.parseInt(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Thank you for using this program");
                    actionRepeater = true;
            }
        }
    }

    /**
     * This method checks if the user's entered PIN matches the correct PIN.
     * It allows a maximum of 3 attempts before locking the account.
     * @param userPin The correct PIN for the account.
     * @param pinEntry The user's entered PIN.
     * @return true if the PIN is correct, false if attempts are exhausted.
     */
    public static boolean accountChecker(int userPin, int pinEntry) {
        int tries = 0; // Tracks the number of incorrect attempts

        // Loop until the correct PIN is entered or attempts are exhausted
        while (pinEntry != userPin) {
            tries++;
            System.out.println("------------------------------------------------------------");
            System.out.println("Incorrect. You now have " + (3 - tries) + " tries allowed."); // 3 tries total
            System.out.println("------------------------------------------------------------");
            System.out.println("Please enter your bank account pin");
            pinEntry = Integer.parseInt(scanner.nextLine());

            if (tries == 3) { // Lock the account after 3 incorrect attempts
                return false;
            }
        }
        return true;
    }

    /**
     * The main method acts as the entry point for the program.
     * It handles PIN validation and navigates the user to the account action menu.
     */
    public static void main(String[] args) {
        boolean checker; // Tracks if the PIN validation is successful
        int userPin = 1234; // Predefined correct PIN (can be customized)

        // Prompt user to enter their PIN
        System.out.println("Please enter your bank account pin (4-digits)");
        int pinEntry = Integer.parseInt(scanner.nextLine());

        // Validate if the entered PIN is within the range of 4-digit numbers
        while (pinEntry > 9999 || pinEntry < 0) {
            System.out.println("Invalid, please enter a valid 4-digit pin");
            pinEntry = Integer.parseInt(scanner.nextLine());
        }

        // Check if the entered PIN matches the correct PIN
        checker = accountChecker(userPin, pinEntry);
        if (checker) { // Successful validation
            System.out.println("------------------------------------------------------------");
            System.out.println("Welcome!");
        } else { // Failed validation
            System.out.println("------------------------------------------------------------");
            System.out.println("Your account has been shut down. Please contact us to reactivate.");
            System.out.println("------------------------------------------------------------");
        }

        // Navigate the user to account actions
        accountAction();
    }
}
