package com.example.danielavargas.styleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Generate extends AppCompatActivity {

    ViewPager upViewPager, pantsViewPager, shoesViewPager;
    List<ParseObject> upClothes = new ArrayList<ParseObject>();
    List<ParseObject> pantsClothes = new ArrayList<ParseObject>();
    List<ParseObject> shoes = new ArrayList<ParseObject>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        //getImages("veryhot");
        final Context context = getApplicationContext();
        String weather = "veryhot";

        final ParseQuery<ParseObject> query = ParseQuery.getQuery("Tag");
        query.whereEqualTo("name", weather);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> weatherList, ParseException e) {
                if (e == null) {
                    ParseQuery<ParseObject> queryPants = ParseQuery.getQuery("Clothes");
                    queryPants.whereEqualTo("part", "pants");
                    queryPants.whereEqualTo("tag", weatherList.get(0));
                    queryPants.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    pantsClothes.add(temp);
                                }
                                System.out.println("pants " + pantsClothes.size());
                                pantsViewPager = (ViewPager) findViewById(R.id.pantsViewPager);
                                ViewPagerAdapter pantsViewPagerAdapter = new ViewPagerAdapter(context, "veryhot", "pants");
                                pantsViewPager.setAdapter(pantsViewPagerAdapter);
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });

                    ParseQuery<ParseObject> queryUp = ParseQuery.getQuery("Clothes");
                    queryUp.whereEqualTo("part", "up");
                    queryUp.whereEqualTo("tag", weatherList.get(0));
                    queryUp.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    upClothes.add(temp);
                                }
                                System.out.println("UP " + upClothes.size());
                                upViewPager = (ViewPager) findViewById(R.id.upViewPager);
                                ViewPagerAdapter upViewPagerAdapter = new ViewPagerAdapter(context, "veryhot", "up");
                                upViewPager.setAdapter(upViewPagerAdapter);
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });

                    ParseQuery<ParseObject> queryShoes = ParseQuery.getQuery("Clothes");
                    queryShoes.whereEqualTo("part", "shoes");
                    queryShoes.whereEqualTo("tag", weatherList.get(0));
                    queryShoes.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    shoes.add(temp);
                                }
                                System.out.println("shoes " + shoes.size());
                                shoesViewPager = (ViewPager) findViewById(R.id.shoesViewPager);
                                ViewPagerAdapter shoesViewPagerAdapter = new ViewPagerAdapter(context, "veryhot", "shoes");
                                shoesViewPager.setAdapter(shoesViewPagerAdapter);
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }

    public void getImages(final String weather){
        final ParseQuery<ParseObject> query = ParseQuery.getQuery("Tag");
        query.whereEqualTo("name", weather);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> weatherList, ParseException e) {
                if (e == null) {
                    ParseQuery<ParseObject> queryPants = ParseQuery.getQuery("Clothes");
                    queryPants.whereEqualTo("part", "pants");
                    queryPants.whereEqualTo("tag", weatherList.get(0));
                    queryPants.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    pantsClothes.add(temp);
                                    System.out.println(pantsClothes);
                                }
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });

                    ParseQuery<ParseObject> queryUp = ParseQuery.getQuery("Clothes");
                    queryUp.whereEqualTo("part", "up");
                    queryUp.whereEqualTo("tag", weatherList.get(0));
                    queryUp.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    upClothes.add(temp);
                                    System.out.println(upClothes);
                                }
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });

                    ParseQuery<ParseObject> queryShoes = ParseQuery.getQuery("Clothes");
                    queryShoes.whereEqualTo("part", "shoes");
                    queryShoes.whereEqualTo("tag", weatherList.get(0));
                    queryShoes.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> scoreList, ParseException e) {
                            if (e == null) {
                                for (ParseObject temp : scoreList) {
                                    shoes.add(temp);
                                    System.out.println(shoes);
                                }
                            } else {
                                Log.d("score", "Error: " + e.getMessage());
                            }
                        }
                    });
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }
}
