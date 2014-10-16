package com.example.syandroidapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        String printThis = "Wrong!";
        try {
	        HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost("http://10.4.3.109:9090/rest/symessage");
			
			HttpResponse response;
			
			Log.e("MAINACTIVITY", "Before execution...");
			response = client.execute(request);
			Log.e("MAINACTIVITY", "After execution...");
			BufferedReader rd = new BufferedReader(
	                new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
				//System.out.println(line);
			}
			
			printThis = result.toString();
			
			Log.e("MAINACTIVITY", printThis);
		} catch (ClientProtocolException e) {
			Log.e("MAINACTIVITY", e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        TextView greeting = (TextView) findViewById(R.id.greetingMessage);
        greeting.setText(printThis);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
