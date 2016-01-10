package classes;

import java.io.Serializable;


public abstract class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 231L;
	private String surname;

	public Client(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public abstract String toString();
	public abstract void printInfo();
	public abstract String getStringRepresentationToTxt();
}
