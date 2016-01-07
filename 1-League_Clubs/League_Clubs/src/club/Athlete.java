package club;

import java.util.ArrayList;

public class Athlete {
	
	private String name;
	private int age;
	private ArrayList<ScoreSheet> scoresheets = new ArrayList<>();
	
	public Athlete(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void addScoreSheet(ScoreSheet sc){
		scoresheets.add(sc);
	}

	@Override
	public String toString() {
		return name + ", " + age;
	}
	
	public void printAthleteInformation(){
		System.out.println(" - " + name +", age: " + age);
		System.out.println("    Has the following scoresheets:");
		for (ScoreSheet s : scoresheets){
			s.printScoreSheetInformation();
		}
	}
	

}
