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
		System.out.println("Enter your name");
		String user = scan.nextLine();
		boolean found = false;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null && user.equals(clients[i].name)) {
				found = true;
				System.out.println("You have been logged in as: " + clients[i].name + "\n");
				while (true) {
					System.out.println("What would you like to do?");
					System.out.println("1: Close Account\n2: Deposit\n3: Withdraw\n4: Log Out");
					int choice = scan.nextInt();
					if (choice == 1) {
						closeAccount(i);
						break;
					}
					if (choice == 2) {
						System.out.println("Enter an amount to deposit");
						double deposit = scan.nextDouble();
						clients[i].deposit(deposit);
						System.out.println("\n\nYour balance is now: $" + clients[i].balance + "\n");
					}
					if (choice == 3) {
						System.out.println("Enter an amount to withdrawal");
						double withdraw = scan.nextDouble();
						clients[i].withdraw(withdraw);
						System.out.println("\n\nYour balance is now: $" + clients[i].balance + "\n");
					}
					if (choice == 4)
						break;
				}

			}

		}
		if (found == false) {
			System.out.println("Account not found.\n\n");
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
				
			}
		}
		accounts.add(b);
		System.out.println("Account Created!");
		menu();
	}
	public void closeAccount(int i) {
		clients[i] = null;
		System.out.println("Account Deleted\n\nReturning to menu...\n\n");
	}

	public void exit() {
		System.out.println("Exiting Bank.");
	}
}
