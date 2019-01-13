package com.example.garfi.jobsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Questions2 extends AppCompatActivity {
    public static String Salary = "";
    public static String Time = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);
    }
    public void Home (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Result (View view){
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
        EditText salary = (EditText) findViewById(R.id.Salary);
        TextView salaryText = (TextView) findViewById(R.id.Question4);
        EditText time = (EditText) findViewById(R.id.Time);
        TextView timeText = (TextView) findViewById(R.id.Question5);
        Salary = salary.getText().toString();
        Time = time.getText().toString();
    }
}
