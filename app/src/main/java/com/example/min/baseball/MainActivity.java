package com.example.min.baseball;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;





public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.change);
        button2 = (Button) findViewById(R.id.introduce);
        setContentView(R.layout.activity_main);//이미지view 불러오기

    }


    public void ChangeView(View v) {
        SubActivity s = new SubActivity();
        s.makingNum();

        Intent intent = new Intent(getApplicationContext(), SubActivity.class);

        intent.putExtra("first", s.com[0]);
        intent.putExtra("second", s.com[1]);
        intent.putExtra("third", s.com[2]);//숫자 보내기
        startActivity(intent);//화면전환
    }

    public void IntroduceGame(View v) {

        switch (v.getId()) {

            case R.id.introduce://버튼이 눌러졌을때 돌아가게 하는 방법

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("게임 방법");// 제목셋팅

                // AlertDialog 셋팅
                alertDialogBuilder
                        .setMessage("숫자야구란 지정된 3가지 숫자를 맞추는 게임입니다\n" +
                                "숫자와 위치 모두 맞추면 strike\n" +
                                "숫자만 맞추면 ball\n" +
                                "3 strike시 승리하게 됩니다")


                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();// 다이얼로그를 취소
                            }
                        });

                // 다이얼로그 객체 생성
                AlertDialog alertDialog = alertDialogBuilder.create();

                // 다이얼로그 부르기
                alertDialog.show();
                break;

            default:
                break;
        }
    }


}







