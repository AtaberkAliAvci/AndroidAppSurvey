package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class surveyQuestions_sec_5 extends AppCompatActivity {

    RadioGroup q1, q2_m, q2_f;
    RadioButton q10a, q10b, q10c, q10d, q10e, q10f;
    int userPoint, point1, point2, point3, lastPoint;
    Button proceed;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions_sec5);

        Intent intent=getIntent();
        gender= (String) intent.getSerializableExtra("gender");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");

//        q1 = findViewById(R.id.q10);
        q2_m = findViewById(R.id.q11_m);
        q2_f = findViewById(R.id.q11_f);
        q10a = findViewById(R.id.radioButtonq101);
        q10b = findViewById(R.id.radioButtonq102);
        q10c = findViewById(R.id.radioButtonq103);
        q10d = findViewById(R.id.radioButtonq104);
        q10e = findViewById(R.id.radioButtonq105);
        q10f = findViewById(R.id.radioButtonq106);

        proceed = findViewById(R.id.buttons5);

//        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                try {
//                    if (checkedId == R.id.radioButtonq101){
//
//                    }
//                    else if(checkedId == R.id.radioButtonq102){
//
//                    }
//                    else if(checkedId == R.id.radioButtonq103){
//
//                    }
//                    else if(checkedId == R.id.radioButtonq104){
//
//                    }
//                    else if(checkedId == R.id.radioButtonq105){
//
//                    }
//                    else if(checkedId == R.id.radioButtonq106){
//
//                    }
//
//                }catch (Exception e){
//                    Toast.makeText(surveyQuestions_sec_5.this, "Error", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        q2_f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq111_f){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq112_f){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq113_f){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq114_f){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq115_f){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq116_f){
                        point1 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_5.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2_m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq111_m){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq112_m){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq113_m){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq114_m){
                        point1 = 2;
                    }
                    else if(checkedId == R.id.radioButtonq115_m){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq116_m){
                        point1 = 0;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_5.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (q10a.isChecked()){
                    point1 = point1 + 2;
                }
                else if(q10b.isChecked()){
                    point1 = point1 + 2;
                }
                else if(q10c.isChecked()){
                    point1 = point1 + 2;
                }
                else if(q10d.isChecked()){
                    point1 = point1 + 2;
                }

                if(point3>point2){
                    lastPoint = point3;
                }
                else{
                    lastPoint = point2;
                }
                userPoint = userPoint+point1+lastPoint;

                Intent intent= new Intent(surveyQuestions_sec_5.this, surveyQuestions_sec_6.class);
                intent.putExtra("userPoint",userPoint);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }
}