package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileSettingActivity extends Activity implements OnClickListener {
	private ImageView mImgBack;
	private Intent mIntent;
	private LinearLayout mLayoutLogout,mLayoutNotificationSetting,mLayoutAboutTastesync,mLayoutContactTastesync;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_setting);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_setting_back);
		mImgBack.setOnClickListener(this);
		mLayoutNotificationSetting = (LinearLayout) findViewById(R.id.layout__noti_setting);
		mLayoutNotificationSetting.setOnClickListener(this);
		mLayoutContactTastesync = (LinearLayout) findViewById(R.id.layout__contact_tastesync);
		mLayoutContactTastesync.setOnClickListener(this);
		mLayoutAboutTastesync = (LinearLayout) findViewById(R.id.layout__about_tastesync);
		mLayoutAboutTastesync.setOnClickListener(this);
		
		mLayoutLogout = (LinearLayout) findViewById(R.id.layout_logout);
		mLayoutLogout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_setting_back:
			finish();
			break;
		case R.id.layout__noti_setting:
			mIntent = new Intent(v.getContext(),
					ProfileNotificationSettingActivity.class);
			TabGroupActivity parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileNotificationSettingActivity", mIntent);
			break;
		case R.id.layout__contact_tastesync:
			mIntent = new Intent(v.getContext(),
					ProfileContactTastesyncActivity.class);
			TabGroupActivity parent2 = (TabGroupActivity) getParent();
			parent2.startChildActivity("ProfileContactTastesyncActivity", mIntent);
			break;
		case R.id.layout__about_tastesync:
			mIntent = new Intent(v.getContext(),
					ProfileAboutTastesyncActivity.class);
			TabGroupActivity parent3 = (TabGroupActivity) getParent();
			parent3.startChildActivity("ProfileAboutTastesyncActivity", mIntent);
			break;
		case R.id.layout_logout:
			System.exit(0);
			break;
		default:
			break;
		}
	}
}
