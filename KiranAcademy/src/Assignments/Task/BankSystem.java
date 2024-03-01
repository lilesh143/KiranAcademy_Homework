package Assignments.Task;
import java.util.Scanner;
import java.util.Random;


	class Account {
	    protected String accountNumber;
	    protected String accountHolder;
	    protected double balance;

	    public Account(String accountNumber, String accountHolder, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolder = accountHolder;
	        this.balance = balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposit of Rs " + amount + " successful");
	    }

	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal of Rs " + amount + " successful");
	        } else {
	            System.out.println("Insufficient funds");
	        }
	    }

	    public void displayAccountInfo() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Holder: " + accountHolder);
	        System.out.println("Balance: Rs" + balance);
	    }
	}

	class SavingsAccount extends Account {
	    private int withdrawalsLeft;
	    private static final int MAX_WITHDRAWALS = 3;

	    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
	        super(accountNumber, accountHolder, balance);
	        this.withdrawalsLeft = MAX_WITHDRAWALS;
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= balance && withdrawalsLeft > 0) {
	            balance -= amount;
	            withdrawalsLeft--;
	            System.out.println("Withdrawal of Rs" + amount + " successful. " + withdrawalsLeft + " withdrawals left this month.");
	        } else if (withdrawalsLeft == 0) {
	            System.out.println("Maximum withdrawals reached for this month.");
	        } else {
	            System.out.println("Insufficient Money");
	        }
	    }
	}

	class CurrentAccount extends Account {
	    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
	        super(accountNumber, accountHolder, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal of Rs" + amount + " successful");
	        } else {
	            System.out.println("Insufficient Money");
	        }
	    }
	}

	public class BankSystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create savings account

	        // Create current account
	        System.out.println("Welcome to JBK Bank");
	        
	        System.out.println("Please enter your name : ");
	        String userName = scanner.next();
	        System.out.println("Please enter initial deposite amount : ");
	        int amount = scanner.nextInt();
	        
	        Random random = new Random();
	        int rInt = random.nextInt(10000);
	        SavingsAccount savingsAccount = new SavingsAccount("SA"+rInt, userName, amount);
	        
	        CurrentAccount currentAccount = new CurrentAccount("CA"+rInt,userName, amount);
	        
	        
	        System.out.println("Enter 1 to Access Your Saving Account  "+ "\n"+" OR "+"\n"+" Enter 2 to access your Current account sir.. " );
	        int t = scanner.nextInt();
	        //  savings account
	        switch (t) {
	        case 1 :
	        	System.out.println("Savings Account Info:");
	        savingsAccount.displayAccountInfo();
	        
	        System.out.println("Enter 1 to deposit amount " + "\n"+" OR "+"\n"+"enter 2 to withdraw money");
	        int SavingAcc = scanner.nextInt();
	        if(SavingAcc == 1) {
	        System.out.println("enter amount to deposit");
	        int sd = scanner.nextInt();
	        savingsAccount.deposit(sd);
	        savingsAccount.displayAccountInfo();
	        }
	        else {
	        System.out.println("enter amount to withdrawl");
	        int sw = scanner.nextInt();
	        savingsAccount.withdraw(sw);
	        savingsAccount.displayAccountInfo();
	        }
	        break ;
	        
	        case 2 :
	        	//current account
	        	System.out.println("\nCurrent Account Info:");
	        currentAccount.displayAccountInfo();
	        System.out.println("Enter 1 to deposit amount " + "\n"+" OR "+"\n"+"enter 2 to withdraw money");
	        int CurrentAcc = scanner.nextInt();
	        if(CurrentAcc == 1) {
	        System.out.println("enter amount to deposit");
	        int cd = scanner.nextInt();
	        currentAccount.deposit(cd);
	        currentAccount.displayAccountInfo();
	        }
	        else {
	        System.out.println("enter amount to withdrawl");
	        int cw = scanner.nextInt();
	        currentAccount.withdraw(cw);
	        currentAccount.displayAccountInfo();
	        }
	        scanner.close();
	        }
	    }
	}
	