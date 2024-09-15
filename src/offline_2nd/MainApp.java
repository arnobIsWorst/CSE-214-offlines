package offline_2nd;

import java.util.Scanner;

import offline_2nd.factories.Customer;
import offline_2nd.singleton.Bank;

public class MainApp {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        
        System.out.println("Welcome to the Bank");
        System.out.println("Create Account. Give an unique Account Number");

        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.nextLine();

        System.out.println("Choose Account Type: ");
        System.out.println("1. Regular");
        System.out.println("2. VIP");
        System.out.println("3. Premium");

        int accountType = scanner.nextInt();
        scanner.nextLine();

        Customer newAccount = null;

        switch (accountType) {
            case 1:
                newAccount = bank.createRegularAccount(accountNumber);
                break;
            case 2:
                newAccount = bank.createVipAccount(accountNumber);
                break;
            case 3:
                newAccount = bank.createPremiumAccount(accountNumber);
                break;
            default:
                System.out.println("Invalid Account Type");
                scanner.close();
                return;
        }

        System.out.println("Saving or Loan Account?");

        String accountChoice = scanner.nextLine();

        if (accountChoice.equalsIgnoreCase("saving")) {
            newAccount = bank.createSavingsAccount(newAccount);
        } else if (accountChoice.equalsIgnoreCase("loan")) {
            newAccount = bank.createLoanAccount(newAccount);
        } else {
            System.out.println("Invalid Account Type");
            scanner.close();
            return;
        }

        bank.addAccount(newAccount);
        System.out.println("Account Created Successfully");

        System.out.println("Enter amount to check total interest: ");
        double amount = scanner.nextDouble();
        bank.getAccount(accountNumber).setAmount(amount);

        System.out.println("Enter time to check total interest: ");
        double time = scanner.nextDouble();

        System.out.println("Total Interest: " + bank.getAccount(accountNumber).calculateInterest(time));

        scanner.close();
    }
}