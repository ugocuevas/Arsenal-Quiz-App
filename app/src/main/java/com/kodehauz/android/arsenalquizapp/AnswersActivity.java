package com.kodehauz.android.arsenalquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
    }

    public void restartQuiz(View view) {
        Intent quizIntent = new Intent(AnswersActivity.this, MainActivity.class);
        startActivity(quizIntent);
    }
}
