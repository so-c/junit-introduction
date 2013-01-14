package chapter18.practice4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberUtilsTest {

	@Test
	public void testIsEven_return_true_when_even() throws Exception {
		assertThat(NumberUtils.isEven(10),is(true));
	}
	
	@Test
	public void testIsEven_return_false_when_odd() throws Exception {
		assertThat(NumberUtils.isEven(7),is(false));
	}
	
}
