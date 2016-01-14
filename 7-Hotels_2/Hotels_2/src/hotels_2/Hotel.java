package hotels_2;
import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
	
	private String name;
	private ArrayList<Booking> bookings = new ArrayList<>();

	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBooking(Booking b){
		bookings.add(b);
	}
	
	public String getCostOfAllBookings(){
		double cost = 0;
		for (Booking b : bookings){
			cost+=b.getCost();
		}
		return String.valueOf(cost);
	}
}
