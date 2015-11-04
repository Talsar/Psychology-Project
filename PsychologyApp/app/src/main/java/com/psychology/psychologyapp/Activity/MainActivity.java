//Oliver

package com.psychology.psychologyapp.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;

import com.psychology.psychologyapp.Fragment.DailyAssessmentFragment;
import com.psychology.psychologyapp.Fragment.InitiativeAssessmentFragment;
import com.psychology.psychologyapp.Fragment.MainMenuFragment;
import com.psychology.psychologyapp.Fragment.RandomAssessmentFragment;
import com.psychology.psychologyapp.Fragment.SettingsFragment;
import com.psychology.psychologyapp.Logic.AssessmentNotification;
import com.psychology.psychologyapp.R;


public class MainActivity extends ActionBarActivity implements MainMenuFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, InitiativeAssessmentFragment.OnFragmentInteractionListener, DailyAssessmentFragment.OnFragmentInteractionListener, RandomAssessmentFragment.OnFragmentInteractionListener {

    MainMenuFragment mMainMenuFragment;
    AssessmentNotification mAssessmentNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAssessmentNotification = new AssessmentNotification();
        //mAssessmentNotification.notificationRandomAssessment(this);
        

        if (findViewById(R.id.fragment_container) != null) {

            // If we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            mMainMenuFragment = new MainMenuFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, mMainMenuFragment)
                    .addToBackStack(null)
                    .commit();

            mAssessmentNotification.alarm(this, findViewById(R.id.fragment_container));



        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}