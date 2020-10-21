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

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("app/src/main/assets/carData.xml");
            NodeList sList = d.getElementsByTagName("car");
            node(sList);
            System.out.println(sList.getClass());
            mapUltra = groupList(return_list(sList));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map map = mapUltra;

        ArrayList<String> arr = new ArrayList<>();

        List<Object> objectList = new ArrayList<>();
        objectList = (List<Object>) map.get(2);
        List<String> strs = (List<String>) (List) objectList;
        String test = strs.get(1);

        System.out.println(test);
    }


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

        List<Object> objectList;
        objectList = (List<Object>) map.get(2);
        List<String> strs = (List<String>) (List) objectList;
        String test = strs.get(1);

        final ArrayList<String> arr = new ArrayList<>();
        arr.add(test);

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

