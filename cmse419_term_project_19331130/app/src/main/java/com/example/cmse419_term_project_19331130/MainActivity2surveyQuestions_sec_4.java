package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2surveyQuestions_sec_4 extends AppCompatActivity {

    RadioGroup q1, q2, q3;
    int userPoint, point1, point2, point3;
    Button proceed;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2survey_questions_sec4);

        Intent intent=getIntent();
        gender= (String) intent.getSerializableExtra("gender");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");

        q1 = findViewById(R.id.q7);
        q2 = findViewById(R.id.q8);
        q3 = findViewById(R.id.q9);
        proceed = findViewById(R.id.buttons4);

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq71){
                        point1 = 4;
                    }
                    else if(checkedId == R.id.radioButtonq72){
                        point1 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity2surveyQuestions_sec_4.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq81){
                        point2 = 14;
                    }
                    else if(checkedId == R.id.radioButtonq82){
                        point2 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity2surveyQuestions_sec_4.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq91){
                        point3 = 1;
                    }
                    else if(checkedId == R.id.radioButtonq92){
                        point3 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity2surveyQuestions_sec_4.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoint = userPoint+point1+point2+point3;

                Intent intent= new Intent(MainActivity2surveyQuestions_sec_4.this, surveyQuestions_sec_5.class);
                intent.putExtra("userPoint",userPoint);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }
}