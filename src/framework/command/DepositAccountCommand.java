package framework.command;

import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class DepositAccountCommand implements Command {
	private AccountService accountService = ServiceFactory.createAccountService();
	private String accountNumber;
	private Double amount;

	public DepositAccountCommand(String accountNumber, Double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.deposit(accountNumber, amount);
	}

	@Override
	public void undo() {
		accountService.withdraw(accountNumber, amount);
	}
	
}