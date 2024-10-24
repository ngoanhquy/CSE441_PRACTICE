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

        lichSu = new StringBuilder();  // Dùng để lưu lịch sử phép tính

        // Xử lý khi nhấn nút "Tổng"
        btnTong.setOnClickListener(v -> calculateSum());

        // Xử lý khi nhấn nút "Clear"
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

        // Chuyển đổi giá trị nhập thành số nguyên
        int a = Integer.parseInt(valueA);
        int b = Integer.parseInt(valueB);
        int sum = a + b;

        // Hiển thị kết quả tổng
        edtKQ.setText(String.valueOf(sum));

        // Lưu lịch sử phép tính
        lichSu.append(a).append(" + ").append(b).append(" = ").append(sum).append("\n");
        txtLichSu.setText(lichSu.toString());
    }

    // Hàm để xóa dữ liệu nhập và kết quả
    private void clearInputs() {
        edtA.setText("");
        edtB.setText("");
        edtKQ.setText("");
    }
}