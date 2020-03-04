package com.jiker.unit2;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

    @Test
    public void should_schedule_animal_action() {
        Schedule schedule = new Schedule(Lists.newArrayList(new WildGoose(), new Swallow(), new Penguin()));
        schedule.print();
    }
}
