package hotels_2;
import java.io.Serializable;


public class Hotel implements Serializable {
	
	private String name;

	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
