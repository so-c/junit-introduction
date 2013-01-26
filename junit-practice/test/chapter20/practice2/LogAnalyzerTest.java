package chapter20.practice2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LogAnalyzerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void LogLoaderが例外を送出するときAnalyzeExceptionが最送出される() throws Exception {
        // SetUp
        LogAnalyzer sut = new LogAnalyzer();
        final IOException errorCause = new IOException("error by stub");
        LogLoader mockLoader = mock(LogLoader.class);
        sut.logLoader = mockLoader;
        when(mockLoader.load("test")).thenThrow(errorCause);

        expectedException.expect(LogAnalyzer.AnalyzeException.class);
        expectedException.expectMessage("error by stub");
        expectedException.expect(new BaseMatcher<Object>() {
            Throwable cause;

            @Override
            public boolean matches(Object item) {
                Throwable throwable = (Throwable) item;
                cause = throwable.getCause();
                return cause == errorCause;
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(cause);
            }
        });

        // Exercise
        sut.analyze("test");
    }

}
