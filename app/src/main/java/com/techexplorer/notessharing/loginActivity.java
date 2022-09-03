package com.techexplorer.notessharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt1 = findViewById(R.id.login2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log_intent = new Intent(loginActivity.this,DashboardActivity.class);
                startActivity(log_intent);
            }
        });

    }
}