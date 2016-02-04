package mobileContracts;

public class Contract {
	
	private String customerName;
	private String customerPhoneNumber;
	private double speechTime;
	private int numberOfSms;
	private double cost;
	
	public Contract(String customerName, String customerPhoneNumber, double speechTime, int numberOfSms) {
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.speechTime = speechTime;
		this.numberOfSms = numberOfSms;
		setCost(0.05*speechTime + 0.01*numberOfSms);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public double getSpeechTime() {
		return speechTime;
	}

	public void setSpeechTime(double speechTime) {
		this.speechTime = speechTime;
	}

	public int getNumberOfSms() {
		return numberOfSms;
	}

	public void setNumberOfSms(int numberOfSms) {
		this.numberOfSms = numberOfSms;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return "Contract [customerName=" + customerName
				+ ", customerPhoneNumber=" + customerPhoneNumber
				+ ", speechTime=" + speechTime + ", numberOfSms=" + numberOfSms
				+ ", cost=" + cost + "]";
	}

	
	
	

}
