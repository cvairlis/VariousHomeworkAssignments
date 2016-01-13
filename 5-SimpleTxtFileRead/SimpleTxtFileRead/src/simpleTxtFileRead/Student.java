package simpleTxtFileRead;


public class Student {


	private String name;
	private int am;
	private int numberOfTitles;
	
	
	public Student(String name, int am) {
		super();
		this.name = name;
		this.am = am;
	}
	public Student(String name, int am, int numberOfTitles) {
		super();
		this.name = name;
		this.am = am;
		this.numberOfTitles = numberOfTitles;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAm() {
		return am;
	}
	public void setAm(int am) {
		this.am = am;
	}
	public int getNumberOfTitles() {
		return numberOfTitles;
	}
	public void setNumberOfTitles(int numberOfTitles) {
		this.numberOfTitles = numberOfTitles;
	}

	public String toString() {
		if (numberOfTitles==0){
			return "O foithths " + name + " exei arithmo mhtrwou " + am + " Den katexei mexri twra kanena ptyxio.";
		} else {
			return "O foithths " + name + " exei arithmo mhtrwou " + am + ". Einai epipleon metaptyxiakos foithths kai meta to peras ths trexousas foithshs tou tha katexei synolika " + (numberOfTitles+1) + " ptyxia.";
		}
	}
	
	public void printInfo(){
		if (numberOfTitles==0){
			System.out.println("O foithths " + name + " exei arithmo mhtrwou " + am + " Den katexei mexri twra kanena ptyxio.");
		} else {
			System.out.println("O foithths " + name + " exei arithmo mhtrwou " + am + ". Einai epipleon metaptyxiakos foithths kai meta to peras ths trexousas foithshs tou tha katexei synolika " + (numberOfTitles+1) + " ptyxia.");
		}	
	}
}
