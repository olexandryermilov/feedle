package com.wchah.feedle.controller

import com.wchah.feedle.controller.RestController
import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.services.FoodService
import com.wchah.feedle.services.MealService
import com.wchah.feedle.services.StatisticsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import java.sql.Timestamp
import java.time.LocalDateTime

@Controller
class DefaultRestController implements RestController {

    Logger logger = LoggerFactory.getLogger(DefaultRestController.class)
    @Autowired
    MealService mealService
    @Autowired
    FoodService foodService
    @Autowired
    StatisticsService statisticsService

    @Override
    @PostMapping(path = "/meal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Boolean putFood(@RequestBody Meal meal) {
        logger.info(meal.toString())
        mealService.putMealIntoDb(meal)
    }

    /*@GetMapping(path = "/stats/{userid}")
    @ResponseBody
    List<Meal> getMeal(@RequestParam Long userId) {
        mealService.getAllMeals(userId)
    }*/


    @Override
    @GetMapping(path = "/foods")
    @ResponseBody
    List<Food> getAllFoodNames() {
        foodService.allFoods
    }

    @Override
    @RequestMapping(value = "stats/{userId}/{time}")
    @ResponseBody
    Statistics getStatistics(@PathVariable long userId, @PathVariable(required = false) Long time) {
        logger.info(time.toString())
        if(time==null) statisticsService.getStatisticsForUser(userId)
        else statisticsService.getStatisticsForUserSinceTimestamp(userId, new Timestamp(new Timestamp(new Date().getTime()).time-time))
    }
}
