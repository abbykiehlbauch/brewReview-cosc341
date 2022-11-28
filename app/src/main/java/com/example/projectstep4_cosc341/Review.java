package com.example.projectstep4_cosc341;

public class Review {
    String brewery, rating, reviewText;

    public Review(){
        brewery=null;
        rating=null;
        reviewText=null;
    }
    public Review(String brewery, String rating, String reviewText){
        this.brewery=brewery;
        this.rating=rating;
        this.reviewText=reviewText;
    }
}
