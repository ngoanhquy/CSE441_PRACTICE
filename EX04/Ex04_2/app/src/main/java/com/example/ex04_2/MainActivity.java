package com.example.ex04_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    Button btnChandoan;
    EditText editChieucao, editCannang, editBMI, editChandoan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChandoan = findViewById(R.id.btnChandoan);
        editChieucao = findViewById(R.id.editChieucao);
        editCannang = findViewById(R.id.editCannang);
        editBMI = findViewById(R.id.editBMI);
        editChandoan = findViewById(R.id.editChandoan);

        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editChieucao.getText().toString());
                double W = Double.parseDouble(editCannang.getText().toString());
                double BMI = W / Math.pow(H, 2);
                String chandoan = "";

                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }

                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chandoan);
            }
        });
    }
}