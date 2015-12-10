package com.psychology.psychologyapp.Fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import com.psychology.psychologyapp.Logic.DataIO;

import java.util.Calendar;

/**
 * Created by oliverbammann on 11.11.15.
 */
public class TimePickerEndFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the start time + 2 hour as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY)+2;
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    /**
     * Saves the picked time in minutes and shows it as a toast;
     * Is executed when timepicker is closed
     * @param view
     * @param hourOfDay The picked hours
     * @param minute The picked minutes
     */
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Saves the picked time in minutes and shows it as a toast
        DataIO.setEndTimeMin(getActivity(), hourOfDay*60+minute);
        //Toast.makeText(getActivity(), "You picked "+(hourOfDay*60+minute), Toast.LENGTH_SHORT).show();
    }
}
