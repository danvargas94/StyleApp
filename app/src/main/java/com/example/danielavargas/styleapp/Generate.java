package com.example.danielavargas.styleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Generate extends AppCompatActivity {
    Context contex;
    ViewPager upViewPager, pantsViewPager, shoesViewPager;
    String weather = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        contex = getApplicationContext();
        //getImages("veryhot");

        Intent intent = getIntent();
        String intentStringExtra = intent.getStringExtra("weather");
        System.out.println("intent " + intentStringExtra);
        weather = intentStringExtra;



        pantsViewPager = (ViewPager) findViewById(R.id.pantsViewPager);
        upViewPager = (ViewPager) findViewById(R.id.upViewPager);
        shoesViewPager = (ViewPager) findViewById(R.id.shoesViewPager);

        getImages();

    }

    public void getImages(){
        final ParseQuery<ParseObject> query = ParseQuery.getQuery("Tag");
        if (weather.contains("error")){
            Toast.makeText(this, "Error, try to reload again", Toast.LENGTH_LONG).show();
        }
        if (weather.contains("vh")){
            weather = "vh";
        } else if (weather.contains("normal")) {
            weather = "normal";
        } else if (weather.contains("hot")) {
            weather = "hot";
        }else if (weather.contains("cold")) {
            weather = "cold";
        }else if (weather.contains("vc")) {
            weather = "vc";
        }
        query.whereEqualTo("name", weather);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> weatherList, ParseException e) {
                if (e == null) {
                    if(weatherList.size() != 0){
                        System.out.println("VA POR ROPA");
                        getPants(weatherList.get(0));
                        getUp(weatherList.get(0));
                        getShoes(weatherList.get(0));
                    }

                } else {
                    Log.d("score", "Error: " + e.getMessage() + e.getCode());
                }
            }
        });

    }

    public void getPants(ParseObject weatherList){

        ParseQuery<ParseObject> queryPants = ParseQuery.getQuery("Clothes");
        queryPants.whereEqualTo("part", "pants");
        queryPants.whereEqualTo("tag", weatherList);
        queryPants.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> pantsList, ParseException e) {
                if (e == null) {
                    ViewPagerAdapter pantsViewPagerAdapter = new ViewPagerAdapter(contex, pantsList);
                    pantsViewPager.setAdapter(pantsViewPagerAdapter);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }

    public void getUp(ParseObject weatherList){

        ParseQuery<ParseObject> queryUp = ParseQuery.getQuery("Clothes");
        queryUp.whereEqualTo("part", "up");
        queryUp.whereEqualTo("tag", weatherList);
        queryUp.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> upList, ParseException e) {
                if (e == null) {
                    ViewPagerAdapter upViewPagerAdapter = new ViewPagerAdapter(contex, upList);
                    upViewPager.setAdapter(upViewPagerAdapter);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }

    public void getShoes(ParseObject weatherList){

        ParseQuery<ParseObject> queryShoes = ParseQuery.getQuery("Clothes");
        queryShoes.whereEqualTo("part", "shoes");
        queryShoes.whereEqualTo("tag", weatherList);
        queryShoes.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> shoesList, ParseException e) {
                if (e == null) {

                    ViewPagerAdapter shoesViewPagerAdapter = new ViewPagerAdapter(contex, shoesList);
                    shoesViewPager.setAdapter(shoesViewPagerAdapter);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }


}
