package com.wchah.feedle.services

import com.wchah.feedle.domain.Food
import com.wchah.feedle.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultFoodService implements FoodService {
    private final FoodRepository foodRepository
    @Autowired
    DefaultFoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository
    }

    @Override
    List<Food> getAllFoods() {
        foodRepository.findAll()
    }

    @Override
    def addFood(Food food) {
        food.setId(null)
        foodRepository.save(food)
    }

    @Override
    Food getFoodById(Long id){
        foodRepository.getOne(id)
    }
}
