package com.psychology.psychologyapp.Logic;

import com.psychology.psychologyapp.AssessmentFragment;

import java.util.ArrayList;

/**
 * Created by oliverbammann on 26.10.15.
 */
public class Assessment {

    ArrayList<ArrayList<String>> questions;
    AssessmentFragment mAssessmentFragment;



    public Assessment(AssessmentFragment mAssessmentFragment) {
        this.mAssessmentFragment=mAssessmentFragment;
        questions = new ArrayList<>();

    }

    public void addQuestion(ArrayList<String> question) {
        questions.add(question);
    }

    public String getIdQuestion(int id, int id2) {
        return questions.get(id).get(id2);
    }

    private void initializeAssessment() {
        ArrayList<String> quests = new ArrayList<>();
        quests.add(0, "Are you on campus?");
        quests.add(1, "Are you in a designated campus smoking area?");
        quests.add(2, "Are other people smoking in the smoking area?");
        quests.add(3, "Are you talking with or socializing with other people in the smoking area?");
        questions.add(0, quests);
    }



}
