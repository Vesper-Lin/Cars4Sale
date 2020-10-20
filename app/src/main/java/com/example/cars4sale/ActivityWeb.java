package com.example.cars4sale;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.cars4sale.DataGenerator.Car;

import java.util.*;


public class ActivityWeb extends AppCompatActivity {
    private Button button;
    ListView lvCar;
    SimpleAdapter simple_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
/*
        ListView lvcar = findViewById(R.id.lvCar);

        String[] from = {"name", "price", "location"};
        int[] to = {R.id.name, R.id.price, R.id.location};

        // Settings of Adapter
        // SimpleAdapter(Context context, List < ? extends Map<String, ?>>data,int resource, String[] from,int[] to)


        // List<String extends Map<String, Object>> arrarylist;
        List<String>
        simple_adapter = new SimpleAdapter(this, arraylist, R.layout.activity_web, from, to);
        list = new arraylist();
        for (Car c : map.values)list.add (c name) {

        }

        // Start Adapter
        lvcar.setAdapter(simple_adapter);

        button = (Button)findViewById(R.id.button_a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        List<String> mapValuesToList = object.mapValuesToList(hashMap);
        mapValuesToList.forEach(System.out::println);

    }

    public List<String> mapValuesToList(Map<String,String> map) {
        Collection<String> values = map.values();
        ArrayList<String> arrayList = new ArrayList<>(values);
        return arrayList;
*/    }
    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
