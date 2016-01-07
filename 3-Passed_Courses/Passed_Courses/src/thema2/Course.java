package thema2;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Auth h klash montelopoiei thn ontothta Mathima - Course.
 *  
 *
 */
public class Course {
	
	private String name;
	private int grade;
	// ypoxrewtiko h epiloghs
	private char kind;
	
	/**
	 * Prwtos kataskeuasths
	 */
	public Course(){}
	
	/**
	 * Deuteros kataskeuasths
	 */
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
	
	/**
	 * H methodos auth kaleitai apo to ApplicationFrame.
	 * Dexetai 2 parametrous mia ArrayList me mathimata kai mia boolean timh.
	 * H methodos ousiastika taksinomei thn lista me ta mathimata ws pros to onoma tou kathe mathimatos.
	 * Gia auksouksa taksinomish pername true sthn parametro boolean.
	 * Gia fthinousa taksinomish pername false sthn parametro boolean. 
	 * Einai void pou shmainei oti den epistrefei tpt.
	 * Anti aftou "epistrefei" thn lista pou perasame san parametro taksinomhmenh. 
	 * 
	 * @param ArrayList<Course> courses
	 * @param asc
	 */
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
	
	/**
	 * H methodos auth kaleitai apo to ApplicationFrame.
	 * Dexetai 2 parametrous mia ArrayList me mathimata kai mia boolean timh.
	 * H methodos ousiastika taksinomei thn lista me ta mathimata ws pros to vathmo tou kathe mathimatos.
	 * Gia auksouksa taksinomish pername true sthn parametro boolean.
	 * Gia fthinousa taksinomish pername false sthn parametro boolean. 
	 * Einai void pou shmainei oti den epistrefei tpt.
	 * Anti aftou "epistrefei" thn lista pou perasame san parametro taksinomhmenh. 
	 * 
	 * @param ArrayList<Course> courses
	 * @param asc
	 */
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
	
	/**
	 * H methodos auth dexetai mia ArrayList me courses, vriskei to meso oro (average) twn vathmwn twn mathimatwn ths listas
	 * kai epistrefei th timh se String morfh me 2 dekadika strogylopoihmenh. 
	 * 
	 * @param ArrayList<Course> courses
	 * @return String avgFormatted
	 */
	public String getAverage(ArrayList<Course> courses){
		int sum = 0; 
		for (Course c: courses){
			sum += c.getGrade();
		}		
		double avg = (double) sum/courses.size();		
	    String avgFormatted = new DecimalFormat("#.00").format(avg);	    
		return avgFormatted;
	}
	
	/**
	 * H methodos auth dexetai mia ArrayList<Course> me mathimata kai ena String pou prosdiorizei to eidos tou kathe mathimatos (Y/E).
	 * Ypologizei posa mathimata apo kathe eidos apomenoun gia thn apokthsh ptyxiou. 
	 * Gia thn apokthsh ptyxiou oi foithtes prepei na exoun 36 ypoxrewtika mathimata perasmena (ektos Agglika) kai 12 epiloghs.
	 * Opote kathe fora pou ekteleitai h methodos auth px gia na vrei posa ypoxrewtika mathimata apomenoun:
	 * getRemaining(courses,"Mandatory") kai epistrefei ena String pou antiproswpeuei ton arithmo int, px apomenoun "10" mathimata.
	 * Omoiws gia epiloghs Elective.
	 * 
	 * @param ArrayList<Course> courses courses
	 * @param String kind
	 * @return String remaining
	 */
	public String getRemaining(ArrayList<Course> courses, String kind){
		int remaining = 0;
		if (kind=="Mandatory"){
			int mandCounter = 0;
			for (Course c : courses){
				if (c.getKind()=='Υ'){
					mandCounter++;
				}
			}
			remaining = (int) 36 - mandCounter;			
		} else if (kind == "Elective") {
			int elecCounter = 0;
			for (Course c : courses){
				if (c.getKind()=='Ε'){
					elecCounter++;
				}
			}
			remaining = 12 - elecCounter;			
		}
		return Integer.toString(remaining);
	}	
}