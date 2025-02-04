package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;

import java.util.ArrayList;

public class QuestionAllActivity extends AppCompatActivity {
    QuestionErrorAdapter questionErrorAdapter;
    QuestionController questionController;
    ArrayList<Question> arr_Questions = new ArrayList<>();
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questioneror_activity);
        questionController = new QuestionController(this);
        arr_Questions = questionController.getQuestionAll();
        if (arr_Questions != null && arr_Questions.size() > 0) {
            questionErrorAdapter = new QuestionErrorAdapter(QuestionAllActivity.this, R.layout.fragment_quiz, arr_Questions);
            gridView = findViewById(R.id.gridviewEror);
            gridView.setAdapter(questionErrorAdapter);
        }
    }
}
