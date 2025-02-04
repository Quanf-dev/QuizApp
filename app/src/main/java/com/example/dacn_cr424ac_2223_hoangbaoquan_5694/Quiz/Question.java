package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Question implements Serializable  {
    private int id;
    private String question, ans_a, ans_b, ans_c, ans_d, result, image,ans_eror;

    private int num_exam;

    private String traloi="";

    public int choiceID= -1; //hỗ trợ check Id của radiogroup

    public String getAns_eror() {
        return ans_eror;
    }

    public void setAns_eror(String ans_eror) {
        this.ans_eror = ans_eror;
    }


    public Question(int id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, String image, int num_exam, String traloi, String ans_eror) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.image = image;
        this.num_exam = num_exam;
        this.traloi = traloi;
        this.ans_eror = ans_eror;
    }
    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }


    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }
}



