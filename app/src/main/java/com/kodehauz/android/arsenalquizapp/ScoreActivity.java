package com.kodehauz.android.arsenalquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoresTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoresTextView = findViewById(R.id.scoresTextView);
        Intent intentFromMainActivity = getIntent();
        if (intentFromMainActivity.hasExtra("Scores")){
            int scores = intentFromMainActivity.getIntExtra("Scores", 0);
            scoresTextView.setText(String.valueOf(scores));
        }
    }

    public void restartQuiz(View view) {
        Intent quizIntent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(quizIntent);
    }

    public void viewAnswers(View view) {
        Intent answersIntent = new Intent(ScoreActivity.this, AnswersActivity.class);
        startActivity(answersIntent);
    }
}
