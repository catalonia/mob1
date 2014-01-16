package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class mockActivity extends Activity {
	Button btn_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mock);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		btn_back = (Button)findViewById(R.id.btn_back);
	}

	private void handle() {
		// TODO Auto-generated method stub
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
