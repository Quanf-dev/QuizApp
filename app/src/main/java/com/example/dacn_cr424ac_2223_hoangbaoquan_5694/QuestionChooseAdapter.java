package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class QuestionChooseAdapter extends ArrayAdapter<NumQuestion> {
    Activity context ;
    int resource ;
    @NonNull List<NumQuestion> object ;

    public QuestionChooseAdapter(@NonNull Activity context, int resource, @NonNull List<NumQuestion> object) {
        super(context, resource, object);
        this.context = context ;
        this.resource = resource ;
        this.object = object ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater() ;

        row = layoutInflater.inflate(this.resource, null) ;

        ImageView imageView = row.findViewById(R.id.imgIcon) ;
        TextView tvName= (TextView) row.findViewById(R.id.tvNumExam);
        TextView tvSave= (TextView) row.findViewById(R.id.tvSave);

        NumQuestion numQuestion = this.object.get(position) ;
        imageView.setImageResource(numQuestion.getImg());
        tvName.setText(numQuestion.getNum_QuestionChoose());
        tvSave.setText(numQuestion.getWhen());


        return row ;
    }
}
