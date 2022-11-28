package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    TextView name;
    Button menu, brewery1, brewery2, brewery3, brewery4, brewery5, brewery6;
    ImageView profile_;
    RatingBar rating;
    EditText search;
    Spinner sort;
    ListView breweries;
    String[] breweryNames = {"Kelowna Brewing Company", "Shoreline Brewing", "Red Bird Brewing", "Bad Tattoo Brewing"};
    String[] sorting = {"SORT BY", "NEAR ME", "HIGHEST RATING", "LARGEST SELECTION"};
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        search = findViewById(R.id.searchBar);
        sort = findViewById(R.id.sort);
        profile_ = findViewById(R.id.userProfile);
        breweries = findViewById(R.id.breweriesList);
        name = findViewById(R.id.textView1);

        HashMap<String, String> item;
       for(int i=0; i<breweryInfo.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", breweryInfo[i][0]);
            item.put("line2", breweryInfo[i][4]);
//            item.put("line3", breweryInfo[i][2]);
            list.add(item);
        }


        sa = new SimpleAdapter(this, list, R.layout.activity_breweries_list, new String[] {"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
        ((ListView) findViewById(R.id.breweriesList)).setAdapter(sa);
        brewery1 = findViewById(R.id.brewery1);
        brewery2 = findViewById(R.id.brewery2);
        brewery3 = findViewById(R.id.brewery3);
        brewery4 = findViewById(R.id.brewery4);
        brewery5 = findViewById(R.id.brewery5);
        brewery6 = findViewById(R.id.brewery6);

        brewery1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        brewery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        brewery3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        brewery4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        brewery5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        brewery6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView.class);
                Bundle bundle = new Bundle();
                for(int i=0; i<breweryInfo.length; i++) {
                    bundle.putString("name", breweryInfo[i][0]);
                    bundle.putString("distance", breweryInfo[i][1]);
                    bundle.putString("rating", breweryInfo[i][2]);
                    bundle.putString("selection", breweryInfo[i][3]);
                    bundle.putString("description", breweryInfo[i][4]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> sorted = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sorting);
        sorted.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sort.setAdapter(sorted);

//        ArrayAdapter<String> names = new ArrayAdapter<String>(this, R.layout.activity_breweries_list, R.id.textView, breweryNames);
//        breweries.setAdapter(names);

        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String item = parent.getSelectedItem().toString();
                ArrayList<Object> all = new ArrayList<>();
                if (item.equals("SORT BY")) {
                } else if (item.equals("NEAR ME")) {

                } else if (item.equals("HIGHEST RATING")) {

                } else if (item.equals("LARGEST SELECTION")) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        profile_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, userProfile.class);
                startActivity(intent);
            }
        });
    }
    private String[][] breweryInfo = {{"Kelowna Brewing Company", "2.0", "3.4", "9", "University Pub"}, {"Shoreline Brewing", "4.6", "4.5", "10", "View of the lake"}, {"Red Bird Brewing", "7.8", "4.9", "6", "Party Central"}, {"Bad Tattoo Brewing", "10.7", "4.3", "11", "PIZZA"}, {"Brewery 5", "3.8", "3.4", "8", "IDK"}, {"Brewery 6", "6.6", "2.6", "6", "IDK"}};
}