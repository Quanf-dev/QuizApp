package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.DBHelper;

import java.io.IOException;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);


        Database database = new Database(this) ;
        database.open() ;
        Button start = (Button) findViewById(R.id.btQuiz) ;
        Button training = findViewById(R.id.btTraining) ;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RuleActivity.class) ;
                intent.putExtra("Key","Quiz") ;
                startActivity(intent);
            }
        });
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ListTrainActivity.class) ;
                startActivity(intent);
            }
        });
    }
}