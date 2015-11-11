package com.psychology.psychologyapp.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by oliverbammann on 10.11.15.
 */
public class AssessmentTimer {

    GregorianCalendar assessmentDatetime;
    ArrayList<Integer> assessmentTimes;
    int numberOfAssessments;

    public AssessmentTimer(int earliestTime, int latestTime, int numberOfAssessments) {
        this.initAssessmentTimes(earliestTime, latestTime, numberOfAssessments);
    }


    private void initAssessmentTimes(int earliestTime, int latestTime, int numberOfAssessments) {
        assessmentTimes = new ArrayList<>();
        this.numberOfAssessments = numberOfAssessments;
        Random random = new Random();
        for (int i=0; i<numberOfAssessments; i++) {
            int randomNumber = random.nextInt(latestTime-earliestTime)+earliestTime;
            while (assessmentTimes.contains(randomNumber)) {
                randomNumber = random.nextInt(latestTime-earliestTime)+earliestTime;
            }
            assessmentTimes.add(randomNumber);
        }
        Collections.sort(assessmentTimes);
    }

    private void createAssessmentDatetime(int time) {
        Random random = new Random();

    }


}
