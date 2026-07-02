package ATMInterface;



import java.util.Scanner;



public class ATM {



    private BankAccount account;

    private int pin;

    private boolean pinCreated = false;



    Scanner sc = new Scanner(System.in);



    public ATM(BankAccount account) {

        this.account = account;

    }



    // Create PIN

    public void createPin() {



        System.out.println("---- Welcome New User! Create a PIN ----");



        while (true) {

            System.out.print("Set your 4-digit PIN: ");

            pin = sc.nextInt();



            if (pin >= 1000 && pin <= 9999) {

                pinCreated = true;

                System.out.println("PIN created successfully.");

                break;

            } else {

                System.out.println("PIN must contain exactly 4 digits.");

            }

        }



        System.out.println();

    }



    // Login

    public boolean login() {



        System.out.print("Enter your PIN: ");

        int enteredPIN = sc.nextInt();



        if (enteredPIN == pin) {

            return true;

        } else {

            System.out.println("Incorrect PIN.");

            return false;

        }

    }



    public boolean isPinCreated() {

        return pinCreated;

    }



    // ATM Menu

    public void menu() {



        int choice;



        do {



            System.out.println("\n==============================");

            System.out.println("        ATM INTERFACE");

            System.out.println("==============================");

            System.out.println("1. Check Balance");

            System.out.println("2. Deposit Money");

            System.out.println("3. Withdraw Money");

            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");



            choice = sc.nextInt();



            switch (choice) {



                case 1:

                    checkBalance();

                    break;



                case 2:

                    deposit();

                    break;



                case 3:

                    withdraw();

                    break;



                case 4:

                    System.out.println("Thank you for using our ATM.");

                    break;



                default:

                    System.out.println("Invalid Choice.");

            }



        } while (choice != 4);

    }



    // Check Balance

    public void checkBalance() {

        System.out.println("Current Balance : ₹" + account.getBalance());

    }



    // Deposit

    public void deposit() {



        System.out.print("Enter amount to deposit: ");

        long amount = sc.nextLong();



        if (amount <= 0) {

            System.out.println("Invalid Amount.");

            return;

        }



        account.deposit(amount);



        System.out.println("Amount Deposited Successfully.");

        System.out.println("Current Balance : ₹" + account.getBalance());

    }



    // Withdraw

    public void withdraw() {



        System.out.print("Enter amount to withdraw: ");

        long amount = sc.nextLong();



        if (amount <= 0) {

            System.out.println("Invalid Amount.");

            return;

        }



        if (account.withdraw(amount)) {



            System.out.println("Please collect your cash.");

            System.out.println("Current Balance : ₹" + account.getBalance());



        } else {



            System.out.println("Insufficient Balance.");

        }

    }

}

