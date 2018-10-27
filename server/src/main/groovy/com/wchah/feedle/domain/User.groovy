package com.wchah.feedle.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "users")
@JsonIgnoreProperties(["hibernateLazyInitializer", "handler"])

class User implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L
    @Id
    Long id

    @Column(name = "user_name")
    String name

    @Column(name = "is_premium")
    int type

    @Column(name = "subscribed")
    boolean subscribed

    @Column(name = "height")
    int height

    @Column(name = "mass")
    int mass

    @Column(name = "food_tracking")
    boolean isFoodTracked

    @Column(name = "water_tracking")
    boolean isWaterTracked

    User() {
    }

    User(Long id, String name, Integer type, Boolean subscribed, Integer height, Integer mass, Boolean isFoodTracked, Boolean isWaterTracked) {
        this.id = id
        this.name = name
        this.type = type
        this.subscribed = subscribed
        this.height = height
        this.mass = mass
        this.isFoodTracked = isFoodTracked
        this.isWaterTracked = isWaterTracked
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Integer getType() {
        return type
    }

    void setType(Integer type) {
        this.type = type
    }

    Boolean getSubscribed() {
        return subscribed
    }

    void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed
    }

    Integer getHeight() {
        return height
    }

    void setHeight(Integer height) {
        this.height = height
    }

    Integer getMass() {
        return mass
    }

    void setMass(Integer mass) {
        this.mass = mass
    }

    Boolean getIsFoodTracked() {
        return isFoodTracked
    }

    void setIsFoodTracked(Boolean isFoodTracked) {
        this.isFoodTracked = isFoodTracked
    }

    Boolean getIsWaterTracked() {
        return isWaterTracked
    }

    void setIsWaterTracked(Boolean isWaterTracked) {
        this.isWaterTracked = isWaterTracked
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", subscribed=" + subscribed +
                ", height=" + height +
                ", mass=" + mass +
                ", isFoodTracked=" + isFoodTracked +
                ", isWaterTracked=" + isWaterTracked +
                '}';
    }
}
