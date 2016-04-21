package com.example.monicastanescu.mediceva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final Button btDone=(Button) findViewById(R.id.btDone);

        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(EditProfileActivity.this,MainMenuActivity.class);    //opens RegisterActivity
                EditProfileActivity.this.startActivity(registerIntent);   //performing the intent

            }
        });
    }
}
