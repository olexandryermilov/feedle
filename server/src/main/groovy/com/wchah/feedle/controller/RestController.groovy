package com.wchah.feedle.controller

import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.domain.User
import org.springframework.stereotype.Controller

@Controller
interface RestController {
    Boolean putFood(Meal meal)
    Statistics getStatistics(long userId, Long time)
    List<String> getAllFoodNames()
    Integer getUserType(Long userId)
    def createUser(Long userId, User user)
    def getUserInfo(Long userId)
}
