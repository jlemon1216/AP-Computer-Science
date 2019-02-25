import java.util.Scanner;

public class Bank {

	Scanner scan = new Scanner(System.in);
	BankAccount[] clients = new BankAccount[5];

	public static void main(String[] args) {

		Bank mybank = new Bank();
		mybank.openBank();
	}

	public void openBank() {
		menu();
	}

	public void menu() {
		while (true) {
			System.out.println(
					"What would you like to do?\n1: Login\n2: Create Account\n3: Exit\n4: Display all Accounts");
			int u = scan.nextInt();
			scan.nextLine();
			if (u == 1)
				login();
			if (u == 2)
				openAccount();
			if (u == 3)
				break;
			if (u == 4)
				displayAllAccounts();
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
				while (true) {
					System.out.println("You have been logged in as: " + clients[i].name + "\n\n");
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
						System.out.println("\n\nYour balance is now: $" + clients[i].balance + "\n\n");
					}
					if (choice == 3) {
						System.out.println("Enter an amount to withdrawal");
						double withdraw = scan.nextDouble();
						clients[i].withdraw(withdraw);
						System.out.println("\n\nYour balance is now: $" + clients[i].balance + "\n\n");
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
		boolean empty = false;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null && empty == false) {
				empty = true;
				System.out.println("Enter a Name");
				String name = scan.nextLine();
				for (int z = 0; z < clients.length; z++) {
					if (clients[z] != null && clients[z].name.equalsIgnoreCase(name)) {
						System.out.println("Name already Exists! Choose another name.");
						menu();
					}
				}
				System.out.println("Enter your balance");
				int balance = scan.nextInt();
				clients[i] = new BankAccount(name, balance);
				System.out.println("Bank Account Created. Your balance is: $" + balance);
				menu();
			}

		}
		System.out.println("Account spaces filled. \n\nReturning to menu...\n\n");
	}

	public void closeAccount(int i) {
		clients[i] = null;
		System.out.println("Account Deleted\n\nReturning to menu...\n\n");
	}

	public void exit() {
		System.out.println("Exiting Bank.");
	}

	public void displayAllAccounts() {
		for (BankAccount x : clients)
			if(x != null)
			System.out.println(x);
	}
}
