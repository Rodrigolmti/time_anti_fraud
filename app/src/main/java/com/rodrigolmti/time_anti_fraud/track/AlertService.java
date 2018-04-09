package com.rodrigolmti.time_anti_fraud.track;

import static com.rodrigolmti.time_anti_fraud.model.AlertType.TIME_SET;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.rodrigolmti.time_anti_fraud.util.NotificationHelper;

/**
 * Created by rodrigolmti on 09/03/18. At Framework
 */

public class AlertService extends IntentService {

    private static final String TAG = AlertBroadcastReceiver.class.getSimpleName();
    private AlertBroadcastReceiver alertBroadcastReceiver;
    public static final int ID = 10051000;

    public AlertService() {
        super("AlertService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        alertBroadcastReceiver = new AlertBroadcastReceiver();
    }

    @Override
    public IBinder onBind(Intent pIntent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");
    }

    @Override
    public int onStartCommand(Intent pIntent, int pFlags, int pStartId) {
        NotificationHelper.getInstance(this)
            .showNotification(ID, this, "Anti fraud running", false);
        Log.d(TAG, "onStartCommand");
        registerAnyBroadcastReceiver();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            Log.d(TAG, "onDestroy");
            unregisterReceiver(alertBroadcastReceiver);
            NotificationHelper.getInstance(this).cancelNotification(ID);
        } catch (Exception ignore) {
        }
    }

    private void registerAnyBroadcastReceiver() {
        try {
            Log.d(TAG, "registerAnyBroadcastReceiver");
            registerBroadcastReceiverForActions();
        } catch (Exception e) {
            Log.d(TAG, "Exception while registering: " + e.getMessage());
        }
    }

    private void registerBroadcastReceiverForActions() {
        Log.d(TAG, "registerBroadcastReceiverForActions");
        registerReceiver(alertBroadcastReceiver, addAllKnownActions());
    }

    private IntentFilter addAllKnownActions() {
        Log.d(TAG, "addAllKnownActions");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TIME_SET.getValue());
        return intentFilter;
    }
}