package com.example.taylor_pc.whwrscoring2016;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int SEED = 10;
    int TOMATOE = 20;
    int LETTUCE = 15;
    int CORN_C = 5;
    int CORN_T = 20;
    int CORN_HARVEST = 30;
    int WATER_VALVE = 100;
    int WATER_VALVE_HALF = 50;
    int HARVEST_DIVERSITY = 50;

    int score = 0;
    int cornHarvestCount = 0;
    int harvestDiversityCount = 0;

    int lettuce = 0;
    int tomatotes = 0;
    int corn = 0;
    int corn2 = 0;
    int seeds = 0;
    int clock = 180;

    int seedsFinal = 0;
    int lettuceFinal = 0;
    int tomatoesFinal = 0;
    int teamCornFinal = 0;
    int shareCornFinal = 0;

    TextView scoreLabel;
    TextView plantingBonus;
    TextView diversityBonus;
    TextView seedsLabel;
    TextView tomatoesLabel;
    TextView teamCornLabel;
    TextView shareCornLabel;
    TextView lettuceLabel;

    Button seedsBtn;
    Button tomatoesBtn;
    Button teamCornBtn;
    Button shareCornBtn;
    Button waterValveBtn;
    Button waterValveBtn2;
    Button lettuceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seedsBtn = (Button) findViewById(R.id.seed_btn);
        lettuceBtn = (Button) findViewById(R.id.lettuce_btn);
        tomatoesBtn = (Button) findViewById(R.id.tomatoes_btn);
        teamCornBtn = (Button) findViewById(R.id.corn_team_btn);
        shareCornBtn = (Button) findViewById(R.id.corn_share_btn);
        waterValveBtn = (Button) findViewById(R.id.valve_btn);
        waterValveBtn2 = (Button) findViewById(R.id.valve2_btn);
        scoreLabel = (TextView) findViewById(R.id.score_label);
        plantingBonus = (TextView) findViewById(R.id.corn_harvest_bonus_label);
        diversityBonus = (TextView) findViewById(R.id.divisty_bonus_label);

        seedsLabel = (TextView) findViewById(R.id.seeds_label);
        tomatoesLabel = (TextView) findViewById(R.id.tomatoes_label);
        lettuceLabel = (TextView) findViewById(R.id.lettuce_label);
        teamCornLabel = (TextView) findViewById(R.id.team_corn_label);
        shareCornLabel = (TextView) findViewById(R.id.share_corn_label);

    }

    public void reset(View v){

        score = 0;
        cornHarvestCount = 0;
        harvestDiversityCount = 0;

        scoreLabel.setText("" + score);

        seedsFinal = 0;
        lettuceFinal = 0;
        tomatoesFinal = 0;
        teamCornFinal = 0;
        shareCornFinal = 0;
        seedsLabel.setText("Seeds");
        lettuceLabel.setText("Lettuce");
        tomatoesLabel.setText("Tomatoes");
        teamCornLabel.setText("Team Corn");
        shareCornLabel.setText("Shared Corn");

        plantingBonus.setText("Planting Bonus\n");
        diversityBonus.setText("Diversoty Bonus\n");

    }

    void cornHarvest(){

        if(corn > 0 && seeds > 0){
            corn--;
            seeds--;
            score += CORN_HARVEST;
            cornHarvestCount++;
            plantingBonus.setText("Planting Bonus\n"+cornHarvestCount);
        }

    }

    void diversityBonus(){

        if(corn2 > 0 && tomatotes > 0 && lettuce > 0){
            corn2--;
            tomatotes--;
            lettuce--;
            score += HARVEST_DIVERSITY;
            harvestDiversityCount++;
            diversityBonus.setText("Diversoty Bonus\n"+harvestDiversityCount);
        }

    }

    public void scoreValve(View v){
        score += WATER_VALVE;
        waterValveBtn.setEnabled(false);
        waterValveBtn2.setEnabled(false);
        scoreLabel.setText("" + score);
    }

    public void scoreValve2(View v){
        score += WATER_VALVE_HALF;
        waterValveBtn.setEnabled(false);
        waterValveBtn2.setEnabled(false);
        scoreLabel.setText("" + score);
    }

    public void scoreSeed(View v){
        score += SEED;
        seeds++;
        seedsFinal++;
        seedsLabel.setText("Seeds\n" + seedsFinal);
        cornHarvest();
        scoreLabel.setText("" + score);
    }

    public void scoreTomatoe(View v){
        score += TOMATOE;
        tomatotes++;
        tomatoesFinal++;
        tomatoesLabel.setText("Tomatoes\n"+tomatoesFinal);
        diversityBonus();
        scoreLabel.setText("" + score);
    }

    public void scoreLettuce(View v){
        score += LETTUCE;
        lettuce++;
        lettuceFinal++;
        lettuceLabel.setText("Lettuce\n"+lettuceFinal);
        diversityBonus();
        scoreLabel.setText("" + score);
    }

    public void scoreShareCorn(View v){
        score += CORN_C;
        shareCornFinal++;
        shareCornLabel.setText("Shared Corn\n"+shareCornFinal);
        scoreLabel.setText("" + score);
    }

    public void scoreTeamCorn(View v){
        score += CORN_T;
        corn++;
        corn2++;
        teamCornFinal++;
        teamCornLabel.setText("Team Corn\n"+teamCornFinal);
        diversityBonus();
        scoreLabel.setText("" + score);

    }

}
