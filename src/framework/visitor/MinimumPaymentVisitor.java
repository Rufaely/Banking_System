package framework.visitor;

import framework.entity.Account;

public class MinimumPaymentVisitor implements Visitor {

	Double minimumPayment;
	@Override
	public void visit(Account account) {
		minimumPayment = account.getBalance() * account.getMinimumPaymentPercent();
	}
	
	public double getMinimumPayment (){
		return this.minimumPayment;
	}

}
