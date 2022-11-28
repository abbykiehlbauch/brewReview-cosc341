package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button menu;
    Button profile_;
    View profile;
    EditText search;
    Spinner sort;
    ListView breweries;
    String[] breweryNames = {"Kelowna Brewing Company", "Shoreline Brewing", "Red Bird Brewing", "Bad Tattoo Brewing"};
    String[] sorting = {"SORT BY", "NEAR ME", "HIGHEST RATING", "LARGEST SELECTION"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        menu = findViewById(R.id.menu);
        search = findViewById(R.id.searchBar);
        sort = findViewById(R.id.sort);
        breweries = findViewById(R.id.breweriesList);
        profile_ = findViewById(R.id.userProfile);
//        profile.setVisibility(View.INVISIBLE);

//        Intent intent = new Intent(this, BreweriesList.class);
//        startActivity(intent);
//        ArrayAdapter<String> sorted = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sorting);
//        sorted.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sort.setAdapter(sorted);
//
//        ArrayAdapter<String> list = new ArrayAdapter<String>(this, R.layout.activity_breweries_list, R.id.textView, breweryNames);
//        breweries.setAdapter(list);


    }
}