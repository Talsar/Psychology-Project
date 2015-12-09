package com.psychology.psychologyapp.Fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.psychology.psychologyapp.Logic.AssessmentNotification;
import com.psychology.psychologyapp.Logic.AssessmentTimer;
import com.psychology.psychologyapp.Logic.DataIO;
import com.psychology.psychologyapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View fragmentView;
    private TextView loadText;

    private Button submitButton;
    private Button loadButton;

    private AssessmentTimer mAssessmentTimer;

    private TimePicker mTimePicker;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsFragment() {
        // Required empty public constructor
    }


    private void initiateSettings() {

        submitButton = (Button) fragmentView.findViewById(R.id.confirmSettingsButton);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Times picked by the user
                int startTimeMin = DataIO.getStartTimeMin(getActivity());
                int endTimeMin = DataIO.getEndTimeMin(getActivity());
                if (startTimeMin + 120 < endTimeMin) {

                    //Set number of finished random assessments to 0 when settings are saved
                    DataIO.setFinishedRandomAssessments(getActivity(), 0);

                    //Creates an instance of AssessmentTimer with the picked
                    //start and end time and with 5 random assessments during a day
                    AssessmentTimer mAssessmentTimer = new AssessmentTimer(startTimeMin, endTimeMin, 5);

                    //Saves times of the random assessments
                    DataIO.setRandomAssessmentTimes(getActivity(), mAssessmentTimer.getAssessmentTimesMin());

                    //Creates an instance of AssessmentNotification and creates a new notification
                    AssessmentNotification mAssessmentNotification = new AssessmentNotification();
                    mAssessmentNotification.nextNotification(getActivity());

                    int currentTimeInMin = (int) SystemClock.elapsedRealtime() / 60000;
                    int nextAss = DataIO.getRandomAssessmentTime(getActivity(), DataIO.getFinishedRandomAssessments(getActivity())) - currentTimeInMin;

                    Toast.makeText(getActivity(), R.string.submitMessage, Toast.LENGTH_SHORT).show();
                } else {
                    //Get this message when picked start and end time are less than two hours apart
                    Toast.makeText(getActivity(), R.string.timePickerAlert, Toast.LENGTH_LONG).show();

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
        fragmentView = inflater.inflate(R.layout.fragment_settings, container, false);
        initiateSettings();
        initiateTimepicker();

        return fragmentView;
    }

    private void initiateTimepicker() {
        Button startTimePicker = (Button) fragmentView.findViewById(R.id.timePickerStart);
        startTimePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showStartTimePickerDialog(fragmentView);
            }

        });

        Button endTimePicker = (Button) fragmentView.findViewById(R.id.timePickerEnd);
        endTimePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showEndTimePickerDialog(fragmentView);
            }

        });

    }

    public void showStartTimePickerDialog(View v) {
        DialogFragment mDialogFragment = new TimePickerStartFragment();
        mDialogFragment.show(getFragmentManager(), "timePicker");

    }

    public void showEndTimePickerDialog(View v) {
        DialogFragment mDialogFragment = new TimePickerEndFragment();
        mDialogFragment.show(getFragmentManager(), "timePicker");

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
