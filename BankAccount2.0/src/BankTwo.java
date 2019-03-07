import java.util.Scanner;
import java.util.*;

public class BankTwo {

	Scanner scan = new Scanner(System.in);
	BankAccount[] clients = new BankAccount[5];
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	public static void main(String[] args) {

		BankTwo mybank = new BankTwo();
		mybank.openBank();
	}

	public void openBank() {
		menu();
	}

	public void menu() {
		while (true) {
			System.out.println("What would you like to do?\n1: Login\n2: Create Account\n3: Exit");
			int u = scan.nextInt();
			scan.nextLine();
			if (u == 1)				//User chooses a number 1 - 3, choice takes them to specified method
				login();
			if (u == 2)
				openAccount();
			if (u == 3)
				break;
		}
		System.out.println("Now leaving...");
	}

	public void login() {
		System.out.println("Please enter your account name.");
		String name = scan.nextLine();
		if (accounts.size() != 0) {						//Checks if any accounts exist
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).name.equalsIgnoreCase(name)) {  //if users input matches name
					loginMenu(accounts.get(i));						//go to login menu			
				}
			}
		}
		else {
			System.out.println("No Accounts created! Please create an account.\n");
		}
	}

	public void loginMenu(BankAccount b) {
				boolean found = true;
				while (true) {
					System.out.println("Welcome, " + b.name + "!\nWhat would you like to do?\n1. Close Account\n2. Withdraw\n3. Deposit\n4. Log Out");
					int choice = scan.nextInt();
					if (choice == 1)
						closeAccount(b);
					if (choice == 2) {
						withdrawal(b); 						//User chooses a number 1 - 4,
					}										//choice, takes them to specified action
					if (choice == 3) {
						deposit(b);
					}
					if (choice == 4)
						System.out.println("Bye, " + b.name + "!");
					break;
				}
		if (found == false) {
			System.out.println("Account not found. Returning to menu...");
		}
	}
	public void deposit(BankAccount b) {
		System.out.println("How much would you like to deposit?");
		int d = scan.nextInt();				//Asks user how much they would like to deposit, and deposits it
		b.deposit(d);
		System.out.println("Deposited $" + d + ". New balance: $" + b.balance); //Returns new amount
	}
	public void withdrawal(BankAccount b) {
		System.out.println("How much would you like to Withdraw?");
		int w = scan.nextInt();				//Asks user how much they would like to withdrawal, and withdraws it
		b.withdraw(w);												
		System.out.println("Withdrew $" + w + ". New Balance: $" + b.balance); //Returns new amount
	}
	
	
	public void openAccount() {
		System.out.println("Enter a name for your account.");
		String name = scan.nextLine(); // Gets name for account
		System.out.println("Enter your starting balance.");
		int bal = scan.nextInt(); // Gets starting Balance
		BankAccount b = new BankAccount(name, bal); // Creates Bank Account for	name and balance
		for (int i = 0; i < accounts.size(); i++) { //goes through all bank accounts in the ArrayList
			if (accounts.get(i).name.equalsIgnoreCase(b.name)) { // Checks if Bank Account name exists
				System.out.println("Name already exists! Please choose another name.");
				menu();  //returns user to menu if the name they have chosen is taken
			}
		}
		accounts.add(b);
		System.out.println("Account Created! Your Balance: $" + bal);  //Lets user know account was successfully created
		menu();
	}
	public void closeAccount(BankAccount b) {
		accounts.remove(b);										//Removes account from ArrayList
		System.out.println("Account Deleted\n\nReturning to menu...\n\n");
	}
	public void exit() {
		System.out.println("Exiting Bank.");
	}
}
