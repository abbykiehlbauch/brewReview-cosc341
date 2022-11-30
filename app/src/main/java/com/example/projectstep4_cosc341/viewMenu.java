package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menu);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String BrewName = bundle.getString("name");
        TextView name = (TextView) findViewById(R.id.brewName);
    }

    public void backBtn(View view) {finish();}
}