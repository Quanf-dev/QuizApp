package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror.QuestionAllActivity;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror.QuestionErrorActivity;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror.QuestionImg;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.StikeyAdapter.TipsActivity;

public class ListTrainActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_train_activity);

        Toolbar toolbar = findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");



        LinearLayout lnExam18 = findViewById(R.id.lnExam18) ;
        LinearLayout lnError = findViewById(R.id.lnError) ;
        CardView cardViewImg = findViewById(R.id.cardImg);
        CardView cardHistory = findViewById(R.id.cardHistory);
        CardView cardAll = findViewById(R.id.cardAll);
        CardView cardRemember = findViewById(R.id.cardRemember);
        cardRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, TipsActivity.class) ;
                startActivity(intent);
            }
        });
        cardAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, QuestionAllActivity.class) ;
                startActivity(intent);
            }
        });
        cardHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, QuestionChoose.class) ;
                intent.putExtra("key",1) ;
                startActivity(intent);
            }
        });
        cardViewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, QuestionImg.class) ;
                startActivity(intent);
            }
        });

        lnExam18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, QuestionChoose.class) ;
                startActivity(intent);
            }
        });
        lnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTrainActivity.this, QuestionErrorActivity.class) ;
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
