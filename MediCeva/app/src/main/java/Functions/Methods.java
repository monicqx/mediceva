package Functions;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import Classes.Profiles;
import Classes.Users;

/**
 * Created by Monica Stanescu on 16.04.2016.
 */
public class Methods {

    public static  void PostUsers(Short id,String name,String pass, String email )
    {
        try {
            Users u =new Users(id, name, pass, email);
            HttpContext context = new BasicHttpContext();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://82.208.186.138:36317/MedicalWeb/webresources/users");
            httpPost.setHeader("Content-Type", "application/json");
            Gson gson = new Gson();
            String json = gson.toJson(u);
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost,context);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }


    public static int GetUserCount()
    {
        int x=-1;
        try {
            URL url2 = new URL("http://82.208.186.138:36317/MedicalWeb/webresources/users/count");

            HttpURLConnection httpCon2 = (HttpURLConnection) url2.openConnection();
            httpCon2.setDoInput(true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon2.getInputStream()));
            String line;
            line = reader.readLine();
            x = Integer.parseInt(line);
            httpCon2.disconnect();

        } catch (Exception e) {

        }
        return x;
    }


    public static void PostProfiles(Short id,Short height,BigDecimal weight,Character sex,Short minute, Short hour, Date birthdate)
    {
        try {
            Profiles p = new Profiles();
            p.setUserId(id);
            p.setHeight(height);
            p.setWeight(weight);
            p.setSex(sex);
            p.setBirthDate(birthdate);
            p.setDefaultBtests(minute);
            p.setDefaultReminderTime(hour);
            HttpContext context = new BasicHttpContext();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://82.208.186.138:36317/MedicalWeb/webresources/profiles");
            httpPost.setHeader("Content-Type", "application/json");
            Gson gson = new Gson();
            String json = gson.toJson(p);
            StringEntity stringEntity = new StringEntity(json.toString());
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost,context);
        }

        catch (Exception ex)
        {
            //System.out.println(ex.toString());
        }
    }



}
