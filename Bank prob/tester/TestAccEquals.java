package tester;

import com.app.bank.BankAccount;

public class TestAccEquals {

	public static void main(String[] args) {
		
		Object acct1=new BankAccount(101, "Rama Mathur", "Saving", 12000);
		Object acct2=new BankAccount(101, "Rama Mathur", "Saving", 12000);
//		System.out.println(acct1==acct2);
//		System.out.println(acct1.equals(acct2));
		System.out.println( acct1.equals(acct2));
		
		Object o=100;
		System.out.println(o.getClass());
		System.out.println(acct1.equals(o));

	}
	

}
