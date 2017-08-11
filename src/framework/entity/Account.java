package framework.entity;

import java.util.List;
import java.util.function.Consumer;

import framework.visitor.Visitor;

public interface Account extends Consumer<Visitor>{

	void setInterest(Interest interest);

	void deposit(Double amount);
	
	void withdraw(Double amount);

	void addInterest();

	String getAccountNumber();

	void setAccountNumber(String accountNumber);

	Customer getCustomer();

	void setCustomer(Customer customer);

	Double getBalance();

	void setBalance(Double balance);

	List<AccountEntry> getAccountEntries();

	void setAccountEntries(List<AccountEntry> accountEntries);
	
	boolean notifyEmail(Double amount);
	
	double getMinimumPaymentPercent();

}