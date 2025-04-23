class BankAccount {
    private double balance;

    public BankAccount(double balance) { this.balance = balance; }

    public void deposit(double amount) { balance += amount; }

    public void withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() { return balance; }
}

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        try {
            account.withdraw(200);
            System.out.println("Balance after withdrawal: " + account.getBalance());
            account.withdraw(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}