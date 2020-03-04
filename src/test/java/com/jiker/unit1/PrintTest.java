package com.jiker.unit1;

import org.junit.Test;

public class PrintTest {

    @Test
    public void should_print_calendar_show_day_weekend() {
        WeekdayCalendarPrinter text = new TextPrint("2020-02-21");
        text.print();

        WeekdayCalendarPrinter html = new HtmlPrint("2020-02-21");
        html.print();
    }
}
