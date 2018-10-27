package com.wchah.feedle.services

import com.wchah.feedle.domain.Food

interface FoodService {
    List<Food> getAllFoods()
    def addFood(Food food)
    Food getFoodById(Long id)
}
