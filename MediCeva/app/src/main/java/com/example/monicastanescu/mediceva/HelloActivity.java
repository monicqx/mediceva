package com.example.monicastanescu.mediceva;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        try {
            String filename = "myfile";
            FileInputStream inputStream = openFileInput(filename);
            int id=inputStream.read();
            if(id!=-1) {
                Intent registerIntent = new Intent(HelloActivity.this, MainMenuActivity.class);    //opens RegisterActivity
                HelloActivity.this.startActivity(registerIntent);
            }
            inputStream.close();
        }
        catch(Exception ex){};
        final Button btStart=(Button) findViewById(R.id.btStart);


        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the suer click the Let's Start button
                Intent registerIntent = new Intent(HelloActivity.this, LoginActivity.class);    //opens RegisterActivity
                HelloActivity.this.startActivity(registerIntent);   //performing the intent

            }
        });



    }
}
