package chapter20.practice3;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class NetworkResourcesTest {
    
    @Test
    public void loadでネットワークから取得した文字列を返す() throws Exception {
        // SetUp
        String expected = "Hello World";
        NetworkLoader mockLoader = mock(NetworkLoader.class);
        ByteArrayInputStream input = new ByteArrayInputStream(expected.getBytes());
        when(mockLoader.getInput()).thenReturn(input);
        
        NetworkResources sut = new NetworkResources();
        sut.loader = mockLoader;
        
        // Exercise
        String actual = sut.load();
        
        // Verify
        assertThat(actual,is(expected));
    }

}
