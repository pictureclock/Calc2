package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Calculator cal = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal.ed1 = findViewById(R.id.ed1);
        cal.textV = findViewById(R.id.textV);
    }
    public void numberEvent(View view) {
        cal.displayNums(view);
    }
    public void eqEvent(View view) {
        int num = cal.calculate();
        String str = cal.fullString + "=" + (num);
        cal.ed1.setText(str);
    }

    public void advanceClick(View view) {
        cal.advBut = findViewById(R.id.bAdvanced);
        if(cal.advBut.getText() == "ADVANCED - WITH HISTORY") {
            cal.isAdvanced = true;
            cal.advBut.setText("STANDARD - NO HISTORY");
        }
        else {
            cal.isAdvanced = false;
            cal.advBut.setText("ADVANCED - WITH HISTORY");
            cal.textV.setText("");
        }

    }
}