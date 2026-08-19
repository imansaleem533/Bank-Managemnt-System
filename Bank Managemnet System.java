import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money deposited successfully!");
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Money withdrawn successfully!");
            System.out.println("Remaining Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display account details
    public void displayAccount() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------");
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankAccountSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = input.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = input.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = input.nextDouble();

                    BankAccount account =
                            new BankAccount(accountNumber, accountHolder, initialDeposit);

                    accounts.add(account);

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositNumber = input.nextLine();

                    BankAccount depositAccount =
                            findAccount(accounts, depositNumber);

                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = input.nextDouble();

                        depositAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawNumber = input.nextLine();

                    BankAccount withdrawAccount =
                            findAccount(accounts, withdrawNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = input.nextDouble();

                        withdrawAccount.withdraw(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String balanceNumber = input.nextLine();

                    BankAccount balanceAccount =
                            findAccount(accounts, balanceNumber);

                    if (balanceAccount != null) {
                        balanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String detailsNumber = input.nextLine();

                    BankAccount detailsAccount =
                            findAccount(accounts, detailsNumber);

                    if (detailsAccount != null) {
                        detailsAccount.displayAccount();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Account System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        input.close();
    }

    // Find account
    public static BankAccount findAccount(
            ArrayList<BankAccount> accounts,
            String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }
}
