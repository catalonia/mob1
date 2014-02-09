package com.activity;

import com.tastesync.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Recommandations5Activity extends Activity {

	TextView tv_title;
	String location, size;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations5);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		tv_title = (TextView) findViewById(R.id.tv_title4);
	}

	private void handle() {
		// TODO Auto-generated method stub
		Bundle data = getIntent().getExtras();
		if (data != null) {
			location = data.getString("position");
			size = data.getString("size");
		} else {
			location = "";
		}
		tv_title.setText("NOTIFICATIONS " + location + " 0f " + size);
	}

}
