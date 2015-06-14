package com.example.brown_lee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Welcome_Screen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Welcome_Screen class onCreate() is called");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen_layout);

		
		Thread thread_obj = new Thread() {
			
			@Override
			public void run() {
				
				try {System.out.println("Welcome Screen class Thread is called");
					sleep(3000);
					
				} catch (Exception e) {
					System.out.println("Error: Welcome Screen class- run method()");
				}finally{
					Intent intent_obj = new Intent(Welcome_Screen.this,MainActivity.class );
					startActivity(intent_obj);
					
				}
				
			}
		};
		
		thread_obj.start();
	}
}
