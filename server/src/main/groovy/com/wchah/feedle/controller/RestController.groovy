package com.wchah.feedle.controller

import com.wchah.feedle.domain.*
import org.springframework.stereotype.Controller

@Controller
interface RestController {
    Boolean putFood(Meal meal)
    Statistics getStatistics(long userId, String timeStr)
    List<String> getAllFoodNames()
    Integer getUserType(Long userId)
    def createUser(User user)
    def getUserInfo(Long userId)
    def createFood(Food food, Long userId)
    def getAllMealsForUser(Long userId, String time)
    Boolean putDiet(Diet diet)
    Diet getDiet()
}
