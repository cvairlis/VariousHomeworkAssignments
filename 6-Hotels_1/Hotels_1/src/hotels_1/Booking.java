package hotels_1;

import java.io.Serializable;

public class Booking implements Serializable{
	
	private String roomName;
	private int days;
	
	public Booking(String room, int days) {
		this.roomName = room;
		this.days = days;
	}

	public String getRoom() {
		return roomName;
	}

	public void setRoom(String room) {
		this.roomName = room;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String toString() {
		return "  Booking [room=" + roomName + ", days=" + days + "]";
	}
	
	

}
