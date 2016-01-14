package hotels_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel diamoniPanel;
	private JPanel allInclusivePanel;
	private JPanel buttonPanel;
	
	private JLabel diamoniLabel;
	private JLabel hotelLabel;
	private JLabel allInclusiveLabel;
	
	private JList<String> listView;
	private DefaultListModel<String> model;
	
	private JTextField daysField;
	private JTextField mealsField;
	
	private JButton storeButton;
	private JButton calculateCostButton;
	
	private JTextField costField;
	
	private LoadData load = new LoadData();
	// edw kaloume th methodo deserializingCompany ths klashs LoadData, ths pername parametro hotels_2.ser 
	// to opoio einai to path kai epistrefei mia lista me antikeimena Hotel pou diavase apo to arxeio ser 
	private ArrayList<Hotel> hotelsFromSerFile = load.deserializingHotels("hotels_2.ser");
	
	public InputFrame() {
		
		panel = new JPanel();
		diamoniPanel = new JPanel();
		allInclusivePanel = new JPanel();
		buttonPanel = new JPanel();	
		
		
		listView = new JList<String>();
		model = new DefaultListModel<String>();
		// edw ginetai h taksinomhsh ths listas hotelsFromSerFile ws pros to pedio name
		Collections.sort(hotelsFromSerFile, new Comparator<Hotel>() {
			public int compare(Hotel h1, Hotel h2){
				return h1.getName().compareTo(h2.getName());				
			}
		});
		/*
		model.addElement("Dummy Hotel Name 1");
		model.addElement("Dummy Hotel Name 2");
		model.addElement("Dummy Hotel Name 3");
		model.addElement("Dummy Hotel Name 4");
		*/
		// edw ginetai to gemisma ths JList me ta onomata twn hotels ths listas hotelsFromSerFile taksinomhmena pleon
		for (Hotel hotel : hotelsFromSerFile){			
			model.addElement(hotel.getName());
		}
		listView.setModel(model);
		
		diamoniLabel = new JLabel("Stoixeia Diamonis");
		hotelLabel = new JLabel("Hotel");
		allInclusiveLabel = new JLabel("AllInclusive");
		
		daysField = new JTextField("Hmeres Diamonis");
		mealsField = new JTextField("Plithos Geumatwn (1,2,3)");
		costField = new JTextField("Synoliko Kostos");
		
		//kataskeuazoume ena antikeimeno ButtonListener
		ButtonListener listener = new ButtonListener();
		
		storeButton = new JButton("Apothikeusi Kratisis");
		// kai prosthetoume to listener sta 2 koumpia ws actionlistener
		storeButton.addActionListener(listener);
		calculateCostButton = new JButton("Ypologismos Kostous");
		calculateCostButton.addActionListener(listener);
		
		diamoniPanel.setLayout(new BoxLayout(diamoniPanel, BoxLayout.Y_AXIS));
		diamoniLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(diamoniLabel);
		hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(hotelLabel);
		diamoniPanel.add(listView);
		diamoniPanel.add(daysField);
		diamoniPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allInclusivePanel.setLayout(new GridLayout(2,0));
		allInclusivePanel.add(allInclusiveLabel);
		allInclusivePanel.add(mealsField);
		allInclusivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(storeButton);
		buttonPanel.add(calculateCostButton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(diamoniPanel);
		panel.add(allInclusivePanel);
		panel.add(buttonPanel);
		panel.add(costField);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == storeButton){ 
				if (mealsField.getText().equals("Plithos Geumatwn (1,2,3)")){
					// an to mealsField den allakse tha kataskeuasei Booking object
					// sthn selectedHotel swnoume th timh pou exei epileksei o xrhsths apo th jlist
					String selectedHotel = listView.getSelectedValue().toString();
					for (Hotel h : hotelsFromSerFile){
						if (h.getName().equals(selectedHotel)){
							// to Integer.parseInt(daysField.getText()) metatrepei to String pou plhktrologise o xrhsths st gui se int
							h.addBooking(new Booking(Integer.parseInt(daysField.getText())));
							System.out.println("Booking object created for the Hotel: " + h.getName());
						}					
					}				
				} else {
					// an allakse shmainei oti o xrhsths thelei na kataxwrisei AllInclusive object
					String selectedHotel = listView.getSelectedValue().toString();
					for (Hotel h : hotelsFromSerFile){
						if (h.getName().equals(selectedHotel)){
							// to Integer.parseInt(daysField.getText()) metatrepei to String pou plhktrologise o xrhsths st gui se int
							int daysNum = Integer.parseInt(daysField.getText());
							int mealsNum = Integer.parseInt(mealsField.getText());
							h.addBooking(new AllInclusive(daysNum, mealsNum));
							System.out.println("AllInclusive object created for the Hotel: " + h.getName());
						}					
					}
				}
				
				load.serializingHotels(hotelsFromSerFile, "hotels_2.ser");
				
			} else if (e.getSource() == calculateCostButton){
				
				String selectedHotel = listView.getSelectedValue().toString();
				for (Hotel h : hotelsFromSerFile){
					if (h.getName().equals(selectedHotel)){
						costField.setText(h.getCostOfAllBookings());
					}					
				}	
			}			
		}
	}
}
