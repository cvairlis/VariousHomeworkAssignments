package hotels_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LoadData {
	
	private String pathHotels = "hotels_1.ser";
		
	public LoadData(){ 
		if (!saveFileExists(pathHotels)){
			Hotel h1 = new Hotel("Alfa", 3);
			h1.addBooking(new Booking("A48", 3));
			h1.addBooking(new SpecialBooking("B22", 5));
			
			Hotel h2 = new Hotel("Vita", 3);
			h2.addBooking(new Booking("A64", 4));
			h2.addBooking(new SpecialBooking("F223", 4));
			
			Hotel h3 = new Hotel("Gama", 3);
			h3.addBooking(new Booking("F43", 7));
			h3.addBooking(new SpecialBooking("S14", 4));
			
			Hotel h4 = new Hotel("Delta", 4);
			
			h4.addBooking(new Booking("B34", 5));
			h4.addBooking(new SpecialBooking("V43", 8));
			
			ArrayList<Hotel> hotels = new ArrayList<>();
			hotels.add(h1);
			hotels.add(h2);
			hotels.add(h3);
			hotels.add(h4);
					
			serializingCompany(hotels);			
		}
	}
		
	public void serializingCompany(ArrayList<Hotel> _hotels) {		
		try {
			FileOutputStream fileOut = new FileOutputStream(pathHotels);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(_hotels);
			out.close();
			fileOut.close();			
		} catch (IOException io){
			io.printStackTrace();
		} finally {
			System.out.println("Serializing Hotels attempted.");
		}
	}
		
	@SuppressWarnings("unchecked")
	public ArrayList<Hotel> deserializingCompany() {
		ArrayList<Hotel> hotels = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathHotels);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			hotels = (ArrayList<Hotel>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException io){
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("Deserializing Hotels attempted.");
		return hotels;
	}
	
	private boolean saveFileExists(String serFileName){
		File f = new File(serFileName);
		return f.exists();
	}

}
