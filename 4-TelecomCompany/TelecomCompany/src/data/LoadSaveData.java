package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import classes.TelecomCompany;

public class LoadSaveData {
	
	private String pathCompany = "company.ser";
	private ReadWriteToTxtFile readFromTxtFile = new ReadWriteToTxtFile();
	
	public LoadSaveData(){
		
		if (!saveFileExists(pathCompany)) {			
			TelecomCompany company = new TelecomCompany("MIND");
			company.setClients(readFromTxtFile.readFromTxtFile());
			serializingCompany(company);
		}		
	}
	
	
	public void serializingCompany(TelecomCompany _company) {		
		try {
			FileOutputStream fileOut = new FileOutputStream(pathCompany);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(_company);
			out.close();
			fileOut.close();			
		} catch (IOException io){
			io.printStackTrace();
		} finally {
			System.out.println("Serializing Company attempted.");
		}
	}
	
	
	public TelecomCompany deserializingCompany() {
		TelecomCompany company = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathCompany);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			company = (TelecomCompany) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException io){
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("Deserializing Company attempted.");
		return company;
	}
	
	public boolean saveFileExists(String serFileName){
		File f = new File(serFileName);
		return f.exists();
	}

}
