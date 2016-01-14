package hotels_1;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;

public class ApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1154L;
	private JPanel contentPane;
	private JButton readSerButton;
	private JList<String> hotelsList;
	private JScrollPane scrollpane;
	private JButton fillJListButton;
	
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private JButton fillJListWithHotelsSortedbyNameButton;
	private JButton printHotelsSortedbutton;
	
	/**
	 * Create the frame.
	 */
	public ApplicationFrame() {
		super("De-serialization - Sorting objects");
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 276);
		setVisible(true);		
	}
	
	public void initialize(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		MyListener listener = new MyListener();
		
		readSerButton = new JButton("Read ser file");
		readSerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		readSerButton.addActionListener(listener);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(readSerButton, BorderLayout.NORTH);
		
		hotelsList = new JList<String>();
		hotelsList.setBounds(60, 140, 192, 194);
		
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(hotelsList);
		contentPane.add(scrollpane, BorderLayout.CENTER);
		
		fillJListButton = new JButton("Fill JList");
		fillJListButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fillJListButton.setEnabled(false);
		fillJListButton.addActionListener(listener);
		contentPane.add(fillJListButton, BorderLayout.WEST);
		
		fillJListWithHotelsSortedbyNameButton = new JButton("Fill JList With Hotels Sorted by Name");
		fillJListWithHotelsSortedbyNameButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fillJListWithHotelsSortedbyNameButton.setEnabled(false);
		fillJListWithHotelsSortedbyNameButton.addActionListener(listener);
		contentPane.add(fillJListWithHotelsSortedbyNameButton, BorderLayout.SOUTH);
		
		printHotelsSortedbutton = new JButton("Print Hotels Sorted");
		printHotelsSortedbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		printHotelsSortedbutton.setEnabled(false);
		printHotelsSortedbutton.addActionListener(listener);
		contentPane.add(printHotelsSortedbutton, BorderLayout.EAST);
	}
	
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == readSerButton){
				hotels = new LoadData().deserializingCompany();
				for (Hotel hotel:hotels){
					hotel.printInfo();
				}
				fillJListButton.setEnabled(true);
				fillJListWithHotelsSortedbyNameButton.setEnabled(true);
				printHotelsSortedbutton.setEnabled(true);				
			} else if (e.getSource() == fillJListButton){
				
				DefaultListModel<String> model = new DefaultListModel<>();
			    for(Hotel h : hotels){
			         model.addElement(h.getName());
			    }    
			    hotelsList.setModel(model);     
			    hotelsList.setSelectedIndex(0);	
			    fillJListButton.setEnabled(false);
			} else if (e.getSource() == fillJListWithHotelsSortedbyNameButton){
				new Hotel().sortByName(hotels);
				DefaultListModel<String> model = new DefaultListModel<>();
			    for(Hotel h : hotels){
			         model.addElement(h.getName());
			    }    
			    hotelsList.setModel(model);     
			    hotelsList.setSelectedIndex(0);	
			} else if (e.getSource() == printHotelsSortedbutton){
				new Hotel().sortByName(hotels);
				for (Hotel h: hotels){
					h.printInfo();
				}				
			}			
		}
	}	
}
