package creditCard.ui;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.Frame;
import java.util.List;

import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class JDialogGenBill extends javax.swing.JDialog
{
    private AccountService accountService = ServiceFactory.createAccountService();
    String billstring;
    
	public JDialogGenBill(Frame parent)
	{
		super(parent);
		setTitle("Monthly Billing Report");
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,400,500);
		JScrollPane1.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0,0,380,500);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,530,96,24);

		// generate the string for the monthly bill
		List<String> monthlyBillingReport = accountService.getMonthlyBillingReport();
		StringBuilder reportBuilder = new StringBuilder();
		for (String report : monthlyBillingReport) {
			System.out.println(report);
			reportBuilder.append(report);
		}
		
		JTextArea1.setLineWrap(true);
		JTextArea1.setText(reportBuilder.toString());
		
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}

	public JDialogGenBill()
	{
		this((Frame)null);
	}



	//{{DECLARE_CONTROLS
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea1 = new javax.swing.JTextArea();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
