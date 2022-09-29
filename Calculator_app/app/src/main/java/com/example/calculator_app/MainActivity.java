package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String oldNumber = "";
    boolean isNewOp = true;
    int opPressed = 0;
    EditText ed1;
    EditText ed2;
    String op;
    ArrayList<String> pastEquations = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if (isNewOp && opPressed < 1)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.oneB:
                number += "1";
                break;
            case R.id.twoB:
                number += "2";
                break;
            case R.id.threeB:
                number += "3";
                break;
            case R.id.fourB:
                number += "4";
                break;
            case R.id.fiveB:
                number += "5";
                break;
            case R.id.sixB:
                number += "6";
                break;
            case R.id.sevenB:
                number += "7";
                break;
            case R.id.eightB:
                number += "8";
                break;
            case R.id.nineB:
                number += "9";
                break;
            case R.id.zeroB:
                number += "0";
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.plusB: op = "+"; break;
            case R.id.minusB: op = "-"; break;
            case R.id.multiplyB: op = "*"; break;
            case R.id.divideB: op = "/"; break;
        }
        opPressed += 1;
        ed1.setText(oldNumber + op);
    }

    public void equalEvent(View view) {

        String fullEquation = "";
        String newNumber = ed1.getText().toString();
        String testing = op;
        String secondNum = "";
        for (int i = newNumber.indexOf(testing) + 1; i < newNumber.length(); i++) {
            secondNum += newNumber.toCharArray()[i];
        }

        fullEquation = fullEquation + oldNumber;
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(secondNum);
                fullEquation += op + secondNum + "=" + result;
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(secondNum);
                fullEquation += op + secondNum + "=" + result;
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(secondNum);
                fullEquation += op + secondNum + "=" + result;
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(secondNum);
                fullEquation += op + secondNum + "=" + result;
                break;
        }
        ed1.setText(fullEquation + "");
        pastEquations.add(fullEquation);
        ed2 = findViewById(R.id.historyEditTextB);
        ed2.getText().toString();
        for(int i = 0; i < pastEquations.size(); i++) {
            ed2.setText(pastEquations.get(i) + '\n');
        }

    }
}