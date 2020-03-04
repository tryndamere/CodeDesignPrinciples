package com.jiker.unit2;

public class PrintFormatter {

    private PrintFormatter() {}

    public static void print(String time, String name, String action) {
        System.out.printf("It's %s, I'm %s, I'm %s \n", time, name, action);
    }
}
