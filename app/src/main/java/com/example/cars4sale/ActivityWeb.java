package com.example.cars4sale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static com.example.cars4sale.DataStructure.BSTSearch.groupList;
import static com.example.cars4sale.DataStructure.BSTSearch.node;
import static com.example.cars4sale.DataStructure.BSTSearch.return_list;


public class ActivityWeb extends AppCompatActivity {

    private static NodeList listUltra;
    private static Map mapUltra = new HashMap();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream is = getAssets().open("carData.xml");
            Document d = builder.parse(is);
            listUltra = d.getElementsByTagName("car");
            node(listUltra);
            System.out.println(listUltra.getClass());
            mapUltra = groupList(return_list(listUltra));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map map = mapUltra;

        final ArrayList<String> arr = new ArrayList<>();

        for (int i=0; i<1000; i++){
            List<Object> objectList = (List<Object>) map.get(i);
            List<String> str = (List<String>) (List) objectList;
            String name = str.get(1);
            String location = str.get(2);
            String price = str.get(3);
            String year = str.get(4);
            arr.add("car: " + name + "\n" + "price: $" + price + "\n" + "year: " + year + "\n" + "location: " + location);
        }

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        final ListView listView = findViewById(R.id.lvCar);
        listView.setAdapter(arrayAdapter);

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
