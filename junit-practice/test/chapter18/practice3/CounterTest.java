package chapter18.practice3;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {
	private Counter counter;

	@Before
	public void setUp() {
		this.counter = new Counter();
	}

	@Test
	public void testIncrement_return_1_when_first_call() {
		assertThat(counter.increment(), is(1));
	}

	@Test
	public void testIncrement_return_1_when_second_call() throws Exception {
		counter.increment();
		assertThat(counter.increment(), is(2));
	}

	@Test
	public void testIncrement_return_2_when_51th_call() throws Exception {
		for (int i = 0; i < 50; i++) {
			counter.increment();
		}
		assertThat(counter.increment(), is(51));
	}
}
