package com.example.cars4sale;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.zip.DataFormatException;

public class ActivityWeb extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvMonth;
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        lvMonth = findViewById(R.id.lvMonth);
        // months = new DataFormatSymbols.getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,months);
        lvMonth.setAdapter(monthAdapter);
        lvMonth.setOnItemClickListener(this);
    }

    public void backButton(View v){
        finish();
    }

    public void SearchButton(View v) {
        Intent intent = new Intent(this, ActivityWeb2.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String month = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),"Click:" + month, Toast.LENGTH_SHORT);
    }
}
