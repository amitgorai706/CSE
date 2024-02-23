abstract class Account {
    private int accountNumber;
    protected double balance;
    
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public abstract void deposit(double amount);
    
    public abstract void withdraw(double amount);
}

class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    @Override
    public void deposit(double amount) {
        double interest = amount * interestRate / 100;
        double totalAmount = amount + interest;
        super.balance += totalAmount;
        System.out.println("Deposit of $" + amount + " with interest $" + interest + " successful. New balance: $" + super.balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount <= super.balance) {
            super.balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + super.balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;
    
    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    @Override
    public void deposit(double amount) {
        super.balance += amount;
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + super.balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount <= super.balance + overdraftLimit) {
            super.balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + super.balance);
        } else {
            System.out.println("Withdrawal amount exceeds overdraft limit.");
        }
    }
}

public class Q7 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1001, 5000, 5);
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Balance: $" + savingsAccount.getBalance());
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(2000);
        
        CurrentAccount currentAccount = new CurrentAccount(2001, 8000, 2000);
        System.out.println("\nCurrent Account Details:");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Balance: $" + currentAccount.getBalance());
        currentAccount.deposit(1500);
        currentAccount.withdraw(10000);
    }
}
