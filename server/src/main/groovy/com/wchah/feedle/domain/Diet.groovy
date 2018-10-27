package com.wchah.feedle.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "diets")
class Diet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(name = "description")
    String description

    Diet() {
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }

    Diet(Long id, String text) {
        this.id = id
        this.text = text
    }
}
