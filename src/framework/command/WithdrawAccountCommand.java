package framework.command;

import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class WithdrawAccountCommand implements Command {
	private AccountService accountService = ServiceFactory.createAccountService();
	private String accountNumber;
	private Double amount;

	public WithdrawAccountCommand(String accountNumber, Double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.withdraw(accountNumber, amount);
	}

	@Override
	public void undo() {
		accountService.deposit(accountNumber, amount);
	}
	
}