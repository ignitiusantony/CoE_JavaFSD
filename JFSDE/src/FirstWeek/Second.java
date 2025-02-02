package FirstWeek;

import java.util.Scanner;

class BankAccount{
	private double balance;

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return this.balance;
	}
	public synchronized void deposit(double amount) {
		balance+=amount;
		System.out.println(Thread.currentThread().getName()+" has deposited: "+amount);
	}
	public synchronized void withdraw(double amount) {
		if(balance<amount) System.out.println("Insufficient Balance");
		else {
			balance-=amount;
			System.out.println(Thread.currentThread().getName()+" has withdrawn: "+amount);
		}
	}
}
class BankUser extends Thread{
	BankAccount account;
	boolean isDeposit;
	int amount;
	public BankUser(BankAccount account, boolean isDeposit, int amount) {
		this.account = account;
		this.isDeposit = isDeposit;
		this.amount = amount;
	}
	public void run() {
		if(isDeposit) {
			account.deposit(amount);
		}else {
			account.withdraw(amount);
		}
	}
	
}
public class Second {
	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       boolean b=true;
       BankAccount bank=new BankAccount();
       bank.setBalance(1000);
       while(b) {
    	   System.out.println("1.Deposit \n2.Withdraw \n3.Exit");
    	   int option=sc.nextInt();
    	   BankUser user=null;
    	   switch(option) {
	    	   case 1:
	    		   System.out.println("Enter amount to deposit: ");
	    		   int amount=sc.nextInt();
	    		   user=new BankUser(bank,true,amount);
	    		   user.start();
	    		   break;
	    	   case 2:
	    		   System.out.println("Enter amount to withdraw: ");
	    		   int amount2=sc.nextInt();
	    		   user=new BankUser(bank,false,amount2);
	    		   user.start();
	    		   break;
	    	   default:
	    		   b=false;
	    		   break; 
    	   }
    	   if(user!=null) {
    		   try {
    			   user.join();
    		   }
    		   catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }
    	   
       }
       System.out.println("Available Balance: "+bank.getBalance());
}
	}
