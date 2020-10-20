package com.example.cars4sale;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.DataFormatException;

public class ActivityWeb extends AppCompatActivity {
    // List View Test
    ListView lvCar;
    SimpleAdapter simple_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

/*
        ListView lvcar = findViewById(R.id.lvCar);
        String[] from = {"name","price","location"};
        int[] to = {R.id.};

        // Settings of Adapter
        SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
        simple_adapter=new SimpleAdapter(this,list, R.layout.lvcar, from, to);

        // Start Adapter
        lvcar.setAdapter(simple_adapter);

/*
        lvCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String car = lvcar.getItemAtPosition(position).toString();
                Intent intent = new Intent(ActivityWeb.this, ActivityWeb2.class);
                intent.putExtra("CAR", car);
                startActivity(intent);
            }
        }); */
    }
}
