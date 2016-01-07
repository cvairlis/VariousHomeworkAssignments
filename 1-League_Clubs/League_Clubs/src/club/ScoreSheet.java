package club;

public class ScoreSheet {
	
	private String date;
	private double takeTime;
	
	public ScoreSheet(String date, double takeTime) {
		super();
		this.date = date;
		this.takeTime = takeTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(double takeTime) {
		this.takeTime = takeTime;
	}

	public String toString() {
		return "ScoreSheet:" + date + ", " + takeTime;
	}
	
	public void printScoreSheetInformation(){
		System.out.println("    - At " + date + ", took time " + takeTime + " minutes.");
	}
	

}
