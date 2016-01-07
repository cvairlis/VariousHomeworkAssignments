package thema2;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Course {
	
	private String name;
	private int grade;
	// ypoxrewtiko h epiloghs
	private char kind;
	
	public Course(){}
	
	public Course(String name, int grade, char kind) {
		super();
		this.name = name;
		this.grade = grade;
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public char getKind() {
		return kind;
	}

	public void setKind(char kind) {
		this.kind = kind;
	}

	public String toString() {
		return name + ", " + grade + " : " + kind;
	}
	
	public void sortByName (ArrayList<Course> courses, boolean asc){		
		Collections.sort(courses, new Comparator<Course>() {
			public int compare(Course c1, Course c2){
				if (asc){
					return c1.name.compareTo(c2.name);
				} else {
					return -c1.name.compareTo(c2.name);
				}
				
			}
		});
	}
	
	public void sortByGrade (ArrayList<Course> courses, boolean asc){		
		Collections.sort(courses, new Comparator<Course>() {
			public int compare(Course c1, Course c2){
				if (asc){
					if (c1.grade > c2.grade){
						return 1;
					} else if (c1.grade < c2.grade) {
						return -1;
					}
					return 0;
				} else {
					if (c1.grade > c2.grade){
						return -1;
					} else if (c1.grade < c2.grade) {
						return 1;
					}
					return 0;
				}			
			}
		});
	}
	
	public String getAverage(ArrayList<Course> courses){
		int sum = 0; 
		for (Course c: courses){
			sum += c.getGrade();
		}		
		double avg = (double) sum/courses.size();		
	    String avgFormatted = new DecimalFormat("#.00").format(avg);	    
		return avgFormatted;
	}
	
	public String getRemaining(ArrayList<Course> courses, String kind){
		int remaining = 0;
		if (kind=="Mandatory"){
			int mandCounter = 0;
			for (Course c : courses){
				if (c.getKind()=='Õ'){
					mandCounter++;
				}
			}
			remaining = (int) 36 - mandCounter;			
		} else if (kind == "Elective") {
			int elecCounter = 0;
			for (Course c : courses){
				if (c.getKind()=='Å'){
					elecCounter++;
				}
			}
			remaining = 12 - elecCounter;			
		}
		return Integer.toString(remaining);
	}
	
}