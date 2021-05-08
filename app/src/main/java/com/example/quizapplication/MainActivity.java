package com.example.quizapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3;
    TextView question, score;
    private Questions nQuestions = new Questions();
    private String nAnswer;
    private int nScore = 0;
    private int nQuestionsLength = nQuestions.nQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);

        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);

        score.setText("Score: " + nScore + "/100");
        updateQuestion(r.nextInt(nQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: " + nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else{
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: " + nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else{
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: " + nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else{
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num){
        question.setText(nQuestions.getQuestion(num));
        answer1.setText(nQuestions.getChoice1(num));
        answer2.setText(nQuestions.getChoice2(num));
        answer3.setText(nQuestions.getChoice3(num));

        nAnswer = nQuestions.getCorrectAnswer(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Great! Your score is " + nScore)
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}