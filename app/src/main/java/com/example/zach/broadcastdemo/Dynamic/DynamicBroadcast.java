package com.example.zach.broadcastdemo.Dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zach.broadcastdemo.R;

public class DynamicBroadcast extends AppCompatActivity {
    private IntentFilter intentFilter;
    private  networkChangedReciever mNetworkChangedReciever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_broadcast);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetworkChangedReciever = new networkChangedReciever();
        registerReceiver(mNetworkChangedReciever, intentFilter);

    }
    class networkChangedReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context,"net is available" + networkInfo.toString() ,Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context,"net is unavailable" ,Toast.LENGTH_SHORT).show();

            }
        }
    }
}
