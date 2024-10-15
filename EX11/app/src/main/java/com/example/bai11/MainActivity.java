package com.example.bai11;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnopen;
    EditText edtlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtlink=findViewById(R.id.edtLink);
        btnopen=findViewById(R.id.btnOpen);
        btnopen.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+edtlink.getText().toString()));
            startActivity(intent);
        });
    }
}