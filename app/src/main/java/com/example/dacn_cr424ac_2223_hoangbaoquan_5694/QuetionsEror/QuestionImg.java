package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.NumQuestion;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuestionChoose;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuestionChooseAdapter;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Shared.PrefConfig;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.ScreenSlideActivity;

import java.util.ArrayList;

public class QuestionImg extends AppCompatActivity {
    GridView gridView ;

    QuestionController questionController ;
    ArrayList<Question> numQuestions = new ArrayList<>() ;

    QuestionErrorAdapter questionImgAdapter ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questioneror_activity);

        questionController = new QuestionController(this) ;
        numQuestions = questionController.getQuestionImg() ;
        if(numQuestions.isEmpty() == false && numQuestions.size() > 0 ){
            questionImgAdapter = new QuestionErrorAdapter(QuestionImg.this,R.layout.fragment_quiz,numQuestions) ;
            gridView = findViewById(R.id.gridviewEror) ;
            gridView.setAdapter(questionImgAdapter);
        }
    }

}
