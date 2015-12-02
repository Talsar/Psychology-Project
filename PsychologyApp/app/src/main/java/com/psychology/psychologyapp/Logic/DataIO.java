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



    public static int getStartTimeHrs(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("startTimeHrs", 10);

    }

    public static int getEndTimeHrs(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("endTimeHrs", 22);

    }

    public static int getStartTimeMin(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("startTimeMin", 0);

    }

    public static int getEndTimeMin(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("endTimeMin", 0);

    }

    public static void setFinishedRandomAssessments(Context context, int finishedAssessments) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("finishedRandomAssessments", finishedAssessments);
        editor.commit();
    }

    public static int getFinishedRandomAssessments(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("finishedRandomAssessments", 0);

    }

    /**
     * Return the time in minutes of the random assessment with the assessmentIndex
     * @param context The activity
     * @param assessmentIndex Index of the assessment whose time should be returned
     * @return Time in minutes when the random assessment with index assessmentIndex should appear
     */
    public static int getRandomAssessmentTime(Context context, int assessmentIndex){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("randomAssessmentTime"+assessmentIndex, 0);

    }

    /**
     * Saves the times of the random assessments in minutes
     * @param context The activity
     * @param randomAssessmentTimes ArrayList with all times in minutes when the notifications
     *                              for the random assessments should appear during a day
     */
    public static void setRandomAssessmentTimes(Context context, ArrayList<Integer> randomAssessmentTimes) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        for (int i=0; i<randomAssessmentTimes.size();i++) {
            editor.putInt("randomAssessmentTime"+i, randomAssessmentTimes.get(i));
        }
        editor.commit();
    }

    /**
     * Saves the time of the earliest possible random assessment in minutes during a day
     * (Time is set by user in settings)
     * @param context The activity
     * @param startTimeMin The time in minutes of earliest possible random assessment
     */
    public static void setStartTimeMin(Context context, int startTimeMin) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("startTimeMin", startTimeMin);
        editor.commit();
    }

    /**
     * Saves the time of the latest possible random assessment in minutes during a day
     * (Time is set by user in settings)
     * @param context The activity
     * @param endTimeMin The time in minutes of latest possible random assessment
     */
    public static void setEndTimeMin(Context context, int endTimeMin) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("endTimeMin", endTimeMin);
        editor.commit();
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
