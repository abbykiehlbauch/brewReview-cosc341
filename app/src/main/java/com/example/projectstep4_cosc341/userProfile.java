package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class userProfile extends AppCompatActivity {

    static ArrayList<User> Users;
    static UserList LOU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        LOU=LOU.readAccs(getApplicationContext());
        Users=LOU.getAccountList();
        if(Users==null||Users.isEmpty()){
            System.out.println("empty");
        }else{
            User test=Users.get(0);
            System.out.println(test.userName);
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