import java.util.*;

class BankAccount {
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance =  balance;
    }

    void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Deposit Successful.");
        }
        else
        {
            System.out.println("Invalid Amount");
        }
    }

    void displayBalance()
    {
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
    }
}
class SavingsAccount extends BankAccount
{
    SavingsAccount(int id, String name, double balance)
    {
        super(id, name, balance);
    }

    void withdraw(double amount)
    {
        if(amount > 0 && balance - amount >= 1000)
        {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
        else
        {
            System.out.println("Minimum Balance of 1000 Required.");
        }
    }
}
class CurrentAccount extends BankAccount
{
    CurrentAccount(int id, String name, double balance)
    {
        super(id, name, balance);
    }

    void withdraw(double amount)
    {
        if(amount > 0 && balance - amount >= -5000)
        {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
        else
        {
            System.out.println("Overdraft Limit Exceeded.");
        }
    }
}

public class BankingSystem
{
    public static void main(String A[]) 
    {
        Scanner sobj = new Scanner(System.in);

        SavingsAccount account = new SavingsAccount(1001, "Vicky", 5000);

        while(true)
        {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter Choice");

            int choice = sobj.nextInt();

            if(choice == 1)
            {
                System.out.println("Enter Amount : ");
                double amount = sobj.nextDouble();
                account.deposit(amount);
            }
            else if(choice == 2)
            {
                System.out.println("Enter Amount : ");
                double amount = sobj.nextDouble();
                account.withdraw(amount);
            }
            else if(choice == 3)
            {
                account.displayBalance();
            }
            else if(choice == 4)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Choice.");
            }
        }

        sobj.close();
    }
}