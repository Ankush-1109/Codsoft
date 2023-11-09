package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button add,sub,mul,div;
    TextView t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.et1);
        num2 = (EditText)findViewById(R.id.et2);

        add = (Button)findViewById(R.id.bt1);
        sub = (Button)findViewById(R.id.bt2);
        mul = (Button)findViewById(R.id.bt3);
        div = (Button)findViewById(R.id.bt4);

        t1 = (TextView)findViewById(R.id.tv1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double number1 = Double.parseDouble(num1.getText().toString());
                double number2 = Double.parseDouble(num2.getText().toString());
                double result = number1 + number2;
                t1.setText("Your Answer is:"+result);
                Toast.makeText(MainActivity.this, "Your Answer is:"+result, Toast.LENGTH_LONG).show();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(num1.getText().toString());
                double number2 = Double.parseDouble(num2.getText().toString());
                double result = number1 - number2;
                t1.setText("Your Answer is:"+result);
                Toast.makeText(MainActivity.this, "Your Answer is:"+result, Toast.LENGTH_LONG).show();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(num1.getText().toString());
                double number2 = Double.parseDouble(num2.getText().toString());
                double result = number1 * number2;
                t1.setText("Your Answer is:"+result);
                Toast.makeText(MainActivity.this, "Your Answer is:"+result, Toast.LENGTH_LONG).show();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(num1.getText().toString());
                double number2 = Double.parseDouble(num2.getText().toString());
                double result = number1 / number2;
                t1.setText("Your Answer is:"+result);
                Toast.makeText(MainActivity.this, "Your Answer is:"+result, Toast.LENGTH_LONG).show();
            }
        });
    }
}