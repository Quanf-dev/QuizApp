package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.QuetionsEror;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.CheckAnswerAdapter;

import java.util.ArrayList;
import java.util.List;


public class QuestionErrorAdapter extends BaseAdapter {

    Activity context ;
    LayoutInflater minflater;


    int resource ;
    @NonNull ArrayList<Question> Question ;
    RadioButton radA, radB, radC, radD;
    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;


    public QuestionErrorAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Question> Question) {
        this.context = context ;
        this.resource = resource ;
        this.Question = Question ;
    }
    private static class ViewHolder{

    }

    @Override
    public int getCount() {
        return Question.size();
    }

    @Override
    public Object getItem(int position) {
        return Question.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater() ;
        row = layoutInflater.inflate(this.resource, null) ;
        Log.e("aa", String.valueOf(position)) ;
        Question numQuestion = Question.get(position);

        radioGroup = row.findViewById(R.id.radGroup) ;
        ImageView imgIcon=(ImageView) row.findViewById(R.id.ivIcon) ;
        tvNum = (TextView) row.findViewById(R.id.tvNum);
        tvQuestion = (TextView) row.findViewById(R.id.tvQuestion);
        radA = (RadioButton) row.findViewById(R.id.radA);
        radB = (RadioButton) row.findViewById(R.id.radB);
        radC = (RadioButton) row.findViewById(R.id.radC);
        radD = (RadioButton) row.findViewById(R.id.radD);

        tvNum.setText("Câu " + (position + 1));
        tvQuestion.setText(numQuestion.getQuestion());
        radA.setText("A. " + numQuestion.getAns_a());
        radB.setText("B. " + numQuestion.getAns_b());
        if (numQuestion.getAns_c() == null) {
            radC.setVisibility(View.GONE);
        } else radC.setText("C." + numQuestion.getAns_c());
        if (numQuestion.getAns_d() == null) {
            radD.setVisibility(View.GONE);
        } else radD.setText("D." + numQuestion.getAns_d());

        if (numQuestion.getImage() != null) {
            imgIcon.setImageResource(row.getResources().getIdentifier(numQuestion.getImage() + "", "drawable", row.getContext().getPackageName()));
        }
                    getCheckAns(numQuestion.getResult().toString());
                    radA.setClickable(false);
                    radB.setClickable(false);
                    radC.setClickable(false);
                    radD.setClickable(false);


//                Toast.makeText(getActivity(),"Đây là đáp án "+ checkedId, Toast.LENGTH_SHORT).show();
        



        return row ;
    }
    private void getCheckAns(String ans){
        if(ans.equals("A")==true){
            radA.setBackgroundResource(R.drawable.rightans_custom);
        }
        else if(ans.equals("B")==true){
            radB.setBackgroundResource(R.drawable.rightans_custom);
        }else if(ans.equals("C")==true){
            radC.setBackgroundResource(R.drawable.rightans_custom);
        }else if(ans.equals("D")==true){
            radD.setBackgroundResource(R.drawable.rightans_custom);
        }else ;
    }
    private void getClickAns(String ans){
        if(ans.equals("A")==true){
            radA.setBackgroundResource(R.drawable.ans_custom);
        }
        else if(ans.equals("B")==true){
            radB.setBackgroundResource(R.drawable.ans_custom);
        }else if(ans.equals("C")==true){
            radC.setBackgroundResource(R.drawable.ans_custom);
        }else if(ans.equals("D")==true){
            radD.setBackgroundResource(R.drawable.ans_custom);
        }else ;
    }
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

}
