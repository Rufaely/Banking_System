package framework.command;

import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class AddInterestCommand implements Command {
	private AccountService accountService = ServiceFactory.createAccountService();
	
	@Override
	public void execute() {
		accountService.addInterest();
	}

	@Override
	public void undo() {
		// to be implemented
	}
	
}