package com.wchah.feedle.controller

import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.services.FoodService
import com.wchah.feedle.services.MealService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class DefaultRestController implements RestController {

    Logger logger = LoggerFactory.getLogger(DefaultRestController.class);
    @Autowired
    MealService mealService
    @Autowired
    FoodService foodService

    @Override
    @PostMapping(path = "/meal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Boolean putFood(@RequestBody Meal meal) {
        logger.info(meal.toString())
        mealService.putMealIntoDb(meal)
    }

    @GetMapping(path = "/stats/{userid}")
    @ResponseBody List<Meal> getMeal(@RequestParam Long userId) {
        mealService.getAllMeals(userId)
    }

    @Override
    Statistics getFoodStats(String userId) {
        return null
    }

    @Override
    @GetMapping(path = "/foods")
    @ResponseBody List<Food> getAllFoodNames() {
        foodService.allFoods
    }
}
