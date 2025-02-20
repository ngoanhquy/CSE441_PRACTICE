package com.example.ex16;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB;
    private TextView edtKQ;
    private TextView txtLichSu;
    private StringBuilder lichSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        Button btnTong = findViewById(R.id.btnTong);
        Button btnClear = findViewById(R.id.btnClear);
        txtLichSu = findViewById(R.id.txtLichSu);

        lichSu = new StringBuilder();

        btnTong.setOnClickListener(v -> calculateSum());

        btnClear.setOnClickListener(v -> clearInputs());
    }

    // Hàm tính tổng và hiển thị kết quả
    @SuppressLint("SetTextI18n")
    private void calculateSum() {
        String valueA = edtA.getText().toString();
        String valueB = edtB.getText().toString();

        if (TextUtils.isEmpty(valueA) || TextUtils.isEmpty(valueB)) {
            edtKQ.setText("Vui lòng nhập đủ số");
            return;
        }

        int a = Integer.parseInt(valueA);
        int b = Integer.parseInt(valueB);
        int sum = a + b;

        edtKQ.setText(String.valueOf(sum));

        lichSu.append(a).append(" + ").append(b).append(" = ").append(sum).append("\n");
        txtLichSu.setText(lichSu.toString());
    }

    private void clearInputs() {
        edtA.setText("");
        edtB.setText("");
        edtKQ.setText("");
    }
}