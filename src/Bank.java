
import java.util.ArrayList;

public class Bank {

	private static ArrayList<Account> listOfAccounts = new ArrayList<>();

	private String name;

	Bank() {

	}

	Bank(String name) {
		this.name = name;
	}

	public static ArrayList<Account> getListOfAccounts() {
		return listOfAccounts;
	}

	public static void setListOfAccounts(ArrayList<Account> listOfAccounts) {
		Bank.listOfAccounts = listOfAccounts;
	}
	public String getName() {
		return this.name;
	}

	public static void createAccount(String clientName, double clientBalance) {

		Account account = new Account();

		String str = "338";

		while (str.length() < 14) {
			int gen = (int) (Math.random() * 10);
			str = str + gen;
		}

		if (Validation.validateAccountID(Long.valueOf(str), Bank.listOfAccounts)) {

			if (Validation.validateBalance(clientBalance)) {
				account.setAccountID(Long.valueOf(str)); // accountID
				account.setName(clientName);// name
				account.setBalance(clientBalance);// balance

				listOfAccounts.add(account);
				
			} else {
				System.out.println("Account is NOT created. Wrong input.");
				System.out.println("Balance must be greater or equal to zero.");
			}

		} else {
			createAccount(clientName, clientBalance);
		}

	}


	public void printAccounts() {
		
		System.out.printf("%-14s\t%-15s\t%-7s\n", "Account", "Client Name", "Balance");
		System.out.println("---------------------------------------");
		
		for (int i = 0; i < listOfAccounts.size(); i++) {
			
			System.out.printf("%-14d\t%-15s\t%-7.2f\n", listOfAccounts.get(i).getAccountID(), listOfAccounts.get(i).getName(), listOfAccounts.get(i).getBalance());

		}
		System.out.println();
		System.out.println("======================================\n");
	}

	
}
