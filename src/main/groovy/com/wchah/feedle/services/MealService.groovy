package com.wchah.feedle.services

import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal

interface MealService {
    Boolean putMealIntoDb(Meal meal)

    List<Meal> getAllMeals(Long userId)
}
