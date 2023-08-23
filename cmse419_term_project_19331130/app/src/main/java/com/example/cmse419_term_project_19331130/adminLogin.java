package com.example.cmse419_term_project_19331130;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {

    EditText userName, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.enterPassword);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Intent intent= new Intent(adminLogin.this, adminScreen.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(adminLogin.this, "User Name or Password is incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}