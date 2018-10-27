package com.wchah.feedle.services

import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.MealFood

import java.sql.Timestamp

interface MealService {
    Boolean putMealIntoDb(Meal meal)

    List<Meal> getAllMealsByUserIdSince(Long userId, String time)
}
