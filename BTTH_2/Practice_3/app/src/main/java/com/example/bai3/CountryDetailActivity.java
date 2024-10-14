package com.example.bai3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class CountryDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrydetail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Bật nút back trên AppBar
            getSupportActionBar().setTitle("Country Details");  // Đặt tiêu đề
        }

        ImageView ivFlag = findViewById(R.id.ivFlagDetail);
        TextView tvNationName = findViewById(R.id.tvNationName);
        TextView tvCapital = findViewById(R.id.tvCapitalDetail);
        TextView tvPopulation = findViewById(R.id.tvPopulation);
        TextView tvArea = findViewById(R.id.tvArea);
        TextView tvDensity = findViewById(R.id.tvDensity);
        TextView tvWorldShare = findViewById(R.id.tvWorldShare);

        // Nhận dữ liệu từ Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String capital = extras.getString("capital");
            String population = extras.getString("population");
            String area = extras.getString("area");
            String density = extras.getString("density");
            String worldShare = extras.getString("worldShare");
            int flagResId = extras.getInt("flagResId");

            // Hiển thị thông tin chi tiết
            ivFlag.setImageResource(flagResId);
            tvNationName.setText("Nation: " + name);
            tvCapital.setText("Capital: " + capital);
            tvPopulation.setText("Population: " + population);
            tvArea.setText("Area: " + area);
            tvDensity.setText("Density: " + density);
            tvWorldShare.setText("World Share: " + worldShare);
        }

    }
}