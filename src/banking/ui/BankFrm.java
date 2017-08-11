package banking.ui;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import banking.factory.entity.BankAccountFactory;
import framework.entity.Account;
import framework.entity.Address;
import framework.entity.Customer;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;
import framework.factory.entity.CustomerFactory;
import framework.factory.entity.CustomerType;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;
import framework.service.AccountServiceInvoker;

/**
 * A basic JFC based application.
 */
public class BankFrm extends javax.swing.JFrame {
	
	private AccountService accountService = ServiceFactory.createAccountService();
	private AccountServiceInvoker accountServiceInvoker = ServiceFactory.createInvokerService();
	private AccountFactory accountFactory = new BankAccountFactory();
	
	/*
	 * init variables in the object
	 */
	AccountType accountType;
	String accountnr, clientName, street, city, zip, state, clientType, amountDeposit, amountWithdraw;
	boolean newaccount;
	private static DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	BankFrm myframe;
	private Object rowdata[];

	public BankFrm() {
		myframe = this;
		
		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(600, 350);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	//static public void main(String args[]) {
	 public static void bankMain() {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new BankFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
		
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
		
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 380);
		pac.show();
		
		if (newaccount) {
			
			Account account = accountFactory.createAccount(accountType);
			account.setAccountNumber(accountnr);
			
			Customer customer = CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
			//customer.setId(id);
			customer.setName(clientName);
			//customer.setBirthDate(birthDate);
			//customer.setEmail(email);
			
			Address address = new Address();
			address.setCity(city);
			address.setZip(zip);
			address.setState(state);
			address.setStreet(street);
			
			customer.setAddress(address);
			account.setCustomer(customer);
			
			// Calling the invoker
			accountServiceInvoker.createAccount(account);
			newaccount = false;
			refreshRows();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}

	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 320, 380);
		pac.show();

		if (newaccount) {		
			
			Account account = accountFactory.createAccount(accountType);
			account.setAccountNumber(accountnr);
			
			Customer customer = CustomerFactory.createCustomer(CustomerType.COMPANY);
			//customer.setId(id);
			customer.setName(clientName);
			//customer.setBirthDate(birthDate);
			//customer.setEmail(email);
			
			Address address = new Address();
			address.setCity(city);
			address.setZip(zip);
			address.setState(state);
			address.setStreet(street);
			
			customer.setAddress(address);
			account.setCustomer(customer);
			
			//Calling the invoker
			accountServiceInvoker.createAccount(account);
			newaccount = false;
			refreshRows();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 290, 180);
			dep.show();

			// compute new amount
			float deposit;
			if (amountDeposit == null || amountDeposit.trim().equals("")){
				deposit = 0;
			}
			else {
				deposit = Float.parseFloat((amountDeposit));
			}
			
			// Calling the invoker
			accountServiceInvoker.deposit(accnr, Double.valueOf(deposit));
			amountDeposit = "0";
			refreshRows();
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 280, 180);
			wd.show();

			// compute new amount
			float withdraw1;
			if (amountWithdraw == null || amountWithdraw.trim().equals("")){
				withdraw1 = 0;
			}
			else {
				withdraw1 = Long.parseLong(amountWithdraw);
			}
			
			float newamount = (Float)model.getValueAt(selection, 5) - withdraw1;
			
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !",
						"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
			}
			
			accountServiceInvoker.withdraw(accnr, Double.valueOf(withdraw1));
			amountWithdraw = "0";
			refreshRows();
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		 int response = JOptionPane.showConfirmDialog(null, "Do you want to add interest to all acounts?", "Add Interest To All Accounts",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if (response == JOptionPane.YES_OPTION) {
			    	accountServiceInvoker.addInterest();
					refreshRows();
					JOptionPane.showMessageDialog(JButton_Addinterest, "Interest has been added to all accounts",
							"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
			    } 
			    else if (response == JOptionPane.NO_OPTION) {
			    	JOptionPane.showMessageDialog(JButton_Addinterest, "No Interest Added",
							"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
			    }
		
	}
	
	// Updating the DefaultTableModel (Display)
	public void refreshRows() {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		
		Iterator<Account> accountIterator = accountService.accountIterator();
		Account data;
		
		while (accountIterator.hasNext()) {
			
			data = accountIterator.next();
			rowdata[0] = data.getAccountNumber();
			rowdata[1] = data.getCustomer().getName();
			rowdata[2] = data.getCustomer().getAddress().getCity();
			
			if (data.getCustomer().getClass().getSimpleName().equals("Individual"))
				rowdata[3] = "P";
			else if (data.getCustomer().getClass().getSimpleName().equals("Company"))
				rowdata[3] = "C";
			
			if (data.getClass().getSimpleName().equals("CheckingAccount"))
				rowdata[4] = "Checking";
			else if (data.getClass().getSimpleName().equals("SavingAccount"))
				rowdata[4] = "Saving";
			
			DecimalFormat df = new DecimalFormat("#.00"); 
			
			String balance = df.format(data.getBalance());
			
			//needed to be converted to float
			rowdata[5] = Float.parseFloat(balance);
			System.out.println("rowdata[5]" + rowdata[5]);
			model.addRow(rowdata);
		}
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}
	
	public static DefaultTableModel getAcctTableModel(){
		return model;
	}
}
