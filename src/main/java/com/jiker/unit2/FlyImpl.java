package com.jiker.unit2;

public class FlyImpl implements IFly {

    private String action;

    private String name;

    public FlyImpl(String name) {
        this.name = name;
    }

    @Override
    public void fly(String time) {
        this.action = "flying";
        PrintFormatter.print(time, this.name, this.action);
    }

}
