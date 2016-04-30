package com.anshdeep.simplenotes;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by ANSHDEEP on 05-04-2016.
 */
public class MyNewIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        String remTitle = intent.getStringExtra("rem_title");
        String remDesc = intent.getStringExtra("rem_desc");


        builder.setContentTitle(remTitle);
        builder.setContentText(remDesc);
        builder.setSmallIcon(R.drawable.ic_alarm_24dp);
        builder.setAutoCancel(true);
        builder.setLights(Color.GREEN, 500, 500);

        Intent notifyIntent = new Intent(this, ReminderActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);

    }
}
