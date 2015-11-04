package com.psychology.psychologyapp.Logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by oliverbammann on 03.11.15.
 */
public class AlarmReceiver extends BroadcastReceiver {


    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AssessmentNotification assessmentNotification = new AssessmentNotification();
        assessmentNotification.notificationRandomAssessment(context);
    }


}
