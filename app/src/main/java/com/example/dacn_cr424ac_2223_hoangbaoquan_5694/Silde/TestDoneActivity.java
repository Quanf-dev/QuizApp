package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Database;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Info;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuestionChoose;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.SignUpActivity;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDoneActivity extends AppCompatActivity  {
    ArrayList<Question> arr_QuesBegin = new ArrayList<Question>();
    ArrayList<Info> arr_Info = new ArrayList<Info>();
    int numEror = 0;
    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int totalScore = 0;
    int num_Train = 0  ;
    Database database ;
    TextView tvTrue, tvFalse, tvNotAns, tvFinal,tvID,tvName,tvNumber,tvStatus,tvDate;
    Button btnCheckFalse;

    TextView btnExit,btnAgain;
    SignUpActivity signUpActivity ;
    Date currentTime = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R.layout.activity_test_done);

        final Intent intent = getIntent();
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        num_Train = intent.getIntExtra("num_exam1",0);
        begin();
        checkResult();

        database = new Database(this) ;
        btnAgain = findViewById(R.id.btnAgain) ;
        btnAgain.setVisibility(View.GONE);
        String keyTrain = intent.getStringExtra("keyTrain");
        if(keyTrain.equalsIgnoreCase("Train")){
            LinearLayout layout = findViewById(R.id.card2) ;
            layout.setVisibility(View.GONE);
            btnAgain.setVisibility(View.VISIBLE);
            btnExit.setVisibility(View.GONE);
            tvNotAns.setText("" + numNoAns);
            tvFalse.setText("" + numFalse);
            tvTrue.setText("" + numTrue);
            int trueAns = Integer.parseInt(tvTrue.getText().toString());

            if (numTrue >=32 && numEror == 3) {
                tvFinal.setText(" ĐẠT - Chúc mừng bạn đã thi đậu");
                tvStatus.setText("B2- ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorClick));
            } else if (trueAns >= 32) {
                tvFinal.setText("KHÔNG ĐẠT - Sai câu điểm liệt");
                tvStatus.setText("B2- (KHÔNG ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorAccent));
            } else {
                tvFinal.setText("KHÔNG ĐẠT - Vui lòng luyện thêm");
                tvStatus.setText("B2- (KHÔNG ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorAccent));
            }
            btnAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TestDoneActivity.this, QuestionChoose.class) ;
                    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss , dd-MM-yyyy", Locale.getDefault());
                    String formattedDate = df.format(currentTime);
                    intent.putExtra("num_exam",num_Train) ;
                    intent.putExtra("Date",formattedDate) ;
                    String status = tvStatus.getText().toString() ;
                    intent.putExtra("Status",status) ;
                    intent.putExtra("arr_Ques", arr_QuesBegin);
                    startActivity(intent);
                    finish();
                }
            });
        }else{
            Bundle b = getIntent().getExtras();
            long id = b.getLong("id");
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss , dd-MM-yyyy", Locale.getDefault());
            String formattedDate = df.format(currentTime);

            arr_Info = database.getInfo(id) ;

            tvID.setText(String.valueOf(arr_Info.get(0).getId()));
            tvName.setText(arr_Info.get(0).getName());
            tvNumber.setText(arr_Info.get(0).getPhone());
            tvDate.setText(formattedDate);

            tvNotAns.setText("" + numNoAns);
            tvFalse.setText("" + numFalse);
            tvTrue.setText("" + numTrue);

            int trueAns = Integer.parseInt(tvTrue.getText().toString());

            if (numTrue >=32 && numEror == 3) {
                tvFinal.setText(" ĐẠT - Chúc mừng bạn đã thi đậu");
                tvStatus.setText("B2- ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorClick));
            } else if (trueAns >= 32) {
                tvFinal.setText("KHÔNG ĐẠT - Sai câu điểm liệt");
                tvStatus.setText("B2- (KHÔNG ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorAccent));
            } else {
                tvFinal.setText("KHÔNG ĐẠT - Vui lòng thi lại đợt sau");
                tvStatus.setText("B2- (KHÔNG ĐẠT)");
                tvStatus.setTextColor(getColor(R.color.colorAccent));
            }

        }



        btnCheckFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent.putExtra("arr_Ques", arr_QuesBegin);
                intent.putExtra("test", "yes");
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    public void begin() {
        tvFalse = (TextView) findViewById(R.id.tvFalse);
        tvTrue = (TextView) findViewById(R.id.tvTrue);
        tvNotAns = (TextView) findViewById(R.id.tvNotAns);
        tvFinal = (TextView) findViewById(R.id.tvFinal);
        btnCheckFalse = (Button) findViewById(R.id.btnCheckfalse);
        btnExit = (TextView) findViewById(R.id.btnExit);
        tvID = (TextView) findViewById(R.id.tvID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvDate = (TextView) findViewById(R.id.tvDate);
    }

    //PT Check kết quả
    public void checkResult() {
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            if (arr_QuesBegin.get(i).getAns_eror() != null && arr_QuesBegin.get(i).getAns_eror().equals(arr_QuesBegin.get(i).getTraloi()) == true) {
                numEror++;
                numTrue++;
            }else if (arr_QuesBegin.get(i).getTraloi().equals("") == true) {
                numNoAns++;
            } else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true) {
                numTrue++;
            } else numFalse++;
        }

    }

}

