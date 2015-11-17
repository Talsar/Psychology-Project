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

    public AssessmentTimer(int earliestTimeHrs, int earliestTimeMin, int latestTimeHrs, int latestTimeMin, int numberOfAssessments) {
        this.initAssessmentTimes(earliestTimeHrs, earliestTimeMin, latestTimeHrs, latestTimeMin, numberOfAssessments);
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

    public int getAssessmentTimeInMin(int hrs, int min) {
        return hrs*60+min;
    }


    private void initAssessmentTimes(int earliestTimeHrs, int earliestTimeMin, int latestTimeHrs, int latestTimeMin, int numberOfAssessments) {
        assessmentTimesHrs = new ArrayList<>();
        assessmentTimesMin = new ArrayList<>();
        this.numberOfAssessments = numberOfAssessments;
        Random random = new Random();
        for (int i=0; i<numberOfAssessments; i++) {
            int earliestTimeMinTotal = earliestTimeHrs*60+earliestTimeMin;
            int latestTimeMinTotal = latestTimeHrs*60+latestTimeMin;
            int randomNumber = random.nextInt(latestTimeMinTotal-earliestTimeMinTotal)+earliestTimeMinTotal;
            assessmentTimesMin.add(randomNumber);
            /*if ((latestTimeMin-earliestTimeMin)/numberOfAssessments>30){
                for (int k : assessmentTimesMin) {

                }
            }*/
        }
        Collections.sort(assessmentTimesMin);

        /*for (int i=0; i<numberOfAssessments; i++) {
            int randomNumber = random.nextInt(latestTimeMin-earliestTimeMin)+earliestTimeMin;
            if (latestTimeHrs-earliestTimeHrs >= numberOfAssessments) {
                while (assessmentTimesHrs.contains(randomNumber)) {
                    randomNumber = random.nextInt(latestTimeHrs - earliestTimeHrs) + earliestTimeHrs;
                }
            }
            assessmentTimesHrs.add(randomNumber);
        }
        Collections.sort(assessmentTimesHrs);

        for (int i=0; i<numberOfAssessments; i++) {
            int randomNumber = random.nextInt(59);
            if (i>0 && latestTimeHrs-earliestTimeHrs >= numberOfAssessments) {
                while ((assessmentTimesHrs.get(i)*60+randomNumber)-
                        (assessmentTimesHrs.get(i-1)*60+assessmentTimesMin.get(i-1))<30) {
                    randomNumber = random.nextInt(59);
                }
            }
            assessmentTimesMin.add(randomNumber);
        }*/
    }



}
