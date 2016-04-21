package com.example.monicastanescu.mediceva;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUserName=(EditText) findViewById(R.id.etUsername);
        final EditText etPassword=(EditText) findViewById(R.id.etPassword);
        final Button btLogin=(Button) findViewById(R.id.btLogin);
        final TextView registerLink=(TextView) findViewById(R.id.tvRegister);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/SIMPLIFICA Typeface.ttf");
        //registerLink.setTypeface(font);

        registerLink.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the user clicks the register Link
                Intent registerIntent=new Intent(LoginActivity.this,RegisterActivity.class);    //opens RegisterActivity
                LoginActivity.this.startActivity(registerIntent);   //performing the intent

            }
        }));

        btLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the user clicks the register Link
                Intent registerIntent=new Intent(LoginActivity.this,MainMenuActivity.class);    //opens RegisterActivity
                LoginActivity.this.startActivity(registerIntent);   //performing the intent


            }
        }));
    }
}
