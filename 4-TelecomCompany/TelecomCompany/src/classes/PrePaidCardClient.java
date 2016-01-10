package classes;

public class PrePaidCardClient extends Client {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 13562L;
	
	private int remainingUnits;

	public PrePaidCardClient(String surname, int remainingUnits) {
		super(surname);
		this.remainingUnits = remainingUnits;
	}

	public int getRemainingUnits() {
		return remainingUnits;
	}

	public void setRemainingUnits(int remainingUnits) {
		this.remainingUnits = remainingUnits;
	}
	
	@Override
	public String toString() {
		return "Client: " + getSurname() + " is a PrePaidCardClient with remaining " + remainingUnits + " units.";
	}
	
	public void printInfo(){
		System.out.println("Client: " + getSurname() + " is a PrePaidCardClient with remaining " + remainingUnits + " units.");		
	}

	@Override
	public String getStringRepresentationToTxt() {
		return getSurname() + ", " + getRemainingUnits() + "\r";
	}
	

}
