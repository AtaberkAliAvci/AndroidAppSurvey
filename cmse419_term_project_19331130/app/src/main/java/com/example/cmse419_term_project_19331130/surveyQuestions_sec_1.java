package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class surveyQuestions_sec_1 extends AppCompatActivity {

    RadioGroup q1, q2;
    int userPoint, point1, point2;
    Button proceed;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions_sec1);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        proceed = findViewById(R.id.buttons1);

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq11){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq12){
                        point1 = 7;
                    }
                    else if(checkedId == R.id.radioButtonq13){
                        point1 = 13;
                    }
                    else if(checkedId == R.id.radioButtonq14){
                        point1 = 15;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_1.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq21){
                        point1 = 6;
                        gender = "Male";
                    }
                    else if(checkedId == R.id.radioButtonq22){
                        point1 = 0;
                        gender = "Female";
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_1.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoint = userPoint+point1+point2;

                Intent intent= new Intent(surveyQuestions_sec_1.this, surveyQuestions_sec_2.class);
                intent.putExtra("userPoint", userPoint);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });

    }
}