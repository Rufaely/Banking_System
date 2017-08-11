package framework.factory.dao;

import framework.dao.AccountDAO;
import framework.dao.AccountDAOImp;
import framework.dao.CustomerDAO;
import framework.dao.CustomerDAOImp;

public class DAOFactory {
/*Volatile and transient key words*/
	//When serializable interface is declared, the compiler knows that the object has 
	//to be handled so as so be able to serialize it. However, if you declare a variable in an 
	//object as transient, then it doesn’t get serialized. 

	/*Volatile*/ 
	//Specifying a variable as volatile tells the JVM that any threads using that variable are not
	//allowed to cache that value at all. 	
	//Volatile modifier tells the compiler that the variable modified by volatile can be 
	//changed unexpectedly by other parts of the program.
	
	private static volatile AccountDAO accountDAO;
	private static volatile CustomerDAO customerDAO;

	public static AccountDAO createAccountDAO() {
		if(null == accountDAO) {
			synchronized(DAOFactory.class) {
				if(null == accountDAO) {
					accountDAO = new AccountDAOImp();
				}
			}
		}
		
		return accountDAO;
	}
	
	
	public static CustomerDAO createCustomerDAO() {
		if(null == customerDAO) {
			synchronized(DAOFactory.class) {
				if(null == customerDAO) {
					customerDAO = new CustomerDAOImp();
				}
			}
		}
		
		return customerDAO;
	}

}
