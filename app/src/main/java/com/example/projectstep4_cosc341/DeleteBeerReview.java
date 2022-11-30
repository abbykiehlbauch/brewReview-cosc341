package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class DeleteBeerReview extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_beer_review);

    }

    public void Yes(View view){

        BeerReview beer=new BeerReview();
        beer.Rating.setRating(0);
        beer.Review.setText("");
        beer.BeerName.setText("");
        beer.BeerType.setText("");
        finish();


    }
    public void No(View view){

        finish();
    }
}