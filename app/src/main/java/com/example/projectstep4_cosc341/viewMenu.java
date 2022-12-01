package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class viewMenu extends AppCompatActivity {



    int kbcMenu[] = {R.drawable.kbcmenu1,R.drawable.kbcmenu2,R.drawable.kbcmenu3,R.drawable.kbcmenu4,R.drawable.kbcmenu5,R.drawable.kbcmenu6};
    int shorelineMenu[] = {R.drawable.shorelinemenu01, R.drawable.shorelinemenu02, R.drawable.shorelinemenu03,R.drawable.shorelinemenu04,R.drawable.shorelinemenu05,R.drawable.shorelinemenu06,R.drawable.shorelinemenu07,R.drawable.shorelinemenu08,R.drawable.shorelinemenu09,R.drawable.shorelinemenu10,R.drawable.shorelinemenu11,R.drawable.shorelinemenu12,R.drawable.shorelinemenu13};
    int redMenu[] = {R.drawable.nomenu};
    int badMenu[] = {R.drawable.nomenu};
    int kbiMenu[] = {R.drawable.nomenu};
    int vvbMenu[] = {R.drawable.nomenu};
    ImageView iv;
    int counter = 0;
    int num;
    int images[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menu);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String BrewName = bundle.getString("BrewName");
        TextView name = (TextView) findViewById(R.id.brewName);
        name.setText(BrewName);
        iv = (ImageView)findViewById(R.id.imageView8);

        switch(BrewName){
            case "Kelowna Brewing Company": images = kbcMenu; break;
            case "Shoreline Brewing": images = shorelineMenu; break;
            case "Red Bird Brewing": images = redMenu; break;
            case "Bad Tattoo Brewing": images = badMenu; break;
            case "Kelowna Beer Institute": images = kbiMenu; break;
            case "Vice and Virtue Brewing Co.": images = vvbMenu; break;
        }
        num = images.length;
    }

    public void nextImage(View view)
    {
        if(counter == num)
            counter = 1;
        else
            counter++;
        iv.setImageResource(images[counter-1]);
    }
    public void previousImage(View view)
    {
        if(counter == 1)
            counter = num;
        else
            counter--;
        iv.setImageResource(images[counter-1]);
    }


    public void backBtn(View view) {finish();}
}