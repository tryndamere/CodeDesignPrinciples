package com.jiker.unit1;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class ConsoleCalendar {

    protected List<String> chineseWeekdayName = new ArrayList<>(6);

    protected List<String> weekDays = new ArrayList<>(6);

    public ConsoleCalendar(String dateStr) {
        this.addWeekDays2Print(DateTime.parse(dateStr).dayOfWeek().withMinimumValue().minusDays(1));
    }

    private void addWeekDays2Print(DateTime startDate) {
        for (int i = 0; i < 7; i++) {
            this.chineseWeekdayName.add(startDate.plusDays(i).dayOfWeek().getAsShortText(Locale.CHINESE).substring(1));
            this.weekDays.add(startDate.plusDays(i).dayOfMonth().getAsShortText());
        }
    }

    public abstract void print();

}
