package com.example.assignmentcs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editMilk;
    EditText editSugar;
    EditText editFlour;
    EditText editBread;
    EditText milkVat;
    EditText milkActual;

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBread = findViewById(R.id.bread_price);
        editFlour = findViewById(R.id.floor_price);
        editMilk = findViewById(R.id.milk_price);
        editSugar = findViewById(R.id.sugar_price);
        milkVat = findViewById(R.id.milk_vat);
        milkActual = findViewById(R.id.actual_milk);

        editBread.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Ensure the EditText is not empty before attempting to parse its content.
                if (!editBread.getText().toString().isEmpty()) {
                    double breadPrice = Double.parseDouble(editBread.getText().toString());
                    double vat = Vat(breadPrice);
                    double actualPrice = Amount(breadPrice);
                    milkVat.setText(String.valueOf(vat));
                    milkActual.setText(String.valueOf(actualPrice));
                }
                return true;
            }
        });
    }

    double Vat(double amount) {
        return amount * 0.16;
    }

    double Amount(double amount) {
        return amount * 0.84;
    }
}
