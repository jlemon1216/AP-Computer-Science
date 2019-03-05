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
			if (u == 1)
				login();
			if (u == 2)
				openAccount();
			if (u == 3)
				break;
		}
		System.out.println("Now leaving...");
	}

	public void login() {
		System.out.println("Please Enter Your Account Name.");
		String check = scan.nextLine();
		for(int i = 0; i <= accounts.size(); i++) {
			if(accounts.size() != 0 && accounts.get(i).name.equals(check)) {
				System.out.println("Welcome, " + accounts.get(i).name + "!\nWhat would you like to do?\n1. Close Account\n2. Withdraw\n3. Deposit\n4. Log Out");
				int choice = scan.nextInt();
				if(choice == 1)
					closeAccount(accounts.get(i));
				if(choice == 2) {
					System.out.println("How much would you like to Withdraw?");
					int w = scan.nextInt();
					accounts.get(i).withdraw(w);
				}
				if(choice == 3)	{
					System.out.println("How much would you like to deposit");
					int d = scan.nextInt();
					accounts.get(i).deposit(d);
				}
				if(choice == 4)
					break;
			}
			else
				System.out.println("Account not found! Returning to menu..");
		}
	}
	public void openAccount() {
		System.out.println("Enter a name for your account.");
		String name = scan.nextLine();							//Gets name for account
		System.out.println("Enter your starting balance.");		
		int bal = scan.nextInt();								//Gets starting Balance
		BankAccount b = new BankAccount(name, bal);				//Creates Bank Account for name and balance
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).name.equals(b.name)) {			//Checks if Bank Account name exists
				System.out.println("Name already exists! Please choose another name.");
				menu();
			}
		}
		accounts.add(b);
		System.out.println("Account Created!");
		menu();
	}
	public void closeAccount(BankAccount b) {
		accounts.remove(b);
		System.out.println("Account Deleted\n\nReturning to menu...\n\n");
	}
	public void exit() {
		System.out.println("Exiting Bank.");
	}
}
