package com.jiker.unit2;

public class SwimImpl implements ISwim {

    private String action;

    private String name;

    public SwimImpl(String name) {
        this.name = name;
    }

    @Override
    public void swim(String time) {
        this.action = "swimming";
        PrintFormatter.print(time, this.name, this.action);
    }
}
