class InsufficentFundException extends Exception
{
	public InsufficentFundException(String des) {
		// TODO Auto-generated constructor stub
		super(des);
	}
			
}
public class Account {
 String accNo;
 String accHolderName;
 String accType;
 int AccBalance;
 public Account(String accNo,String accHolderName,String accType, int AccBalance)
 {
	// TODO Auto-generated constructor stub
	 this.AccBalance=AccBalance;
	 this.accNo=accNo;
	 this.accHolderName=accHolderName;
	 this.accType=accType;
}
 
}
class Transaction{
	public void withdraw(Account acc,int wd_amt)
	{
		try {
		System.out.println("Transaction deatail");
		System.out.println("---------------------");
		System.out.println("AccNm"+ acc.AccBalance);
		System.out.println("holderName"+acc.accHolderName);
		System.out.println("Accountype"+acc.accType);
		System.out.println("Transaction deatail:withdraw");
		System.out.println("withdraw"+wd_amt);
		
		if(acc.AccBalance>=wd_amt) {
		acc.AccBalance=acc.AccBalance-wd_amt;
		System.out.println("total balance"+acc.AccBalance);
		}
		else 
			throw new InsufficentFundException("funds insufficent");
		}catch (InsufficentFundException e) {
			System.out.println(e.getMessage());
		}
	}
}
class Test {
	public static void main(String[] args) {
		Account a1=new Account("abc123", "milan", "saving", 20000);
		Transaction t1=new Transaction();
		t1.withdraw(a1, 250000);
	}
}