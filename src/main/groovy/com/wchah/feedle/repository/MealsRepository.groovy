package com.wchah.feedle.repository

import com.wchah.feedle.domain.Meal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MealsRepository extends JpaRepository<Meal, Long> {

    @Query("SELECT m FROM meals m WHERE m.userId = :userId")
    Iterable<Meal> findAllByUserId(@Param("userId") Long userId)
    //@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    //public List<Person> find(@Param("lastName") String lastName);
}
