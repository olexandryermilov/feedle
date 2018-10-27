package com.wchah.feedle.services

import com.wchah.feedle.domain.Statistics

interface StatisticsService {
    Statistics getStatisticsForUser(Long userId)
    Statistics getStatisticsForUserSinceTimestamp(Long userId, String since)
}
