import java.util.*;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String toString() {
        return accountNumber + " - Balance: $" + balance;
    }
}

public class BankingSystem {
    private Map<String, BankAccount> hashMap = new HashMap<>();
    private Map<Double, BankAccount> treeMap = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(BankAccount account) {
        hashMap.put(account.getAccountNumber(), account);
        treeMap.put(account.getBalance(), account);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(accountNumber + " - $" + amount);
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            System.out.println("Processing: " + withdrawalQueue.poll());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(new BankAccount("ACC001", 5000));
        bank.addAccount(new BankAccount("ACC002", 15000));

        bank.requestWithdrawal("ACC001", 1000);
        bank.processWithdrawals();
    }
}