package com.activity;

import com.tastesync.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash_screen_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen_layout);
		Thread BamGio = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(4000);
				}
				catch(Exception e)
				{
					
				}
				finally
				{
					Intent newActivity = new Intent(Splash_screen_Activity.this, WelcomeActivity.class);
					startActivity(newActivity);
					finish();
				}
			}
		};
		BamGio.start();
	}
	
	//Khi chuyá»ƒn qua MainActivity thÃ¬ hÃ m nÃ y Ä‘Æ°á»£c gá»�i vÃ  káº¿t thÃºc ManhinhchaoActivity
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
