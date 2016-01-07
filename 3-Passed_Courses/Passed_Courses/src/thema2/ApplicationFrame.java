package thema2;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Color;


/**
 * for Sorting Lists using Comparators TUTORIAL
 * https://www.youtube.com/watch?v=QYvUmIYgsiA
 * 
 * @author Administrador
 *
 */
public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Course> courses = new ArrayList<>();
	private JList<String> coursesFromTextJlist;
	private JList<String> sortedJlist;
	private JButton sortButton;
	private JRadioButton courseRadioButton;
	private JRadioButton gradeRadioButton;
	private JCheckBox ascDescCheckBox;
	private JLabel sortByLabel;
	private JScrollPane coursesScrollPane;
	private JScrollPane sortedScrollPane;
	private JLabel averageLabel;
	private JLabel remainingLabel;
	private JTextField mandatoryTextField;
	private JTextField electiveTextField;
	private JLabel mandatoryLabel;
	private JLabel electiveLabel;
	private JTextField avgTextField;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ApplicationFrame(){
		super("Thema 2 GUI");
		courses = new Reader().readFromTxtFile("courses.txt");
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// auta ta set einai gia to frame
		setBounds(100, 100, 625, 486);
		setResizable(false);
		
		// ftiaxnetai ena panel me onoma contentPane
		contentPane = new JPanel();
		contentPane.setLayout(null);
		// sto frame kanei setContentPane to panel pou kataskeuasame
		setContentPane(contentPane);		
		
		//Jlist pou tha periexei String me tis plhrofories pou diavase apo to txt
		coursesFromTextJlist = new JList<String>();
		coursesFromTextJlist.setBounds(25, 11, 253, 287);
		// methodos pou ylopoieitai parakatw
		UpdateJList(coursesFromTextJlist, courses);

		// scrollPane gia thn coursesFromTextJlist
		coursesScrollPane = new JScrollPane();
		coursesScrollPane.setBounds(25, 11, 253, 287);
		coursesScrollPane.setViewportView(coursesFromTextJlist);
		contentPane.add(coursesScrollPane);
		
		// JList pou tha periexei string me tis taksinomhmenes plhrofories
		// sthn arxh tha einai kenh, tha gemizei meta to pathma tou koumpiou sortButton
		sortedJlist = new JList<String>();
		sortedJlist.setBounds(343, 11, 253, 287);
		
		// scrollPane gia thn sortedJlist
		sortedScrollPane = new JScrollPane();
		sortedScrollPane.setBounds(343, 11, 253, 287);
		sortedScrollPane.setViewportView(sortedJlist);
		contentPane.add(sortedScrollPane);
		
		// Sort Button - prepei na ylopoiithei Action Listener
		sortButton = new JButton("Sort");
		sortButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sortButton.setBounds(182, 331, 96, 46);
		contentPane.add(sortButton);
		MyButtonListener listener = new MyButtonListener();
		sortButton.addActionListener(listener);
		
		courseRadioButton = new JRadioButton("Course Name");
		courseRadioButton.setBounds(35, 364, 112, 23);
		contentPane.add(courseRadioButton);
		// h set selected(true) shmainei oti me to pou anoigei to GUI to courseRadioButton tha einai epilegmeno apo proepilogh
		courseRadioButton.setSelected(true);
		
		gradeRadioButton = new JRadioButton("Grade");
		gradeRadioButton.setBounds(35, 390, 74, 23);
		contentPane.add(gradeRadioButton);
		
		// edw ta radio button ginontai group, etsi eksasfalizetai oti kathe fora ena apo ta 2 radio buttons tha einai epilegmeno
		ButtonGroup btg = new ButtonGroup();
		btg.add(courseRadioButton);
		btg.add(gradeRadioButton);		
		
		ascDescCheckBox = new JCheckBox("Descending");
		ascDescCheckBox.setBounds(181, 390, 97, 23);
		contentPane.add(ascDescCheckBox);
		
		JLabel lblNewLabel = new JLabel("=>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(288, 103, 40, 33);
		contentPane.add(lblNewLabel);
		
		sortByLabel = new JLabel("Sort By:");
		sortByLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sortByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sortByLabel.setBounds(35, 319, 74, 46);
		contentPane.add(sortByLabel);
		
		averageLabel = new JLabel("AVG:");
		averageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		averageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		averageLabel.setBounds(343, 319, 56, 46);
		contentPane.add(averageLabel);
		
		remainingLabel = new JLabel("Remaining:");
		remainingLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		remainingLabel.setBounds(343, 375, 80, 33);
		contentPane.add(remainingLabel);
		
		mandatoryTextField = new JTextField();
		mandatoryTextField.setHorizontalAlignment(SwingConstants.CENTER);
		mandatoryTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mandatoryTextField.setBackground(Color.WHITE);
		mandatoryTextField.setEditable(false);
		mandatoryTextField.setBounds(427, 376, 56, 33);
		mandatoryTextField.setText(new Course().getRemaining(courses, "Mandatory"));
		contentPane.add(mandatoryTextField);
		mandatoryTextField.setColumns(10);
		
		electiveTextField = new JTextField();
		electiveTextField.setHorizontalAlignment(SwingConstants.CENTER);
		electiveTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		electiveTextField.setEditable(false);
		electiveTextField.setColumns(10);
		electiveTextField.setBackground(Color.WHITE);
		electiveTextField.setBounds(427, 413, 56, 33);
		electiveTextField.setText(new Course().getRemaining(courses, "Elective"));
		contentPane.add(electiveTextField);
		
		mandatoryLabel = new JLabel("Mandatory");
		mandatoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mandatoryLabel.setBounds(493, 375, 74, 33);
		contentPane.add(mandatoryLabel);
		
		electiveLabel = new JLabel("Elective");
		electiveLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		electiveLabel.setBounds(493, 411, 74, 33);
		contentPane.add(electiveLabel);
		
		avgTextField = new JTextField();
		avgTextField.setHorizontalAlignment(SwingConstants.CENTER);
		avgTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avgTextField.setEditable(false);
		avgTextField.setColumns(10);
		avgTextField.setBackground(Color.WHITE);
		avgTextField.setBounds(427, 329, 56, 33);
		avgTextField.setText(new Course().getAverage(courses));
		contentPane.add(avgTextField);
	}
	
	
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sortButton) {
				// System.out.println("Sort Button pressed");
				if (courseRadioButton.isSelected()){
					if (ascDescCheckBox.isSelected()){
						new Course().sortByName(courses, false);
						UpdateJList(sortedJlist, courses);	
					} else {
						new Course().sortByName(courses, true);
						UpdateJList(sortedJlist, courses);	
					}									
				} else if (gradeRadioButton.isSelected()){
					if (ascDescCheckBox.isSelected()){
						new Course().sortByGrade(courses, false);
						UpdateJList(sortedJlist, courses);
					} else {
						new Course().sortByGrade(courses, true);
						UpdateJList(sortedJlist, courses);	
					}	
				}
			}			
		}
	}
	
	/**
	 * H methodos auth dexetai kathe fora mia JList kai mia ArrayList me Courses
	 * @param jlist
	 * @param list
	 */
	private void UpdateJList(JList<String> jlist, ArrayList<Course> list){
		DefaultListModel<String> model = new DefaultListModel<String>();
	    for(Course c : list){
	         model.addElement(c.toString());
	    }    
	    jlist.setModel(model);     
	    jlist.setSelectedIndex(0);
	}
	
	
}
