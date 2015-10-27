package com.psychology.psychologyapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InitiativeAssessmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InitiativeAssessmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InitiativeAssessmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<ArrayList<String>> questionAnswerGroup;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View fragmentView;


    int iSeekBarQuestionThree;

    private HashMap<SeekBar, TextView> textSeekBarMap;
    private ArrayList<SeekBar> seekBars;
    private ArrayList<TextView> seekBarTexts;

    private TextView textSeekBarQuestionTwo;
    private TextView textSeekBarQuestionThreeA;
    private TextView textSeekBarQuestionThreeB;
    private TextView textSeekBarQuestionThreeC;
    private TextView textSeekBarQuestionThreeD;
    private TextView textSeekBarQuestionThreeE;
    private TextView textSeekBarQuestionThreeF;
    private TextView questionOneText;
    private TextView questionOneAText;
    private TextView questionOneBText;
    private TextView questionOneCText;
    private TextView questionOneDText;
    private TextView questionOneEText;
    private RadioGroup radioGroupQuestionOne;
    private RadioGroup radioGroupQuestionOneA;
    private RadioGroup radioGroupQuestionOneB;
    private RadioGroup radioGroupQuestionOneC;
    private RadioGroup radioGroupQuestionOneD;
    private RadioGroup radioGroupQuestionOneE;
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
    private Spinner locationSpinnerQuestion1;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InitiativeAssessmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InitiativeAssessmentFragment newInstance(String param1, String param2) {
        InitiativeAssessmentFragment fragment = new InitiativeAssessmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public InitiativeAssessmentFragment() {
        // Required empty public constructor
    }

    private void initiateAssessment() {

        seekBars = new ArrayList<>(6);
        seekBarQuestionThreeA = (SeekBar) fragmentView.findViewById(R.id.seekBarQuestionThreeA);
        seekBars.add(seekBarQuestionThreeA);
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

                    textSeekBarMap.get(seekBar).setText(""+progress);




                }
            });
        }

        cardViewQuestion1 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion1);
        cardViewQuestion1.setVisibility(View.VISIBLE);

        cardViewQuestion2 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion2);
        cardViewQuestion2.setVisibility(View.GONE);

        cardViewQuestion3 = (CardView) fragmentView.findViewById(R.id.cardViewQuestion3);
        cardViewQuestion3.setVisibility(View.GONE);

        textSeekBarQuestionTwo = (TextView) fragmentView.findViewById(R.id.textSeekBarQuestionTwo);
        textSeekBarQuestionTwo.setText("0");



        questionOneText = (TextView) fragmentView.findViewById(R.id.questionOneText);
        questionOneAText = (TextView) fragmentView.findViewById(R.id.questionOneAText);
        questionOneAText.setVisibility(View.GONE);
        questionOneBText = (TextView) fragmentView.findViewById(R.id.questionOneBText);
        questionOneBText.setVisibility(View.GONE);
        questionOneCText = (TextView) fragmentView.findViewById(R.id.questionOneCText);
        questionOneCText.setVisibility(View.GONE);
        questionOneDText = (TextView) fragmentView.findViewById(R.id.questionOneDText);
        questionOneDText.setVisibility(View.GONE);
        questionOneEText = (TextView) fragmentView.findViewById(R.id.questionOneEText);
        questionOneEText.setVisibility(View.GONE);

        radioGroupQuestionOne = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOne);
        radioGroupQuestionOneA = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneA);
        radioGroupQuestionOneA.setVisibility(View.GONE);
        radioGroupQuestionOneB = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneB);
        radioGroupQuestionOneB.setVisibility(View.GONE);
        radioGroupQuestionOneC = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneC);
        radioGroupQuestionOneC.setVisibility(View.GONE);
        radioGroupQuestionOneD = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneD);
        radioGroupQuestionOneD.setVisibility(View.GONE);
        radioGroupQuestionOneE = (RadioGroup) fragmentView.findViewById(R.id.radioGroupQuestionOneE);
        radioGroupQuestionOneE.setVisibility(View.GONE);

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


        radioGroupQuestionOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    Toast.makeText(getActivity(), "You selected " + checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    if (checkedRadioButton.getText().equals("Yes")) {
                        //locationSpinnerQuestion1.setVisibility(View.GONE);
                        questionOneDText.setVisibility(View.GONE);
                        radioGroupQuestionOneD.setVisibility(View.GONE);
                        questionOneAText.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneA.setVisibility(View.VISIBLE);

                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);


                    } else {
                        //locationSpinnerQuestion1.setVisibility(View.VISIBLE);
                        questionOneDText.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneD.setVisibility(View.VISIBLE);
                        questionOneAText.setVisibility(View.GONE);
                        radioGroupQuestionOneA.setVisibility(View.GONE);
                        questionOneBText.setVisibility(View.GONE);
                        radioGroupQuestionOneB.setVisibility(View.GONE);
                        questionOneCText.setVisibility(View.GONE);
                        radioGroupQuestionOneC.setVisibility(View.GONE);
                        questionOneEText.setVisibility(View.GONE);
                        radioGroupQuestionOneE.setVisibility(View.GONE);

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
                    Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    if (checkedRadioButton.getText().equals("Yes")) {
                        questionOneBText.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneB.setVisibility(View.VISIBLE);
                        questionOneDText.setVisibility(View.GONE);
                        radioGroupQuestionOneD.setVisibility(View.GONE);
                        questionOneEText.setVisibility(View.GONE);
                        radioGroupQuestionOneE.setVisibility(View.GONE);

                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);
                    }else{
                        questionOneBText.setVisibility(View.GONE);
                        radioGroupQuestionOneB.setVisibility(View.GONE);
                        questionOneCText.setVisibility(View.GONE);
                        radioGroupQuestionOneC.setVisibility(View.GONE);
                        questionOneEText.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneE.setVisibility(View.VISIBLE);

                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);
                    }
                }
            }
        });

        radioGroupQuestionOneB.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    if (checkedRadioButton.getText().equals("Yes")) {
                        questionOneCText.setVisibility(View.VISIBLE);
                        radioGroupQuestionOneC.setVisibility(View.VISIBLE);

                        cardViewQuestion2.setVisibility(View.GONE);
                        cardViewQuestion3.setVisibility(View.GONE);
                    }else{
                        questionOneCText.setVisibility(View.GONE);
                        radioGroupQuestionOneC.setVisibility(View.GONE);

                        cardViewQuestion2.setVisibility(View.VISIBLE);
                        cardViewQuestion3.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        radioGroupQuestionOneC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                cardViewQuestion2.setVisibility(View.VISIBLE);
                cardViewQuestion3.setVisibility(View.VISIBLE);
            }
        });

        radioGroupQuestionOneD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                cardViewQuestion2.setVisibility(View.VISIBLE);
                cardViewQuestion3.setVisibility(View.VISIBLE);
            }
        });

        radioGroupQuestionOneE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rGroup, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                Toast.makeText(getActivity(), "You selected "+ checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                cardViewQuestion2.setVisibility(View.VISIBLE);
                cardViewQuestion3.setVisibility(View.VISIBLE);
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
        fragmentView = inflater.inflate(R.layout.fragment_initiative_assessment, container, false);
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
/*
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView myText = (TextView) view;
        if (!myText.getText().equals("Nothing Selected")) {
            cardViewQuestion2.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "You selected "+myText.getText(), Toast.LENGTH_SHORT).show();

        } else {
            cardViewQuestion2.setVisibility(View.GONE);
        }


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
*/
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
