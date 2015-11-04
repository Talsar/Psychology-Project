package com.psychology.psychologyapp.Logic;

import android.content.Context;
import android.content.SharedPreferences;


import java.util.ArrayList;


/**
 * Created by mikehuesing on 03.11.15.
 */
public class StoredData {

    public static final String PREFS_NAME = "PsychData";


    public static void saveData(int startTime, int endTime, ArrayList<Boolean> assessmentsDone, Context context){

        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("startTime", startTime);
        editor.putInt("endTime", startTime);
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("assessment"+(i+1), assessmentsDone.get(i));
        }




    }



}
