package com.example.cars4sale.ActivityUI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cars4sale.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        // Navigation drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String[] carDetails = intent.getStringExtra("CarDetails").split("\\n");

        final TextView name = findViewById(R.id.textName);
        final TextView price = findViewById(R.id.textPrice);
        final TextView location = findViewById(R.id.textLocation);
        final TextView year = findViewById(R.id.textYear);

        name.setText(carDetails[0]);
        price.setText(carDetails[1]);
        location.setText(carDetails[2]);
        year.setText(carDetails[3]);

    }
}