package com.example.projectstep4_cosc341;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class BeerReview extends AppCompatActivity {
    EditText BeerName;
    EditText BeerType;
    EditText Review;
    RatingBar Rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_review);
        BeerName = (EditText) findViewById(R.id.BeerName);
        BeerType = (EditText) findViewById(R.id.BeerType);
        Review = (EditText) findViewById(R.id.Review);
        Rating= (RatingBar) findViewById(R.id.Rating);



    }






    public void Save(View view){
        if(BeerName.getText().toString().length()==0
                || BeerType.getText().toString().length()==0
                ||Review.getText().toString().length()==0 || Rating.getRating()==0)
        {
            Toast.makeText(this, "Please fill out all of the review", Toast.LENGTH_LONG).show();
        }
        else{
            //add beer name beer type and rating to data storage system

        }

    }
    public void Delete(View view){
        Intent intent = new Intent(this, DeleteBeerReview.class);
        startActivity(intent);




    }




}