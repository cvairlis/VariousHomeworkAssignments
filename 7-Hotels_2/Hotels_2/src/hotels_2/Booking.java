package hotels_2;

import java.io.Serializable;

public class Booking implements Serializable {
	
	private int days;
	private double cost;
	
	public Booking(int days) {
		this.days = days;
		setCost(days*120);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return "Booking [days=" + days + ", cost=" + cost + "]";
	}

	
	
	

}
