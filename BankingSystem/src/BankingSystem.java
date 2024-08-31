import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Bank class
class Bank {
    private Map<Integer, Account> accounts;

    public Bank(){
        accounts = new HashMap<>();
    }

    public void addAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
    }

}

// Account class
class Account{
    private int accountNumber;
    private double balance;

    public Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }
}

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Changa Banking System");
            System.out.println("1. Create a customer");
            System.out.println("2. Create an account");
            System.out.println("3. Check account balance");
            System.out.println("4. Deposit money to the account");
            System.out.println("5. Widthraw money from the account");
            System.out.println("6. Transfer money");
            System.out.println("7. Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();

            // use a if statement or switch
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;

                default:
                    break;
            }

        }
    }
    private static void createAccount(){
        System.out.println("Enter an Account number (Number): ");
        int accountNumber = scanner.nextInt();
        Account account = new Account(accountNumber);
        bank.addAccount(account);
        System.out.println("Account created successfully!");
    }
}
