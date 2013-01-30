package chapter20.practice6;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;

public class HelloWorldTest {
    @Rule
    public SysoutSpy sysoutSpy = new SysoutSpy();

    @Test
    public void outputにHelloWorldが出力される() throws Exception {
        // SetUp
        HelloWorld sut = new HelloWorld();
        // Exercise
        sut.say();
        // Verify
        verify(sysoutSpy.spy).println("Hello World");
    }
    
    class SysoutSpy implements TestRule {
        PrintStream spy;
        @Override
        public Statement apply(final Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    PrintStream out = System.out;
                    spy = Mockito.spy(out);
                    try {
                        System.setOut(spy);
                        base.evaluate();
                    } finally {
                        System.setOut(out);
                    }
                }
            };
        }

    }
    
}
