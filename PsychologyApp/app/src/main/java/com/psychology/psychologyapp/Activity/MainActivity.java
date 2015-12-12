package com.psychology.psychologyapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.psychology.psychologyapp.Fragment.DailyAssessmentFragment;
import com.psychology.psychologyapp.Fragment.InitiativeAssessmentFragment;
import com.psychology.psychologyapp.Fragment.LogInFragment;
import com.psychology.psychologyapp.Fragment.MainMenuFragment;
import com.psychology.psychologyapp.Fragment.RandomAssessmentFragment;
import com.psychology.psychologyapp.Fragment.SettingsFragment;
import com.psychology.psychologyapp.Logic.AssessmentNotification;
import com.psychology.psychologyapp.Logic.DataIO;
import com.psychology.psychologyapp.R;


public class MainActivity extends Activity implements MainMenuFragment.OnFragmentInteractionListener, LogInFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, InitiativeAssessmentFragment.OnFragmentInteractionListener, DailyAssessmentFragment.OnFragmentInteractionListener, RandomAssessmentFragment.OnFragmentInteractionListener {

    LogInFragment mLogInFragment;
    MainMenuFragment mMainMenuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        //Get the String from the Intent created in AssessmentNotification
        String menuFragment = getIntent().getStringExtra("menuFragment");

        if (findViewById(R.id.fragment_container) != null) {

            // If we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            mMainMenuFragment = new MainMenuFragment();
            //DataIO.pushTheRedButton(this);

            if (menuFragment != null) {

                if (menuFragment.equals("randomAssessmentFragment")) {
                    //If the Intent was set in AssessmentNotification, the mainMenuFragment is added
                    //to the fragment container(just to add it to the backStack) and afterwards it's
                    //replaced immediately by the randomAssessmentFragment.
                    RandomAssessmentFragment mRandomAssessmentFragment = new RandomAssessmentFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, mMainMenuFragment)
                            .addToBackStack(null)
                            .commit();

                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, mRandomAssessmentFragment)
                            .addToBackStack(null)
                            .commit();

                }
            } else {


                //DataIO.pushTheRedButton(this);

                if (DataIO.isLogInInformationExisting(this)) {
                    Toast.makeText(this, "Hello, "+DataIO.getLogInName(this), Toast.LENGTH_SHORT).show();
                    mMainMenuFragment = new MainMenuFragment();
                    // Add the fragment to the 'fragment_container' FrameLayout
                    getFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, mMainMenuFragment)
                            .addToBackStack(null)
                            .commit();
                } else {

                    mLogInFragment = new LogInFragment();
                    // Add the fragment to the 'fragment_container' FrameLayout
                    getFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, mLogInFragment)
                            .commit();
                }

            }

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void recreate(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            //when pressed the back button it goes back one in the stack and loads the last fragment
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingsFragment mSettingsFragment = new SettingsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, mSettingsFragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
