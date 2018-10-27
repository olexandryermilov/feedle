package com.wchah.feedle.services

import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.repository.MealsRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Timestamp

@Service
class DefaultStatisticsService implements StatisticsService {
    Logger logger = LoggerFactory.getLogger(DefaultStatisticsService.class)

    MealsRepository mealsRepository

    @Autowired
    DefaultStatisticsService(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository
    }

    @Override
    Statistics getStatisticsForUser(Long userId) {
        getStatisticsForUserSinceTimestamp(userId, new Timestamp(0))
    }

    @Override
    Statistics getStatisticsForUserSinceTimestamp(Long userId, Timestamp since) {
        def water = mealsRepository.getWaterForUserSince(userId, since)
        def calories = mealsRepository.getCaloriesForUserSince(userId, since)
        new Statistics(water==null?0:water, calories==null?0:calories)
    }
}
