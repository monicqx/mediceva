package com.example.monicastanescu.mediceva;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Monica Stanescu on 12.04.2016.
 */
public class DatePiker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private Date d;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        try {
            String a = new String(day + "." + (month+1) + "." + year);
            Date date = new SimpleDateFormat("YYYYMMDD").parse(a);
            d=date;
        }
        catch(Exception ex){}
    }


    public Date getDate()
    {
        return d;
    }
}
