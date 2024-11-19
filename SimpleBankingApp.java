import java.util.Scanner;

public class SimpleBankingApp {

    private double balance;  // To store the account balance

    // Constructor to initialize balance
    public SimpleBankingApp() {
        this.balance = 0.0;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
            } else {
                System.out.println("Insufficient funds for this withdrawal.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBankingApp bankAccount = new SimpleBankingApp();
        
        int choice;

        // Menu for user operations
        do {
            System.out.println("\n----- Simple Banking Application -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an operation: ");
            
            // Read user's choice
            choice = scanner.nextInt();

            // Handle user's choice with switch statement
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our banking service. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid operation.");
            }

        } while (choice != 4);  // Loop until user chooses to exit
        
        scanner.close();
    }
}
