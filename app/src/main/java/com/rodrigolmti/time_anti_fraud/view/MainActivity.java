package com.rodrigolmti.time_anti_fraud.view;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.rodrigolmti.time_anti_fraud.R;
import com.rodrigolmti.time_anti_fraud.track.AlertService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("DeviceId: " + Settings.Secure
            .getString(getContentResolver(), Settings.Secure.ANDROID_ID));

        (findViewById(R.id.buttonStart)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, AlertService.class));
            }
        });

        (findViewById(R.id.buttonStop)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, AlertService.class));
            }
        });
    }
}
