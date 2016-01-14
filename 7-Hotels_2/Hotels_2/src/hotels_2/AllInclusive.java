package hotels_2;

public class AllInclusive extends Booking {
	
	private int numberOfMealsPerDay;

	public AllInclusive(int days, int numberOfMealsPerDay) {
		super(days);
		this.numberOfMealsPerDay = numberOfMealsPerDay;
		super.setCost(days*(120+numberOfMealsPerDay*30));
	}

	public int getNumberOfMealsPerDay() {
		return numberOfMealsPerDay;
	}

	public void setNumberOfMealsPerDay(int numberOfMealsPerDay) {
		this.numberOfMealsPerDay = numberOfMealsPerDay;
	}

	@Override
	public String toString() {
		return super.toString() + " AllInclusive [numberOfMealsPerDay=" + numberOfMealsPerDay;
	}
	
	
	
	
}
