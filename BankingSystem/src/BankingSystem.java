import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Bank class
class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

}

// Account class    
class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void depositMoney(double amount){
        if (amount > 0){
            balance+=amount;
            System.out.println("Deposited: $" + amount);

        }else{
            System.out.println("Please deposit a valid amount of money");
        }
    }
    public void Widthraw(double amount){
        if(amount < 100){
            System.out.println("Amount too low to be widhtrawn");
        }else{
            balance-= amount;
            System.out.println("Widthdrawn: $" + amount);
            System.out.println("New account balance is: $" + getBalance());
        }
    }
}

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Changa Banking System");
            System.out.println("1. Create an account");
            System.out.println("2. Option unavailable");
            System.out.println("3. Check account balance");
            System.out.println("4. Deposit money to the account");
            System.out.println("5. Widthraw money from the account");
            System.out.println("6. Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();

            // use a if statement or switch
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    System.out.println("Nothing to see here");
                case 3:
                    checkBalance();;
                case 4:
                    depositMoney();
                case 5:
                    widthraw();
                case 6:
                    break;
                default:
                    break;
            }

        }
    }

    private static void createAccount() {
        System.out.println("Enter an Account number (Number): ");
        int accountNumber = scanner.nextInt();
        Account account = new Account(accountNumber);
        bank.addAccount(account);
        System.out.println("Account created successfully!");
    }

    private static void checkBalance() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        System.out.println("Account balance: $" + account.getBalance());
    }

    private static void depositMoney(){
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = bank.getAccount(accountNumber);
        if (account ==null){
            System.out.println("Account not found");
            return;
        } 
        System.out.println("Enter amount to deposit");
        double amount = scanner.nextDouble();
        account.depositMoney(amount);
    }

    private static void widthraw(){
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = bank.getAccount(accountNumber);
        if (account ==null){
            System.out.println("Account not found");
            return;
        } 
        System.out.println("Enter amount to widthraw: ");
        double amount = scanner.nextDouble();
        account.Widthraw(amount);
    }
}
