package com.example.bai2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;





public class MainActivity extends AppCompatActivity {

    private StaffViewModel staffViewModel;
    private EditText etStaffId, etFullName, etBirthDate, etSalary;
    private TextView tvStaffList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStaffId = findViewById(R.id.etStaffId);
        etFullName = findViewById(R.id.etFullName);
        etBirthDate = findViewById(R.id.etBirthDate);
        etSalary = findViewById(R.id.etSalary);
        tvStaffList = findViewById(R.id.tvStaffList);
        Button btnAddStaff = findViewById(R.id.btnAddStaff);

        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        // Lắng nghe thay đổi dữ liệu
        staffViewModel.getStaffList().observe(this, staffList -> {
            if (staffList.isEmpty()) {
                tvStaffList.setText("No Result!");
            } else {
                StringBuilder staffInfo = new StringBuilder();
                for (Staff staff : staffList) {
                    staffInfo.append(staff.getStaffId())
                            .append("-")
                            .append(staff.getFullName())
                            .append("-")
                            .append(staff.getBirthDate())
                            .append("-")
                            .append(staff.getSalary())
                            .append("\n");
                }
                tvStaffList.setText(staffInfo.toString());
            }
        });

        // Xử lý sự kiện nhấn nút "Add New Staff"
        btnAddStaff.setOnClickListener(v -> {
            String staffId = etStaffId.getText().toString();
            String fullName = etFullName.getText().toString();
            String birthDate = etBirthDate.getText().toString();
            String salaryStr = etSalary.getText().toString();

            if (!TextUtils.isEmpty(staffId) && !TextUtils.isEmpty(fullName) &&
                    !TextUtils.isEmpty(birthDate) && !TextUtils.isEmpty(salaryStr)) {

                double salary = Double.parseDouble(salaryStr);
                Staff newStaff = new Staff(staffId, fullName, birthDate, salary);
                staffViewModel.addStaff(newStaff);

                // Xóa dữ liệu nhập sau khi thêm
                etStaffId.setText("");
                etFullName.setText("");
                etBirthDate.setText("");
                etSalary.setText("");
            }
        });
    }
}