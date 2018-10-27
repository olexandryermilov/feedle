package com.wchah.feedle.domain

import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.*

@Entity(name="food")
@JsonInclude(JsonInclude.Include.NON_NULL)
class Food implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L
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


    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Double getWaterPerG() {
        return waterPerG
    }

    void setWaterPerG(Double waterPerG) {
        this.waterPerG = waterPerG
    }

    Double getCaloriesPerG() {
        return caloriesPerG
    }

    void setCaloriesPerG(Double caloriesPerG) {
        this.caloriesPerG = caloriesPerG
    }

    String getFoodName() {
        return foodName
    }

    void setFoodName(String foodName) {
        this.foodName = foodName
    }

    String getTags() {
        return tags
    }

    void setTags(String tags) {
        this.tags = tags
    }

    String getPiecesName() {
        return piecesName
    }

    void setPiecesName(String piecesName) {
        this.piecesName = piecesName
    }

    String getPiecesToGramms() {
        return piecesToGramms
    }

    void setPiecesToGramms(String piecesToGramms) {
        this.piecesToGramms = piecesToGramms
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", waterPerG=" + waterPerG +
                ", caloriesPerG=" + caloriesPerG +
                ", foodName='" + foodName + '\'' +
                ", tags='" + tags + '\'' +
                ", piecesName='" + piecesName + '\'' +
                ", piecesToGramms='" + piecesToGramms + '\'' +
                '}'
    }
}
