package com.jiker.unit2;

public class Penguin extends Bird implements ISwim {

    private ISwim swimmer;

    public Penguin() {
        this.swimmer = new SwimImpl(this.getName());
    }

    @Override
    public String getName() {
        return "Penguin";
    }

    @Override
    public void swim(String time) {
        this.swimmer.swim(time);
    }
}
