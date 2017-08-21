package com.example.zach.broadcastdemo.Static;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zach.broadcastdemo.R;

public class StaticActivity extends AppCompatActivity {
    Button normal;
    Button ordered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);
        normal = (Button) findViewById(R.id.normal);
        ordered = (Button) findViewById(R.id.ordered);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.example.zach.broadcastdemo.static");
                intent.putExtra("msg", "This is a normal broadcast");
                sendBroadcast(intent);
            }
        });

        ordered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.example.zach.broadcastdemo.static");
                intent.putExtra("msg", "This is an ordered broadcast");
                sendOrderedBroadcast(intent, null);
            }
        });




    }
}
