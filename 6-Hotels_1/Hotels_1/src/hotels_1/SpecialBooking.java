package hotels_1;

public class SpecialBooking extends Booking {

	private static double completeFacilitiesPerDay = 25.0;
	private double specialBookingCost;
	
	public SpecialBooking(String room, int days) {
		super(room, days);
		setSpecialBookingCost(completeFacilitiesPerDay*days);
	}

	public static double getCompleteFacilitiesPerDay() {
		return completeFacilitiesPerDay;
	}

	public static void setCompleteFacilitiesPerDay(double completeFacilitiesPerDay) {
		SpecialBooking.completeFacilitiesPerDay = completeFacilitiesPerDay;
	}

	public double getSpecialBookingCost() {
		return specialBookingCost;
	}

	public void setSpecialBookingCost(double specialBookingCost) {
		this.specialBookingCost = specialBookingCost;
	}

	@Override
	public String toString() {
		return super.toString() + ". SpecialBookingCost " + specialBookingCost + " for " + super.getDays() + " days.";
	}	

}
