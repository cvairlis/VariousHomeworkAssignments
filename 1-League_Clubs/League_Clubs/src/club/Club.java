package club;

import java.util.ArrayList;

public class Club {
	
	private String name;
	private String place;
	private ArrayList<Athlete> athletes = new ArrayList<>();
	
	public Club(String name, String place) {
		super();
		this.name = name;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}

	public void setAthletes(ArrayList<Athlete> athletes) {
		this.athletes = athletes;
	}

	public void addAthlete(Athlete ath){
		athletes.add(ath);
	}

	@Override
	public String toString() {
		return name + ", " + place;
	}
	
	public void printClubInformation (){
		System.out.print("Club: " + toString() +"\n");
		for (Athlete athl : athletes){
			athl.printAthleteInformation();			
		}		
	}
}
