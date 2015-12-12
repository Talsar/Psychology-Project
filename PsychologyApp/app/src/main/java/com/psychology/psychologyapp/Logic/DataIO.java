package com.psychology.psychologyapp.Logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by mikehuesing on 03.11.15.
 */
public class DataIO {

    public static final String PREFS_NAME = "PsychData";

    /**
     * set the assessment that is finished
     * @param context The activity
     * @param assessmentsDone the arraylist of all done assessments
     */
    public static void setAssessmentDone(ArrayList<Boolean> assessmentsDone, Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("assessment" + (i + 1), assessmentsDone.get(i));
        }
        editor.commit();

    }

    /**
     * saves the data put in in a random assessment
     * @param context The activity
     * @param answerOneA the answer of one a
     * @param answerTwo the answer of two
     * @param answerThree the answer og three
     */
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


    /**
     * calculates the time to next assessment and returns it
     * @param context The activity
     * @return gets the time to next assessment back
     */
    public static int getTimeNextAssessment(Context context) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int currentTimeInMin = (hour*60)+minute;
        //int currentTimeInMin = (int) SystemClock.elapsedRealtime() / 60000;
        int finishedAss = DataIO.getFinishedRandomAssessments(context);
        for (int i=finishedAss;i<5;i++) {
            int currentAssTime = getRandomAssessmentTime(context, i);
            if (currentAssTime > currentTimeInMin) {
                return currentAssTime-currentTimeInMin;
            }
            DataIO.setFinishedRandomAssessments(context, DataIO.getFinishedRandomAssessments(context)+1);
        }
        return 0;

    }

    /**
     * gives back the start time of the user set random assessment times
     * @param context The activity
     * @return start time of random assessments
     */
    public static int getStartTimeMin(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("startTimeMin", 0);

    }

    /**
     * gives back the end time of the user set random assessment times
     * @param context The activity
     * @return end time of random assessments
     */
    public static int getEndTimeMin(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("endTimeMin", 0);

    }

    /**
     * Set the number of finished random assessments to
     * the integer parameter; When number is at 5, times of the random
     * assessments are set newly.
     * @param context
     * @param finishedAssessments Number of finished assessments
     */
    public static void setFinishedRandomAssessments(Context context, int finishedAssessments) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        if (DataIO.getFinishedRandomAssessments(context)==DataIO.getRandomAssessmentsNumber(context)) {
            //int earliestTime = DataIO.getStartTimeMin(context);
            //int latestTime = DataIO.getEndTimeMin(context);
            //AssessmentTimer mAssessmentTimer = new AssessmentTimer(earliestTime, latestTime, 5);
            //DataIO.setRandomAssessmentTimes(context, mAssessmentTimer.getAssessmentTimesMin());
            editor.putInt("finishedRandomAssessments", 0);
        } else {
            editor.putInt("finishedRandomAssessments", finishedAssessments);
        }
        editor.commit();
    }

    public static int getFinishedRandomAssessments(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("finishedRandomAssessments", 0);
    }

    /**
     * Return the number of random assessments
     * @param context
     * @return returns the number of random assessments
     */
    public static int getRandomAssessmentsNumber(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("randomAssessments", 2);
    }

    /**
     * Sets the random assessment number
     * @param context The activity
     * @param numberOfAssessments Number of assessments
     *
     */
    public static void setRandomAssessmentsNumber(Context context, int numberOfAssessments) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("randomAssessments", numberOfAssessments);
        editor.commit();
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
        DataIO.setFinishedRandomAssessments(context, 0);
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

    /**
     * Returns all assessments done
     * @param context The activity
     * @return ArrayList of all assessments done
     */
    public static ArrayList<Boolean> getAssessmentsDone(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        ArrayList<Boolean> assessmentsDone = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            assessmentsDone.add(settings.getBoolean("assessment" + (i + 1), false));
        }

        return assessmentsDone;

    }

    /**
     * Deletes every data in the shared preferences (data saved on phone)
     * @param context The activity
     */
    public static void pushTheRedButton(Context context) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("firstName", "");
        editor.putString("lastName", "");
        editor.putInt("startTimeMin", 600);
        editor.putInt("endTimeMin", 1200);
        editor.putInt("finishedRandomAssessments", 0);
        for (int i=0; i<getRandomAssessmentsNumber(context);i++) {
            editor.putInt("randomAssessmentTime"+i, 0);
        }
        editor.commit();
    }

    /**
     * returns back a boolean
     * @param context The activity
     * @return boolean if there are login information
     */
    public static boolean isLogInInformationExisting(Context context) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);

        if (settings.getString("firstName", "").equals("")) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * Saves the name of the user
     * @param context The activity
     * @param fname First name of the user
     * @param lname Last name of the user
     *
     */
    public static void setLogInInformation(String fname, String lname, Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("firstName", fname);
        editor.putString("lastName", lname);
        editor.commit();
    }

    /**
     * gives back the login information
     * @param context The activity
     * @return returns the login information
     */
    public static String getLogInName(Context context){
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);

        return settings.getString("firstName", "")+" "+settings.getString("lastName", "");
    }




}
