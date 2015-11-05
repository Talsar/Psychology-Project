package com.psychology.psychologyapp.Logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


import java.util.ArrayList;


/**
 * Created by mikehuesing on 03.11.15.
 */
public class DataIO {

    public static final String PREFS_NAME = "PsychData";


    public static void saveSettings(int startTime, int endTime, Context context){

        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("startTime", startTime);
        editor.putInt("endTime", endTime);
        editor.commit();
    }

    public static void setAssessmentDone(ArrayList<Boolean> assessmentsDone, Context context){

        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("assessment" + (i + 1), assessmentsDone.get(i));
        }
        editor.commit();

    }

    public static void saveRandomAssessment(String answerOne, String answerOneA, String answerTwo, ArrayList<String> answerThree, Context context){

        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("RandomAssessmentQuestionOne", answerOne);
        editor.putString("RandomAssessmentQuestionOneA", answerOneA);
        editor.putString("RandomAssessmentQuestionTwo", answerTwo);
        for (int i = 0; i < 6; i++){
            editor.putString("RandomAssessmentQuestionThree" + i, answerThree.get(i));
        }

        editor.commit();
    }


    public static ArrayList<String> getRandomAssessment(Context context){
        ArrayList<String> answers = new ArrayList<>(9);
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        answers.add(settings.getString("RandomAssessmentQuestionOne", ""));
        answers.add(settings.getString("RandomAssessmentQuestionOneA", ""));
        answers.add(settings.getString("RandomAssessmentQuestionTwo", "0"));
        for (int i = 0; i < 6; i++){
            answers.add(settings.getString("RandomAssessmentQuestionThree" + i, "0"));
        }
        return answers;
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
        editor.putString("firstName", "");
        editor.putString("lastName", "");
        editor.commit();
    }

    public static boolean isLogInInformationExisting(Context context) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);

        if (settings.getString("firstName", "").equals("")) {
            return false;
        }else {
            return true;
        }
    }

    public static void setLogInInformation(String fname, String lname, Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("firstName", fname);
        editor.putString("lastName", lname);
        editor.commit();
    }

    public static String getLogInName(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);

        return settings.getString("firstName", "")+" "+settings.getString("lastName", "");
    }




}
