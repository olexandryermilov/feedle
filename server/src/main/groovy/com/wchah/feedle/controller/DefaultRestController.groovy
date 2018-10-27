package com.wchah.feedle.controller

import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.MealFood
import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.domain.User
import com.wchah.feedle.services.FoodService
import com.wchah.feedle.services.MealService
import com.wchah.feedle.services.StatisticsService
import com.wchah.feedle.services.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import java.sql.Timestamp

@Controller
class DefaultRestController implements RestController {

    Logger logger = LoggerFactory.getLogger(DefaultRestController.class)
    @Autowired
    MealService mealService
    @Autowired
    FoodService foodService
    @Autowired
    StatisticsService statisticsService
    @Autowired
    UserService userService

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
    @RequestMapping(value = "/stats/{userId}/{time}")
    @ResponseBody
    Statistics getStatistics(@PathVariable long userId, @PathVariable(required = false) Long time) {
        logger.info(time.toString())
        if (time == null) statisticsService.getStatisticsForUser(userId)
        else statisticsService.getStatisticsForUserSinceTimestamp(userId, new Timestamp(new Timestamp(new Date().getTime()).time - time))
    }

    @Override
    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    Integer getUserType(@PathVariable Long userId) {
        userService.getUserType(userId)
    }

    @Override
    @PostMapping(value = "/users/{userId}")
    def createUser(@PathVariable Long userId, @RequestBody(required = false) User user) {
        logger.info(user.toString())
        if (user == null) userService.createUser(userId)
        else userService.updateUser(userId, user)
    }

    @Override
    @GetMapping(value = "/user/{userId}")
    @ResponseBody
    User getUserInfo(@PathVariable Long userId) {
        userService.getUser(userId)
    }

    @Override
    @PostMapping(value = "/food")
    @ResponseBody
    def createFood(@RequestBody Food food, @RequestHeader Long userId) {
        if (getUserType(userId) == 2)
            foodService.addFood(food)
        else
            HttpStatus.FORBIDDEN
    }

    @Override
    @GetMapping(value = "meals/{userId}/{time}")
    @ResponseBody
    def getAllMealsForUser(@PathVariable("userId") Long userId, @PathVariable(required = false) Long time) {
        List<Meal> meals = mealService.getAllMealsByUserIdSince(userId, new Timestamp(new Timestamp(new Date().getTime()).time - time))
        List<MealFood> mealFood = meals.stream().map{ meal -> new MealFood(meal, foodService.getFoodById(meal.foodId))}.collect { x -> x} as List<MealFood>
        mealFood
    }
}
