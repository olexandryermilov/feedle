package com.wchah.feedle.services

import com.wchah.feedle.domain.User

interface UserService {
    def createUser(User user)

    def updateUser(User user)

    Integer getUserType(Long userId)

    User getUser(Long userId)
}