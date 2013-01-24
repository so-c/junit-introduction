package chapter20.practice1;

import java.util.Calendar;

public class MonthlyCalendar {

    private final Calendar calendar;

    public MonthlyCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getRemainingDays() {
        return calendar.getActualMaximum(Calendar.DATE) - calendar.get(Calendar.DATE);
    }

}
