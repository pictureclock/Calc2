package com.example.week3follow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button donationButton;
    EditText donationAmount;
    RadioButton paypal;
    RadioButton creditCard;
    String selectedPMethod;
    double actualAmount;
    Donation currentDonation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donationButton = (Button)findViewById(R.id.button);
        donationAmount = (EditText) findViewById(R.id.amount);
        paypal = (RadioButton) findViewById(R.id.paypal);
        creditCard = (RadioButton) findViewById(R.id.creditCard);


        //Click listener
        donationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Donation", "Donation button clicked");
                if(validateUI()) {
                    String msg = "Thank you for your $" + actualAmount + "CAD donation completed via " + selectedPMethod + ".";
                    currentDonation = new Donation(actualAmount, selectedPMethod);
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Missing Information", Toast.LENGTH_LONG).show();
                }

            }
        });
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Donation", "Paypal selected");
                selectedPMethod = "PayPal";
            }
        });
        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Donation", "CC selected");
                selectedPMethod = "Credit Card";
            }
        });
    }
    Boolean validateUI() {
        Boolean valid = false;
        if (!donationAmount.getText().toString().isEmpty()) {
            actualAmount = Double.parseDouble(donationAmount.getText().toString());
            if (!selectedPMethod.isEmpty() && actualAmount > 0)
                valid = true;
        }
        return valid;
    }
}