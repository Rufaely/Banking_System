package framework.visitor;

import framework.entity.Account;

public interface Visitor {
	public void visit(Account account);
}
