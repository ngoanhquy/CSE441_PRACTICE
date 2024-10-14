package com.example.bai3;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Liên kết MainActivity với file activity_main.xml

        RecyclerView recyclerView = findViewById(R.id.recyclerView);  // Tham chiếu RecyclerView trong XML
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Cài đặt LayoutManager

        // Tạo danh sách quốc gia và cài đặt adapter
        List<Country> countryList = CountryData.getTopCountries();
        CountryAdapter countryAdapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(countryAdapter);
    }
}