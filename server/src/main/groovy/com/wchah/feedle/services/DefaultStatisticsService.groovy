package com.wchah.feedle.services

import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.repository.MealsRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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
        getStatisticsForUserSinceTimestamp(userId, "1970-01-01 00:00:01")
    }

    @Override
    Statistics getStatisticsForUserSinceTimestamp(Long userId, String since) {
        logger.info(since.toString())
        def water = mealsRepository.getWaterForUserSince(userId, since)
        def calories = mealsRepository.getCaloriesForUserSince(userId, since)
        def points = mealsRepository.getPointsForUserSince(userId, since)
        new Statistics(water==null?0:water, calories==null?0:calories, points==null?0:points)
    }
}
