package com.jiker.unit2;

public class WildGoose extends Bird implements IFly {

    private IFly flier;

    public WildGoose() {
        this.flier = new FlyImpl(this.getName());
    }

    @Override
    public String getName() {
        return "WildGoose";
    }

    @Override
    public void fly(String time) {
        this.flier.fly(time);
    }
}
