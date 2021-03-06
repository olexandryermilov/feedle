package com.wchah.feedle.controller

import com.wchah.feedle.domain.Diet
import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.MealFood
import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.domain.User
import com.wchah.feedle.services.DietService
import com.wchah.feedle.services.FoodService
import com.wchah.feedle.services.MealService
import com.wchah.feedle.services.StatisticsService
import com.wchah.feedle.services.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

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
    @Autowired
    DietService dietService

    @Override
    @PostMapping(path = "/meal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Boolean putFood(@RequestBody Meal meal) {
        logger.info(meal.toString())
        mealService.putMealIntoDb(meal)
    }

    @Override
    @GetMapping(path = "/foods")
    @ResponseBody
    List<Food> getAllFoodNames() {
        foodService.allFoods
    }

    @Override
    @RequestMapping(value = ["/stats/{userId}/{timeStr}", "/stats/{userId}"])
    @ResponseBody
    Statistics getStatistics(@PathVariable long userId, @PathVariable(required = false) String timeStr) {
        logger.info(timeStr.toString())
        if (timeStr == null) statisticsService.getStatisticsForUser(userId)
        else statisticsService.getStatisticsForUserSinceTimestamp(userId, timeStr)
    }

    @Override
    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    Integer getUserType(@PathVariable Long userId) {
        userService.getUserType(userId)
    }

    @Override
    @PostMapping(value = "/users")
    @ResponseBody
    def createUser(@RequestBody(required = true) User user) {
        logger.info(user.toString())
        if (user == null) userService.createUser(user)
        else userService.updateUser(user)
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
            new ResponseEntity<>(HttpStatus.FORBIDDEN)
    }

    @Override
    @GetMapping(value = ["meals/{userId}/{time}","meals/{userId}"])
    @ResponseBody
    def getAllMealsForUser(@PathVariable("userId") Long userId, @PathVariable(required = false) String time) {
        List<Meal> meals = mealService.getAllMealsByUserIdSince(userId, time)
        List<MealFood> mealFood = meals.stream().map{ meal -> new MealFood(meal, foodService.getFoodById(meal.foodId))}.collect { x -> x} as List<MealFood>
        mealFood
    }

    @Override
    @GetMapping(value = "/diet")
    @ResponseBody
    Diet getDiet(){
        dietService.randomDiet
    }

    @Override
    @PostMapping(value = "/diet")
    @ResponseBody
    Boolean putDiet(@RequestBody Diet diet){
        dietService.saveDiet(diet)
    }
}
