package com.techexplorer.notessharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_name,ed_email,ed_phone,ed_institute_name,ed_studentId,ed_course,ed_password;
    Button bt1,bt2;
    Database db_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_obj = new Database(this);

        ed_name = findViewById(R.id.editName);
        ed_email = findViewById(R.id.editEmail);
        ed_phone = findViewById(R.id.editPhone);
        ed_institute_name = findViewById(R.id.editInstituteName);
        ed_studentId = findViewById(R.id.editStudentId);
        ed_course = findViewById(R.id.editCourse);
        ed_password = findViewById(R.id.editPassword);

        bt1 = findViewById(R.id.signup);
        bt2 = findViewById(R.id.login);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ed_name.getText().toString();
                String email = ed_email.getText().toString();
                String temp_phone = ed_phone.getText().toString();
                Integer phone = Integer.parseInt(temp_phone);
                String institute_name = ed_studentId.getText().toString();
                String temp_studentId = ed_studentId.getText().toString();
                Integer studentId = Integer.parseInt(temp_studentId);
                String course = ed_course.getText().toString();
                String password = ed_password.getText().toString();

                if (name.equals("") || email.equals("") || temp_phone.equals("") || institute_name.equals("") || temp_studentId.equals("") || course.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this,"Please fill all the fileds.",Toast.LENGTH_SHORT).show();
                }
                else{
                    db_obj.insert_data(name, email, phone, institute_name, studentId, course, password);
                    Intent log_intent = new Intent(MainActivity.this,loginActivity.class);
                    startActivity(log_intent);
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log_intent = new Intent(MainActivity.this,loginActivity.class);
                startActivity(log_intent);
            }
        });
    }
}