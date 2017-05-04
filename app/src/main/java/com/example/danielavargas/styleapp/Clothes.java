package com.example.danielavargas.styleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Clothes extends AppCompatActivity {

    GridView gridView;
    Context context;
    int icons[] = {R.drawable.pants1, R.drawable.falda3, R.drawable.shoes2, R.drawable.blusa2, R.drawable.blusa1}; // hola Dani lololololololol

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        context = getApplicationContext();
        gridView = (GridView) findViewById(R.id.icons);

        ParseQuery<ParseObject> queryShoes = ParseQuery.getQuery("Clothes");
        queryShoes.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> clothes, ParseException e) {
                if (e == null) {
                    gridView.setAdapter(new GridAdapter(context, clothes));
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        //gridView.setAdapter(new GridAdapter(this, icons));

    }
}
