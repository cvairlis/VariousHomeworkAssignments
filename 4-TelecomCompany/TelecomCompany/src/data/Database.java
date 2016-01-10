package data;

import java.util.ArrayList;

import classes.Client;
import classes.PrePaidCardClient;
import classes.Subscriber;
import classes.TelecomCompany;

public class Database {
	
	private TelecomCompany company;
	private LoadSaveData loadSave = new LoadSaveData();
	private ReadWriteToTxtFile writeToTxtFile = new ReadWriteToTxtFile();
	
	public Database(){
		updateInfo();
	}
	
	public TelecomCompany updateInfo(){
		company = loadSave.deserializingCompany();
		return company;
	}
	
	
	public String getCompanyInformation(){
		return company.getName();
	}
	
	public void printCompanyClients(){
		for (Client c: updateInfo().getClients()){
			System.out.println(c.toString());
		}
	}
	
	public ArrayList<Client> getSubscribers(){		
		ArrayList<Client> subs = new ArrayList<>();
		for (Client c : updateInfo().getClients()){			
			if (c instanceof Subscriber){
				subs.add(c);
			}
		}
		return subs;
	}
		
	public ArrayList<Client> getPrePaidCardClients(){
		ArrayList<Client> subs = new ArrayList<>();
		for (Client c : updateInfo().getClients()){
			if (c instanceof PrePaidCardClient){
				subs.add(c);
			}
		}
		return subs;
	}
	
	public void addClient(Client c){
		company.addClient(c);
		loadSave.serializingCompany(company);
	}
	
	public void exportClientsToTxtFile(){
		exportSubscribersToTxtFile(getSubscribers());
		exportPrePaidCardClientsToTxtFile(getPrePaidCardClients());
		
	}
	
	private void exportSubscribersToTxtFile(ArrayList<Client> subs){
		writeToTxtFile.writeToTxtFile(subs, "subscribers.txt");
	}
	
	private void exportPrePaidCardClientsToTxtFile(ArrayList<Client> pres){
		writeToTxtFile.writeToTxtFile(pres, "prepaidcardclients.txt");
	}
	

}
