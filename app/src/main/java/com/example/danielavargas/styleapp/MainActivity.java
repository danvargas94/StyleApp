package com.example.danielavargas.styleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout profile, clothes, generate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tag");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        profile = (LinearLayout) findViewById(R.id.btn1);
        clothes = (LinearLayout) findViewById(R.id.btn2);
        generate = (LinearLayout) findViewById(R.id.btn3);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Clothes.class);
                startActivity(intent);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Generate.class);
                startActivity(intent);
            }
        });
    }
}
