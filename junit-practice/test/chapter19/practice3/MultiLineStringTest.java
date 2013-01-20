package chapter19.practice3;

import static matcher.MultiLineStringMatcher.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MultiLineStringTest {
    @Test
    public void joinで文字列が連結される() throws Exception {
        // SetUp
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("World");
        String expected = stringBuilder.toString();
        // Exercise
        String actual = MultiLineString.join("Hello", "World");
        // Verify
        assertThat(actual, is(text(expected)));
    }
}
