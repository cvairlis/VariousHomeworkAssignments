package mobileContracts;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddCustomerForm extends JFrame {
	
	private JPanel fieldPanel;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	
	private JTextField nameField;
	private JTextField timeField;
	private JTextField smsField;
	private JTextField numberField;
	private JTextField mbField;
	
	private JButton createContractButton;
	private JButton showAllContractsButton;	
	
	public AddCustomerForm() {
				
		nameField = new JTextField("Customer Name");
		timeField = new JTextField("free Time in mins");
		smsField = new JTextField("free sms");
		numberField = new JTextField("phone number");
		mbField = new JTextField("free MBytes");
		
		createContractButton = new JButton("Create Contract");
		showAllContractsButton = new JButton("Show Contracts");
		
		fieldPanel = new JPanel();
		fieldPanel.add(nameField);
		fieldPanel.add(timeField);
		fieldPanel.add(smsField);
		fieldPanel.add(numberField);
		fieldPanel.add(mbField);
		
		buttonPanel = new JPanel();
		buttonPanel.add(createContractButton);
		buttonPanel.add(showAllContractsButton);
		
		GridLayout layout = new GridLayout(1, 2);
		mainPanel = new JPanel();
		mainPanel.setLayout(layout);
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		
		this.setContentPane(mainPanel);
		
		this.setVisible(true);
		this.setSize(300, 200);
		this.setTitle("Add New Customer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

}
