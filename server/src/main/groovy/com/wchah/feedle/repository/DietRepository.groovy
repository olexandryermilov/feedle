package com.wchah.feedle.repository

import com.wchah.feedle.domain.Diet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DietRepository extends JpaRepository<Diet, Long> {
}
