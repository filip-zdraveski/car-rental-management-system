/**
 * This class contains the main method .
 * It calls a function called run() which is used to the entire program
 */
public class Start {
	public static void main(String[] args) throws Exception {
		ThriftyRentSystem rentSystem = new ThriftyRentSystem();
		rentSystem.run();
	}
}