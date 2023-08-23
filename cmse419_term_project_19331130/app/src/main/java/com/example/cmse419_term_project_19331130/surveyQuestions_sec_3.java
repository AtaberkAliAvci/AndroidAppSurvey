package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class surveyQuestions_sec_3 extends AppCompatActivity {

    RadioGroup q1, q2;
    int userPoint, point1, point2;
    Button proceed;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions_sec3);


        Intent intent=getIntent();
        gender= (String) intent.getSerializableExtra("gender");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");

        q1 = findViewById(R.id.q5);
        q2 = findViewById(R.id.q6);
        proceed = findViewById(R.id.buttons3);

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq51){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq52){
                        point1 = 1;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_3.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq61){
                        point2 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq62){
                        point2 = 2;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_3.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoint = userPoint+point1+point2;

                Intent intent= new Intent(surveyQuestions_sec_3.this, MainActivity2surveyQuestions_sec_4.class);
                intent.putExtra("userPoint",userPoint);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }
}