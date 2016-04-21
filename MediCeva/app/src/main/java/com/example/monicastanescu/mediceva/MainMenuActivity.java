package com.example.monicastanescu.mediceva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button btViewAppointments=(Button) findViewById(R.id.btViewAppointments);
        final Button btAddAppointment=(Button) findViewById(R.id.btAddAppointment);
        final Button btEditProfile=(Button) findViewById(R.id.btEditProfile);


        btAddAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(MainMenuActivity.this,AddAppointmentActivity.class);    //opens RegisterActivity
                MainMenuActivity.this.startActivity(registerIntent);
            }
        });

        btEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(MainMenuActivity.this,MedicalProfileActivity.class);    //opens RegisterActivity
                MainMenuActivity.this.startActivity(registerIntent);
            }
        });
    }
}
