package framework.entity;

import java.time.LocalDate;
import java.util.List;

public class CustomerImp implements Customer {
	private Long id;
	private String name;
	private LocalDate birthDate;
	private String email;
	private Address address;
	private List<Account> accounts;

	public CustomerImp() {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	/* (non-Javadoc)
	 * @see framework.entity.Customer#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Customer#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Customer#getAccounts()
	 */
	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Customer#setAccounts(java.util.List)
	 */
	@Override
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "CustomerImp [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email
				+ ", address=" + address + ", accounts=" + accounts + "]";
	}
}
