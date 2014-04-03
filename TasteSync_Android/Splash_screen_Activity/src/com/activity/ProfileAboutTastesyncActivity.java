package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ProfileAboutTastesyncActivity extends Activity implements OnClickListener {
	private ImageView mImgBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_tastesync);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_about_tastesync_back);
		mImgBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_about_tastesync_back:
			finish();
			break;
		default:
			break;
		}
	}
}
