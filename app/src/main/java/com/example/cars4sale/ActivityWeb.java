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

        lvCar = findViewById(R.id.lvCar);

        // Click to add String on activity web
        String[] values = new String[]{
                "Trump SB","Vesper SB","Carry SB"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,values);

        lvCar.setAdapter(adapter);

        lvCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(view.getContext(),ActivityWeb2.class);
                    startActivity(intent);

            }
        });

/*
        // Settings of Adapter
        // SimpleAdapter(Context context, List < ? extends Map<String, ?>>data,int resource, String[] from,int[] to)
        // List<String extends Map<String, Object>> arrarylist;
        List<String>
        SimpleAdapter simple_adapter = new SimpleAdapter(this, arraylist, R.layout.activity_web, from, to);
        list = new arraylist();
        for (Car c : map.values) list.add(c name) {

        }
*/
        // Start Adapter
        // lvCar.setAdapter(simple_adapter);

        // Button back to main activity
        button = (Button) findViewById(R.id.button_a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }
/*
    public List<String> mapValuesToList(Map<String, String> map) {
        Collection<String> values = map.values();
        ArrayList<String> arrayList = new ArrayList<>(values);
        return arrayList;
      }
*/
    // Button back to main activity
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
