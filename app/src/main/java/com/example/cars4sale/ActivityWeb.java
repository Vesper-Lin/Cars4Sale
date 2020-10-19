package com.example.cars4sale;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.DataFormatException;

public class ActivityWeb extends AppCompatActivity {
    // List View Test
    ListView lvCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        lvCar = (ListView) findViewById(R.id.lvCar);
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Vesper SB");
        arrayList.add("Carry SB");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvCar.setAdapter(arrayAdapter);

        lvCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityWeb.this,"No." +position+ "" + arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
