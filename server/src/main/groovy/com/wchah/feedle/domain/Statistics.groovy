package com.wchah.feedle.domain

class Statistics {
    Integer water
    Integer calories

    Statistics() {
    }

    Statistics(Integer water, Integer calories) {

        this.water = water
        this.calories = calories
    }

    Integer getWater() {

        return water
    }

    void setWater(Integer water) {
        this.water = water
    }

    Integer getCalories() {
        return calories
    }

    void setCalories(Integer calories) {
        this.calories = calories
    }
}
