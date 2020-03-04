package com.jiker.unit2;

public abstract class Bird {

    private String action;

    public void eat(String time) {
        this.action = "eating";
        PrintFormatter.print(time, this.getName(), this.action);
    }

    public void walk(String time) {
        this.action = "walking";
        PrintFormatter.print(time, this.getName(), this.action);
    }

    public void perform(String time) {
        this.action = "performing";
        PrintFormatter.print(time, this.getName(), this.action);
    }

    public abstract String getName();

}
