import java.util.ArrayList;

public class Validation {

	public static boolean validateAccountID(Long acc, ArrayList<Account> listOfAccounts) {

		boolean valid = true;

		for (int i = 0; i < listOfAccounts.size(); i++) {

			if (acc == listOfAccounts.get(i).getAccountID()) {

				valid = false;
				break;
			}
		}

		return valid;
	}

	public static boolean validateBalance(double clientBalance) {

		boolean valid = clientBalance >= 0 ? true : false;

		return valid;
	}

	public static boolean validateSorceAccount(long sourceAccount) {

		boolean valid = false;

		for (int i = 0; i < Bank.getListOfAccounts().size(); i++) {

			if (Bank.getListOfAccounts().get(i).getAccountID() == sourceAccount) {
				valid = true;
				break;
			}
		}

		return valid;
	}

	public static boolean validateTargetAccount(long targetAccount) {

		boolean valid = false;

		for (int i = 0; i < Bank.getListOfAccounts().size(); i++) {

			if (Bank.getListOfAccounts().get(i).getAccountID() == targetAccount) {
				valid = true;
				break;
			}
		}

		return valid;
	}

	public static boolean validateSourceAccountAmount(double amount, long sourceAccount) {

		boolean valid = true;

		for (int i = 0; i < Bank.getListOfAccounts().size(); i++) {
			
			if (Bank.getListOfAccounts().get(i).getBalance() < amount) {
				valid = false;
				break;
			}

		}

		return valid;
	}

}
