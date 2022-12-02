package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.projectstep4_cosc341.MainActivity.LOR;
import static com.example.projectstep4_cosc341.MainActivity.LOU;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BrewReview extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView BrewNameText;
    EditText Review;
    RatingBar Rating;
    Spinner spinner;
    ArrayList<Review> reviewList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brew_review);

        BrewNameText = (TextView) findViewById(R.id.BrewNameText);
        //set beername text
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        String name=bundle.getString("name");
        System.out.println(name);
        BrewNameText.setText(name);

        Review = (EditText) findViewById(R.id.Review);
        Rating= (RatingBar) findViewById(R.id.Rating);
        spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.my_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }






    public void Save(View view){
        BrewNameText = (TextView) findViewById(R.id.BrewNameText);
        Review = (EditText) findViewById(R.id.Review);
        Rating= (RatingBar) findViewById(R.id.Rating);
        spinner = (Spinner) findViewById(R.id.spinner);

        String name=BrewNameText.getText().toString();
        String review=Review.getText().toString();
        float rating=Rating.getRating();
        String price=spinner.getSelectedItem().toString();

        if(Review.getText().toString().length()==0 || Rating.getRating()==0  || spinner.getSelectedItem().toString()==null)
        {
            Toast.makeText(this, "Please fill out all of the review", Toast.LENGTH_LONG).show();
        }
        else{
            //add beer name beer type and rating to data storage system
            LOR.read(getApplicationContext());

            if(LOR.getReviewList()==null){
                reviewList=new ArrayList<Review>();
                reviewList.add(new Review(name,rating,review,price));
                LOR= new ReviewList(reviewList);
                LOR.writeToFile(LOR,getApplicationContext());
                System.out.println("made it1");
                finish();
            }else{
                reviewList=LOR.getReviewList();
                reviewList.add(new Review(name,rating,review,price));
                LOR= new ReviewList(reviewList);
                LOR.writeToFile(LOR,getApplicationContext());
                System.out.println("made it2");
                finish();
            }



        }

    }


    public void Delete(View view){
        finish();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "Selected: Select Price", Toast.LENGTH_LONG).show();
    }
}