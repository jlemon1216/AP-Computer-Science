package bankaccount;

public class Tester {
	public static void main(String[] args) {
		
		BankAccount a = new BankAccount(500);
		SavingsAccount s = new SavingsAccount( 1000, 4);
		//BankAccount hybrid = new SavingsAccount(500, 4);
		
		s.deposit(500);
		System.out.println(s.getBalance());
		System.out.println(s.superGetBalance());
		
	}
}