package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.DBHelper;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.SignUpActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifDrawable;

public class ScreenSlideActivity extends FragmentActivity {
    private static final int NUM_PAGES = 35;


    private ViewPager mPager ;
    private PagerAdapter mPagerAdapter;
    public int checkAns = 0 ;
    QuestionController questionController;

    ArrayList<Question> arr_Ques;
    TextView  tvTimer;
    TextView tvKiemtra,tvExit ;
    ProgressBar progressBar ;
    CounterClass timer;
    String test="",key="";
    int totalTimer;
    int num_exam1 ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activy);
        DBHelper db = new DBHelper(this) ;
        progressBar = findViewById(R.id.progessbar) ;

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        tvExit = (TextView) findViewById(R.id.tvExit1)  ;
        tvExit.setVisibility(View.GONE);

        tvKiemtra = (TextView) findViewById(R.id.tvKiemTra1) ;
//        tvKiemtra = (TextView) findViewById(R.id.tvKiemTra);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        totalTimer = 22;
        timer = new CounterClass(totalTimer * 60 * 1000, 1000);

        Intent intent = getIntent();
        test= intent.getStringExtra("test");
        key= intent.getStringExtra("key");

        questionController = new QuestionController(this);
        arr_Ques = new  ArrayList<Question>();

        Random rand = new Random();


        int randomQuesTion = rand.nextInt(1); ;

        if(randomQuesTion == 0 ){
            randomQuesTion +=1 ;
        }

        if(key != null && key.equalsIgnoreCase("train")){
            num_exam1 = intent.getIntExtra("num_exam1",0) ;
            arr_Ques = questionController.getQuestion(num_exam1) ;
        }else if(key != null && key.equalsIgnoreCase("history")){
            tvTimer.setVisibility(View.GONE);
            arr_Ques = (ArrayList<Question>) intent.getExtras().getSerializable("num_exam1");
            checkAns = 1;
            mPager.setAdapter(mPagerAdapter);
            tvKiemtra.setVisibility(View.GONE);
            tvExit.setVisibility(View.VISIBLE);
            tvExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(1);
                }
            });
        }else{
            arr_Ques = questionController.getQuestion(randomQuesTion) ;
        }

        if(test != null && test.equalsIgnoreCase("yes")==true) {
            tvTimer.setVisibility(View.GONE);
            arr_Ques = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
            checkAns = 1;
            mPager.setAdapter(mPagerAdapter);
            tvKiemtra.setVisibility(View.GONE);
            tvExit.setVisibility(View.VISIBLE);
            tvExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(1);
                }
            });
        }


        tvKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
        Log.e("Page", String.valueOf(mPager.getCurrentItem()));
        progressBar.setMax(20);

        timer.start();
    }

    public ArrayList<Question> getData() {
        return arr_Ques;
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.e("Page", String.valueOf(mPager.getCurrentItem()));
            progressBar.setMax(NUM_PAGES);
            progressBar.setProgress(mPager.getCurrentItem() + 1);
            return ScreenSlidePageFragment.create(position, checkAns);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
    public void checkAnswer() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Danh sách câu trả lời");

        CheckAnswerAdapter answerAdapter = new CheckAnswerAdapter(arr_Ques, this);
        GridView gvLsQuestion = (GridView) dialog.findViewById(R.id.gvLsQuestion);
        gvLsQuestion.setAdapter(answerAdapter);

        gvLsQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });

        Button btnCancle, btnFinish;
        btnCancle = (Button) dialog.findViewById(R.id.btnCancle);
        btnFinish = (Button) dialog.findViewById(R.id.btnFinish);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////
                timer.cancel();
                dialog.dismiss();
                result();
                Intent intent1 = new Intent(ScreenSlideActivity.this, TestDoneActivity.class);
                Intent intent = getIntent() ;
                num_exam1 = intent.getIntExtra("num_exam1",0) ;
                intent1.putExtra("arr_Ques", arr_Ques);
                intent1.putExtra("num_exam1", num_exam1);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    intent1.putExtras(bundle);
                }
                if(key != null && key.equalsIgnoreCase("train")){
                    intent1.putExtra("keyTrain","Train");
                }else{
                    intent1.putExtra("keyTrain","false");
                }

                startActivity(intent1);
            }
        });

        dialog.show();
    }
    public void result() {
        checkAns = 1;
        mPager.setAdapter(mPagerAdapter);
    }

    public class CounterClass extends CountDownTimer {



        //millisInFuture: 60*1000
        //countDownInterval:  1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
            result();
        }
    }


}
