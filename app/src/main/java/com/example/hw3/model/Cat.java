package com.example.hw3.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {

    @PrimaryKey
    @NonNull
    private String id;

    private String name;
    private String description;
    private String temperament;



    private String weight_imperial;
    private String life_span;
    private String origin;
    private String wikipedia_url;
    private String dog_friendly;

    public Cat(String id, String name, String description, String temperament, String weight_imperial, String life_span, String origin, String wikipedia_url, String dog_friendly, String catImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.temperament = temperament;
        this.weight_imperial = weight_imperial;
        this.life_span = life_span;
        this.origin = origin;
        this.wikipedia_url = wikipedia_url;
        this.dog_friendly = dog_friendly;
        this.catImage = catImage;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    @SerializedName("cat_image")
    private String catImage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public void setWeight(String weight_imperial) {
        this.weight_imperial = weight_imperial;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public String getDog_friendly() { return dog_friendly;
    }

    public void setDog_friendly(String dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

}
