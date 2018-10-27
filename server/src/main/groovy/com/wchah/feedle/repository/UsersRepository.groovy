package com.wchah.feedle.repository

import com.wchah.feedle.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsersRepository extends JpaRepository<User, Long> {
    @Query(value = "select is_premium from users where users.id=:id", nativeQuery = true)
    Integer getTypeById(@Param("id") Long id)
}
