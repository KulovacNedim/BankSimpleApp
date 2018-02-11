
import java.util.ArrayList;
import java.util.Scanner;

public class Account {

	private long accountID;
	private String name;
	private double balance;

	public void setAccountID(long account) {
		this.accountID = account;
	}

	public long getAccountID() {
		return this.accountID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}

	public static void transferMoney(Scanner sc, Bank myBank) {

		System.out.print("Enter source account: ");
		long sourceAccount = sc.nextLong();

		if (!Validation.validateSorceAccount(sourceAccount)) {
			System.out.println("\nAccount you entered do not exist. Try again.\n");
			
			System.out.println("======================================\n");

			Main.showBankMenuOptions(sc, myBank);
		}

		System.out.print("Enter target account: ");
		long targetAccount = sc.nextLong();

		if (!Validation.validateTargetAccount(targetAccount)) {
			System.out.println("\nAccount you entered do not exist. Try again.\n");
			
			System.out.println("======================================\n");

			Main.showBankMenuOptions(sc, myBank);
		}

		System.out.print("Enter amount to transfer: ");
		double amount = sc.nextDouble();
		
		System.out.println("======================================\n");

		ArrayList<Account> listOfAccounts = Bank.getListOfAccounts();

		if (Validation.validateSourceAccountAmount(amount, sourceAccount)) {
		
			for (int i = 0; i < listOfAccounts.size(); i++) {

				if (listOfAccounts.get(i).accountID == sourceAccount) {

					listOfAccounts.get(i).balance = listOfAccounts.get(i).balance - amount;
				}

				if (listOfAccounts.get(i).accountID == targetAccount) {

					listOfAccounts.get(i).balance = listOfAccounts.get(i).balance + amount;
				}
			}
		} else {
			
			System.out.println("Insufficient amount on source account. Transaction canceled. ");
			
			Main.showBankMenuOptions(sc, myBank);
		}
			

	}

}
