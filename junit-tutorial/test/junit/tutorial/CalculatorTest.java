package junit.tutorial;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testMultiplyCanGetResult() {
		Calculator calculator = new Calculator();
		int expected = 12;
		int actual = calculator.multiply(3, 4);
		assertThat(actual, is(expected));
	}

	@Test
	public void testDivideCanGetResultUsingIntValues() {
		Calculator calculator = new Calculator();
		float expected = 1.5f;
		float actual = calculator.divide(3, 2);
		assertThat(actual, is(expected));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDivideThrowExceptionWhenDividedByZero() {
		Calculator calculator = new Calculator();
		calculator.divide(5, 0);
	}
	
}
