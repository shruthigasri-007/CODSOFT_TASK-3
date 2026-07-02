package ATMInterface;



public class Main {



    public static void main(String[] args) {



        BankAccount account = new BankAccount(100000);



        ATM atm = new ATM(account);



        if (!atm.isPinCreated()) {

            atm.createPin();

        }



        if (atm.login()) {

            atm.menu();

        }

    }

}

