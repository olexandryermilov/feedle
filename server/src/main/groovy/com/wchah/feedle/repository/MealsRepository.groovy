package com.wchah.feedle.repository

import com.wchah.feedle.domain.Meal
import com.wchah.feedle.domain.Statistics
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import java.sql.Timestamp

@Repository
interface MealsRepository extends JpaRepository<Meal, Long> {

    @Query("SELECT m FROM meals m WHERE m.userId = :userId")
    Iterable<Meal> findAllByUserId(@Param("userId") Long userId)
    //@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    //public List<Person> find(@Param("lastName") String lastName);

    @Query(
            value = "SELECT sum(food.calories_per_g * meals.amount) FROM meals JOIN food on meals.food_id = food.id where meals.user_id = :userId and time>=:time",
            nativeQuery = true
    )
    Integer getCaloriesForUserSince(@Param("userId") Long userId, @Param("time") Timestamp time)

    @Query(
            value = "SELECT sum(food.water_per_g * meals.amount) FROM meals JOIN food on meals.food_id = food.id where meals.user_id = :userId and time>=:time",
            nativeQuery = true
    )
    Integer getWaterForUserSince(@Param("userId") Long userId, @Param("time") Timestamp time)
}
