package com.example.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// R.java
        setContentView(R.layout.activity_main);// R is an auto generated java Class
        //R.string.greeting
        TextView myText = (TextView)findViewById(R.id.mytextview);
        myText.setText(R.string.updatedText);
    }

}