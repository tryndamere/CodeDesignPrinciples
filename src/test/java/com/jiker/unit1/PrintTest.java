package com.jiker.unit1;

import org.junit.Test;

public class PrintTest {

    @Test
    public void should_print_calendar_show_day_weekend() {
        ConsoleCalendar text = new TextPrint("2020-02-21");
        text.print();

        ConsoleCalendar html = new HtmlPrint("2020-02-21");
        html.print();
    }
}
