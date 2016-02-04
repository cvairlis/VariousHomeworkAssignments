package mobileContracts;

public class Main {

	public static void main(String[] args) {
		//new AddCustomerForm();
		
		Contract c = new Contract("pelatis1", "2314241", 500, 500);
		System.out.println(c.toString());
		
		Contract p = new PlusContract("pelatis2", "2314241", 500, 500, 200);
		System.out.println(p.toString());
	}

}
