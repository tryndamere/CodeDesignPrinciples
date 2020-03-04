package com.jiker.unit2;

import java.util.List;

public class Schedule {

    private List<Bird> scheduleBirds;

    public Schedule(List<Bird> scheduleBirds) {
        this.scheduleBirds = scheduleBirds;
    }

    public void print() {
        this.sevenTask();
        this.eightTask();
        this.nineTask();
        this.tenTask();
        this.elevenTask();
    }

    public void sevenTask() {
        this.scheduleBirds.forEach(bird -> bird.eat("7:00"));
    }

    public void eightTask() {
        this.scheduleBirds.forEach(bird -> bird.walk("8:00"));
    }

    public void nineTask() {
        this.scheduleBirds.forEach(bird -> bird.perform("9:00"));
    }

    public void tenTask() {
        this.scheduleBirds.stream()
                .filter(bird -> bird instanceof IFly)
                .forEach(bird -> ((IFly) bird).fly("10:00"));
    }

    public void elevenTask() {
        this.scheduleBirds.stream()
                .filter(bird -> bird instanceof ISwim)
                .forEach(bird -> ((ISwim)bird).swim("11:00"));
    }
}
