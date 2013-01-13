package chapter18.practice2;

import org.junit.Test;

public class CalculatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testDivide_throw_Exception_when_dividee_is_zero() {
		new Calculator().divide(1, 0);
	}

}
