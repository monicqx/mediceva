package com.example.monicastanescu.mediceva;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.FileInputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ViewAppointments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointments);
        try {
            String filename = "myfile";
            FileInputStream inputStream = openFileInput(filename);
            int id = inputStream.read();
            Short idShort=Short.parseShort(Integer.toString(id));
            ViewApp v=new ViewApp();
            v.execute(idShort);
            NodeList lista=v.get();


        }
        catch(Exception ex){}
    }


    public class ViewApp extends AsyncTask<Short,String,NodeList>{

        @Override
        protected NodeList doInBackground(Short... params) {
            try {
                String x="http://82.208.186.138:36317/MedicalPlannerWEb/webresources/appointments";
                x+='/';
                x+=params[0].toString();
                URL url = new URL(x);        //aici dam url
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

                NodeList nodeList1 = doc.getElementsByTagName("appointments");
                for (int i = 0; i < nodeList1.getLength(); i++) {
                    Node nod1 = nodeList1.item(i).getFirstChild();
                    //System.out.println(nod1.getTextContent());
                    while(nod1.getNextSibling()!=null)
                    {
                        nod1 = nod1.getNextSibling();
                    }
                }
                return nodeList1;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

}


