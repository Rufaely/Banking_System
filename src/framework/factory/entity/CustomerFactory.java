package framework.factory.entity;

import framework.entity.Company;
import framework.entity.Customer;
import framework.entity.Individual;

public class CustomerFactory {
	
	public static Customer createCustomer(CustomerType accountType) {
		if (accountType == CustomerType.COMPANY) {
			return new Company();
		} else if (accountType == CustomerType.INDIVIDUAL) {
			return new Individual();
		} else {
			return null;
		}
	}
}
