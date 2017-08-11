package framework.entity;

import java.time.LocalDate;
import java.util.List;

public interface Customer {

	Long getId();

	void setId(Long id);
	
	String getName();

	void setName(String name);

	LocalDate getBirthDate();

	void setBirthDate(LocalDate birthDate);

	String getEmail();

	void setEmail(String email);

	Address getAddress();

	void setAddress(Address address);

	List<Account> getAccounts();

	void setAccounts(List<Account> accounts);

}