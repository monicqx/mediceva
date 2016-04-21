package com.example.monicastanescu.mediceva;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Classes.Profiles;
import Functions.Methods;
import Functions.ProfileAdd;

public class ProfileActivity extends FragmentActivity {
    DialogFragment df;
    DialogFragment tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText etHeight = (EditText) findViewById((R.id.etHeight));
        final EditText etWeight = (EditText) findViewById((R.id.etWeight));
        final Button btPickDate = (Button) findViewById(R.id.btPickDate);
        final Button btCreate = (Button) findViewById(R.id.btCreate);
        final Button btSkip = (Button) findViewById(R.id.btSkip);
        final RadioGroup radioGroup = (RadioGroup) findViewById((R.id.rGroup));
        final RadioButton rbtFemale = (RadioButton) findViewById((R.id.rbtFemale));
        final RadioButton rbtMale = (RadioButton) findViewById((R.id.rbtMale));


        btPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df = new DatePiker();
                df.show(getFragmentManager(), "Pick a date!");
            }
        });

        final Button btPickTime = (Button) findViewById(R.id.btReminder);
        btPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tf = new TimePiker();
                tf.show(getFragmentManager(), "Pick a time!");

            }
        });


        btCreate.setOnClickListener(new View.OnClickListener() {    //if
            @Override
            public void onClick(View v) {
                        try {
                            int radioId = radioGroup.getCheckedRadioButtonId();
                            View rb = radioGroup.findViewById(radioId);
                            int index = radioGroup.indexOfChild(rb);
                            RadioButton r = (RadioButton) radioGroup.getChildAt(index);
                            String selected = r.getText().toString();
                            char sex = selected.charAt(0);

                            Date d = ((DatePiker) df).getDate();
                            Short hour = Short.parseShort(Integer.toString(((TimePiker) tf).getHour()));
                            Short minute = Short.parseShort(Integer.toString(((TimePiker) tf).getMin()));

                            String filename = "myfile";
                            FileInputStream inputStream = openFileInput(filename);
                            int id = inputStream.read();

                            Profiles p = new Profiles(Short.parseShort(Integer.toString(id)), new java.sql.Date(d.getTime()),
                                    sex, BigDecimal.valueOf(Double.parseDouble(etWeight.getText().toString())),
                                    Short.parseShort(etHeight.getText().toString()), hour, minute);
                            Gson gson = new Gson();
                            String json = gson.toJson(p);
                            btPickTime.setText(json.toString());
                            Add nou = new Add();
                            nou.execute(json);

                        } catch (Exception ex) {

                        }

            }

        });


        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(ProfileActivity.this, MainMenuActivity.class);    //opens RegisterActivity
                ProfileActivity.this.startActivity(registerIntent);   //performing the intent

            }
        });
    }




    public class Add extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {
            String oki=" ok"  ;
            try {
                HttpContext context = new BasicHttpContext();
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://82.208.186.138:36317/MedicalPlannerWEb/webresources/profiles");
                httpPost.setHeader("Content-Type", "application/json");
                StringEntity stringEntity = new StringEntity(params[0]);
                httpPost.setEntity(stringEntity);
                HttpResponse response = httpClient.execute(httpPost, context);
            } catch (Exception ex) {
                oki= "npe";
            }
            return oki;
        }


    }

}








