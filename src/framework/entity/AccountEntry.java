package framework.entity;

import java.time.LocalDate;

public interface AccountEntry {

	LocalDate getDate();

	void setDate(LocalDate date);

	Double getAmount();

	void setAmount(Double amount);

	String getDescription();

	void setDescription(String description);

	String getFromAccountNumber();

	void setFromAccountNumber(String fromAccountNumber);

	String getFromPersonName();

	void setFromPersonName(String fromPersonName);

	public Double getBalanceAfterTrans();

	public void setBalanceAfterTrans(Double balanceAfterTrans);
}