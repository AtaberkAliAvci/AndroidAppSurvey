package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class adminScreen extends AppCompatActivity {

    TextView totMale, totFemale, totPart, maleL, maleM, maleH, femaleL, femaleM, femaleH;
//    ArrayList <String> get = new ArrayList<String>();
    int get_all;
    Button return_bt;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);

        StudentDB db = new StudentDB(this);

        totPart = findViewById(R.id.totnum);
        totFemale = findViewById(R.id.femnum);
        totMale = findViewById(R.id.malenum);
        maleL = findViewById(R.id.malelownum);
        maleM = findViewById(R.id.malemidnum);
        maleH = findViewById(R.id.malehighnum);
        femaleL = findViewById(R.id.femlownum);
        femaleM = findViewById(R.id.femmidnum);
        femaleH = findViewById(R.id.femhighnum);

        return_bt = findViewById(R.id.buttonReturn);


        c = db.getCountFromDatabase();
        get_all = c;
        totPart.setText(String.valueOf(get_all));

        c = db.getFemaleCountFromDatabase();
        get_all = c;
        totFemale.setText(String.valueOf(get_all));

        c = db.getMaleCountFromDatabase();
        get_all = c;
        totMale.setText(String.valueOf(get_all));

        get_all=0;
        c = db.getLowMaleCountFromDatabase();
        get_all = c;
        maleL.setText(String.valueOf(get_all));

        c = db.getMidMaleCountFromDatabase();
        get_all = c;
        maleM.setText(String.valueOf(get_all));

        c = db.getHighMaleCountFromDatabase();
        get_all = c;
        maleH.setText(String.valueOf(get_all));

        c = db.getLowFemaleCountFromDatabase();
        get_all = c;
        femaleL.setText(String.valueOf(get_all));

        c = db.getMidFemaleCountFromDatabase();
        get_all = c;
        femaleM.setText(String.valueOf(get_all));

        c = db.getHighFemaleCountFromDatabase();
        get_all = c;
        femaleH.setText(String.valueOf(get_all));


        return_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(adminScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}