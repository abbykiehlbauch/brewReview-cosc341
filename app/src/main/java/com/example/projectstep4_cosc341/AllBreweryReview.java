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

public class AllBreweryReview extends AppCompatActivity {

    static ArrayList<Review> Reviews;
    static ReviewList LOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_brewery_review);
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        String Brewname=bundle.getString("name");


        LOR=LOR.read(getApplicationContext());
        Reviews=LOR.getReviewList();

        TableLayout displayReviews=(TableLayout) findViewById(R.id.displayBreweryReview);
         System.out.println(Brewname+Reviews.get(0).brewery);
        if(Reviews==null||Reviews.isEmpty()){

            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            empty.setTextColor(Color.BLACK);
            row1.addView(empty);
            displayReviews.addView(row1);
        }else{
            for(int i=0;i<Reviews.size();i++){
                Review fill=Reviews.get(i);

                if(fill.brewery.equals(Brewname)){
                    TableRow row1=new TableRow(this);
                    TableRow row2=new TableRow(this);
                    TableRow row3=new TableRow(this);
                    TableRow row4=new TableRow(this);
                    TableRow row5=new TableRow(this);
                    String name=fill.brewery;
                    String review=fill.reviewText;
                    String price=fill.price;
                    float rating=fill.starRating;
                    System.out.println(rating);
                    TextView nameView=new TextView(this);
                    TextView reviewView=new TextView(this);
                    TextView priceView=new TextView(this);
                    RatingBar ratingView=new RatingBar(this);
                    TextView space=new TextView(this);



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


                    displayReviews.addView(row1);
                    displayReviews.addView(row2);
                    displayReviews.addView(row3);
                    displayReviews.addView(row4);
                    displayReviews.addView(row5);
                }
            }
        }
        if(displayReviews.getChildCount()==4){

            TableRow row1=new TableRow(this);

            TextView empty=new TextView(this);
            empty.setText("There are no recorded reviews");
            empty.setTextColor(Color.BLACK);
            row1.addView(empty);
            displayReviews.addView(row1);
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