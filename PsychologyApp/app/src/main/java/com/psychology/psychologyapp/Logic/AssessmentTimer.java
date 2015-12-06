package com.psychology.psychologyapp.Logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

/**
 * Created by oliverbammann on 10.11.15.
 */
public class AssessmentTimer {

    ArrayList<Integer> assessmentTimesMin;
    int numberOfAssessments;


    public AssessmentTimer(int earliestTimeMin, int latestTimeMin, int numberOfAssessments) {
        this.initAssessmentTimes(earliestTimeMin, latestTimeMin, numberOfAssessments);
    }


    public ArrayList<Integer> getAssessmentTimesMin() {
        return assessmentTimesMin;
    }

    public void setAssessmentTimesMin(ArrayList<Integer> assessmentTimesMin) {
        this.assessmentTimesMin = assessmentTimesMin;
    }

    public int getNumberOfAssessments() {
        return numberOfAssessments;
    }

    public void setNumberOfAssessments(int numberOfAssessments) {
        this.numberOfAssessments = numberOfAssessments;
    }

    public int getAssessmentMinByIndex(int index) {
        return assessmentTimesMin.get(index);
    }


    /**
     * Calculates the times of the random
     * assessments and saves it in an Arraylist
     * @param earliestTimeMin The earliest possible time for a random assessment
     * @param latestTimeMin The latest possible time for a random assessment
     * @param numberOfAssessments The number of random assessments during a day
     */
    private void initAssessmentTimes(int earliestTimeMin, int latestTimeMin, int numberOfAssessments) {
        assessmentTimesMin = new ArrayList<>();
        this.numberOfAssessments = numberOfAssessments;
        Random random = new Random();
        for (int i=0; i<numberOfAssessments; i++) {
            //Creates a random number between the earliest and latest time
            int randomNumber = random.nextInt(latestTimeMin-earliestTimeMin) + earliestTimeMin;

            //Adds the random time to Arraylist
            assessmentTimesMin.add(randomNumber);

        }
        //Sorts the random times in the Arraylist
        Collections.sort(assessmentTimesMin);

    }



}
