package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

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

public class BrewReview extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView BrewNameText;
    EditText Review;
    RatingBar Rating;
    Spinner spinner;
    String brewname;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brew_review);

        BrewNameText = (TextView) findViewById(R.id.BrewNameText);
        //set beername text
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        brewname=bundle.getString("Brewname");
        BrewNameText.setText(brewname);

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
        if(Review.getText().toString().length()==0 || Rating.getRating()==0  || spinner.getSelectedItem().toString()==null)
        {
            Toast.makeText(this, "Please fill out all of the review", Toast.LENGTH_LONG).show();
        }
        else{
            //add beer name beer type and rating to data storage system

        }

    }


    public void Delete(View view){
        Intent intent = new Intent(this, DeleteBrewReview.class);
        startActivity(intent);


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