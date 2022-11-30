package com.example.projectstep4_cosc341;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DeleteBrewReview extends AppCompatActivity{
    BrewReview brew;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_brew_review);
    }

    public void Yes(View view){

        brew=new BrewReview();
        brew.Rating.setRating(0);
        brew.Review.setText("");
        brew.spinner.setSelection(0);

        finish();


    }
    public void No(View view){

        finish();
    }
}