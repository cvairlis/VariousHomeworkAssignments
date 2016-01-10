package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

import classes.Client;
import classes.PrePaidCardClient;
import classes.Subscriber;

public class ReadWriteToTxtFile {
	
	public ReadWriteToTxtFile(){}	
	
	public ArrayList<Client> readFromTxtFile(){
		ArrayList<Client> clients = new ArrayList<>();
		int num = 0;
		for (String path : textFiles()){	
			// Prosoxh edw gia na elegxoume an ena String einai iso me ena allo xrhsimopoioume th methodo equals kai oxi to ==
			if (path.equals("subscribers.txt")){				
				num = 0;
			} else if (path.equals("prepaidcardclients.txt")){
				num = 1;
			}
			Scanner s = null;
			try {				
				s = new Scanner(new BufferedReader(new FileReader(path)));
				while(s.hasNextLine()){
					String line = s.nextLine();
					clients.add(createClientFromTxtLines(line, num));
				}				
			} catch (FileNotFoundException e) {
				System.out.println("File not found !");
			} catch (NumberFormatException e) {
				System.out.println("Grade must be an integer !");
			} finally { if(s != null) s.close();}	
		}		
		return clients;		
	}
	
	
	private Client createClientFromTxtLines(String line, int num){
		StringTokenizer st = new StringTokenizer(line,",");
		String name = st.nextToken();
		String contract = st.nextToken();
		contract = contract.trim(); //Returns a copy of the string, with leading and trailing whitespace omitted.
		int contractNum = Integer.parseInt(contract);
		// Prosoxh edw gia na elegxoume an ena int einai iso me ena allo xrhsimopoioume to == kai oxi th methodo equals
		if (num==0) return new Subscriber(name, contractNum);
		else return new PrePaidCardClient(name, contractNum);		
	}
	
	private ArrayList<String> textFiles() {
		  ArrayList<String> textFiles = new ArrayList<String>();
		  File dir = new File(System.getProperty("user.dir"));
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".txt"))) {
		      textFiles.add(file.getName());
		    }
		  }
		  return textFiles;
	}
	
	public void writeToTxtFile(ArrayList<Client> clients, String str){
		String filePath = currentDateToString();
		filePath = filePath + "_" + str;
		sortByName(clients);		
		File file = new File(filePath);
		FileOutputStream fop = null;		
		try {
			fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}			
			for (Client c : clients){
				//System.out.println(c.getStringRepresentationToTxt());
				byte[] contentInBytes = c.getStringRepresentationToTxt().getBytes();
				fop.write(contentInBytes);
				fop.write("\n".getBytes());
			}
			
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	private String currentDateToString() {
		Calendar cal = Calendar.getInstance();
		String DATE_FORMAT_NOW = "dd-MM-yyyy_HH-mm-ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	
	public void sortByName (ArrayList<Client> clients){		
		Collections.sort(clients, new Comparator<Client>() {
			public int compare(Client c1, Client c2){
				return c1.getSurname().compareTo(c2.getSurname());
			}
		});
	}
	
}
