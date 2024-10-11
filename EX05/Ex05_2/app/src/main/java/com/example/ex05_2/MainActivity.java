package com.example.ex05_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC, edtKQ;
    Button btnPT, btnTT, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        edtC = findViewById(R.id.edt_c);
        edtKQ = findViewById(R.id.edt_kq);
        btnPT = findViewById(R.id.btn_pt);
        btnTT = findViewById(R.id.btn_tt);
        btnThoat = findViewById(R.id.btn_thoat);
        btnPT.setOnClickListener(view -> {
            String S_A = edtA.getText().toString();
            String S_B = edtB.getText().toString();
            String S_C = edtC.getText().toString();
            int A = Integer.parseInt(S_A);
            int B = Integer.parseInt(S_B);
            int C = Integer.parseInt(S_C);
            String ketqua;
            DecimalFormat df = new DecimalFormat("0.00");
            if (A == 0) {
                if (B == 0){
                    if (C == 0){
                        ketqua = "PT vô số nghiệm";
                    }
                    else {
                        ketqua = "PT vô nghiệm";
                    }
                }
                else {
                    ketqua = "PT có nghiệm x = " + df.format(-C/B);
                }
            }
            else {
                double delta = B*B - 4*A*C;
                if (delta < 0){
                    ketqua = "PT vô nghiệm";
                }
                else if (delta == 0){
                    ketqua = "PT có nghiệm kép x1 = x2 = " + df.format(-B/(2L *A));
                }
                else {
                    ketqua = "PT có 2 nghiệm phân biệt x1 = " + df.format((-B + Math.sqrt(delta))/(2*A)) + " và x2 = " + df.format((-B - Math.sqrt(delta))/(2*A));
                }
            }
            edtKQ.setText(ketqua);
        });
        btnTT.setOnClickListener(view -> {
            edtA.setText("");
            edtB.setText("");
            edtC.setText("");
            edtKQ.setText("");
            edtA.requestFocus();
        });
        btnThoat.setOnClickListener(view -> finish());
    }
}