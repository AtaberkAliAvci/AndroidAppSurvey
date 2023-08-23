package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class surveyQuestions_sec_2 extends AppCompatActivity {

    RadioGroup q1, q2;
    RadioButton q41, q42, q43;
    int userPoint, point1, point2;
    Button proceed, bmi;
    EditText height, weight;
    TextView result;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions_sec2);

        Intent intent=getIntent();
        gender= (String) intent.getSerializableExtra("gender");
        userPoint= (Integer) intent.getSerializableExtra("userPoint");

        q1 = findViewById(R.id.q3);
        q2 = findViewById(R.id.q4);
        proceed = findViewById(R.id.buttons2);
        bmi = findViewById(R.id.buttonBMI);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.resultBMI);

        q41 = findViewById(R.id.radioButtonq41);
        q42 = findViewById(R.id.radioButtonq42);
        q43 = findViewById(R.id.radioButtonq43);

        if(gender.equals("Female")){
            q41.setText("Less than 80 cm or 31.5 inches");
            q42.setText("Between 80-88 cm or 31.5-35 inches");
            q43.setText("Over 88 cm or 35 inches");
        }

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq31){
                        point1 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq32){
                        point1 = 4;
                    }
                    else if(checkedId == R.id.radioButtonq33){
                        point1 = 9;
                    }
                    else if(checkedId == R.id.radioButtonq34){
                        point1 = 14;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_2.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    if (checkedId == R.id.radioButtonq41){
                        point2 = 0;
                    }
                    else if(checkedId == R.id.radioButtonq42){
                        point2 = 4;
                    }
                    else if(checkedId == R.id.radioButtonq43){
                        point2 = 6;
                    }

                }catch (Exception e){
                    Toast.makeText(surveyQuestions_sec_2.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double c_height = Double.parseDouble(height.getText().toString());
                Double c_weight = Double.parseDouble(weight.getText().toString());
                c_height = c_height / 100;
                Double resultValue = c_weight / (c_height * c_height);
                DecimalFormat decimalFormat = new DecimalFormat("0");
                String decimalResultValue = decimalFormat.format(resultValue);

                result.setText(String.valueOf(decimalResultValue));
                height.setText("");
                weight.setText("");
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoint = userPoint+point1+point2;

                Intent intent= new Intent(surveyQuestions_sec_2.this, surveyQuestions_sec_3.class);
                intent.putExtra("userPoint",userPoint);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }
}