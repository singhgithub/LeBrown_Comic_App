package com.example.brown_lee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button latest_comic_button_obj;
	Button life_of_lee_button_obj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Main_Activity class onCreate() is called");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intialize_every_thing_here();
		buttons_listner_method();
		
}
	
	public void intialize_every_thing_here() {
		System.out.println("intialize_every_thing_here() is called");
		
		latest_comic_button_obj = (Button) findViewById(R.id.latest_comics_button_id);
		life_of_lee_button_obj = (Button) findViewById(R.id.life_of_lee_button_id);	
		
	}
	
	public void buttons_listner_method() {
		System.out.println("buttons_listner_method() is called");

		
		latest_comic_button_obj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("latest_comic_button_obj onClick is called");
				
				Intent intent_obj = new Intent(MainActivity.this, Latest_Comic.class);
				startActivity(intent_obj);
		
			}
		});
		
		life_of_lee_button_obj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("life_of_lee_button_obj is called");
				
				Intent intent_obj = new Intent(MainActivity.this, Life_of_brown_lee.class);
				startActivity(intent_obj);
				
			}
		});
	}
}
