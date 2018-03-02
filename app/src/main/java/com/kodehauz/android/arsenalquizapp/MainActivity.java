package com.kodehauz.android.arsenalquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkOneOne, chkOneTwo, chkOneThree, chkOneFour;
    CheckBox chkFourOne, chkFourTwo, chkFourThree, chkFourFour;
    CheckBox chkSixOne, chkSixTwo, chkSixThree, chkSixFour;
    RadioGroup radioGroupTwo, radioGroupThree, radioGroupFive, radioGroupSeven;
    RadioButton radioButtonTwoOne, radioButtonTwoTwo, radioButtonTwoThree, radioButtonTwoFour;
    RadioButton radioButtonThreeOne, radioButtonThreeTwo, radioButtonThreeThree, radioButtonThreeFour;
    RadioButton radioButtonFiveOne, radioButtonFiveTwo, radioButtonFiveThree, radioButtonFiveFour;
    RadioButton radioButtonSevenOne, radioButtonSevenTwo, radioButtonSevenThree, radioButtonSevenFour;
    EditText editTextEight;
    public int points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void validateQuestionOne(){
        chkOneOne = findViewById(R.id.question_one_option_one);
        chkOneTwo = findViewById(R.id.question_one_option_two);
        chkOneThree = findViewById(R.id.question_one_option_three);
        chkOneFour = findViewById(R.id.question_one_option_four);

        //Check if answer is right or wrong
        if (chkOneOne.isChecked() && chkOneThree.isChecked()){
            points = points + 10;
        }
        else if(chkOneOne.isChecked() || chkOneThree.isChecked()){
            points = points + 5;
        }
        else
            points = points;
    }

    private void validateQuestionTwo(){
        radioGroupTwo = findViewById(R.id.question_two);
        radioButtonTwoOne = findViewById(R.id.question_two_option_one);
        radioButtonTwoTwo = findViewById(R.id.question_two_option_two);
        radioButtonTwoThree = findViewById(R.id.question_two_option_three);
        radioButtonTwoFour = findViewById(R.id.question_two_option_four);

            if(radioButtonTwoFour.isChecked()){
                    points = points + 10;
                }
    }
    private void validateQuestionThree(){
        radioGroupThree = findViewById(R.id.question_three);
        radioButtonThreeOne = findViewById(R.id.question_three_option_one);
        radioButtonThreeTwo = findViewById(R.id.question_three_option_two);
        radioButtonThreeThree = findViewById(R.id.question_three_option_three);
        radioButtonThreeFour = findViewById(R.id.question_three_option_four);
        if (radioButtonThreeOne.isChecked()){
            points = points + 10;
        }

    }
    private void validateQuestionFour(){
        chkFourOne = findViewById(R.id.question_four_option_one);
        chkFourTwo = findViewById(R.id.question_four_option_two);
        chkFourThree = findViewById(R.id.question_four_option_three);
        chkFourFour = findViewById(R.id.question_four_option_four);

        //Check if answer is right or wrong
        if (chkFourThree.isChecked() && chkFourTwo.isChecked()){
            points = points + 20;
        }
        else if (chkFourTwo.isChecked() || chkFourThree.isChecked()){
            points = points + 10;
        } else
            points = points;
    }
    private void validateQuestionFive() {
        radioGroupFive = findViewById(R.id.question_five);
        radioButtonFiveOne = findViewById(R.id.question_five_option_one);
        radioButtonFiveTwo = findViewById(R.id.question_five_option_two);
        radioButtonFiveThree = findViewById(R.id.question_five_option_three);
        radioButtonFiveFour = findViewById(R.id.question_five_option_four);
        if (radioButtonFiveThree.isChecked()){
            points = points + 10;
        }
    }
    private void validateQuestionSix() {
        chkSixOne = findViewById(R.id.question_six_option_one);
        chkSixTwo = findViewById(R.id.question_six_option_two);
        chkSixThree = findViewById(R.id.question_six_option_three);
        chkSixFour = findViewById(R.id.question_six_option_four);

        //Check if answer is right or wrong
        if (chkSixTwo.isChecked() && chkSixFour.isChecked()){
            points = points + 20;
        }
        else if (chkSixTwo.isChecked() || chkSixFour.isChecked()){
            points = points + 10;
        }
        else
            points = points;
    }
    private void validateQuestionSeven() {
        radioGroupSeven = findViewById(R.id.question_seven);
        radioButtonSevenOne = findViewById(R.id.question_seven_option_one);
        radioButtonSevenTwo = findViewById(R.id.question_seven_option_two);
        radioButtonSevenThree = findViewById(R.id.question_seven_option_three);
        radioButtonSevenFour = findViewById(R.id.question_seven_option_four);
        if (radioButtonSevenTwo.isChecked()){
            points = points + 10;
        }
    }
    private void validateQuestionEight(){
        editTextEight = findViewById(R.id.question_eight_answer);
        String questionEightAnswer = editTextEight.getText().toString();
        if (TextUtils.isEmpty(questionEightAnswer)){
            editTextEight.setError("Are you sure you have attempted all the questions?");
        }
        else {
            if (questionEightAnswer.matches("Francesc Fabregas") || questionEightAnswer.matches("Cesc Fabregas") ||
                    questionEightAnswer.matches("Fabregas")){
                points = points + 10;
            }
        }
    }

    public void submitQuiz(View view) {
        computeScores();
        Intent submitIntent = new Intent(MainActivity.this, ScoreActivity.class);
        submitIntent.putExtra("Scores", points);
        startActivity(submitIntent);
    }
    public void computeScores(){
        validateQuestionOne();
        validateQuestionTwo();
        validateQuestionThree();
        validateQuestionFour();
        validateQuestionFive();
        validateQuestionSix();
        validateQuestionSeven();
        validateQuestionEight();
    }
}
