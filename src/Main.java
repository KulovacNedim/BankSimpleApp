
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Bank myBank = new Bank("Rich People Bank");
		
		System.out.println("======================================\n");
		System.out.println("Welcome to " + myBank.getName());
		System.out.println("\n======================================");
		
		showBankMenuOptions(sc, myBank);
		
	}

	static void showBankMenuOptions(Scanner sc, Bank myBank) {
		
		System.out.println("\nWhat do you want to do next:\n");
		
		System.out.println("    1) Create new account");
		System.out.println("    2) Money transfer");
		System.out.println("    3) Accounts overview");
		
		System.out.println("\n======================================\n");
		
		int choice = 0;

		try {
			choice = Integer.valueOf(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Wrong input. Select option 1 - 3.");
			showBankMenuOptions(sc, myBank);
		}
		
		switch (choice) {
		
		case 1:
			
			System.out.print("Enter client name: ");
			String clientName = sc.nextLine();
			
			System.out.print("Enter client balance: ");
			double clientBalance =sc.nextDouble();
			
			Bank.createAccount(clientName, clientBalance); // da li ovdje treba ovaj code ili myBank.createAccount(); sta je ispravnije i zasto
		
			System.out.println("\n======================================\n");
			
			showBankMenuOptions(sc, myBank);
			
			break;
			
		case 2:
			
			System.out.println("List of accounts:\n");
			
			myBank.printAccounts();
			
			Account.transferMoney(sc, myBank); //(da li je dobra opcija ovu metodu postaviti u account
			
			showBankMenuOptions(sc, myBank);
			
//			System.out.println(yourBank.getName()); //prosljedjena banka
			break;
			
		case 3:
			
			myBank.printAccounts(); //zbog static zezanja metodi sam proslijedio banku. jel ok
			
			showBankMenuOptions(sc, myBank);
			
			break;
			
		default:
			System.out.println("Wrong input. Select option 1 - 3.");
			
			showBankMenuOptions(sc, myBank);
		}
		
	}

}
