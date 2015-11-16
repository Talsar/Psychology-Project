package com.psychology.psychologyapp.Logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

/**
 * Created by oliverbammann on 10.11.15.
 */
public class AssessmentTimer {

    ArrayList<Integer> assessmentTimesHrs;
    ArrayList<Integer> assessmentTimesMin;
    int numberOfAssessments;

    public AssessmentTimer(int earliestTime, int latestTime, int numberOfAssessments) {
        this.initAssessmentTimes(earliestTime, latestTime, numberOfAssessments);
    }


    public int getNumberOfAssessments() {
        return numberOfAssessments;
    }

    public void setNumberOfAssessments(int numberOfAssessments) {
        this.numberOfAssessments = numberOfAssessments;
    }

    public int getAssessmentHrByIndex(int index) {
        return assessmentTimesHrs.get(index);
    }

    public int getAssessmentMinByIndex(int index) {
        return assessmentTimesMin.get(index);
    }


    private void initAssessmentTimes(int earliestTime, int latestTime, int numberOfAssessments) {
        assessmentTimesHrs = new ArrayList<>();
        this.numberOfAssessments = numberOfAssessments;
        Random random = new Random();
        for (int i=0; i<numberOfAssessments; i++) {
            int randomNumber = random.nextInt(latestTime-earliestTime)+earliestTime;
            if (latestTime-earliestTime >= numberOfAssessments) {
                while (assessmentTimesHrs.contains(randomNumber)) {
                    randomNumber = random.nextInt(latestTime - earliestTime) + earliestTime;
                }
            }
            assessmentTimesHrs.add(randomNumber);
        }
        Collections.sort(assessmentTimesHrs);

        for (int i=0; i<numberOfAssessments; i++) {
            int randomNumber = random.nextInt(59);
            if (i>0 && latestTime-earliestTime >= numberOfAssessments) {
                while ((assessmentTimesHrs.get(i)*60+randomNumber)-
                        (assessmentTimesHrs.get(i-1)*60+assessmentTimesMin.get(i-1))<30) {
                    randomNumber = random.nextInt(59);
                }
            }
            assessmentTimesMin.add(randomNumber);
        }
    }



}
