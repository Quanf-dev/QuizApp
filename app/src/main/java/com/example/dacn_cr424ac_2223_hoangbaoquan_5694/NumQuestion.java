package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import java.io.Serializable;

public class NumQuestion implements Serializable {

    private String num_QuestionChoose ;
    private int img ;

    private String when ;

    public NumQuestion(String num_QuestionChoose, int img,String when) {
        this.num_QuestionChoose = num_QuestionChoose;
        this.img = img;
        this.when = when;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getNum_QuestionChoose() {
        return num_QuestionChoose;
    }

    public void setNum_QuestionChoose(String num_QuestionChoose) {
        this.num_QuestionChoose = num_QuestionChoose;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
