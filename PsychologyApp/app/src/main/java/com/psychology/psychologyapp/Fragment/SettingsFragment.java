package com.psychology.psychologyapp.Fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.psychology.psychologyapp.Logic.DataIO;
import com.psychology.psychologyapp.R;

import java.util.ArrayList;

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

        loadText = (TextView) fragmentView.findViewById(R.id.loadText);

        submitButton = (Button) fragmentView.findViewById(R.id.confirmSettingsButton);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = 11;
                int b = 23;
                ArrayList<Boolean> bools = new ArrayList(5);
                bools.add(false);
                bools.add(false);
                bools.add(true);
                bools.add(false);
                bools.add(false);
                DataIO.saveSettings(a, b, getActivity());
                Toast.makeText(getActivity(), "You submitted your data!", Toast.LENGTH_SHORT).show();
            }

        });



        loadButton = (Button) fragmentView.findViewById(R.id.loadSettingsButton);
        loadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = DataIO.getStartTime(getActivity());
                int b = DataIO.getEndTime(getActivity());
                ArrayList<Boolean> bools = DataIO.getAssessmentsDone(getActivity());
                loadText.setText("StartTime: " + a + "\n" +
                        "EndTime: " + b + "\n" +
                        "Assessments: " + bools.get(0) + ", " + bools.get(1) + ", "
                        + bools.get(2) + ", " + bools.get(3) + ", " + bools.get(4));

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
        Button timePicker = (Button) fragmentView.findViewById(R.id.timePicker);
        timePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showTimePickerDialog(fragmentView);
            }

        });
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
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
