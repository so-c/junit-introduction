package chapter18.practice6;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class BackgroundTaskTest {

    @Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void invokeで別スレッドで実行される() throws Exception {
        // SetUp
        final AtomicReference<String> backGroundThreadName =
                new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                backGroundThreadName.set(Thread.currentThread().getName());
                latch.countDown();
            }
        };

        BackgroundTask sut = new BackgroundTask(task);

        // Exercise
        sut.invoke();
        latch.await();

        // Verify
        assertThat(backGroundThreadName.get(),
                   is(not(Thread.currentThread().getName())));
    }
}
