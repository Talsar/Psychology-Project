package com.psychology.psychologyapp.Logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


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
        editor.putInt("endTime", endTime);
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("assessment" + (i + 1), assessmentsDone.get(i));
        }
        editor.commit();
    }

    public static void saveAssessments(ArrayList<Boolean> assessmentsDone, Context context){

        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("assessment" + (i + 1), assessmentsDone.get(i));
        }
        editor.commit();

    }

    public static int getStartTime(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("startTime", 10);

    }

    public static int getEndTime(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("endTime", 22);

    }

    public static ArrayList<Boolean> getAssessmentsDone(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        ArrayList<Boolean> assessmentsDone = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            assessmentsDone.add(settings.getBoolean("assessment" + (i + 1), false));
        }

        return assessmentsDone;

    }

    public static void pushTheRedButton(Context context) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
    }






}
