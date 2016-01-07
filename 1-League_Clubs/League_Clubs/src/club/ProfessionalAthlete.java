package club;

public class ProfessionalAthlete extends Athlete {
	
	private double money;

	public ProfessionalAthlete(String name, int age, double money) {
		super(name, age);
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String toString() {
		return super.toString() + " - " + money;
	}
	
	public void printAthleteInformation(){
		super.printAthleteInformation();
		System.out.println("    Additionally " + getName() + " is a professional athlete.");
		System.out.println("    So it takes " + money + " euros per year.");
	}	
}
