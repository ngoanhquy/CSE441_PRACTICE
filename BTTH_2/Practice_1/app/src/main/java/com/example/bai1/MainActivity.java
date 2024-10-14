package com.example.bai1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startActivityButton = findViewById(R.id.startNewActivityButton);
        resultTextView = findViewById(R.id.resultTextView);

        startActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Subject.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String gpa = data.getStringExtra("gpa");
            resultTextView.setText("Họ và tên: " + name + "\nĐiểm GPA: " + gpa);
        }
    }
}
