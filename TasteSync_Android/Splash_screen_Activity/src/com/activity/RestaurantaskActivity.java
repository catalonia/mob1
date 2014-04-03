package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RestaurantaskActivity extends Activity {
	ImageView mImageBack;
	private LinearLayout layout_body_ask_res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_restaurant_detail);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		layout_body_ask_res = (LinearLayout) findViewById(R.id.layout_body_ask_res);

		mImageBack = (ImageView) findViewById(R.id.img_rec_ask_back);
		mImageBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void handle() {
		// TODO Auto-generated method stub

		layout_body_ask_res.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_ask_res.getWindowToken(), 0);
			}
		});

	}

}
