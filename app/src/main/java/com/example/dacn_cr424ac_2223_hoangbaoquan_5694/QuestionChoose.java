package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.DBHelper;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Shared.PrefConfig;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Shared.PrefConfigHistoryChoose;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.ScreenSlideActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class QuestionChoose extends AppCompatActivity {
    GridView gridView ;

    QuestionController questionController ;
    ArrayList<NumQuestion> numQuestions = new ArrayList<>() ;
    ArrayList<Question> arr_Ques = new ArrayList<>() ;

    ArrayList<NumQuestion> numQuestions1 = new ArrayList<>() ;
    QuestionChooseAdapter questionChooseAdapter ;
    int k = 0 ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionchoose_activity);

        Toolbar toolbar = findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        questionController = new QuestionController(this) ;
        ArrayList<NumQuestion> numQuestions1 = new ArrayList<>() ;
        int num = questionController.getQuestionChoose() ;
        if(PrefConfig.readListFromPref(this) == null){
            for (int i = 1; i <= 10; i++) {
                numQuestions.add(new NumQuestion("Đề số: " + i, R.drawable.test, " "));
            }
            PrefConfig.writeListInPref(getApplicationContext(),numQuestions);
        }else{
            numQuestions = PrefConfig.readListFromPref(this) ;
        }

        addControl();

    }
    private void addControl(){
        Intent intent= getIntent() ;
        gridView = findViewById(R.id.gridview) ;
        if(intent.getStringExtra("Status") != null && intent.getStringExtra("Date") != null ){
            String status = intent.getStringExtra("Status") ;
            String date = intent.getStringExtra("Date") ;
            int numexam = intent.getIntExtra("num_exam",0) ;
            arr_Ques = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
            numQuestions.get(numexam - 1).setWhen(status +"\n" + date) ;
            PrefConfigHistoryChoose.writeListInPref(getApplicationContext(),arr_Ques);
            PrefConfig.writeListInPref(getApplicationContext(),numQuestions);
            k = 1 ;
        }
        int key = intent.getIntExtra("key",0);
        if(PrefConfigHistoryChoose.readListFromPref(this) != null && key == 1 ){
            arr_Ques = PrefConfigHistoryChoose.readListFromPref(this) ;
            for (int i = 0; i < numQuestions.size() ; i++) {
                if(numQuestions.get(i).getWhen().equals(" ") == false ){
                    numQuestions1.add(numQuestions.get(i));
                }
            }
            questionChooseAdapter = new QuestionChooseAdapter(QuestionChoose.this,R.layout.item_gridview,numQuestions1) ;
            gridView.setAdapter(questionChooseAdapter);
        }else if(key == 1 && arr_Ques.size() == 0 ){
            gridView.setAdapter(null);
        }else{
            questionChooseAdapter = new QuestionChooseAdapter(QuestionChoose.this,R.layout.item_gridview,numQuestions) ;
            gridView.setAdapter(questionChooseAdapter);
        }


        if(key == 1 && arr_Ques.size() > 0 ){
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(QuestionChoose.this, ScreenSlideActivity.class) ;
                    intent.putExtra("num_exam1",arr_Ques) ;
                    intent.putExtra("key","history") ;
                    startActivity(intent);
                }
            });
        } else if (key == 1 ) {
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(QuestionChoose.this, ScreenSlideActivity.class) ;
                    intent.putExtra("num_exam1",position + 1) ;
                    intent.putExtra("key","train") ;
                    startActivity(intent);
                }
            });
        } else{
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(QuestionChoose.this, ScreenSlideActivity.class) ;
                    intent.putExtra("num_exam1",position + 1) ;
                    intent.putExtra("key","train") ;
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            startActivity(new Intent(QuestionChoose.this,ListTrainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (k == 1 ) {
            k = 0;

            Intent i = new Intent(this, ListTrainActivity.class);
            startActivity(i);
        } else {
            super.onBackPressed();
        }
    }
}
