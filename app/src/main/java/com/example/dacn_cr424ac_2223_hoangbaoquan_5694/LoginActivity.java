package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde.ScreenSlideActivity;

public class LoginActivity extends AppCompatActivity {
    Database database ;

    long idcccd;
    private static final String NAME = "id" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Database database = new Database(this) ;
        Button btDangNhap = (Button) findViewById(R.id.loginButton) ;

        TextView tvSignUp = (TextView) findViewById(R.id.signupText) ;
        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtID = findViewById(R.id.username) ;
                EditText edtPass = findViewById(R.id.password);
                String Sidcccd = edtID.getText().toString() ;
                String pass = edtPass.getText().toString() + "";
                if (pass.equals("") || Sidcccd == null){
                    Toast.makeText(LoginActivity.this,"Vui Lòng nhập tài khoản",Toast.LENGTH_SHORT).show();
                }else{
                    idcccd = Long.parseLong(edtID.getText().toString()) ;
                    if(CheckRangeIdCCCD(idcccd)){
                        boolean check = database.CheckSign(idcccd, pass);
                        if (check == true) {
                            Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, ScreenSlideActivity.class) ;
                            intent.putExtra("id",idcccd) ;
                            intent.putExtra("key","Quiz") ;
                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this,"ID CCCD bao gồm 12 số",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class) ;
                startActivity(intent);
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


}