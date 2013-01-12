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

}
