package com.example.cars4sale;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.cars4sale.DataGenerator.Car;
import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.*;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.HashMap;
import java.util.Map;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.node;


public class ActivityWeb extends AppCompatActivity {
    private Button button;
    SimpleAdapter simple_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);



        /*
        // Click to add String on activity web
        String[] values = new String[]{
                "Trump SB", "Vesper SB", "Carry SB"
        };*/


        Map map = BSTSearch.readData_map();

        ArrayList<String> arr = new ArrayList<>();
        for (Object i : map.keySet()){
            arr.add(map.get(i).toString());
        }


        final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arr);

        final ListView lvCar = findViewById(R.id.lvCar);
        lvCar.setAdapter(arrayAdapter);

        lvCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String car = lvCar.getItemAtPosition(i).toString();
                Intent intent = new Intent(view.getContext(), ActivityWeb2.class);
                startActivity(intent);
            }
        });

        // Button back to main activity
        button = (Button) findViewById(R.id.button_a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    // Button back to main activity
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


        /*
        // Settings of Adapter
        // SimpleAdapter(Context context, List < ? extends Map<String, ?>>data,int resource, String[] from,int[] to)
        // List<String extends Map<String, Object>> arrarylist;
        List<String> lyx = mapValuesToList(BSTSearch.readData_map());
        SimpleAdapter simple_adapter = new SimpleAdapter(this, arraylist, R.layout.activity_web, from, to);

        // Start Adapter
        lvCar.setAdapter(simple_adapter);


    }

    public List<String> mapValuesToList(Map<String, String> map) {
        Collection<String> values = map.values();
        ArrayList<String> arrayList = new ArrayList<>(values);
        return arrayList;
      }
*/

    public static void main(String[] args) {

        Map map = BSTSearch.readData_map();

        ArrayList<String> arr = new ArrayList<>();
        for (Object i : map.keySet()){
            arr.add(map.get(i).toString());
        }
        System.out.println(arr);
    }
}