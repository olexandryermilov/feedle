package com.wchah.feedle.controller

import com.wchah.feedle.domain.Food
import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.Statistics
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller

@Controller
interface RestController {
    Boolean putFood(Meal meal)
    Statistics getStatistics(Long userId)
    List<String> getAllFoodNames()
}
