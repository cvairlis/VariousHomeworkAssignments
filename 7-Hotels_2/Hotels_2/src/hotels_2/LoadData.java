package hotels_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LoadData {
	
	private String pathHotels = "hotels_2.ser";
		
	public LoadData(){ 
		if (!saveFileExists(pathHotels)){
			Hotel h1 = new Hotel("Bellevue");
			Hotel h2 = new Hotel("Hermes");
			Hotel h3 = new Hotel("CityHotel");
			Hotel h4 = new Hotel("Panorama");
			
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			hotels.add(h1);
			hotels.add(h2);
			hotels.add(h3);
			hotels.add(h4);
			
			serializingHotels(hotels, pathHotels);	
			
		}
	}
		
	public void serializingHotels(ArrayList<Hotel> _hotels, String path) {		
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
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
	public ArrayList<Hotel> deserializingHotels(String path) {
		ArrayList<Hotel> hotels = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
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
