package chapter20.practice1;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class MonthlyCalendarTest {
    @Test
    public void testGetRemainingDays_現在時刻が20120131の場合0を返す() throws Exception {
        // SetUp
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 31));
        // Exercise
        // Verify
        assertThat(sut.getRemainingDays(), is(0));
    }

    @Test
    public void testGetRemainingDays_現在時刻が20120130の場合1を返す() throws Exception {
        // SetUp
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 30));
        // Exercise
        // Verify
        assertThat(sut.getRemainingDays(), is(1));
    }
    
    @Test
    public void testGetRemainingDays_現在時刻が20120201の場合28を返す() throws Exception {
        // SetUp
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 2, 1));
        // Exercise
        // Verify
        assertThat(sut.getRemainingDays(), is(28));
    }

    private Calendar newCalendar(int year, int month, int date) {
        Calendar result = Calendar.getInstance();
        result.clear();
        result.set(year, month - 1, date, 0, 0, 0);
        result.set(Calendar.MILLISECOND, 0);
        return result;
    }

}
