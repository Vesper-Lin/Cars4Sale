package com.example.cars4sale;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        simple_adapter = new SimpleAdapter(this, list, R.layout.lvcar, from, to);

        // Start Adapter
        lvcar.setAdapter(simple_adapter);
*/
        button = (Button)findViewById(R.id.button_a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
/*
        List<String> mapValuesToList = object.mapValuesToList(hashMap);
        mapValuesToList.forEach(System.out::println);
*/
    }

    public List<String> mapValuesToList(Map<String,String> map) {
        Collection<String> values = map.values();
        ArrayList<String> arrayList = new ArrayList<>(values);
        return arrayList;
    }


    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
