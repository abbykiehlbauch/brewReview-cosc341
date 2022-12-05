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
        Review breweryOne = new Review(BrewName, 4, "Great prices!", "$");
        Review breweryTwo = new Review(BrewName, 3, "Love their happy hour", "$$");
        Review breweryThree = new Review(BrewName, 5, "Bartenders are so friendly!", "$");

        //create beer reviews
        Review beerOne = new Review(BrewName, 2, "Too bitter", "$");
        Review beerTwo = new Review(BrewName, 5, "Best beer I've ever had, perfect hints of pineapple!", "$$");
        Review beerThree = new Review(BrewName, 4, "Wish the honey taste was more pronounced but still good", "$");

        //Brewery review 1
        TextView brewReview1 = findViewById(R.id.breweryReviewName);
        brewReview1.setText(BrewName);
        TextView brewReviewText = findViewById(R.id.textView);
        brewReviewText.setText(breweryOne.reviewText);
        RatingBar ratingBrew1 = findViewById(R.id.MyRating);
        ratingBrew1.setRating(breweryOne.starRating);

        //Brewery review 2
        TextView brewReview2 = findViewById(R.id.breweryReviewName2);
        brewReview2.setText(BrewName);
        TextView brewReviewText2 = findViewById(R.id.textView2);
        brewReviewText2.setText(breweryTwo.reviewText);
        RatingBar ratingBrew2 = findViewById(R.id.MyRating2);
        ratingBrew2.setRating(breweryTwo.starRating);

        //Brewery review 3
        TextView brewReview3 = findViewById(R.id.breweryReviewName3);
        brewReview3.setText(BrewName);
        TextView brewReviewText3 = findViewById(R.id.textView3);
        brewReviewText3.setText(breweryThree.reviewText);
        RatingBar ratingBrew3 = findViewById(R.id.MyRating3);
        ratingBrew3.setRating(breweryThree.starRating);

        //Beer review 1
        TextView beerReview1 = findViewById(R.id.beerBreweryReviewName);
        beerReview1.setText(BrewName);
        TextView beerReviewName1 = findViewById(R.id.beerName);
        beerReviewName1.setText("Pale Ale");
        RatingBar ratingBeer1 = findViewById(R.id.beerMyRating);
        ratingBeer1.setRating(beerOne.starRating);
        TextView beerReviewText1 = findViewById(R.id.beerTextView);
        beerReviewText1.setText(beerOne.reviewText);

        //Beer review 2
        TextView beerReview2 = findViewById(R.id.beerBreweryReviewName2);
        beerReview2.setText(BrewName);
        TextView beerReviewName2 = findViewById(R.id.beerName2);
        beerReviewName2.setText("Pineapple Daze");
        RatingBar ratingBeer2 = findViewById(R.id.beerMyRating2);
        ratingBeer2.setRating(beerTwo.starRating);
        TextView beerReviewText2 = findViewById(R.id.beerTextView2);
        beerReviewText2.setText(beerTwo.reviewText);

        //Beer review 3
        TextView beerReview3 = findViewById(R.id.beerBreweryReviewName3);
        beerReview3.setText(BrewName);
        TextView beerReviewName3 = findViewById(R.id.beerName3);
        beerReviewName3.setText("Honey Brew");
        RatingBar ratingBeer3 = findViewById(R.id.beerMyRating3);
        ratingBeer3.setRating(beerThree.starRating);
        TextView beerReviewText3 = findViewById(R.id.beerTextView3);
        beerReviewText3.setText(beerThree.reviewText);
    }

    public void backbtn(View view)
    {
        finish();
    }

    public void onProfileClick(View view)
    {
        Intent intent = new Intent(this, userProfile.class); startActivity(intent);
    }

    public void onAddBrewReview(View view)
    {
        Intent intent= getIntent();
        Bundle bundle1 = intent.getExtras();
        String name=bundle1.get("name").toString();
        System.out.println(name);

        Intent intent2= new Intent(this, BrewReview.class);
        Bundle bundle2=new Bundle();
        bundle2.putString("name",name);
        intent2.putExtras(bundle2);
        startActivity(intent2);
    }

    public void onAddBeerReview(View view)
    {
        Intent intent = new Intent (this, BeerReview.class);
        Bundle bundle = new Bundle();
        bundle.putString("Brewname", BrewName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void onMenuBtn(View view) {
        Intent intent = new Intent(this, viewMenu.class);
        Bundle bundle = new Bundle();
        bundle.putString("BrewName", BrewName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onBrewreviewClick(View view){

        Intent intent= getIntent();
        Bundle bundle1 = intent.getExtras();
        String name=bundle1.get("name").toString();
        System.out.println(name);

        Intent intent2= new Intent(this, AllBreweryReview.class);
        Bundle bundle2=new Bundle();
            bundle2.putString("name",name);
            intent2.putExtras(bundle2);
        startActivity(intent2);

    }
    public void onBeerreviewClick(View view){
        Intent intent= new Intent(this, AllBeerReview.class);
        startActivity(intent);

    }
}
