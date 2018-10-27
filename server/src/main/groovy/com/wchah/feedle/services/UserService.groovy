package com.wchah.feedle.services

import com.wchah.feedle.domain.User

interface UserService {
    def createUser(Long userId)

    def updateUser(Long userId, User user)

    Integer getUserType(Long userId)

    User getUser(Long userId)
}