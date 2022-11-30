package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Listview extends AppCompatActivity {

    String BrewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        BrewName = bundle.getString("name");
        bundle.getString("distance");
        bundle.getString("rating");
        bundle.getString("selection");
        bundle.getString("description");

        //set brewery name
        TextView breweryName = findViewById(R.id.breweryName);
        breweryName.setText(BrewName);

        //set overall brewery rating
        final RatingBar myRatingBar = (RatingBar) findViewById(R.id.breweryRating);
        int rating = Integer.parseInt(bundle.getString("rating"));
        myRatingBar.setRating(rating);

        //create brewery reviews
        Review breweryOne = new Review(BrewName, 4, "Great prices!");
        Review breweryTwo = new Review(BrewName, 3, "Love their happy hour");
        Review breweryThree = new Review(BrewName, 5, "Bartenders are so friendly!");

        //Brewery review 1
        TextView brewReview1 = findViewById(R.id.breweryReviewName);
        brewReview1.setText(BrewName);
        TextView brewReviewText = findViewById(R.id.textView);
        brewReviewText.setText(breweryOne.reviewText);
        RatingBar ratingBrew1 = findViewById(R.id.myRating);
        ratingBrew1.setRating(breweryOne.starRating);

        //Brewery review 2
        TextView brewReview2 = findViewById(R.id.breweryReviewName2);
        brewReview2.setText(BrewName);
        TextView brewReviewText2 = findViewById(R.id.textView2);
        brewReviewText2.setText(breweryTwo.reviewText);
        RatingBar ratingBrew2 = findViewById(R.id.beerMyRating2);
        ratingBrew2.setRating(breweryTwo.starRating);

        //Brewery review 3
        TextView brewReview3 = findViewById(R.id.breweryReviewName3);
        brewReview3.setText(BrewName);
        TextView brewReviewText3 = findViewById(R.id.textView2);
        brewReviewText3.setText(breweryThree.reviewText);
        RatingBar ratingBrew3 = findViewById(R.id.beerMyRating3);
        ratingBrew3.setRating(breweryThree.starRating);


        //Beer review 1
        TextView beerReview1 = findViewById(R.id.beerBreweryReviewName);
        beerReview1.setText(BrewName);

        //Beer review 2
        TextView beerReview2 = findViewById(R.id.beerBreweryReviewName2);
        brewReview2.setText(BrewName);
        //Beer review 3
        TextView beerReview3 = findViewById(R.id.beerBreweryReviewName3);
        brewReview3.setText(BrewName);
    }

    public void backbtn(View view)
    {
        finish();
    }

    public void onProfileClick(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
    }

    public void onAddBrewReview(View view)
    {
        Intent intent = new Intent(this, BrewReview.class);
        Bundle bundle = new Bundle();
        bundle.putString("Brewname", BrewName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onAddBeerReview(View view)
    {
        Intent intent = new Intent (this, BeerReview.class);
        Bundle bundle = new Bundle();
        bundle.putString("Brewname", BrewName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void onMenuBtn(View view)
    {
        Intent intent = new Intent(this, viewMenu.class);
        Bundle bundle = new Bundle();
        bundle.putString("BrewName", BrewName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
