package com.activity;

import com.tastesync.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Recommandations1Activity extends Activity {

	TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations1);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		tv_title = (TextView) findViewById(R.id.tv_title1);
	}

	private void handle() {
		// TODO Auto-generated method stub
		Bundle data = getIntent().getExtras();
		String location = null, size = null;
		if (data != null) {
			location = data.getString("position");
			size = data.getString("size");
		}
		tv_title.setText("NOTIFICATIONS " + location + " 0f " + size);
	}

}
