//Oliver

package com.psychology.psychologyapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements MainMenuFragment.OnFragmentInteractionListener, InitiativeAssessmentFragment.OnFragmentInteractionListener, DailyAssessmentFragment.OnFragmentInteractionListener, RandomAssessmentFragment.OnFragmentInteractionListener {

    //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    //Button mInitiaveAssessmentButton;
    MainMenuFragment mMainMenuFragment;
    InitiativeAssessmentFragment mInitiativeAssessmentFragment;
    NotificationCompat.Builder mBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Assessment");
        mBuilder.setContentText("An Assessment is due!");

        //mBuilder.notify();

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
