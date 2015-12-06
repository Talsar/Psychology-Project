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
            int randomNumber = random.nextInt(latestTimeMin-earliestTimeMin)+earliestTimeMin;
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
