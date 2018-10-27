package com.wchah.feedle.services

import com.wchah.feedle.domain.Statistics

import java.sql.Timestamp

interface StatisticsService {
    Statistics getStatisticsForUser(Long userId)
    Statistics getStatisticsForUserSinceTimestamp(Long userId, Timestamp since)
}
