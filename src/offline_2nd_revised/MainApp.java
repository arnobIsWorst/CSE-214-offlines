package offline_2nd_revised;

import java.util.Scanner;
import offline_2nd_revised.singleton.Bank;
import offline_2nd_revised.factory.Operations;

public class MainApp {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        System.out.println("Welcome to the Bank");
        System.out.println("Create an account. Give an unique Account Number");

        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.nextLine();

        if (bank.checkAccount(accountNumber)) {
            System.out.println("Account already exists");
            scanner.close();
            return;
        } else {
            System.out.println("Choose Account Type: ");
            System.out.println("1. Savings");
            System.out.println("2. Loan");

            int accountType = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter initial amount: ");
            double amount = scanner.nextDouble();

            Operations newAccount = null;

            switch (accountType) {
                case 1:
                    newAccount = bank.createSavingsAccount(accountNumber, amount);
                    break;
                case 2:
                    newAccount = bank.createLoanAccount(accountNumber, amount);
                    break;
                default:
                    System.out.println("Invalid Account Type");
                    scanner.close();
                    return;
            }

            System.out.println("Which tier customer service do you want?");
            System.out.println("1. Regular");
            System.out.println("2. Premium");
            System.out.println("3. VIP");

            int tier = scanner.nextInt();
            scanner.nextLine();

            switch (tier) {
                case 1:
                    bank.createRegularAccount(newAccount);
                    break;
                case 2:
                    bank.createPremiumAccount(newAccount);
                    break;
                case 3:
                    bank.createVipAccount(newAccount);
                    break;
                default:
                    System.out.println("Invalid Tier");
                    scanner.close();
                    return;
            }

            System.out.println("Account Created Successfully");
            bank.addAccount(newAccount);

            System.out.println("Enter a certain amount of years to check total interest: ");

            double time = scanner.nextDouble();
            System.out.println("Total Interest: " + bank.getAccount(accountNumber).calculateInterest(time));

            scanner.close();
        }
    }
}
