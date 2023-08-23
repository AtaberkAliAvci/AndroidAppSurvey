package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class surveyQuestions_sec_6 extends AppCompatActivity {

    RadioGroup q1;
    int userPoint, point1;
    Button proceed;
    String gender, userStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions_sec6);

        Intent intent=getIntent();
        gender= (String) intent.getSerializableExtra("gender");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");
        StudentDB db = new StudentDB(this);
        q1 = findViewById(R.id.q12);
        proceed = findViewById(R.id.buttons6);

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq121){
                        point1 = 5;
                    }
                    else if(checkedId == R.id.radioButtonq122){
                        point1 = 1;
                    }
                    else if(checkedId == R.id.radioButtonq123){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq124){
                        point1 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_6.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoint = userPoint+point1;

                if((userPoint > 21) && (userPoint < 32)){
                    userStat = "Mid";
                } else if (userPoint>32) {
                    userStat = "High";
                } else if (userPoint<21) {
                    userStat = "Low";
                }

                db.AddParticipant(gender, userStat);
                Intent intent= new Intent(surveyQuestions_sec_6.this, surveyResult.class);
                intent.putExtra("userPoint", userPoint);
                intent.putExtra("stat", userStat);
                startActivity(intent);
            }
        });
    }
}