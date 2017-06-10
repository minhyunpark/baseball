package com.example.min.baseball;

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

    int countStrike;
    int countBall;
    int countOut;
    int[] com = new int[3];
    int[] user = new int[3];
    TextView check1;
    TextView check2;
    TextView check3;

    TextView strike;
    TextView ball;
    EditText input;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1 = (TextView) findViewById(R.id.check1);
        check2 = (TextView) findViewById(R.id.check2);
        check3 = (TextView) findViewById(R.id.check3);
        strike = (TextView) findViewById(R.id.strike);
        ball = (TextView) findViewById(R.id.ball);
        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);

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

    public void userNum() {


        for (int i = 0; i < 3; i++) {
            user[i] = input.getText().charAt(i);


        }

    }

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
        strike.setText(Integer.toString(countStrike));
        ball.setText(Integer.toString(countBall));

    }

    public void start(View v) {
        makingNum();
        check1.setText(Integer.toString(user[0]));
        check2.setText(Integer.toString(user[1]));
        check3.setText(Integer.toString(user[2]));
        userNum();
        checkingNum();


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


