package com.example.smallcalc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityRelative extends AppCompatActivity {

    EditText num1, num2;
    Button addBtn, resetBtn;
    TextView ansText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_relative);

        num1 = findViewById(R.id.editText);
        num2 = findViewById(R.id.editText1);
        addBtn = findViewById(R.id.button1);
        resetBtn = findViewById(R.id.button2);
        ansText = findViewById(R.id.textView1);

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    num1.setHint("Enter first number");
                }
            }
        });

        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    num2.setHint("Enter second number");
                }
            }
        });

        addBtn.setOnClickListener(v -> {
            String num1Text = num1.getText().toString().trim();
            String num2Text = num2.getText().toString().trim();

            // Check if the inputs are empty
            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                Toast.makeText(MainActivityRelative.this, "Enter Valid Numbers!", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                double number1 = Double.parseDouble(num1Text);
                double number2 = Double.parseDouble(num2Text);
                double result = number1 + number2;

                ansText.setText(String.valueOf(result));
                Toast.makeText(MainActivityRelative.this, "Result = " + result, Toast.LENGTH_LONG).show();
            }
            catch (NumberFormatException nfe) {
                Toast.makeText(MainActivityRelative.this, "Enter Valid Numbers!", Toast.LENGTH_LONG).show();
            }
        });

        resetBtn.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            ansText.setText("0");

            num1.requestFocus();
            num1.setSelection((num1.getText().length()));
        });
    }
}