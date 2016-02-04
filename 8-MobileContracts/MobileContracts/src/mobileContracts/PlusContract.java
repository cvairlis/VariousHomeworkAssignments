package mobileContracts;

public class PlusContract extends Contract{

	private double mBytes;

	public PlusContract(String customerName, String customerPhoneNumber, double speechTime, int numberOfSms, double mBytes) {
		super(customerName, customerPhoneNumber, speechTime, numberOfSms);
		this.mBytes = mBytes;
		setCost(0.04*speechTime + 0.01*numberOfSms + 0.02*mBytes);
	}

	public double getmBytes() {
		return mBytes;
	}

	public void setmBytes(double mBytes) {
		this.mBytes = mBytes;
	}

	public String toString() {
		return "PlusContract [customerName=" + super.getCustomerName()
				+ ", customerPhoneNumber=" + super.getCustomerPhoneNumber()
				+ ", speechTime=" + super.getSpeechTime() + ", numberOfSms=" + super.getNumberOfSms()
				+ ", mBytes=" + mBytes
				+ ", cost=" + super.getCost() + "]";
	}
	
	
}
