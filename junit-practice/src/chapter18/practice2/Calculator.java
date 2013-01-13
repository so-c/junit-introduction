package chapter18.practice2;

public class Calculator {
	public int divide(int divided, int dividee) {
		if (dividee == 0) {
			throw new IllegalArgumentException("divided by zero.");
		}
		return divided / dividee;
	}
}
