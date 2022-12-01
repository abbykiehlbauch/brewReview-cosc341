package com.example.projectstep4_cosc341;

import android.widget.EditText;
import android.widget.RatingBar;

import java.io.Serializable;

public class bReview implements Serializable {

    String name,type,review;
    float rating;

    public bReview(){
        name=null;
        type=null;
        review=null;
        rating=0;
    }
    public bReview(String name,String type,String review,float rating){
        this.name=name;
        this.type=type;
        this.review=review;
        this.rating=rating;
    }
}
