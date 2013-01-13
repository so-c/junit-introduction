package chapter18.practice1;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void testToSnakeCase_return_aaa_when_input_aaa() {
		String expected = "aaa";
		String actual = StringUtils.toSnakeCase("aaa");
		assertThat(actual, is(expected));
	}

	@Test
	public void testToSnakeCase_return_hello_world_when_input_HelloWorld() {
		String expected = "hello_world";
		String actual = StringUtils.toSnakeCase("HelloWorld");
		assertThat(actual, is(expected));
	}

	@Test
	public void testToSnakeCase_return_practice_junit_when_input_PracticeJunit() {
		String expected = "practice_junit";
		String actual = StringUtils.toSnakeCase("PracticeJunit");
		assertThat(actual, is(expected));
	}
}
