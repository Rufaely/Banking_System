package framework.entity;

import java.time.LocalDate;

public class AccountEntryImp implements AccountEntry {

	private LocalDate date;
	private Double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	private Double balanceAfterTrans;

	public AccountEntryImp(Double amount, Double balanceAfterTrans, String description, String fromAccountNumber, String fromPersonName) {
		this.date = LocalDate.now();
		this.amount = amount;
		this.balanceAfterTrans = balanceAfterTrans;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#getDate()
	 */
	@Override
	public LocalDate getDate() {
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#setDate(java.time.LocalDate)
	 */
	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#getAmount()
	 */
	@Override
	public Double getAmount() {
		return amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#setAmount(java.lang.Double)
	 */
	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#getFromAccountNumber()
	 */
	@Override
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * framework.entity.IAccountEntry#setFromAccountNumber(java.lang.String)
	 */
	@Override
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#getFromPersonName()
	 */
	@Override
	public String getFromPersonName() {
		return fromPersonName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.entity.IAccountEntry#setFromPersonName(java.lang.String)
	 */
	@Override
	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

	public Double getBalanceAfterTrans() {
		return balanceAfterTrans;
	}

	public void setBalanceAfterTrans(Double balanceAfterTrans) {
		this.balanceAfterTrans = balanceAfterTrans;
	}

}
