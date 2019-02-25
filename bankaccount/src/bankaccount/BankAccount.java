package bankaccount;

public class BankAccount {
	
	public BankAccount(double amt) // Constructor
	{
		balance = amt;
	}

	public double getBalance() { // You supply code here that returns the state
		return balance;							// variable, balance.
	}

	public void deposit(double d) { // You supply code here that adds d to// balance.
		balance += d;
	}

	public void withdraw(double d) {// You supply code here that subtracts d // from balance.
		balance -= d;
		 
	}

	private double balance;
}
