package framework.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import framework.entity.Account;

public class AccountDAOImp implements AccountDAO {
	private Map<String, Account> dataMap = new HashMap<>();
		
	@Override
	public void saveAccount(Account account) {
		dataMap.put(account.getAccountNumber(), account);
		log();
	}

	@Override
	public void updateAccount(Account account) {
		dataMap.put(account.getAccountNumber(), account);
		log();
	}

	@Override
	public Account loadAccount(String accountNumber) {
		return dataMap.get(accountNumber);
	}

	@Override
	public Collection<Account> getAccounts() {
		return dataMap.values();
	}
	
	public void log(){
		System.out.println();
		System.out.println("start logging");
		for (Account account : dataMap.values()) {
			System.out.println(account);
		}
	}

}
