package framework.service;

import java.util.Iterator;
import java.util.List;

import framework.entity.Account;

public interface AccountService {
	
	public void createAccount(Account account);
	
	public void deposit(String accountNumber, Double amount);
	
	public void withdraw(String accountNumber, Double amount);
	
	public void transferFunds(Account source, Account destination, Double amount);
	
	public Iterator<Account> accountIterator();
	
	public Account getAccount(String accountNumber);
	
	public void addInterest();
	
	public List<String> getMonthlyBillingReport();
	
}
