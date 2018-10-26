package com.wchah.feedle.repository

import com.wchah.feedle.domain.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository extends JpaRepository<Food, Long> {
    @Query(value = "SELECT food_name FROM food", nativeQuery = true)
    List<String> findAllFoodNames()
}
