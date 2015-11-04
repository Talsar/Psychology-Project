package com.psychology.psychologyapp.Logic;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.psychology.psychologyapp.Activity.MainActivity;
import com.psychology.psychologyapp.R;

import java.util.GregorianCalendar;

/**
 * Created by oliverbammann on 03.11.15.
 */
public class AssessmentNotification {

    NotificationCompat.Builder mBuilder;

    public AssessmentNotification() {

    }

    public void notificationRandomAssessment(Context context) {
        mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setContentTitle("Assessment");
        mBuilder.setSmallIcon(R.drawable.icon_assessment);
        mBuilder.setContentText("An Assessment is due!");
        mBuilder.setAutoCancel(true);

        Intent resultIntent = new Intent(context, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        int mId = 0;
        mNotificationManager.notify(mId, mBuilder.build());
    }

    public void alarm(Context context, View view) {
        Long time = SystemClock.elapsedRealtime()+15*1000;
        Intent intentAlarm = new Intent(context, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, time, PendingIntent.getBroadcast(context, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
    }

}