package com.example.garfi.jobsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Questions extends AppCompatActivity {
    public static String Work = "";
    public static String Where = "";
    public static String Position = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void next (View view){
        EditText work = (EditText) findViewById(R.id.Type);
        TextView workText = (TextView) findViewById(R.id.Question1);
        EditText where = (EditText) findViewById(R.id.Where);
        TextView whereText = (TextView) findViewById(R.id.Question2);
        EditText position = (EditText) findViewById(R.id.Position);
        TextView positionText = (TextView) findViewById(R.id.Question3);
        Work = work.getText().toString();
        Where = where.getText().toString();
        Position= position.getText().toString();
        Intent intent = new Intent(this, Questions2.class);
        startActivity(intent);
    }
}
