package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.DBHelper;

import java.io.IOException;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        DBHelper dbHelper = new DBHelper(this) ;
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread( ){
            @Override
            public void run() {
                try{
                    sleep(1000);
                    startActivity(new Intent(SplashScreen.this,WelcomeActivity.class) );
                    finish();
                }catch (Exception e){

                }
            }
        };thread.start();


    }
}
