package framework.command;

import framework.entity.Account;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class CreateAccountCommand implements Command {

	private AccountService accountService = ServiceFactory.createAccountService();
	
	private Account account;

	public CreateAccountCommand(Account account) {
		this.account = account;
	}
	
	@Override
	public void execute() {
		accountService.createAccount(account);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
