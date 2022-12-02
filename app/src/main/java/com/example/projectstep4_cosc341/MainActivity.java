package com.example.projectstep4_cosc341;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView welcome;
    TextView name;
    ImageView profile_;
//    RatingBar rating;
    SearchView searchView_;
    Spinner sort;
    ListView breweries;
    String[] breweryNames = {"Kelowna Brewing Company", "Shoreline Brewing", "Red Bird Brewing", "Bad Tattoo Brewing", "Kelowna Beer Institute", "Vice and Virtue Brewing Co."};
    String[] sorting = {"SORT BY", "NEAR ME", "HIGHEST RATING", "LARGEST SELECTION"};
    ArrayList<HashMap<String,String>> list1 = new ArrayList<HashMap<String,String>>();
    ArrayList<HashMap<String,String>> list2 = new ArrayList<HashMap<String,String>>();
    ArrayList<HashMap<String,String>> list3 = new ArrayList<HashMap<String,String>>();
    ArrayList<HashMap<String,String>> list4 = new ArrayList<HashMap<String,String>>();
    ArrayList<HashMap<String,String>> list5 = new ArrayList<HashMap<String,String>>();
    ArrayList<HashMap<String,String>> list6 = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter sa;
//    String[] breweriesList_;
//    ArrayList<String> list;
//    ArrayList<String> list2;
    ArrayAdapter<String> adapter_;
    ArrayAdapter<String> adapter2;

    static int id=0;
    static ArrayList<User> Users;
    static ArrayList<Review> Reviews;
    static ArrayList<bReview> BeerReviews;
    static UserList LOU;
    static ReviewList LOR;
    static BeerReviewList LOBR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LOU=LOU.readAccs(getApplicationContext());
        LOR=LOR.read(getApplicationContext());
        LOBR=LOBR.read(getApplicationContext());

        Users= new ArrayList<User>();
        Reviews= new ArrayList<Review>();
        BeerReviews= new ArrayList<bReview>();

        ArrayList<User> listOfUsers;
        listOfUsers=LOU.getAccountList();

        if(listOfUsers == null || listOfUsers.isEmpty()){
            User userMain= new User();
            Users.add(userMain);
            LOU=new UserList(Users);
            LOU.writeAccToFile(LOU, getApplicationContext());
            System.out.println("is empty and writing");
        }

        ArrayList<Review> listOfReviews;
        listOfReviews=LOR.getReviewList();

        if(listOfReviews==null||listOfReviews.isEmpty()){
            LOR=new ReviewList();
            LOR.writeToFile(LOR, getApplicationContext());
        }

        ArrayList<bReview> listOfBeerReviews;
        listOfBeerReviews=LOBR.getBeerReviewList();

        if(listOfBeerReviews==null||listOfBeerReviews.isEmpty()){
            LOBR=new BeerReviewList();
            LOBR.writeToFile(LOBR, getApplicationContext());
        }


        welcome = findViewById(R.id.welcome);
        searchView_ = findViewById(R.id.search_bar);
        sort = findViewById(R.id.sort);
        profile_ = findViewById(R.id.userProfile);
        breweries = findViewById(R.id.breweriesList);
        name = findViewById(R.id.textView1);

        breweries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[0][0]);
                    bundle.putString("distance", breweryInfo1[0][1]);
                    bundle.putString("rating", breweryInfo1[0][2]);
                    bundle.putString("selection", breweryInfo1[0][3]);
                    bundle.putString("description", breweryInfo1[0][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 1){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[1][0]);
                    bundle.putString("distance", breweryInfo1[1][1]);
                    bundle.putString("rating", breweryInfo1[1][2]);
                    bundle.putString("selection", breweryInfo1[1][3]);
                    bundle.putString("description", breweryInfo1[1][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 2){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[2][0]);
                    bundle.putString("distance", breweryInfo1[2][1]);
                    bundle.putString("rating", breweryInfo1[2][2]);
                    bundle.putString("selection", breweryInfo1[2][3]);
                    bundle.putString("description", breweryInfo1[2][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 3){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[3][0]);
                    bundle.putString("distance", breweryInfo1[3][1]);
                    bundle.putString("rating", breweryInfo1[3][2]);
                    bundle.putString("selection", breweryInfo1[3][3]);
                    bundle.putString("description", breweryInfo1[3][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 4){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[4][0]);
                    bundle.putString("distance", breweryInfo1[4][1]);
                    bundle.putString("rating", breweryInfo1[4][2]);
                    bundle.putString("selection", breweryInfo1[4][3]);
                    bundle.putString("description", breweryInfo1[4][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 5){
                    Intent intent = new Intent(MainActivity.this, Listview.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", breweryInfo1[5][0]);
                    bundle.putString("distance", breweryInfo1[5][1]);
                    bundle.putString("rating", breweryInfo1[5][2]);
                    bundle.putString("selection", breweryInfo1[5][3]);
                    bundle.putString("description", breweryInfo1[5][4]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        HashMap<String, String> item1;
        for (int i = 0; i < breweryInfo1.length; i++) {
            item1 = new HashMap<String, String>();
            item1.put("line1", breweryInfo1[i][0]);
            item1.put("line2", breweryInfo1[i][4]);
            list1.add(item1);
        }

        HashMap<String, String> item2;
        for (int i = 0; i < breweryInfo2.length; i++) {
            item2 = new HashMap<String, String>();
            item2.put("line1", breweryInfo2[i][0]);
            item2.put("line2", breweryInfo2[i][4]);
            list2.add(item2);
        }

        HashMap<String, String> item3;
        for (int i = 0; i < breweryInfo3.length; i++) {
            item3 = new HashMap<String, String>();
            item3.put("line1", breweryInfo3[i][0]);
            item3.put("line2", breweryInfo3[i][4]);
            list3.add(item3);
        }

        HashMap<String, String> item4;
        for (int i = 0; i < breweryInfo4.length; i++) {
            item4 = new HashMap<String, String>();
            item4.put("line1", breweryInfo4[i][0]);
            item4.put("line2", breweryInfo4[i][4]);
            list4.add(item4);
        }

        searchView_.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sa.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sa.getFilter().filter(newText);
                return false;
            }
        });

        ArrayAdapter<String> sorted = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sorting);
        sorted.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sort.setAdapter(sorted);

        sa = new SimpleAdapter(MainActivity.this, list1, R.layout.activity_breweries_list, new String[]{"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
        breweries.setAdapter(sa);

        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String item = parent.getSelectedItem().toString();
                ArrayList<Object> all = new ArrayList<>();
                if (item.equals("SORT BY")) {
                    sa = new SimpleAdapter(MainActivity.this, list1, R.layout.activity_breweries_list, new String[]{"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
                    ((ListView) findViewById(R.id.breweriesList)).setAdapter(sa);
                } else if (item.equals("NEAR ME")) {
                    sa = new SimpleAdapter(MainActivity.this, list2, R.layout.activity_breweries_list, new String[]{"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
                    ((ListView) findViewById(R.id.breweriesList)).setAdapter(sa);
                } else if (item.equals("HIGHEST RATING")) {
                    sa = new SimpleAdapter(MainActivity.this, list3, R.layout.activity_breweries_list, new String[]{"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
                    ((ListView) findViewById(R.id.breweriesList)).setAdapter(sa);
                } else if (item.equals("LARGEST SELECTION")) {
                    sa = new SimpleAdapter(MainActivity.this, list4, R.layout.activity_breweries_list, new String[]{"line1", "line2"}, new int[]{R.id.textView1, R.id.textView2});
                    ((ListView) findViewById(R.id.breweriesList)).setAdapter(sa);
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

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search");

        return super.onCreateOptionsMenu(menu);
    }
    private String[][] breweryInfo1 = {
            {"Kelowna Brewing Company", "1.4", "3", "9", "University Pub"},
            {"Shoreline Brewing", "15.0", "5", "10", "View of the lake"},
            {"Red Bird Brewing", "12.0", "4", "6", "Party Central"},
            {"Bad Tattoo Brewing", "13.0", "2", "11", "PIZZA"},
            {"Kelowna Beer Institute", "14.0", "4", "8", "Great food"},
            {"Vice and Virtue Brewing Co.", "12.0", "4", "6", "Wheelchair Accessible"}};

    private String[][] breweryInfo2 = {
            {"Kelowna Brewing Company", "1.4", "3", "9", "University Pub"},
            {"Red Bird Brewing", "12.0", "4", "6", "Party Central"},
            {"Vice and Virtue Brewing Co.", "12.0", "4", "6", "Wheelchair Accessible"},
            {"Bad Tattoo Brewing", "13.0", "2", "11", "PIZZA"},
            {"Kelowna Beer Institute", "14.0", "4", "8", "Great food"},
            {"Shoreline Brewing", "15.0", "5", "10", "View of the lake"}};

    private String[][] breweryInfo3 = {
            {"Shoreline Brewing", "15.0", "5", "10", "View of the lake"},
            {"Red Bird Brewing", "12.0", "4", "6", "Party Central"},
            {"Vice and Virtue Brewing Co.", "12.0", "4", "6", "Wheelchair Accessible"},
            {"Kelowna Beer Institute", "14.0", "3", "8", "Great food"},
            {"Kelowna Brewing Company", "1.4", "3", "9", "University Pub"},
            {"Bad Tattoo Brewing", "13.0", "2", "11", "PIZZA"}};

    private String[][] breweryInfo4 = {
            {"Bad Tattoo Brewing", "13.0", "2", "11", "PIZZA"},
            {"Shoreline Brewing", "15.0", "5", "10", "View of the lake"},
            {"Kelowna Brewing Company", "1.4", "3", "9", "University Pub"},
            {"Kelowna Beer Institute", "14.0", "3", "8", "Great food"},
            {"Red Bird Brewing", "12.0", "4", "6", "Party Central"},
            {"Vice and Virtue Brewing Co.", "12.0", "4", "6", "Wheelchair Accessible"}};
}

//        breweries.setClickable(true);
//        breweries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                if (position == 0) {
//                    Toast.makeText(MainActivity.this, "You selected KBC", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[0][0]);
////                    bundle.putString("distance", breweryInfo[0][1]);
////                    bundle.putString("rating", breweryInfo[0][2]);
////                    bundle.putString("selection", breweryInfo[0][3]);
////                    bundle.putString("description", breweryInfo[0][4]);
////                    intent.putExtras(bundle);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//                } else if (position == 1) {
//                    Toast.makeText(MainActivity.this, "You selected Shoreline", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[1][0]);
////                    bundle.putString("distance", breweryInfo[1][1]);
////                    bundle.putString("rating", breweryInfo[1][2]);
////                    bundle.putString("selection", breweryInfo[1][3]);
////                    bundle.putString("description", breweryInfo[1][4]);
////                    intent.putExtras(bundle);
////                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//
//                } else if (position == 2) {
//                    Toast.makeText(MainActivity.this, "You selected Red Bird", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[2][0]);
////                    bundle.putString("distance", breweryInfo[2][1]);
////                    bundle.putString("rating", breweryInfo[2][2]);
////                    bundle.putString("selection", breweryInfo[2][3]);
////                    bundle.putString("description", breweryInfo[2][4]);
////                    intent.putExtras(bundle);
////                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//                } else if (position == 3) {
//                    Toast.makeText(MainActivity.this, "You selected Bad Tattoo", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[3][0]);
////                    bundle.putString("distance", breweryInfo[3][1]);
////                    bundle.putString("rating", breweryInfo[3][2]);
////                    bundle.putString("selection", breweryInfo[3][3]);
////                    bundle.putString("description", breweryInfo[3][4]);
////                    intent.putExtras(bundle);
////                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//                } else if (position == 4) {
//                    Toast.makeText(MainActivity.this, "You selected KBI", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[4][0]);
////                    bundle.putString("distance", breweryInfo[4][1]);
////                    bundle.putString("rating", breweryInfo[4][2]);
////                    bundle.putString("selection", breweryInfo[4][3]);
////                    bundle.putString("description", breweryInfo[4][4]);
////                    intent.putExtras(bundle);
////                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//                } else if (position == 5) {
//                    Toast.makeText(MainActivity.this, "You selected V&V", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(MainActivity.this, ListView.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("name", breweryInfo[5][0]);
////                    bundle.putString("distance", breweryInfo[5][1]);
////                    bundle.putString("rating", breweryInfo[0][5]);
////                    bundle.putString("selection", breweryInfo[5][3]);
////                    bundle.putString("description", breweryInfo[5][4]);
////                    intent.putExtras(bundle);
////                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this, ListView.class));
//
//                }
//            }
//        });
