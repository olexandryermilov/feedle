package com.wchah.feedle.domain

class MealFood implements Serializable {
    Food food
    Meal meal
    MealFood(){

    }

    MealFood(Meal meal, Food food){
        this.meal = meal
        this.food = food
    }

    Food getFood() {
        return food
    }

    void setFood(Food food) {
        this.food = food
    }

    Meal getMeal() {
        return meal
    }

    void setMeal(Meal meal) {
        this.meal = meal
    }

    @Override
    public String toString() {
        return "MealFood{" +
                "food=" + food +
                ", meal=" + meal +
                '}';
    }
}
