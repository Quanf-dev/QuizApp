package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {


    Database database;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Database database = new Database(this) ;

        EditText edtID = findViewById(R.id.idcccd) ;

        Button registerbutton = findViewById(R.id.regísterButton) ;


        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtID = findViewById(R.id.idcccd) ;
                EditText edtPass = findViewById(R.id.password) ;
                EditText edtName = findViewById(R.id.name) ;
                EditText edtPhone = findViewById(R.id.phone);
                String number= edtID.getText().toString();
                String Name= edtName.getText().toString()+"";
                String Phone = edtPhone.getText().toString() ;
                String pass = edtPass.getText().toString() + "" ;

                if(pass.equals("") || Name.equals("") || Phone == null || number == null){
                    Toast.makeText(SignUpActivity.this, "Vui lòng không để trống dữ liệu nhập vào", Toast.LENGTH_SHORT).show();
                }else{
                    long idcccd = Long.parseLong(edtID.getText().toString()) ;
                    if(CheckRangeIdCCCD(idcccd)){
                        long phone = Long.parseLong(edtPhone.getText().toString()) ;
                        if(CheckRangePhone(phone)){
                            if(CheckRangeName(Name)){
                                Boolean checkUser = database.CheckUser(idcccd);
                                if(checkUser == false){
                                    Boolean insert = database.insertData(idcccd,pass,Name,Phone) ;
                                    if(insert == true){
                                        Toast.makeText(SignUpActivity.this, "Đăng Ký Thành Công!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(SignUpActivity.this, "Đăng Ký thất bại!", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(SignUpActivity.this, "IDCCCD Đã tồn tại!", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(SignUpActivity.this, "Nhập đầy đủ Họ và Tên", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this, "SDT bao gồm 11 số", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this,"ID CCCD bao gồm 12 số",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public boolean CheckRangeIdCCCD(long idcccd){
        int count = 0  ;
        while (idcccd != 0){
            idcccd /= 10  ;
            count++ ;
        }
        if(count == 12) return true;
        return false ;
    }
    public boolean CheckRangePhone(long phone){
        int count = 0  ;
        while (phone != 0){
            phone /= 10  ;
            count++ ;
        }
        if(count == 11) return true;
        return false ;
    }
    public boolean CheckRangeName(String name) {
        Log.e("ten",name);
//        Log.e("teen", String.valueOf(name.charAt(3))) ;
        int i = 0 ;
        boolean x = false ;
        while (i < name.length()){
            char c = name.charAt(i) ;
            char y = ' ' ;
            if(Character.compare(c,y) > 0 ){
                x = false ;
            }
            else{
                x = true ;
                break ;
            }
            ++i ;
        }
        return x ;
    }
}

