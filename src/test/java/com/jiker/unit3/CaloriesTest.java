package com.jiker.unit3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaloriesTest {

    @Test
    public void should_calories_if_12years_110pound_male_height_5ft_1inch() {
        String result = new Calories.Builder()
                .isMale(true)
                .weight("110")
                .feet("5")
                .inches("1")
                .age("12")
                .build()
                .calc();
        Assertions.assertEquals("1464.3", result);
    }

    @Test
    public void should_calories_if_12years_110pound_female_height_5ft_1inch() {
        String result = new Calories.Builder()
                .isMale(false)
                .weight("110")
                .feet("5")
                .inches("1")
                .age("12")
                .build()
                .calc();
        Assertions.assertEquals("1358.3", result);
    }

}
