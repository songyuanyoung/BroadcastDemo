package com.example.zach.broadcastdemo.Static;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zhangwenpurdue on 8/21/2017.
 */

public class StaticReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "The recieved broadcast message is：" + intent.getStringExtra("msg"),
                Toast.LENGTH_SHORT).show();

    }

}
