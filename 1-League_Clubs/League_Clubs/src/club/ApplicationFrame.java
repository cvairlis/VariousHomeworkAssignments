package club;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JList;


public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField clubNameTextField;
	private JSeparator separator_1;
	private JLabel createAthleteLabel;
	private JTextField clubPlaceTextField;
	private JButton createClubButton;
	private JTextField athleteNameTextField;
	private JTextField athleteAgeTextField;
	private JTextField professionalAthleteMoneyTextField;
	private JRadioButton professionalAthleteRadioButton;
	private JRadioButton athleteRadioButton;
	private JButton createAthleteButton;
	private JList<Club> clubsList;
	
	private ArrayList<Club> clubs = new ArrayList<>();
	private JList<Athlete> athletesList;
	private JTextField dateScoresheetTextField;
	private JTextField timeScoresheetTextField;
	private JButton addScoresheetButton;
	private JButton printClubInformationButton;

	public ApplicationFrame(){
		super("Club - Athletes");
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
		
		clubNameTextField = new JTextField();
		clubNameTextField.setToolTipText("club name");
		clubNameTextField.setBounds(10, 39, 132, 20);
		contentPane.add(clubNameTextField);
		clubNameTextField.setColumns(10);
		
		JLabel createClubLabel = new JLabel("Club creation");
		createClubLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		createClubLabel.setBounds(10, 12, 132, 16);
		contentPane.add(createClubLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(105, 22, 342, 16);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(127, 89, 320, 16);
		contentPane.add(separator_1);
		
		createAthleteLabel = new JLabel("Athlete creation");
		createAthleteLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		createAthleteLabel.setBounds(10, 79, 132, 16);
		contentPane.add(createAthleteLabel);
		
		clubPlaceTextField = new JTextField();
		clubPlaceTextField.setToolTipText("club place");
		clubPlaceTextField.setColumns(10);
		clubPlaceTextField.setBounds(154, 39, 132, 20);
		contentPane.add(clubPlaceTextField);
		
		MyButtonListener listener = new MyButtonListener();
		
		createClubButton = new JButton("Create Club");
		createClubButton.setBounds(323, 38, 107, 20);
		createClubButton.addActionListener(listener);
		contentPane.add(createClubButton);
		
		athleteRadioButton = new JRadioButton("Athlete");
		athleteRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professionalAthleteMoneyTextField.setVisible(false);
			}
		});
		athleteRadioButton.setSelected(true);
		athleteRadioButton.setBounds(10, 102, 70, 23);
		contentPane.add(athleteRadioButton);
		
		professionalAthleteRadioButton = new JRadioButton("Professional Athlete");
		professionalAthleteRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				professionalAthleteMoneyTextField.setVisible(true);
			}
		});
		professionalAthleteRadioButton.setBounds(82, 101, 165, 23);
		contentPane.add(professionalAthleteRadioButton);
		
		ButtonGroup bt = new ButtonGroup();
		bt.add(athleteRadioButton);
		bt.add(professionalAthleteRadioButton);
		
		athleteNameTextField = new JTextField();
		athleteNameTextField.setToolTipText("athlete name");
		athleteNameTextField.setBounds(10, 132, 132, 20);
		contentPane.add(athleteNameTextField);
		athleteNameTextField.setColumns(10);
		
		athleteAgeTextField = new JTextField();
		athleteAgeTextField.setToolTipText("athlete age");
		athleteAgeTextField.setColumns(10);
		athleteAgeTextField.setBounds(154, 132, 132, 20);
		contentPane.add(athleteAgeTextField);
		
		professionalAthleteMoneyTextField = new JTextField();
		professionalAthleteMoneyTextField.setVisible(false);
		professionalAthleteMoneyTextField.setToolTipText("professional athlete money");
		professionalAthleteMoneyTextField.setColumns(10);
		professionalAthleteMoneyTextField.setBounds(311, 132, 101, 20);
		contentPane.add(professionalAthleteMoneyTextField);
		
		
		createAthleteButton = new JButton("Create Athlete");
		createAthleteButton.setBounds(253, 102, 123, 20);
		createAthleteButton.addActionListener(listener);
		createAthleteButton.setEnabled(false);
		contentPane.add(createAthleteButton);
		
		JLabel addToClubLabel = new JLabel("Add to");
		addToClubLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		addToClubLabel.setBounds(10, 163, 82, 16);
		contentPane.add(addToClubLabel);
		
		clubsList = new JList<Club>();
		clubsList.setBounds(10, 190, 165, 175);
		clubsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(clubsList);
		
		clubsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (athleteRadioButton.isSelected()){
					if (athleteNameTextField.getText().trim().length() > 0 && athleteAgeTextField.getText().trim().length() > 0) {  
			            createAthleteButton.setEnabled(true);  
			        } else {
			          	createAthleteButton.setEnabled(false);  
			        }			
				} else if (professionalAthleteRadioButton.isSelected()){
					if (athleteNameTextField.getText().trim().length() > 0 && athleteAgeTextField.getText().trim().length() > 0 && professionalAthleteMoneyTextField.getText().trim().length() > 0) {  
			            createAthleteButton.setEnabled(true);  
			        } else {
			          	createAthleteButton.setEnabled(false);  
			        }
				}
				printClubInformationButton.setEnabled(true);
			}
		});
		
		JScrollPane clubsScrollPane = new JScrollPane(clubsList);	    
		clubsScrollPane.setBounds(10, 190, 165, 175);
		contentPane.add(clubsScrollPane);	
			
		KeyAdapter adapter1 = new KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				super.keyReleased(evt);
				if (athleteRadioButton.isSelected()){
					if (athleteNameTextField.getText().trim().length() > 0 && athleteAgeTextField.getText().trim().length() > 0 && !clubsList.isSelectionEmpty()) {  
			            createAthleteButton.setEnabled(true);  
			        } else {
			          	createAthleteButton.setEnabled(false);  
			        }				
				} else if (professionalAthleteRadioButton.isSelected()){
					if (athleteNameTextField.getText().trim().length() > 0 && athleteAgeTextField.getText().trim().length() > 0 && professionalAthleteMoneyTextField.getText().trim().length() > 0 && !clubsList.isSelectionEmpty()) {  
			            createAthleteButton.setEnabled(true);  
			        } else {
			          	createAthleteButton.setEnabled(false);  
			        }					
				}		        
		    }  
		};
		
		athleteNameTextField.addKeyListener(adapter1);
		athleteAgeTextField.addKeyListener(adapter1);
		professionalAthleteMoneyTextField.addKeyListener(adapter1);
		
		JLabel scoreSheetLabel = new JLabel("Scoresheet creation");
		scoreSheetLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		scoreSheetLabel.setBounds(10, 376, 132, 16);
		contentPane.add(scoreSheetLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(154, 386, 293, 16);
		contentPane.add(separator_2);
		
		athletesList = new JList<Athlete>();
		athletesList.setBounds(10, 403, 165, 175);
		contentPane.add(athletesList);
		athletesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				dateScoresheetTextField.setEnabled(true);
				timeScoresheetTextField.setEnabled(true);
			}
		});
		
		JScrollPane athletesScrollPane = new JScrollPane(athletesList);	    
		athletesScrollPane.setBounds(10, 403, 165, 175);
		contentPane.add(athletesScrollPane);	
		
		dateScoresheetTextField = new JTextField();
		dateScoresheetTextField.setToolTipText("date scoresheet");
		dateScoresheetTextField.setBounds(218, 402, 107, 20);
		dateScoresheetTextField.setColumns(10);
		dateScoresheetTextField.setEnabled(false);
		contentPane.add(dateScoresheetTextField);
		
		
		timeScoresheetTextField = new JTextField();
		timeScoresheetTextField.setToolTipText("time scoresheet");
		timeScoresheetTextField.setColumns(10);
		timeScoresheetTextField.setBounds(218, 433, 107, 20);
		timeScoresheetTextField.setEnabled(false);
		contentPane.add(timeScoresheetTextField);
		
		addScoresheetButton = new JButton("Add scoresheet");
		addScoresheetButton.setBounds(208, 464, 132, 23);
		addScoresheetButton.setEnabled(false);
		addScoresheetButton.addActionListener(listener);
		contentPane.add(addScoresheetButton);
		
		KeyAdapter adapter2 = new KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				super.keyReleased(evt);
				if (dateScoresheetTextField.getText().trim().length() > 0 && timeScoresheetTextField.getText().trim().length() > 0) {  
			        addScoresheetButton.setEnabled(true);  
			    } else {
			    	addScoresheetButton.setEnabled(false);  
			    }		        
		    }  
		};
		
		dateScoresheetTextField.addKeyListener(adapter2);
		timeScoresheetTextField.addKeyListener(adapter2);
		
		printClubInformationButton = new JButton("Print Club Information");
		printClubInformationButton.addActionListener(listener);
		printClubInformationButton.setBounds(218, 225, 181, 73);
		printClubInformationButton.setEnabled(false);
		contentPane.add(printClubInformationButton);
	}
		
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == createClubButton){
				clubs.add(new Club(clubNameTextField.getText(), clubPlaceTextField.getText()));
				clubsList.setListData(clubs.toArray(new Club[1]));
				clubPlaceTextField.setText("");
				clubNameTextField.setText("");
			} else if (e.getSource() == createAthleteButton) {
				int ageInt = Integer.parseInt(athleteAgeTextField.getText());
				if (athleteRadioButton.isSelected()){					
					clubsList.getSelectedValue().addAthlete(new Athlete(athleteNameTextField.getText(), ageInt));
					//athletes.add(new Athlete(athleteNameTextField.getText(), ageInt));
					//System.out.println("Athlete created: " + new Athlete(athleteNameTextField.getText(), ageInt).toString());
				} else if (professionalAthleteRadioButton.isSelected()){
					double moneyDouble = Double.parseDouble(professionalAthleteMoneyTextField.getText());
					clubsList.getSelectedValue().addAthlete(new ProfessionalAthlete(athleteNameTextField.getText(), ageInt, moneyDouble));
					//athletes.add(new ProfessionalAthlete(athleteNameTextField.getText(), ageInt, moneyDouble));
					//System.out.println("Professional Athlete created: " + new ProfessionalAthlete(athleteNameTextField.getText(), ageInt, moneyDouble).toString());
				}				
				athletesList.setListData(athletesAdded().toArray(new Athlete[1]));
				//System.out.println("Added to club: "+ clubsList.getSelectedValue().toString());		
				athleteNameTextField.setText("");
				athleteAgeTextField.setText("");
			} else if (e.getSource() == addScoresheetButton) {
				double takeTimeNum = Double.parseDouble(timeScoresheetTextField.getText());
				athletesList.getSelectedValue().addScoreSheet(new ScoreSheet(dateScoresheetTextField.getText(), takeTimeNum));
				timeScoresheetTextField.setText("");
				dateScoresheetTextField.setText("");
			} else if (e.getSource() == printClubInformationButton) {
				for (Club club : clubs){					
					club.printClubInformation();
				}				
			}
		}
	}
	
	public ArrayList<Athlete> athletesAdded(){
		ArrayList<Athlete> athletes = new ArrayList<>();
		for (Club club : clubs){
			for (Athlete ath : club.getAthletes()){
				athletes.add(ath);
			}
		}
		return athletes;		
	}
}
