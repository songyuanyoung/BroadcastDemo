package com.example.zach.broadcastdemo.Local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zach.broadcastdemo.R;

public class LocalActivity extends AppCompatActivity {
    Button button;
    LocalBroadcastReciever localBroadcastReciever;
    LocalBroadcastManager localBroadcastManager;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        button = (Button) findViewById(R.id.btn);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.zach.broadcastdemo.Local");
                localBroadcastManager.sendBroadcast(intent);

            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.zach.broadcastdemo.Local");
        localBroadcastReciever = new LocalBroadcastReciever();
        localBroadcastManager.registerReceiver(localBroadcastReciever, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadcastReciever);
    }

    class LocalBroadcastReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
