
public class BankAccount {

	String name;
	double balance;
	
	public BankAccount() {
	}
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	public double deposit(double x) {
		balance += x;
		return balance;
	}
	public double withdraw(double x) {
		balance -= x;
		return balance;
	}
	public String toString() {
		return "Your balance is: " + balance + "\nYour name is: " + name;
	}
}
