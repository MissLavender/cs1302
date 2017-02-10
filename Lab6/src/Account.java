/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #6                                               *
 *              Account Class                                         *
 *********************************************************************/
public class Account
{

    // =====================================Properties=======================
    private int acctNo;
    private String owner;
    private double balance;

    // ===============================Constructors============================
    public Account()
    {
        acctNo = 0;
        owner = "";
        balance = 0.0;

    }
    public Account(int a, String o, double b)
    {
        acctNo = a;
        owner = o;
        balance = b;
    }
    //===============================Behaviors===============================

    public void setAcctNo(int a)
    {
        acctNo = a;
    }
    public int getAcctNo()
    {
        return acctNo;
    }
    public void setOwner(String o)
    {
        owner = o;
    }
    public String getOwner()
    {
        return owner;
    }
    public void setBalance(double b)
    {
        balance = b;
    }
    public double getBalance()
    {
        return balance;
    }

    public void display()
    {
        System.out.println(" Account Number = " + getAcctNo());
        System.out.println(" Owner = " + getOwner());
        System.out.println(" Balance = " + getBalance());
    }//end display
    public void withdraw(double amount) throws InsufficientFundsException
    {
        if (balance-amount<0)
            throw new InsufficientFundsException(" The Account has Insuficient Funds" );
        balance -= amount;
    }
    public void deposit(double amount)
    {
        balance+=amount;
    }

}//end class

