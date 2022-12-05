package com.example.projectstep4_cosc341;

import static com.example.projectstep4_cosc341.MainActivity.LOR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class userProfile extends AppCompatActivity {


    static ArrayList<Review> Reviews;
    static ReviewList LOR;
    static ArrayList<bReview> beerReviews;
    static BeerReviewList LOBR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        LOR=LOR.read(getApplicationContext());
        Reviews=LOR.getReviewList();

        TableLayout displayReviews=(TableLayout) findViewById(R.id.displayReview);
        if(Reviews==null||Reviews.isEmpty()){
            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            empty.setTextColor(Color.BLACK);
            row1.addView(empty);
            displayReviews.addView(row1);
        }else {
            for (int i = 0; i < Reviews.size(); i++) {
                Review fill = Reviews.get(i);
                TableRow row1 = new TableRow(this);
                TableRow row2 = new TableRow(this);
                TableRow row3 = new TableRow(this);
                TableRow row4 = new TableRow(this);
                TableRow row5 = new TableRow(this);
                TableRow row6=new TableRow(this);
                String name = fill.brewery;
                String review = fill.reviewText;
                String price = fill.price;
                float rating = fill.starRating;
                System.out.println(rating);
                TextView nameView = new TextView(this);
                TextView reviewView = new TextView(this);
                TextView priceView = new TextView(this);
                RatingBar ratingView = new RatingBar(this);
                TextView space = new TextView(this);
                Button delete= new Button(this);

                delete.setText("Delete this review");
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Reviews.remove(fill);
                        LOR= new ReviewList(Reviews);
                        LOR.writeToFile(LOR,getApplicationContext());
                        restart();
                    }
                });



                nameView.setText(name);
                nameView.setTextColor(Color.BLACK);
                nameView.setTextSize(20);
                nameView.setTypeface(null, Typeface.BOLD);

                reviewView.setText(review);
                reviewView.setTextColor(Color.BLACK);
                reviewView.setTextSize(18);

                priceView.setText(price);
                priceView.setTextSize(20);
                priceView.setTextColor(Color.BLACK);

                ratingView.setNumStars(5);
                ratingView.setRating(rating);
                ratingView.setClickable(false);
                ratingView.setHovered(false);


                row1.addView(nameView);
                row2.addView(ratingView);
                row3.addView(priceView);
                row4.addView(reviewView);
                row5.addView(space);
                row6.addView(delete);


                displayReviews.addView(row1);
                displayReviews.addView(row2);
                displayReviews.addView(row3);
                displayReviews.addView(row4);
                displayReviews.addView(row6);
                displayReviews.addView(row5);

            }
        }

    }

    public void showReviews(View v){
        LOR=LOR.read(getApplicationContext());
        Reviews=LOR.getReviewList();

        TableLayout displayReviews=(TableLayout) findViewById(R.id.displayReview);
        displayReviews.removeAllViews();

        if(Reviews==null||Reviews.isEmpty()){
            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            empty.setTextColor(Color.BLACK);
            row1.addView(empty);
            displayReviews.addView(row1);
        }else {
            for (int i = 0; i < Reviews.size(); i++) {
                Review fill = Reviews.get(i);
                TableRow row1 = new TableRow(this);
                TableRow row2 = new TableRow(this);
                TableRow row3 = new TableRow(this);
                TableRow row4 = new TableRow(this);
                TableRow row5 = new TableRow(this);
                TableRow row6=new TableRow(this);
                String name = fill.brewery;
                String review = fill.reviewText;
                String price = fill.price;
                float rating = fill.starRating;
                System.out.println(rating);
                TextView nameView = new TextView(this);
                TextView reviewView = new TextView(this);
                TextView priceView = new TextView(this);
                RatingBar ratingView = new RatingBar(this);
                TextView space = new TextView(this);
                Button delete= new Button(this);

                delete.setText("Delete this review");
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Reviews.remove(fill);
                        LOR= new ReviewList(Reviews);
                        LOR.writeToFile(LOR,getApplicationContext());
                        restart();
                    }
                });



                nameView.setText(name);
                nameView.setTextColor(Color.BLACK);
                nameView.setTextSize(20);
                nameView.setTypeface(null, Typeface.BOLD);

                reviewView.setText(review);
                reviewView.setTextColor(Color.BLACK);
                reviewView.setTextSize(18);

                priceView.setText(price);
                priceView.setTextSize(20);
                priceView.setTextColor(Color.BLACK);

                ratingView.setNumStars(5);
                ratingView.setRating(rating);
                ratingView.setClickable(false);
                ratingView.setHovered(false);


                row1.addView(nameView);
                row2.addView(ratingView);
                row3.addView(priceView);
                row4.addView(reviewView);
                row5.addView(space);
                row6.addView(delete);


                displayReviews.addView(row1);
                displayReviews.addView(row2);
                displayReviews.addView(row3);
                displayReviews.addView(row4);
                displayReviews.addView(row6);
                displayReviews.addView(row5);
            }
        }
    }
    public void showBeerReviews(View v){
        LOBR=LOBR.read(getApplicationContext());
        beerReviews=LOBR.getBeerReviewList();

        TableLayout displayReviews=(TableLayout) findViewById(R.id.displayReview);
        displayReviews.removeAllViews();
        if(beerReviews==null||beerReviews.isEmpty()){
            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            empty.setTextColor(Color.BLACK);
            row1.addView(empty);
            displayReviews.addView(row1);
        }else {
            for (int i = 0; i < beerReviews.size(); i++) {

                bReview fill = beerReviews.get(i);

                TableRow row1 = new TableRow(this);
                TableRow row2 = new TableRow(this);
                TableRow row3 = new TableRow(this);
                TableRow row4 = new TableRow(this);
                TableRow row5 = new TableRow(this);

                String name = fill.name;
                String type = fill.type;
                String review = fill.review;
                float rating = fill.rating;

                TextView nameView = new TextView(this);
                TextView typeView = new TextView(this);
                TextView reviewView = new TextView(this);
                RatingBar ratingView = new RatingBar(this);
                TextView space = new TextView(this);
                Button delete = new Button(this);

                delete.setText("Delete this Review");
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        beerReviews.remove(fill);
                        LOBR= new BeerReviewList(beerReviews);
                        LOBR.writeToFile(LOBR,getApplicationContext());
                        restart();

                    }
                });


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
                row5.addView(delete);

                displayReviews.addView(row1);
                displayReviews.addView(row2);
                displayReviews.addView(row3);
                displayReviews.addView(row5);
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
    public void restart(){
        Intent intent = new Intent(userProfile.this, userProfile.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }
}