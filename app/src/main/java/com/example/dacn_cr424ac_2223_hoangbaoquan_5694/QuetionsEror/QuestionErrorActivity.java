package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.NumQuestion;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuestionChoose;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuestionChooseAdapter;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.ScreenSlideActivity;

import java.util.ArrayList;

public class QuestionErrorActivity extends AppCompatActivity {
    QuestionErrorAdapter questionErrorAdapter ;
    QuestionController questionController ;
    ArrayList<Question> arr_Questions = new ArrayList<>() ;
    GridView gridView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questioneror_activity);

        questionController = new QuestionController(this) ;
        arr_Questions = questionController.getQuestionError() ;
        if(arr_Questions != null && arr_Questions.size() >0 ){
            questionErrorAdapter = new QuestionErrorAdapter(QuestionErrorActivity.this,R.layout.fragment_quiz,arr_Questions) ;
            gridView = findViewById(R.id.gridviewEror) ;
            gridView.setAdapter(questionErrorAdapter);

        }





    }

}
