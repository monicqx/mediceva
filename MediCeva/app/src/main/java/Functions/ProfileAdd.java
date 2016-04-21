package Functions;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * Created by Monica Stanescu on 17.04.2016.
 */
public class ProfileAdd extends AsyncTask<String,String,String> {

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
