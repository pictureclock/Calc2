package com.example.calc2;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator  {
    boolean isAdvanced = false;
    Button advBut;
    TextView textV;
    String fullString = "";
    EditText ed1;
    int elementCounter = 0;
    ArrayList<String> nums = new ArrayList<>();
    public void push(String value) {
        nums.add(value);
    }
    @SuppressLint("NonConstantResourceId")
    public void displayNums(View view) {
        switch (view.getId()) {
            case R.id.b1:
                push("1");
                elementCounter += 1;
                break;
            case R.id.b2:
                push("2");
                elementCounter += 1;
                break;
            case R.id.b3:
                push("3");
                elementCounter += 1;
                break;
            case R.id.b4:
                push("4");
                elementCounter += 1;
                break;
            case R.id.b5:
                push("5");
                elementCounter += 1;
                break;
            case R.id.b6:
                push("6");
                elementCounter += 1;
                break;
            case R.id.b7:
                push("7");
                elementCounter += 1;
                break;
            case R.id.b8:
                push("8");
                elementCounter += 1;
                break;
            case R.id.b9:
                push("9");
                elementCounter += 1;
                break;
            case R.id.bplus:
                push("+");
                elementCounter += 1;
                break;
            case R.id.bMinus:
                push("-");
                elementCounter += 1;
                break;
            case R.id.bMultiply:
                push("*");
                elementCounter += 1;
                break;
            case R.id.bDivide:
                push("/");
                elementCounter += 1;
                break;
            case R.id.bEqual:
                push("=");
                elementCounter += 1;
                break;
            case R.id.b0:
                push("0");
                elementCounter += 1;
                break;
            case R.id.bClear:
                nums.clear();
                fullString = "";
                break;
        }
        String displayString = "";
        for (int i = 0; i < nums.size(); i++) {
            displayString += nums.get(i);
        }
        ed1.setText(displayString);
        fullString = displayString;
    }
    public int calculate() {
        int resultValue = 0;
        String str = "0123456789";
        String str2 = "+-*/";
        int i = 0;
        while(nums.size() > 0) {
            if (i == 0) {
                StringBuilder firstThree = new StringBuilder();
                String firstThreeOne ="";
                String firstThreeTwo ="";
                String firstThreeThree ="";
                for (int j = 0; j < 3; j++){
                    firstThree.append(nums.get(j));
                    if (j == 0) {firstThreeOne += nums.get(j);}
                    if (j == 1) {firstThreeTwo += nums.get(j);}
                    if (j == 2) {firstThreeThree += nums.get(j);}
                }
                if (str.contains(firstThreeOne) && str2.contains(firstThreeTwo) && str.contains(firstThreeThree)) {
                    switch (firstThreeTwo) {
                        case "+":
                            resultValue = Integer.parseInt(firstThreeOne) +  Integer.parseInt(firstThreeThree);
                            break;
                        case "-":
                            resultValue = Integer.parseInt(firstThreeOne) -  Integer.parseInt(firstThreeThree);
                            break;
                        case "*":
                            resultValue = Integer.parseInt(firstThreeOne) *  Integer.parseInt(firstThreeThree);
                            break;
                        case "/":
                            resultValue = Integer.parseInt(firstThreeOne) /  Integer.parseInt(firstThreeThree);
                            break;
                    }
                    nums.remove(firstThreeOne);
                    nums.remove(firstThreeTwo);
                    nums.remove(firstThreeThree);

                }
                i++;
            }
            else {
                String firstThreeOne ="";
                String firstThreeTwo ="";
                for (int j = 0; j < 2; j++){
                    if (j == 0) {firstThreeOne += nums.get(j);}
                    if (j == 1) {firstThreeTwo += nums.get(j);}
                }
                if (str2.contains(firstThreeOne) && str.contains(firstThreeTwo)) {
                    switch (firstThreeOne) {
                        case "+":
                            resultValue = resultValue +  Integer.parseInt(firstThreeTwo);
                            break;
                        case "-":
                            resultValue = resultValue -  Integer.parseInt(firstThreeTwo);
                            break;
                        case "*":
                            resultValue = resultValue *  Integer.parseInt(firstThreeTwo);
                            break;
                        case "/":
                            resultValue = resultValue /  Integer.parseInt(firstThreeTwo);
                            break;
                    }
                    nums.remove(firstThreeOne);
                    nums.remove(firstThreeTwo);
            }
        }
    }
        if(isAdvanced) {
            textV.append(fullString + "="+resultValue+ "\n");
        }

        return resultValue;
}}
