package com.activity;

import com.tastesync.R;
import com.tastesync.R.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileContactTastesyncActivity extends Activity implements
		OnClickListener {
	private ImageView mImgBack;
	private Button mBtnContactReportbugs, mBtnContactFeedback,
			mBtnContactRestaurantdata, mBtnContactRequestblogger;
	private boolean check;
	private LinearLayout layout_body_contact_taste;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_tastesync);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_contact_tastesync_back);
		mImgBack.setOnClickListener(this);
		mBtnContactReportbugs = (Button) findViewById(R.id.btn_contact_reportbugs);
		mBtnContactReportbugs.setOnClickListener(this);
		mBtnContactFeedback = (Button) findViewById(R.id.btn_contact_feedback);
		mBtnContactFeedback.setOnClickListener(this);
		mBtnContactRestaurantdata = (Button) findViewById(R.id.btn_contact_restaurantdata);
		mBtnContactRestaurantdata.setOnClickListener(this);
		mBtnContactRequestblogger = (Button) findViewById(R.id.btn_contact_requestblogger);
		mBtnContactRequestblogger.setOnClickListener(this);

		layout_body_contact_taste = (LinearLayout) findViewById(R.id.layout_body_contact_taste);
		layout_body_contact_taste.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_contact_tastesync_back:
			finish();
			break;
		case R.id.layout_body_contact_taste:
			InputMethodManager imm = (InputMethodManager) getSystemService(v
					.getContext().INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(
					layout_body_contact_taste.getWindowToken(), 0);
			break;
		case R.id.btn_contact_reportbugs:
			check = true;
			if (check == true) {
				v.setBackgroundResource(drawable.ic_bt_reportbugs2);
				mBtnContactFeedback
						.setBackgroundResource(drawable.ic_bt_feedback);
				mBtnContactRestaurantdata
						.setBackgroundResource(drawable.ic_bt_restaurantdata);
				mBtnContactRequestblogger
						.setBackgroundResource(drawable.ic_bt_requestblogger);
				check = false;
			}
			break;
		case R.id.btn_contact_feedback:
			check = true;
			if (check == true) {
				v.setBackgroundResource(drawable.ic_bt_feedback2);
				mBtnContactReportbugs
						.setBackgroundResource(drawable.ic_bt_reportbugs);
				mBtnContactRestaurantdata
						.setBackgroundResource(drawable.ic_bt_restaurantdata);
				mBtnContactRequestblogger
						.setBackgroundResource(drawable.ic_bt_requestblogger);
				check = false;
			}
			break;
		case R.id.btn_contact_restaurantdata:
			check = true;
			if (check == true) {
				v.setBackgroundResource(drawable.ic_bt_restaurantdata2);
				mBtnContactReportbugs
						.setBackgroundResource(drawable.ic_bt_reportbugs);
				mBtnContactFeedback
						.setBackgroundResource(drawable.ic_bt_feedback);
				mBtnContactRequestblogger
						.setBackgroundResource(drawable.ic_bt_requestblogger);
				check = false;
			}
			break;
		case R.id.btn_contact_requestblogger:
			check = true;
			if (check == true) {
				v.setBackgroundResource(drawable.ic_bt_requestblogger2);
				mBtnContactReportbugs
						.setBackgroundResource(drawable.ic_bt_reportbugs);
				mBtnContactFeedback
						.setBackgroundResource(drawable.ic_bt_feedback);
				mBtnContactRestaurantdata
						.setBackgroundResource(drawable.ic_bt_restaurantdata);
				check = false;
			}
			break;
		default:
			break;
		}
	}
}
