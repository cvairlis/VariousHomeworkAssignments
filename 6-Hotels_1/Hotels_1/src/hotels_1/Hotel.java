package hotels_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hotel implements Serializable {

	private String name;
	private int stars;
	private ArrayList<Booking> bookings = new ArrayList<>();
	
	public Hotel(){}

	public Hotel(String name, int stars) {
		super();
		this.name = name;
		this.stars = stars;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public void addBooking(Booking booking){
		bookings.add(booking);		
	}
	
	@Override
	public String toString() {
		return "- " + name + " Hotel, " + stars + " stars." + " Number of bookings=" + bookings.size() + ".";
	}
	
	public void printInfo(){
		System.out.println(toString());
		System.out.println("  "+ name + " Hotel " + "Bookings:");
		for (Booking b : bookings){
			System.out.println(b.toString());
		}
	}
	
	public void sortByName (ArrayList<Hotel> hotels){		
		Collections.sort(hotels, new Comparator<Hotel>() {
			public int compare(Hotel h1, Hotel h2){
				return h1.name.compareTo(h2.name);				
			}
		});
	}
	
	

}
