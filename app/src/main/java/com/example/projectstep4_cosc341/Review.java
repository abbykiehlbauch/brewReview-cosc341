package com.example.projectstep4_cosc341;

import java.io.Serializable;

public class Review implements Serializable {
    String brewery,reviewText,price;
    float starRating;

    public Review(){
        brewery=null;
        starRating=0;
        reviewText=null;
        price=null;
    }
    public Review(String brewery, float starRating, String reviewText, String price){
        this.brewery=brewery;
        this.starRating=starRating;
        this.reviewText=reviewText;
        this.price=price;
    }
}
