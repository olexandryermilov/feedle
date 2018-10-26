package com.wchah.feedle.domain

import javax.annotation.Generated
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="food")
class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(name = "water_per_g")
    Double waterPerG

    @Column(name = "calories_per_g")
    Double caloriesPerG

    @Column(name = "food_name")
    String foodName

    @Column(name = "tags")
    String tags

    @Column(name = "pieces_name")
    String piecesName

    @Column(name = "pieces_to_gramms")
    String piecesToGramms
}
