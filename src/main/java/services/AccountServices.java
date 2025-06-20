package services;

import bean.Account;

public interface AccountServices {
	
	public Account openAccount(String accType, float amount);
	public float deposit(int accNo,float amount);
	public Account balEnquiry(int accNo, String accType);
	public float withdraw(int accNo,float amount);
	public float delete(int accNo);

}