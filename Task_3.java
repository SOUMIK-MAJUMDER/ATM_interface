import java.util.Scanner;

class Bank_account {
    private int balance;

    public Bank_account(int balance) {
        this.balance = balance;
    }

    int getbalance() {
        return balance;
    }

    void setbalance(int balance) {
        this.balance = balance;
    }

}

class atm_interface extends Bank_account {

    public atm_interface(int balance) {
        super(balance);
    }

    public void deposit(int money) {
        this.setbalance(this.getbalance() + money);
        System.out.println("MONEY ADDES SUCCESSFULLY...");
        System.out.println("PRESENT BALANCE IS: " + this.getbalance());
    }

    public void check_balance() {
        System.out.println("PRESENT BALANCE IS: " + this.getbalance());
    }

    public void withdrawl(int amount) {
        if (this.getbalance() < 1000) {
            System.out.println("MONEY WITHDRAWN IS NOT POSSIBLE ACCOUNT BALANCE IS LOWER THAN 1000");
        }

        else if (amount >= this.getbalance()) {
            System.out.println("IT IS NOT POSSIBLE...");
        }

        else {
            this.setbalance(this.getbalance() - amount);
            System.out.println("MONEY WITHDRAWN SUCCESSFULL...");
            System.out.println("Present Balance Is: " + this.getbalance());
        }
    }

}

public class Task_3 {
    public static void main(String[] args) {
        char ch;
        Scanner sc = new Scanner(System.in);
        int balance;
        System.out.println("YOU HAVE TO DEPOSIT SOME MONEY TO OPEN A BANK ACOUNT(>1000)");
        while (true) {
            System.out.println("Enter the amount to deposit: ");
            balance = sc.nextInt();

            if (balance >= 1000) {
                break;
            } else {
                System.out.println("Invalid amount. Please enter 1000 or more.");
            }
        }
        atm_interface ac1 = new atm_interface(balance);

        System.out.println("WELCOME TO THE ATM");
        System.out.println("PRESS 1 TO WITHDRAW MONEY\nPRESS 2 TO DEPOSIT MONEY\nPRESS 3 TO CHECK BALANCE\nPRESS 4 FOR EXIT");
        System.out.println("YOUR CHOICE---> ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                int withdrawl_value;
                System.out.println("HOW MUCH AMOUNT YOU WANT TO WITHDRAW: ");
                withdrawl_value = sc.nextInt();
                ac1.withdrawl(withdrawl_value);
                System.out.println("THANK YOU...");
                break;

            case 2:
                int deposit_value;
                System.out.println("HOW MUCH AMOUNT YOU WANT TO DEPOSIT: ");
                deposit_value = sc.nextInt();
                ac1.deposit(deposit_value);
                break;

            case 3:
                ac1.check_balance();
                break;

            case 4:
                System.exit(0);
               
            default:
                System.out.println("PLEASE SELECT A VALID OPTION");
                break;
        }
        sc.close();
       
    }
}
