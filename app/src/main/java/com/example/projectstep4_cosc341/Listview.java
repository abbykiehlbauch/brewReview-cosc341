package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        bundle.getString("distance");
        bundle.getString("rating");
        bundle.getString("selection");
        bundle.getString("description");
        TextView breweryName = findViewById(R.id.breweryName);
        breweryName.setText( bundle.getString("name"));
        //breweryName.setText(bundle.getString("BreweryName"));
        final RatingBar myRatingBar = (RatingBar) findViewById(R.id.MyRating);
        myRatingBar.setRating(4);

    }

    public void backbtn(View view)
    {
        finish();
    }

    public void onProfileClick(View view)
    {Intent intent = new Intent(this, userProfile.class);}

    public void onBrewreviewClick(View view){

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
    public void onBeerreviewClick(View view){
        Intent intent= new Intent(this, BeerReview.class);
        startActivity(intent);

    }
}
