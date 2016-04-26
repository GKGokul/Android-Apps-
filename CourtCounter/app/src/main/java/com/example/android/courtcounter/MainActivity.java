package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    public void threePointerforTeamA(View V){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }

    public void twoPointerforTeamA(View V){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }

    public void freethrowforTeamA(View V){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }

    public void resetscore(View V){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    int scoreTeamB=0;
    public void threePointerforTeamB(View V){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }

    public void twoPointerforTeamB(View V){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }

    public void freethrowforTeamB(View V){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
