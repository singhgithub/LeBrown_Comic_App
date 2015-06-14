package com.example.brown_lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class Latest_Comic extends Activity {

	ImageView latest_comic_image_view_obj;
	String latest_comic_url;
	String server_php_script_url;
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Latest_Comic class onCreate() is called");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.latest_comic_layout);

		initialize_everything_here();
		
		System.out.println("get_url_from_server class is called");
		new get_url_from_server().execute(server_php_script_url);
		
		
	}

	public void initialize_everything_here() {
		System.out.println("initialize_everything_here() is called");
		
		//server_php_script_url ="http://10.0.3.2/Example/Android/Gary's_comic_app/latest_comic.php";
		server_php_script_url = "http://piserver.noip.me/Gary's_app/latest_comic.php";
		
		latest_comic_image_view_obj = (ImageView) findViewById(R.id.latest_comic_imageview_id);
	}

	//get the string url of the lastest comic that has been place on the php script running on the laptop server
	class get_url_from_server extends AsyncTask<String, String, String>{
		
		
		HttpURLConnection httpURLConnection_obj;
		URL url_obj;
		InputStreamReader inputStreamReader_obj;
		BufferedReader bufferedReader_obj;
		String response_obj;
				
		//@param 	its equavelent to String params[] array, its it used to pass multiple urls when you declare/intialize
		//			this class object in the onCreate(), for example .....execute(url1,url2,url3);
		@Override
		protected String doInBackground(String... params) {
			System.out.println("get_url_from_server class doInBackground() method is called");
			
			
			try {
				String param_url_obj = params[0];
				url_obj = new URL(param_url_obj);
				httpURLConnection_obj = (HttpURLConnection) url_obj.openConnection();
				httpURLConnection_obj.setRequestMethod("GET");
				httpURLConnection_obj.setDoOutput(true);
				
				inputStreamReader_obj = new InputStreamReader(httpURLConnection_obj.getInputStream());
				bufferedReader_obj = new BufferedReader(inputStreamReader_obj);
				
				response_obj = bufferedReader_obj.readLine();
				
				System.out.println("The response_obj value is:  " + response_obj );
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return response_obj.toString();
		}

		@Override
		protected void onPostExecute(String result) {
			System.out.println("get_url_from_server class onPostExecute() method is called");
			
			//intialize the url with the latest response url
			latest_comic_url = result;
			
			System.out.println("Picasso class is called");
			Picasso.with(context).load(latest_comic_url).error(R.drawable.error).into(latest_comic_image_view_obj);
			
		}
		
		
		
	}
	
}
