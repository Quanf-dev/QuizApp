package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;
    public static  String TB_TracNghiem = "tracnghiem" ;
    public static  String TB_TracNghiem_NumExam = "num_exam" ;
    public static  String TB_TracNghiem_QuestionError = "questioneror" ;
    public static  String TB_TracNghiem_QuestionImg = "image" ;
    public QuestionController(Context context) {
        dbHelper= new DBHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<Question> getQuestion(int num_exam){
        ArrayList<Question> lsData= new ArrayList<Question>();
        Cursor cursor= dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " +TB_TracNghiem+  " Where " + TB_TracNghiem_NumExam + " = " +num_exam,null);
        cursor.moveToFirst();
        do {
            Question item;
            item= new Question(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(8),cursor.getInt(7),"",cursor.getString(9));
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
    public int getQuestionChoose(){
        ArrayList<Question> lsData= new ArrayList<Question>();
        Cursor cursor= dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " +TB_TracNghiem+"",null);
        cursor.moveToFirst();
        do {
            Question item;
            item= new Question(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(8),cursor.getInt(7),"",cursor.getString(9));
            lsData.add(item);
        }while (cursor.moveToNext());
        int sum = 0 ;
        int k = 0 ;
        for(int i = 0 ; i < lsData.size(); i++){
            if(lsData.get(i).getNum_exam() != k ){
                ++sum ;
                ++k;
            }
        }
        return sum;
    }
    public ArrayList<Question> getQuestionError(){
        ArrayList<Question> lsData= new ArrayList<Question>();
        Cursor cursor= dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " +TB_TracNghiem+  " Where " + TB_TracNghiem_QuestionError + " IS NOT NULL",null);
        cursor.moveToFirst();
        do {
            Question item;
            item= new Question(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(8),cursor.getInt(7),"",cursor.getString(9));
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
    public ArrayList<Question> getQuestionImg(){
        ArrayList<Question> lsData= new ArrayList<Question>();
        Cursor cursor= dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " +TB_TracNghiem+  " Where " + TB_TracNghiem_QuestionImg + " IS NOT NULL",null);
        cursor.moveToFirst();
        do {
            Question item;
            item= new Question(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(8),cursor.getInt(7),"",cursor.getString(9));
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
    public ArrayList<Question> getQuestionAll(){
        ArrayList<Question> lsData= new ArrayList<Question>();
        Cursor cursor= dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " +TB_TracNghiem+ "",null);
        cursor.moveToFirst();
        do {
            Question item;
            item= new Question(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(8),cursor.getInt(7),"",cursor.getString(9));
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }

}
