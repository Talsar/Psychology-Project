package com.psychology.psychologyapp.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.psychology.psychologyapp.Logic.DataIO;
import com.psychology.psychologyapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainMenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainMenuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private InitiativeAssessmentFragment mInitiativeAssessmentFragment;
    private RandomAssessmentFragment mRandomAssessmentFragment;
    private DailyAssessmentFragment mDailyAssessmentFragment;
    private SettingsFragment mSettingsFragment;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainMenuFragment newInstance(String param1, String param2) {
        MainMenuFragment fragment = new MainMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainMenuFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        final Button mInitiativeAssessmentButton = (Button) view.findViewById(R.id.initiativeAssessmentButton);
        mInitiativeAssessmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create fragment
                mInitiativeAssessmentFragment = new InitiativeAssessmentFragment();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mInitiativeAssessmentFragment)
                        .addToBackStack(mInitiativeAssessmentFragment.getClass().getName())
                        .commit();
            }
        });

        final Button mRandomAssessmentButton = (Button) view.findViewById(R.id.randomAssessmentButton);
        mRandomAssessmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int finishedAssess = DataIO.getFinishedRandomAssessments(getActivity());
                int assessNumber = DataIO.getRandomAssessmentsNumber(getActivity());
                if (DataIO.getTimeNextAssessment(getActivity())<11 && finishedAssess!=assessNumber) {
                    // Create fragment
                    mRandomAssessmentFragment = new RandomAssessmentFragment();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, mRandomAssessmentFragment)
                            .addToBackStack(null)
                            .commit();
                } else if(finishedAssess==assessNumber) {
                    Toast.makeText(getActivity(), R.string.randomAssessmentAlertNumber, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), R.string.randomAssessmentAlertTime, Toast.LENGTH_LONG).show();
                }

            }
        });

        final Button mDailyAssessmentButton = (Button) view.findViewById(R.id.eodAssessmentButton);
        mDailyAssessmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(DataIO.getFinishedRandomAssessments(getActivity())==DataIO.getRandomAssessmentsNumber(getActivity())) {
                    // Create fragment
                    mDailyAssessmentFragment = new DailyAssessmentFragment();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, mDailyAssessmentFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    Toast.makeText(getActivity(), R.string.dailyAssessmentAlert, Toast.LENGTH_LONG).show();
                }

            }
        });

        //Put the number of finished assessments in the text view
        int assNumber = DataIO.getRandomAssessmentsNumber(getActivity())-DataIO.getFinishedRandomAssessments(getActivity());
        String numberofAssessments = Integer.toString(assNumber);
        TextView mTextView = (TextView) view.findViewById(R.id.descriptionTwoB);
        mTextView.setText(numberofAssessments);

        //Put the time until next assessment in text view
        String timeToNextAssessment = Integer.toString(DataIO.getTimeNextAssessment(getActivity()));
        TextView nTextView = (TextView) view.findViewById(R.id.descriptionTwoD);
        nTextView.setText(timeToNextAssessment);

        return view;
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
