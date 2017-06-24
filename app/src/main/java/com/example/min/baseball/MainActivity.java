package com.example.min.baseball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.InputMismatchException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    Button button;
    int[] make = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.change);



    }

    public void makingNum() {

        while (true) {

            for (int j = 0; j <= 2; j++) {
                make [j] = (int) (Math.random() * 9) + 1;// typecasting

            }
            if (make [0] != make [1] && make [1] != make [2] && make [2] != make [0])
                break;
        }

    }
    //숫자생성,중복제거


    public void changeView (View v){
        makingNum();

        Intent intent = new Intent(getApplicationContext(),SubActivity.class);

        intent.putExtra("first",make [0]);
        intent.putExtra("second",make [1]);
        intent.putExtra("third",make [2]);//숫자 보내기
        startActivity(intent);//화면전환
    }
}





