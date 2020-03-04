package com.jiker.unit1;

import java.util.stream.Collectors;

public class TextPrint extends WeekdayCalendarPrinter {

    public TextPrint(String dateStr) {
        super(dateStr);
    }

    @Override
    public void print() {
        System.out.println(this.chineseWeekdayName.stream().collect(Collectors.joining("\t")));
        System.out.println(this.weekDays.stream().collect(Collectors.joining("\t")));
    }

}
