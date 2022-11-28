package com.example.projectstep4_cosc341;

public class Review {
    String brewery,reviewText;
    int starRating;
    public Review(){
        brewery=null;
        starRating=0;
        reviewText=null;
    }
    public Review(String brewery, int starRating, String reviewText){
        this.brewery=brewery;
        this.starRating=starRating;
        this.reviewText=reviewText;
    }
}
