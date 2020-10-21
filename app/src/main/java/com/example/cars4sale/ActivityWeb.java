package com.example.cars4sale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ActivityWeb extends AppCompatActivity {

    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Map map = BSTSearch.readData_map();

        ArrayList<String> arr = new ArrayList<>();

        List<Object> objectList = new ArrayList<>();
        List<String> strs = (List<String>)(List) objectList;


        for (int i = 0; i < map.size(); i++) {
            objectList.add(map.get(i));
            arr.add(objectList.toString());
        }

        final ListView lvCar = findViewById(R.id.lvCar);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arr);
        lvCar.setAdapter(arrayAdapter);

        /*
        lvCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String car = lvCar.getItemAtPosition(i).toString();
                Intent intent = new Intent(view.getContext(), ActivityWeb2.class);
                startActivity(intent);
            }
        });*/

        // Button back to main activity
        button = findViewById(R.id.button_a);
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
}


/*
        // Click to add String on activity web
        String[] values = new String[]{
                "Trump SB", "Max SB", "Carry SB"
        };*/



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
