package com.example.cars4sale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }

    public void backButton(View v){
        finish();
    }

    public void SearchButton(View v) {
        Intent intent = new Intent(this, ActivityWeb2.class);
        startActivity(intent);
    }
}
