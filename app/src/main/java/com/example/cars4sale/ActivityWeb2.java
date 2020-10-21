package com.example.cars4sale;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Objects;

public class ActivityWeb2 extends AppCompatActivity {
    private Button button;
    //private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        // Get user from intent
        //Intent intent = getIntent();
        //user = (User) Objects.requireNonNull(intent.getExtras()).getSerializable("USER");

        button = (Button) findViewById(R.id.button_b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityWeb();
            }
        });
    }

    public void openActivityWeb() {
        Intent intent = new Intent(this, ActivityWeb.class);
        startActivity(intent);
    }
}
