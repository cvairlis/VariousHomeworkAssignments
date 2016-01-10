package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import data.Database;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JList;

import classes.Client;
import classes.PrePaidCardClient;
import classes.Subscriber;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JTextField;

public class ApplicationFrame extends JFrame {

	private static final long serialVersionUID = 11231254;
	
	private JPanel contentPane;
	private Database database = new Database();
	private JRadioButton prePaidCardClientRadioButton;
	private JRadioButton subscribersRadioButton;
	private JList<String> viewClientsList;
	private JButton viewListButton;
	
	//private ArrayList<Client> subscribers = new ArrayList<>();
	//private ArrayList<Client> prePaidCardClients = new ArrayList<>();
	private JButton viewClientButton;
	private JTextArea viewClientArea;
	private JRadioButton addSubscriberRadioButton;
	private JRadioButton addPrePaidCardClientRadioButton;
	private JTextField newClientSurnameTextField;
	private JTextField newClientContractTextField;
	private JButton addNewClientButton;
	private JButton printConsoleButton;
	private JButton exportToTxTButton;
	
	/**
	 * ApplicationFrame constructor
	 */
	public ApplicationFrame(){
		super("mpla");
		//subscribers = database.getSubscribers();
		//prePaidCardClients = database.getPrePaidCardClients();
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}	

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setBounds(100, 100, 473, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel companyInformationLabel = new JLabel("");
		companyInformationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		companyInformationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		companyInformationLabel.setBounds(11, 11, 436, 38);
		companyInformationLabel.setText("Company name: " + database.getCompanyInformation());
		contentPane.add(companyInformationLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(90, 294, 355, 2);
		contentPane.add(separator_1);
		
		JLabel newClientLabel = new JLabel("New Client");
		newClientLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newClientLabel.setBounds(11, 281, 136, 25);
		contentPane.add(newClientLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 60, 345, 2);
		contentPane.add(separator);
		
		JLabel viewClientsLabel = new JLabel("View Clients");
		viewClientsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewClientsLabel.setBounds(11, 47, 136, 25);
		contentPane.add(viewClientsLabel);
		
		subscribersRadioButton = new JRadioButton("Subscribers");
		subscribersRadioButton.setSelected(true);
		subscribersRadioButton.setBounds(21, 75, 109, 23);
		contentPane.add(subscribersRadioButton);
		
		prePaidCardClientRadioButton = new JRadioButton("PrePaidCardClients");
		prePaidCardClientRadioButton.setBounds(145, 75, 136, 23);
		contentPane.add(prePaidCardClientRadioButton);
		
		ButtonGroup bt = new ButtonGroup();
		bt.add(subscribersRadioButton);
		bt.add(prePaidCardClientRadioButton);
		
		MyButtonListener listener = new MyButtonListener();
		
		viewListButton = new JButton("View list");
		viewListButton.setBounds(313, 75, 89, 23);
		viewListButton.addActionListener(listener);
		contentPane.add(viewListButton);
		
		viewClientsList = new JList<String>();
		viewClientsList.setBounds(25, 110, 165, 160);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 110, 165, 160);
		scrollPane.setViewportView(viewClientsList);		
		UpdateJList(database.getSubscribers());
		contentPane.add(scrollPane);
		
		viewClientButton = new JButton("View Client");
		viewClientButton.setBounds(210, 227, 112, 23);
		viewClientButton.addActionListener(listener);
		contentPane.add(viewClientButton);
		
		viewClientArea = new JTextArea();
		viewClientArea.setFont(new Font("Arial", Font.BOLD, 13));
		viewClientArea.setLineWrap(true);
		viewClientArea.setRows(10);
		viewClientArea.setBackground(Color.LIGHT_GRAY);
		viewClientArea.setEditable(false);
		viewClientArea.setBounds(200, 112, 236, 104);
		contentPane.add(viewClientArea);
		
		addSubscriberRadioButton = new JRadioButton("Subscriber");
		addSubscriberRadioButton.setSelected(true);
		addSubscriberRadioButton.setBounds(21, 313, 109, 23);
		contentPane.add(addSubscriberRadioButton);
		
		addPrePaidCardClientRadioButton = new JRadioButton("PrePaidCardClient");
		addPrePaidCardClientRadioButton.setBounds(145, 313, 136, 23);
		contentPane.add(addPrePaidCardClientRadioButton);
		
		ButtonGroup bt2 = new ButtonGroup();
		bt2.add(addSubscriberRadioButton);
		bt2.add(addPrePaidCardClientRadioButton);
		
		newClientSurnameTextField = new JTextField();
		newClientSurnameTextField.setBounds(21, 348, 148, 25);
		contentPane.add(newClientSurnameTextField);
		newClientSurnameTextField.setColumns(10);
		
		newClientContractTextField = new JTextField();
		newClientContractTextField.setColumns(10);
		newClientContractTextField.setBounds(187, 348, 148, 25);
		contentPane.add(newClientContractTextField);
		
		addNewClientButton = new JButton("Add Client");
		addNewClientButton.setBounds(31, 391, 136, 25);
		addNewClientButton.addActionListener(listener);
		contentPane.add(addNewClientButton);		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 440, 355, 2);
		contentPane.add(separator_2);
		
		JLabel actionsLabel = new JLabel("Actions");
		actionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		actionsLabel.setBounds(11, 427, 136, 25);
		contentPane.add(actionsLabel);
		
		printConsoleButton = new JButton("Console Print");
		printConsoleButton.setBounds(10, 466, 137, 23);
		printConsoleButton.addActionListener(listener);
		contentPane.add(printConsoleButton);
		
		exportToTxTButton = new JButton("txt Print");
		exportToTxTButton.setBounds(10, 515, 137, 23);
		exportToTxTButton.addActionListener(listener);
		contentPane.add(exportToTxTButton);		
	}
	
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == viewListButton) {
				if (subscribersRadioButton.isSelected()){
					UpdateJList(database.getSubscribers());
				} else {
					UpdateJList(database.getPrePaidCardClients());
				}				
			} else if (e.getSource() == viewClientButton) {
				if (subscribersRadioButton.isSelected()){
					for (Client c : database.getSubscribers()){
						if (c.getSurname().equals(viewClientsList.getSelectedValue())) {
							viewClientArea.setText(c.toString());
						}
					}
				} else {
					for (Client c : database.getPrePaidCardClients()){
						if (c.getSurname().equals(viewClientsList.getSelectedValue())) {
							viewClientArea.setText(c.toString());
						}
					}
				}				
			} else if (e.getSource() == addNewClientButton){
				String surname = newClientSurnameTextField.getText();
				int contractNum = Integer.parseInt(newClientContractTextField.getText());
				if (addSubscriberRadioButton.isSelected()){					
					database.addClient(new Subscriber(surname, contractNum));
					//subscribers = database.getSubscribers();
				} else if (addPrePaidCardClientRadioButton.isSelected()){
					database.addClient(new PrePaidCardClient(surname, contractNum));
					//prePaidCardClients = database.getPrePaidCardClients();
				}
				newClientSurnameTextField.setText("");
				newClientContractTextField.setText("");				
			} else if (e.getSource() == printConsoleButton) {
				database.printCompanyClients();
			} else if (e.getSource() == exportToTxTButton) { 
				database.exportClientsToTxtFile();				
			}
		}		
	}
	
	private void UpdateJList(ArrayList<Client> list){
		DefaultListModel<String> model = new DefaultListModel<String>();
	    for(Client c : list){
	         model.addElement(c.getSurname());
	    }    
		viewClientsList.setModel(model);     
		viewClientsList.setSelectedIndex(0);
	}
}
