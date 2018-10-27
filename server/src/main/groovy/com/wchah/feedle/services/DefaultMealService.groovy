package com.wchah.feedle.services

import com.wchah.feedle.domain.Meal
import com.wchah.feedle.repository.MealsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultMealService implements MealService{

    private final MealsRepository mealRepository
    @Autowired
    DefaultMealService(MealsRepository mealRepository){
        this.mealRepository = mealRepository
    }

    @Override
    Boolean putMealIntoDb(Meal meal) {
        try{
            mealRepository.save(meal)
        }
        catch (Exception e){
            return false
        }
        return true
    }

    @Override
    List<Meal> getAllMeals(Long userId) {
        return mealRepository.findById()
    }
}
