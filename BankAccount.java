package ATMInterface;



public class BankAccount {



    private long balance;



    public BankAccount(long balance) {

        this.balance = balance;

    }



    public long getBalance() {

        return balance;

    }



    public void deposit(long amount) {

        balance += amount;

    }



    public boolean withdraw(long amount) {

        if (amount <= balance) {

            balance -= amount;

            return true;

        }

        return false;

    }

}

