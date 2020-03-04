package com.jiker.unit2;

public class Swallow extends Bird implements IFly, ISwim {

    private IFly flier;

    private ISwim swimmer;

    public Swallow() {
        this.flier = new FlyImpl(this.getName());
        this.swimmer = new SwimImpl(this.getName());
    }

    @Override
    public String getName() {
        return "Swallow";
    }

    @Override
    public void fly(String time) {
        this.flier.fly(time);
    }

    @Override
    public void swim(String time) {
        this.swimmer.swim(time);
    }
}
