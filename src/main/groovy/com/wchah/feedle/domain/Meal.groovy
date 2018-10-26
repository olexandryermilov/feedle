package com.wchah.feedle.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.deser.std.DateDeserializers
import com.fasterxml.jackson.databind.ser.std.DateSerializer
import com.wchah.feedle.JsonTimestampSerializer

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.sql.Timestamp


@Entity(name = "meals")
class Meal implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    Meal() {
    }

    Meal(Long foodId, Long userId, Timestamp time) {
        this.foodId = foodId
        this.userId = userId
        this.time = time
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column
    Long foodId

    @Column
    Long userId

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    Timestamp time

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", userId=" + userId +
                ", timestamp=" + time +
                '}';
    }


    static long getSerialVersionUID() {
        return serialVersionUID
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getFoodId() {
        return foodId
    }

    void setFoodId(Long foodId) {
        this.foodId = foodId
    }

    Long getUserId() {
        return userId
    }

    void setUserId(Long userId) {
        this.userId = userId
    }


    Timestamp getTime() {
        return time
    }

    void setTime(Timestamp time) {
        this.time = time
    }
}


