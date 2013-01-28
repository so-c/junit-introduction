package chapter20.practice5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class HelloServletTest {
    @Test
    public void doGetでリクエストパラメータを含むテキストを出力する() throws Exception {
        // SetUp
        HelloServlet sut = new HelloServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("JUnit");
        StringServletOutputStream output = new StringServletOutputStream();
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getOutputStream()).thenReturn(output);
        
        // Exercise
        sut.doGet(request, response);
        
        // Verify
        assertThat(output.getOutput(),is("Hello JUnit\r\n"));
        verify(response).setContentType("text/plain; charset=UTF-8");
        verify(response).flushBuffer();
    }
}
