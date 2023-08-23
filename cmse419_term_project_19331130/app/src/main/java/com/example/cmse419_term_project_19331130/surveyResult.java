package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class surveyResult extends AppCompatActivity {

    int userPoint;
    Button done;
    TextView score, risk, desc;
    String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_result);

        Intent intent=getIntent();
        stat= (String) intent.getSerializableExtra("stat");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");

        done = findViewById(R.id.buttonDone);
        score = findViewById(R.id.scoreView);
        risk = findViewById(R.id.risktitle);
        desc = findViewById(R.id.riskdesc);

        score.setText("Your score is: " + userPoint);

        if(stat.equals("Mid")) {
            risk.setText("21-32: moderate risk");
            desc.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is moderate. You may wish to consult with a health care practitioner about your risk of developing diabetes. ");
        } else if (stat.equals("High")) {
            risk.setText("33 and over: high risk");
            desc.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is high. You may wish to consult with a health care practitioner to discuss getting your blood sugar tested.");
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(surveyResult.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}