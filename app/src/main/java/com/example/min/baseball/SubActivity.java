package com.example.min.baseball;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;





public class SubActivity extends AppCompatActivity {

    int countStrike;
    int countBall;
    int countOut;
    int[] com = new int[3];
    int[] user = new int[3];
    TextView check1;
    TextView check2;
    TextView check3;

    TextView view;


    EditText input;
    Button button;

    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);//xml 연결


        check1 = (TextView) findViewById(R.id.check1);
        check2 = (TextView) findViewById(R.id.check2);
        check3 = (TextView) findViewById(R.id.check3);
        view = (TextView) findViewById(R.id.view);


        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);


        com[0] = getIntent().getIntExtra("first", 0);
        com[1] = getIntent().getIntExtra("second", 0);
        com[2] = getIntent().getIntExtra("third", 0);//intent 값 받기




    }

    public void makingNum() {

        while (true) {

            for (int j = 0; j <= 2; j++) {
                com[j] = (int) (Math.random() * 9) + 1;// typecasting

            }
            if (com[0] != com[1] && com[1] != com[2] && com[2] != com[0])
                break;
        }

    }
    //숫자생성,중복제거


    public void userNum() throws Exception {


        for (int i = 0; i < 3; i++) {
            if (input.getText().charAt(i) <= 47 || input.getText().charAt(i) >= 58) {

                throw new Exception("오류발생 : 1~9 사이의 숫자를 입력하세요");
            }
            user[i] = input.getText().charAt(i) - 48;//char to dec ASCII
        }
        if (user[0] == user[1] || user[1] == user[2] || user[2] == user[0]) {
            throw new Exception("오류발생 : 서로 다른 숫자를 입력하세요");
        }

    }
    //사용자 숫자 입력부분


    public void checkingNum() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((com[i] == user[j])) {
                    if (i == j) {
                        countStrike += 1;
                    } else {
                        countBall += 1;
                    }

                }
            }
        }
        countOut += 1;


        view.setText(String.valueOf("Strike  " + countStrike+ "  Ball  " + countBall + "  count  " +countOut));

        Toast.makeText(SubActivity.this,  countStrike + "strike  " +  countBall + "ball  "+ "  count" +countOut, Toast.LENGTH_LONG).show();

    }
    //생성된 숫자와 사용자 숫자 비교


    public void start(View v) {


        check1.setText(Integer.toString(com[0]));
        check2.setText(Integer.toString(com[1]));
        check3.setText(Integer.toString(com[2]));//숫자 확인용

        try {

            userNum();
            checkingNum();
            if (countStrike == 3) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    // 제목
                    alertDialogBuilder.setTitle("3strike YOU WIN\n" + countOut+"번만에 맞추셨습니다");

                    // AlertDialog 셋팅
                    alertDialogBuilder
                            .setMessage("다시 하시겠습니까?")
                            .setCancelable(false)
                            //오른쪽
                            .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            finishAffinity();//종료하기 finish는 안됨
                                        }
                                    })
                            //왼쪽
                            .setNegativeButton("재시작", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel(); // 다이얼로그를 취소
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);//화면전환
                                }

                            });
                    // 다이얼로그 객체 생성
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // 다이얼로그 부르기
                    alertDialog.show();




            }
            countStrike = 0;
            countBall = 0;
        } catch (Exception e) {
            Toast.makeText(SubActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}




/*
    public void makingNum() {

        while (true) {

            for (int j = 0; j <= 2; j++) {
                com[j] = (int) (Math.random() * 9) + 1;// typecasting

            }
            if (com[0] != com[1] && com[1] != com[2] && com[2] != com[0])
                break;
        }

    }

    public void userNum() throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            user[i] = sc.nextInt();

            if (user[i] < 1 || user[i] > 9) {
                throw new Exception("오류발생 : 1~9 사이의 숫자를 입력하세요");
            }
        }
        if (user[0] == user[1] || user[1] == user[2] || user[2] == user[0]) {
            throw new Exception("오류발생 : 서로 다른 숫자를 입력하세요");
        }

    }

    public void checkingNum() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((com[i] == user[j])) {
                    if (i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }

                }
            }
        }
        out += 1;
        System.out.printf("Strike /// Ball /// OUT(%d chance left)\n", 9 - out);
        System.out.printf("%d        %d        %d\n", strike, ball, out);

    }

    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        baseball.makingNum();
        System.out.println(baseball.com[0]);
        System.out.println(baseball.com[1]);
        System.out.println(baseball.com[2]);

        outer_loop:
        while (true) {
            try {
                while (true) {
                    System.out.println("3가지 숫자를 입력하세요");
                    baseball.userNum();
                    baseball.checkingNum();

                    if (baseball.strike == 3) {
                        System.out.println("\nYOU WIN");
                        break outer_loop;
                    } else if (baseball.out == 9) {
                        System.out.println("\nYOU LOSE");
                        break outer_loop;
                    }
                    baseball.strike = 0;
                    baseball.ball = 0;

                }

            } catch (InputMismatchException e) {
                System.out.println("오류발생 : 숫자를 입력하세요");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
*/

