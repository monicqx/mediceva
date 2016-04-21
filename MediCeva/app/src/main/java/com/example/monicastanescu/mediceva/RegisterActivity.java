
package com.example.monicastanescu.mediceva;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Functions.Methods;

public class RegisterActivity extends AppCompatActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etUserName=(EditText) findViewById(R.id.etUsername);
        final EditText etEmail=(EditText) findViewById(R.id.etEmail);
        final EditText etPassword=(EditText) findViewById(R.id.etPassword);


        final Button btRegister=(Button) findViewById(R.id.btRegister);
        if (btRegister != null) {
            btRegister.setOnClickListener((new View.OnClickListener() {
                @Override
                public  void onClick(View v) {
                    //when the user clicks the register Link

                    //str = String.format(etEmail.getText() + "," + etPassword.getText() + "," + 11 + "," + etUserName.getText());
                    final Thread thread = new Thread(new Runnable(){
                    @Override
                    public synchronized void run () {
                        try {
                            int count=Methods.GetUserCount();
                            count++;
                            Methods.PostUsers(Short.parseShort(Integer.toString(count)),etUserName.getText().toString(),etPassword.getText().toString(),etEmail.getText().toString());
                            FileOutputStream outputStream = openFileOutput("myfile", Context.MODE_PRIVATE);
                            outputStream.write(count);
                            outputStream.close();

                        } catch (Exception e)

                        {

                        }

                    }

                });

                    int nrThreads=1;
                    ExecutorService ex= Executors.newFixedThreadPool(nrThreads);
                    ex.execute(thread);

                    ex.shutdown();//nu mai adaugam fire

                    //de facut if-ul
                    Intent registerIntent=new Intent(RegisterActivity.this,ProfileActivity.class);    //opens RegisterActivity
                    RegisterActivity.this.startActivity(registerIntent);

            }



            }));




        }
    }
}
