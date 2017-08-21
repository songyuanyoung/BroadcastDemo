package com.example.zach.broadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zach.broadcastdemo.Dynamic.DynamicBroadcast;
import com.example.zach.broadcastdemo.Local.LocalActivity;
import com.example.zach.broadcastdemo.Static.StaticActivity;

public class MainActivity extends AppCompatActivity {
    Button staticBroadcast;
    Button dynamicBroadcast;
    Button localBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staticBroadcast = (Button) findViewById(R.id.staticBroad);
        dynamicBroadcast = (Button) findViewById(R.id.dynamicBraodcast);
        localBroadcast = (Button) findViewById(R.id.localBraodcast);

        staticBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StaticActivity.class);
                startActivity(intent);
            }
        });
        dynamicBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DynamicBroadcast.class);
                startActivity(intent);
            }
        });

        localBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocalActivity.class);
                startActivity(intent);
            }
        });
    }
}
