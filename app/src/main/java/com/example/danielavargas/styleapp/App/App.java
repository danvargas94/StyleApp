package com.example.danielavargas.styleapp.App;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by arturogr on 04/05/17.
 */

public class App extends Application {



    @Override
    public void onCreate(){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("6gzBfgad2irRCWsbK38njQ6s9wo49M6Yn6Y8pL2l")
                .clientKey("bEisAzCDb9gSX4YDhDVJn6ubzaGiLdmU8SS7D4HF")
                .server("https://parseapi.back4app.com/").build()
        );





    }



}
