package classes;


public class Subscriber extends Client {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 152543L;
	
	private int contractDuration;

	public Subscriber(String surname, int contractDuration) {
		super(surname);
		this.contractDuration = contractDuration;
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}

	@Override
	public String toString() {
		return "Client: " + getSurname() + " is a Subscriber with contract duration " + contractDuration + " months.";
	}
	
	public void printInfo(){
		
		System.out.println("Client: " + getSurname() + " is a Subscriber with contract duration " + contractDuration + " months.");
	}

	@Override
	public String getStringRepresentationToTxt() {
		return getSurname() + ", " + getContractDuration() + "\r";
	}
	
	

	
}
