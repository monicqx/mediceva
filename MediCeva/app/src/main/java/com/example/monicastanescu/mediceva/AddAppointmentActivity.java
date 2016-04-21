package com.example.monicastanescu.mediceva;

import android.app.DialogFragment;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

import Classes.Profiles;

public class AddAppointmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        Spinner spinner = (Spinner) findViewById(R.id.spTypes);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button btPickDate=(Button) findViewById(R.id.btPickDate);

        btPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePiker();
                newFragment.show(getFragmentManager(), "Pick a date!");

            }
        });

        final Button btPickTime=(Button) findViewById(R.id.btTime);
        btPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePiker();
                newFragment.show(getFragmentManager(),"Pick a time!");

            }
        });


        final EditText etLocation=(EditText) findViewById(R.id.etLocation);
        final EditText etDoctor=(EditText) findViewById(R.id.etDoctor);
        final EditText etPhone=(EditText) findViewById(R.id.etPhone);
        final EditText etDescription=(EditText) findViewById(R.id.etDescription);
        final EditText etFrequency=(EditText) findViewById(R.id.etFrequency);

        try {
            String filename = "myfile";
            FileInputStream inputStream = openFileInput(filename);
            int id = inputStream.read();
            Short idShort=Short.parseShort(Integer.toString(id));

            Profiles p = new Profiles(Short.parseShort("2"), new SimpleDateFormat("dd.MM.yyyy").parse("14.02.2016"),
                    'F', BigDecimal.valueOf(15), Short.parseShort("5"), Short.parseShort("10"), Short.parseShort("14"));
            Gson gson = new Gson();
            String json = gson.toJson(p);
            //btPickTime.setText(json.toString());
            Add nou = new Add();
            nou.execute(json);
        }
        catch(Exception ex){}
    }



    public class Add extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {
            String oki=" ok"  ;
            try {
                HttpContext context = new BasicHttpContext();
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://82.208.186.138:36317/MedicalWeb/webresources/profiles");
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
