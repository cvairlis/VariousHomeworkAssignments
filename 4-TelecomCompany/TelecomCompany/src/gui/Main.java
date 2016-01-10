package gui;

public class Main {
	
	private static ApplicationFrame frame;
	
	public static void main(String[] args) {
		setFrame(new ApplicationFrame());
	}

	public static ApplicationFrame getFrame() {
		return frame;
	}

	public static void setFrame(ApplicationFrame frame) {
		Main.frame = frame;
	}
}
