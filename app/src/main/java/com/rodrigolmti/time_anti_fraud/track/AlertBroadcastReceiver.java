package com.rodrigolmti.time_anti_fraud.track;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.rodrigolmti.time_anti_fraud.model.Alert;
import com.rodrigolmti.time_anti_fraud.model.AlertType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by rodrigolmti on 09/03/18. At Framework
 */

public class AlertBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = AlertBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent pIntent) {
        try {

            String action = pIntent.getAction();
            saveReceivedBroadcastDetails(context, action);
            Log.d(TAG, "onReceive");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private void saveReceivedBroadcastDetails(Context context, String action) {
        try {

            Log.d(TAG, "saveReceivedBroadcastDetails");
            sendDataToFirebase(context, AlertType.getType(action));

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private void sendDataToFirebase(Context context, AlertType alertType) {
        try {

            if (alertType != null) {
                Log.d(TAG, "sendDataToFirebase");
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "dd-MM-yyy HH:mm:ss");
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference databaseReference = database.getReference("alerts");
                final Alert alert = new Alert(alertType.getValue(), ServerValue.TIMESTAMP,
                    simpleDateFormat.format(new Date()), Settings.Secure
                    .getString(context.getContentResolver(), Settings.Secure.ANDROID_ID));
                databaseReference.child(UUID.randomUUID().toString()).setValue(alert);
            }

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
