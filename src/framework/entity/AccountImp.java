package framework.entity;

import java.util.ArrayList;
import java.util.List;

import framework.visitor.Visitor;

public abstract class AccountImp implements Account {

	private String accountNumber;

	private Customer customer;

	private Double balance = 0.00;

	private List<AccountEntry> accountEntries = new ArrayList<>();

	private Interest interest;

	public AccountImp() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#setInterest(framework.entity.Interest)
	 */
	@Override
	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#deposit(java.lang.Double)
	 */
	@Override
	public void deposit(Double amount) {
		setBalance(balance + amount);

		AccountEntryImp newAccountEntry = new AccountEntryImp(amount, getBalance(), "+", "fromAccountNumber",
				"fromPersonName");
		accountEntries.add(newAccountEntry);
	}

	@Override
	public void withdraw(Double amount) {
		setBalance(balance - amount);

		AccountEntryImp newAccountEntry = new AccountEntryImp(amount, getBalance(), "-", "fromAccountNumber",
				"fromPersonName");
		accountEntries.add(newAccountEntry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#addInterest()
	 */
	@Override
	public void addInterest() {
		interest.addInterest(this);
	}

	/*
	 * getters and setters
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#getAccountNumber()
	 */
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#setAccountNumber(java.lang.String)
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#getCustomer()
	 */
	@Override
	public Customer getCustomer() {
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#setCustomer(framework.entity.Customer)
	 */
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#getBalance()
	 */
	@Override
	public Double getBalance() {
		return balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#setBalance(java.lang.Double)
	 */
	@Override
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#getAccountEntries()
	 */
	@Override
	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#setAccountEntries(java.util.List)
	 */
	@Override
	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public double getMinimumPaymentPercent() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.Account#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}

}
