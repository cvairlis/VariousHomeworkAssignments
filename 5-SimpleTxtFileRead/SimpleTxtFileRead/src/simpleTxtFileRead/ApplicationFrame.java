package simpleTxtFileRead;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 412321L;
	private JPanel contentPane;
	private ArrayList<Student> students = new ArrayList<>();
	private JButton firstButton;
	private JButton secondButton;
	
	public ApplicationFrame(){
		super("Students");
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initialize() {
		setBounds(100, 100, 625, 486);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		MyButtonListener listener = new MyButtonListener();
		
		firstButton = new JButton("Create");
		firstButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstButton.setBounds(182, 131, 96, 46);
		firstButton.addActionListener(listener);
		contentPane.add(firstButton);	
		
		secondButton = new JButton("Print");
		secondButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		secondButton.setBounds(182, 231, 96, 46);
		secondButton.addActionListener(listener);
		contentPane.add(secondButton);
	}
		
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == firstButton) {
				students = new Reader().readFromTxtFile("students.txt");
				System.out.println("Diavastike to arxeio txt. Ta Student objects kataskeuastikan.");
			} else if(e.getSource()==secondButton) {
				for(Student s : students){
					s.printInfo();
				}
			}
		}
	}
}
