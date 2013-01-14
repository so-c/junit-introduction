package chapter18.practice3;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CounterTest {
	private static Counter counter;

	public static class InitialState {
		@Before
		public void setUp() {
			counter = new Counter();
		}

		@Test
		public void testIncrement_return_1_when_first_call() {
			assertThat(counter.increment(), is(1));
		}

	}

	public static class OneceIncremented {
		@Before
		public void setUp() {
			counter = new Counter();
			counter.increment();
		}

		@Test
		public void testIncrement_return_1_when_second_call() throws Exception {
			assertThat(counter.increment(), is(2));
		}
	}

	public static class FiftyTimesIncremented {
		@Before
		public void setUp() {
			counter = new Counter();
			for (int i = 0; i < 50; i++) {
				counter.increment();
			}
		}

		@Test
		public void testIncrement_return_2_when_51th_call() throws Exception {
			assertThat(counter.increment(), is(51));
		}
	}

}
