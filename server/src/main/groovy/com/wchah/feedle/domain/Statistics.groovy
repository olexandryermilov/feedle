package com.wchah.feedle.domain

class Statistics implements Serializable{
    Integer water
    Integer calories
    Integer points
    Statistics() {
    }

    Statistics(Integer water, Integer calories, Integer points) {
        this.water = water
        this.calories = calories
        this.points = points
    }

    Integer getPoints() {
        return points
    }

    void setPoints(Integer points) {
        this.points = points
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
