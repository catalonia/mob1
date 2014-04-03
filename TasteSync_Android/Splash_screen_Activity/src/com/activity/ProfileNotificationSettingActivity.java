package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class ProfileNotificationSettingActivity extends Activity implements
		OnClickListener, OnCheckedChangeListener {
	private ImageView mImgBack;

	private CheckBox cbRecommendMobile1, cbRecommendMobile2,
			cbRecommendMobile3, cbRecommendMobile4, cbRecommendMobile5,
			cbRecommendMobile6, cbRecommendMail1, cbRecommendMail2,
			cbRecommendMail3, cbRecommendMail4, cbRecommendMail5,
			cbRecommendMail6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_setting);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_notification_setting_back);
		mImgBack.setOnClickListener(this);
		cbRecommendMobile1 = (CheckBox) findViewById(R.id.cb_recommend_mobile_1);
		cbRecommendMobile1.setOnCheckedChangeListener(this);
		cbRecommendMobile2 = (CheckBox) findViewById(R.id.cb_recommend_mobile_2);
		cbRecommendMobile2.setOnCheckedChangeListener(this);
		cbRecommendMobile3 = (CheckBox) findViewById(R.id.cb_recommend_mobile_3);
		cbRecommendMobile3.setOnCheckedChangeListener(this);
		cbRecommendMobile4 = (CheckBox) findViewById(R.id.cb_recommend_mobile_4);
		cbRecommendMobile4.setOnCheckedChangeListener(this);
		cbRecommendMobile5 = (CheckBox) findViewById(R.id.cb_recommend_mobile_5);
		cbRecommendMobile5.setOnCheckedChangeListener(this);
		cbRecommendMobile6 = (CheckBox) findViewById(R.id.cb_recommend_mobile_6);
		cbRecommendMobile6.setOnCheckedChangeListener(this);
		cbRecommendMail1 = (CheckBox) findViewById(R.id.cb_recommend_mail_1);
		cbRecommendMail1.setOnCheckedChangeListener(this);
		cbRecommendMail2 = (CheckBox) findViewById(R.id.cb_recommend_mail_2);
		cbRecommendMail2.setOnCheckedChangeListener(this);
		cbRecommendMail3 = (CheckBox) findViewById(R.id.cb_recommend_mail_3);
		cbRecommendMail3.setOnCheckedChangeListener(this);
		cbRecommendMail4 = (CheckBox) findViewById(R.id.cb_recommend_mail_4);
		cbRecommendMail4.setOnCheckedChangeListener(this);
		cbRecommendMail5 = (CheckBox) findViewById(R.id.cb_recommend_mail_5);
		cbRecommendMail5.setOnCheckedChangeListener(this);
		cbRecommendMail6 = (CheckBox) findViewById(R.id.cb_recommend_mail_6);
		cbRecommendMail6.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_notification_setting_back:
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean ischeck) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.cb_recommend_mobile_1:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail1.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_1:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile1.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mobile_2:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail2.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_2:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile2.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mobile_3:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail3.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_3:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile3.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mobile_4:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail4.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_4:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile4.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mobile_5:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail5.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_5:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile5.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mobile_6:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMail6.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		case R.id.cb_recommend_mail_6:
			ischeck = true;
			if (ischeck) {
				buttonView.setButtonDrawable(R.drawable.tich_on);
				cbRecommendMobile6.setButtonDrawable(R.drawable.tich);
				ischeck = false;
			}
			break;
		default:
			break;
		}
	}
}
