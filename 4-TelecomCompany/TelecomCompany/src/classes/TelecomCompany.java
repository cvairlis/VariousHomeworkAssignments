package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class TelecomCompany implements Serializable {
	
	private static final long serialVersionUID = 132561L;
	
	private String name;
	private ArrayList<Client> clients = new ArrayList<>();
	
	public TelecomCompany(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "TelecomCompany [name=" + name + ", clients=" + clients + "]";
	}
	
	
	
	public void addClient(Client c){
		clients.add(c);		
	}
	
	
	
}