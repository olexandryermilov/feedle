package com.wchah.feedle.services

import com.wchah.feedle.domain.Diet
import com.wchah.feedle.repository.DietRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultDietService implements DietService {

    DietRepository dietRepository

    @Autowired
    DefaultDietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository
    }

    @Override
    Diet getRandomDiet() {
        def id = 1 //new Random().nextInt(dietRepository.count().toInteger()+1)
        return dietRepository.getOne(id*1L)
    }

    @Override
    Boolean saveDiet(Diet diet){
        dietRepository.save(diet)
    }
}
