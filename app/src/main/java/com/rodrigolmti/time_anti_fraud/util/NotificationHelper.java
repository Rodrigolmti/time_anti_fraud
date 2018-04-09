package com.rodrigolmti.time_anti_fraud.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.rodrigolmti.time_anti_fraud.R;

/**
 * Created by rodrigolmti on 06/04/18. At Framework
 */
public class NotificationHelper {

    private static NotificationManager mNotificationManager;
    private static NotificationHelper instance;

    private NotificationHelper(Context context) {
        mNotificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static NotificationHelper getInstance(Context context) {
        if (instance == null) {
            instance = new NotificationHelper(context);
        }
        return instance;
    }

    public void showNotification(Integer id, Context context, String message,
        boolean cancel) {

        Bitmap largeIcon = BitmapFactory
            .decodeResource(context.getResources(), R.mipmap.ic_launcher);
        NotificationCompat.Builder mBuilder = new NotificationCompat
            .Builder(context, "channel_fraude")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(largeIcon)
            .setVibrate(new long[]{-1})
            .setContentTitle(message)
            .setContentText(message)
            .setOngoing(!cancel)
            .setAutoCancel(cancel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_fraude",
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableVibration(false);
            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(channel);
            }
        }

        if (mNotificationManager != null) {
            mNotificationManager.notify(id, mBuilder.build());
        }
    }

    public void cancelNotification(Integer id) {
        if (mNotificationManager != null) {
            mNotificationManager.cancel(id);
        }
    }
}
