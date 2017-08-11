package framework.command;

import framework.entity.Account;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class TransferAccountCommand implements Command {
	private AccountService accountService = ServiceFactory.createAccountService();
	private Account source;
	private Account destination;
	private Double amount;

	public TransferAccountCommand(Account source, Account destination, Double amount) {
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.transferFunds(source, destination, amount);
	}

	@Override
	public void undo() {
		accountService.transferFunds(destination, source, amount);
	}
	
}