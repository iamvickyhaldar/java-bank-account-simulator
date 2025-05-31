import java.util.Scanner;

class BankAccount
{
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName)
    {
    this.ownerName = ownerName;
    this.balance = 0.0;
    }

    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Your balance is : " + balance);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount)
    {
        if(amount <= balance && amount > 0)
        {
            balance -= amount;
            System.out.println("Withdraw amount : " +amount);
            System.out.println("Current Balance is : " +balance);
        }
        else{
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }

    public void checkBalance()
    {
        System.out.println("Balance : "+balance);
    }

    public String getOwnerName()
    {
        return ownerName;
    }

}


class BankSimulator
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name to creat a bank account : ");

        String name = sc.nextLine();
        
        BankAccount ba = new BankAccount(name);

        int choice;
        do
        {
            System.out.println("Welcome to our bank "+ name);
            System.out.println("Choose an Operation");
            System.out.println("1. For Deposit");
            System.out.println("2. For Withdraw");
            System.out.println("3. For Check Balance");
            System.out.println("4. For Exit");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter amount to deposit");
                    double depositAmount = sc.nextDouble();
                    ba.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw");
                    Double withdrawAmount = sc.nextDouble();
                    ba.withdraw(withdrawAmount);
                    break;
                
                case 3:
                    ba.checkBalance();
                    break;

                case 4: 
                    System.out.println("Thanks for banking with us ");
                    break;

                default:
                    System.out.println("Invalid Operation. Try again.");
                    break;
            }

        }
        while (choice != 4);
        sc.close();
    }
}