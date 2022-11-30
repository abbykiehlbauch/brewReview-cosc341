package com.example.projectstep4_cosc341;

public class User extends Review {
    String userName, passWord;
    Review reviews[];
    public User() {
        userName = null;
        passWord = null;
        reviews=null;
    }
    //This will be used for creating the account when the user gives information
    public User(String userName,String passWord, Review[] reviews){
        this.userName = userName;
        this.passWord = passWord;
        this.reviews = reviews;
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

}
