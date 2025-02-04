package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.ScreenSlideActivity;

public class RuleActivity extends AppCompatActivity {

    Button btnStart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        String key = getIntent().getStringExtra("Key");

        btnStart = findViewById(R.id.btnStart) ;
        if(key.equalsIgnoreCase("Train")){
           btnStart.setText("Bắt Đầu Làm");
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(key.equalsIgnoreCase("Quiz")){
                    Intent intent = new Intent(RuleActivity.this, LoginActivity.class) ;
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(RuleActivity.this, QuestionChoose.class) ;
                    startActivity(intent);
                }
            }
        });
    }
}