package com.psychology.psychologyapp.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.psychology.psychologyapp.Logic.AssessmentNotification;
import com.psychology.psychologyapp.Logic.DataIO;
import com.psychology.psychologyapp.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RandomAssessmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RandomAssessmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomAssessmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private View fragmentView;

    int iSeekBarQuestionThree;

    private ArrayList<SeekBar> seekBars;
    private ArrayList<TextView> seekBarTexts;

    private HashMap<SeekBar, TextView> textSeekBarMap;


    private Button submitButton;
    private TextView textSeekBarQuestionTwo;
    private TextView textSeekBarQuestionThreeA;
    private TextView textSeekBarQuestionThreeB;
    private TextView textSeekBarQuestionThreeC;
    private TextView textSeekBarQuestionThreeD;
    private TextView textSeekBarQuestionThreeE;
    private TextView textSeekBarQuestionThreeF;
    private TextView headlineQuestionOne;
    private TextView headlineQuestionOneA;
    private RadioGroup radioGroupQuestionOne;
    private RadioGroup radioGroupQuestionOneA;
    private CardView cardViewQuestion1;
    private CardView cardViewQuestion2;
    private CardView cardViewQuestion3;
    private SeekBar seekBarQuestionTwo;
    private SeekBar seekBarQuestionThreeA;
    private SeekBar seekBarQuestionThreeB;
    private SeekBar seekBarQuestionThreeC;
    private SeekBar seekBarQuestionThreeD;
    private SeekBar seekBarQuestionThreeE;
    private SeekBar seekBarQuestionThreeF;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomAssessmentFragment.
     */
    public static RandomAssessmentFragment newInstance(String param1, String param2) {
        RandomAssessmentFragment fragment = new RandomAssessmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RandomAssessmentFragment() {
        // Required empty public constructor
    }

    /**
     * Initiates the assessment. Calls all the widgets and sets their options.
     * Also creates all the action listeners for when questions are answered
     * to make the next widget visible.
     */
    private void initiateAssessment() {

        //Creates all the seekbars and set their parameters, after that the belonging texts
        seekBars = new ArrayList<>(6);
        seekBarQuestionThreeA = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeA);
        seekBars.add(seekBarQuestionThreeA);
        seekBarQuestionThreeA.setMax(5);
        seekBarQuestionThreeB = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeB);
        seekBars.add(seekBarQuestionThreeB);
        seekBarQuestionThreeC = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeC);
        seekBars.add(seekBarQuestionThreeC);
        seekBarQuestionThreeD = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeD);
        seekBars.add(seekBarQuestionThreeD);
        seekBarQuestionThreeE = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeE);
        seekBars.add(seekBarQuestionThreeE);
        seekBarQuestionThreeF = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeF);
        seekBars.add(seekBarQuestionThreeF);
        seekBarQuestionThreeA.setMax(5);

        seekBarTexts = new ArrayList<>(6);
        textSeekBarQuestionThreeA = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeA);
        textSeekBarQuestionThreeA.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeA);
        textSeekBarQuestionThreeB = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeB);
        textSeekBarQuestionThreeB.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeB);
        textSeekBarQuestionThreeC = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeC);
        textSeekBarQuestionThreeC.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeC);
        textSeekBarQuestionThreeD = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeD);
        textSeekBarQuestionThreeD.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeD);
        textSeekBarQuestionThreeE = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeE);
        textSeekBarQuestionThreeE.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeE);
        textSeekBarQuestionThreeF = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionThreeF);
        textSeekBarQuestionThreeF.setText("0");
        seekBarTexts.add(textSeekBarQuestionThreeF);
        textSeekBarMap = new HashMap<>(6);

        //Creates the submitButton and sets its listener
        submitButton = (Button) fragmentView.findViewById(R.id.submitButton);
        submitButton.setVisibility(View.GONE);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                ArrayList<Boolean> bools = new ArrayList<Boolean>(5);
                bools.add(false);bools.add(true);bools.add(true);bools.add(false);bools.add(false);
                DataIO.setAssessmentDone(bools, getActivity());
                RadioButton radioButtonQOne = (RadioButton)radioGroupQuestionOne.findViewById(radioGroupQuestionOne.getCheckedRadioButtonId());
                RadioButton radioButtonQOneA = (RadioButton)radioGroupQuestionOneA.findViewById(radioGroupQuestionOneA.getCheckedRadioButtonId());
                //Toast.makeText(getActivity(), radioButtonQOneA.getText(), Toast.LENGTH_SHORT).show();
                ArrayList<String> moods = new ArrayList<String>(6);
                for (int i = 0; i < 6; i++){
                    moods.add(i, Integer.toString(seekBars.get(i).getProgress()));
                }
                DataIO.saveRandomAssessment(radioButtonQOne.getText().toString(),
                        radioButtonQOneA.getText().toString(),
                        Integer.toString(seekBarQuestionTwo.getProgress()),
                        moods,
                        getActivity());

                //Increase the number of finished assessments for this day by one
                DataIO.setFinishedRandomAssessments(getActivity(), DataIO.getFinishedRandomAssessments(getActivity()) + 1);
                AssessmentNotification mAssessmentNotification = new AssessmentNotification();
                mAssessmentNotification.nextNotification(getActivity());

                Toast.makeText(getActivity(), R.string.submitMessage, Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();

            }

        });

        //sets the listener of the seekbars
        for (iSeekBarQuestionThree=0; iSeekBarQuestionThree<6; iSeekBarQuestionThree++) {
            seekBars.get(iSeekBarQuestionThree).setMax(5);
            textSeekBarMap.put(seekBars.get(iSeekBarQuestionThree), seekBarTexts.get(iSeekBarQuestionThree));
            seekBars.get(iSeekBarQuestionThree).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }


                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // TODO Auto-generated method stub


                    textSeekBarMap.get(seekBar).setText("" + progress);


                }
            });
        }


        //creates all the elements belong to the questions
        cardViewQuestion1 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion1);
        cardViewQuestion1.setVisibility(View.VISIBLE);

        cardViewQuestion2 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion2);
        cardViewQuestion2.setVisibility(View.GONE);

        cardViewQuestion3 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion3);
        cardViewQuestion3.setVisibility(View.GONE);

        textSeekBarQuestionTwo = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionTwo);
        textSeekBarQuestionTwo.setText("0");



        headlineQuestionOne = (TextView) fragmentView.findViewById(R.id.headlineQuestionOne);
        headlineQuestionOneA = (TextView) fragmentView.findViewById(R.id.questionOneAText);
        headlineQuestionOneA.setVisibility(View.GONE);


        radioGroupQuestionOne = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOne);
        radioGroupQuestionOneA = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneA);
        radioGroupQuestionOneA.setVisibility(View.GONE);

        seekBarQuestionTwo = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionTwo);
        seekBarQuestionTwo.setMax(10);
        seekBarQuestionTwo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub

                textSeekBarQuestionTwo.setText("" + progress);


            }
        });

        //the next listeners created shows the correct next questions
        //of the quiz because the questions depend on the answers
        radioGroupQuestionOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    //Toast.makeText(getActivity(), "You selected " + checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    if (checkedRadioButton.getText().equals("Yes")) {
                        //locationSpinnerQuestion1.setVisibility(View.GONE);
                        headlineQuestionOneA.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneA.setVisibility(View.VISIBLE);

                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);


                    } else {
                        //locationSpinnerQuestion1.setVisibility(View.VISIBLE);
                        headlineQuestionOneA.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneA.setVisibility(View.VISIBLE);
                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);
                    }
                }
            }
        });


        radioGroupQuestionOneA.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    //Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    cardViewQuestion2.setVisibility(View.VISIBLE);
                    cardViewQuestion3.setVisibility(View.VISIBLE);
                    submitButton.setVisibility(View.VISIBLE);


                }
            }
        });



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_random_assessment, container, false);
        initiateAssessment();
        return fragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
