package com.wchah.feedle.services

import com.wchah.feedle.domain.User
import com.wchah.feedle.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultUserService implements com.wchah.feedle.services.UserService {

    UsersRepository usersRepository

    @Autowired
    DefaultUserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository
    }

    @Override
    def createUser(Long userId) {
        User user = new User()
        user.setId(userId)
        usersRepository.save(user)
    }

    @Override
    def updateUser(Long userId, User user) {
        user.setId(userId)
        usersRepository.save(user)
    }

    @Override
    Integer getUserType(Long userId) {
        usersRepository.getTypeById(userId)
    }

    @Override
    User getUser(Long userId) {
        usersRepository.getOne(userId)
    }
}
