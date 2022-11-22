package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button menu, profile;
    EditText search;
    Spinner sort;
    ListView breweries;
    String breweryNames[] = {"Kelowna Brewing Company", "Shoreline Brewing", "Red Bird Brewing", "Bad Tattoo Brewing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        menu = findViewById(R.id.menu);
        profile = findViewById(R.id.userProfile);
        search = findViewById(R.id.searchBar);
        sort = findViewById(R.id.sort);
        breweries = findViewById(R.id.breweriesList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, breweryNames);
        breweries.setAdapter(adapter);


    }
}