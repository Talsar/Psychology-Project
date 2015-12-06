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
import com.psychology.psychologyapp.Fragment.RandomAssessmentFragment;
import com.psychology.psychologyapp.R;

import java.util.Calendar;


/**
 * Created by oliverbammann on 03.11.15.
 */
public class AssessmentNotification {

    NotificationCompat.Builder mBuilder;
    AssessmentTimer mAssessmentTimer;

    public AssessmentNotification() {

    }

    /**
     * Build a notification with several settings;
     * Create an Intent that is used in mainActivity to make sure that
     * the randomAssessmentFragment is opened by clicking the notification
     * @param context The activity
     */
    public void notificationRandomAssessment(Context context) {
        //New notification with title, icon, text and autoCancel when clicked
        mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setContentTitle("Assessment");
        mBuilder.setSmallIcon(R.drawable.icon_assessment);
        mBuilder.setContentText("An Assessment is due!");
        mBuilder.setAutoCancel(true);

        //New intent used in mainActivity
        Intent resultIntent = new Intent(context, MainActivity.class);
        resultIntent.putExtra("menuFragment", "randomAssessmentFragment");
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


    /**
     * Set the notification for the next random assessment by using
     * the data saved in DataIO (time for next assessment)
     * @param context Context of the notification -> activity
     */
    public void nextNotification(Context context) {

        int currentTimeInMin = (int)SystemClock.elapsedRealtime()/60000;

        //time for next random assessment is set by using the method of DataIO class
        //and subtracted by the current time
        int nextAssessment = DataIO.getRandomAssessmentTime(context, DataIO.getFinishedRandomAssessments(context))-currentTimeInMin;

        //test long value; set the time of next notification to 10 seconds (10*1000)
        Long notificationTime = SystemClock.elapsedRealtime()+10*1000;

        //Long notificationTime = (nextAssessment*60000) - SystemClock.elapsedRealtime();

        Intent intentAlarm = new Intent(context, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, notificationTime, PendingIntent.getBroadcast(context, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
    }

}