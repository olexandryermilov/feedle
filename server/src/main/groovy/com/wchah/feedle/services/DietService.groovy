package com.wchah.feedle.services

import com.wchah.feedle.domain.Diet

interface DietService {
    Diet getRandomDiet()
    Boolean saveDiet(Diet diet)
}
