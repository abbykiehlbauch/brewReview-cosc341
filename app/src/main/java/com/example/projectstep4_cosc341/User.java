package com.example.projectstep4_cosc341;

import java.io.Serializable;

public class User implements Serializable {
    String userName, passWord;
    Review reviews[];
    BeerReview beerReviews[];
    public User() {
        userName = "user";
        passWord = "pass";
        reviews=null;
        beerReviews=null;
    }
    //This will be used for creating the account when the user gives information
    public User(String userName,String passWord, Review[] reviews, BeerReview[] beerReviews){
        this.userName = userName;
        this.passWord = passWord;
        this.reviews = reviews;
        this.beerReviews=beerReviews;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
  public Review[] getReviews(){
        return reviews;
  }
  public BeerReview[] getBeerReviews(){return beerReviews;}

}
