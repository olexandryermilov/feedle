package com.wchah.feedle.services

import com.wchah.feedle.domain.Statistics
import com.wchah.feedle.repository.MealsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Timestamp

@Service
class DefaultStatisticsService implements StatisticsService {

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
        new Statistics(mealsRepository.getWaterForUserSince(userId, since), mealsRepository.getCaloriesForUserSince(userId, since))
    }
}
