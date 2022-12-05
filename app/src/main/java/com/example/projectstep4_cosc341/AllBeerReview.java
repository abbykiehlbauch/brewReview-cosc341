package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class AllBeerReview extends AppCompatActivity {

    static ArrayList<bReview> beerReviews;
    static BeerReviewList LOBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_beer_review);
        LOBR=LOBR.read(getApplicationContext());
        beerReviews=LOBR.getBeerReviewList();

        TableLayout displayReviews=(TableLayout) findViewById(R.id.displayBeerReview);

        if(beerReviews==null||beerReviews.isEmpty()){
            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            row1.addView(empty);
            displayReviews.addView(row1);
        }else{
            for(int i=0;i<beerReviews.size();i++){

                bReview fill=beerReviews.get(i);

                TableRow row1=new TableRow(this);
                TableRow row2=new TableRow(this);
                TableRow row3=new TableRow(this);
                TableRow row4=new TableRow(this);

                String name=fill.name;
                String type=fill.type;
                String review=fill.review;
                float rating=fill.rating;

                TextView nameView=new TextView(this);
                TextView typeView=new TextView(this);
                TextView reviewView=new TextView(this);
                RatingBar ratingView=new RatingBar(this);
                TextView space=new TextView(this);

                nameView.setText(name);
                nameView.setTextColor(Color.BLACK);
                nameView.setTextSize(20);
                nameView.setTypeface(null, Typeface.BOLD);

                reviewView.setText(review);
                reviewView.setTextColor(Color.BLACK);
                reviewView.setTextSize(18);

                ratingView.setNumStars(5);
                ratingView.setRating(rating);
                ratingView.setClickable(false);
                ratingView.setHovered(false);

                typeView.setText(type);
                typeView.setTextSize(18);
                typeView.setTextColor(Color.BLACK);

                row1.addView(nameView);
                row1.addView(typeView);
                row2.addView(ratingView);
                row3.addView(reviewView);
                row4.addView(space);

                displayReviews.addView(row1);
                displayReviews.addView(row2);
                displayReviews.addView(row3);
                displayReviews.addView(row4);


            }
        }

    }
    public void backbtn(View view)
    {
        finish();
    }

    public void onProfileClick(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
        startActivity(intent);
    }
}