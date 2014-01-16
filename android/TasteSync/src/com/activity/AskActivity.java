package com.activity;

import com.tastesync.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;

public class AskActivity extends Activity {
	LinearLayout click_cuisine, click_Ambience, click_whowithyou, click_price,
			click_neighborhood;
	ImageView btn_getrecommandation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		click_Ambience = (LinearLayout) findViewById(R.id.click_Ambience);
		click_cuisine = (LinearLayout) findViewById(R.id.click_cuisine);
		click_neighborhood = (LinearLayout) findViewById(R.id.click_neighborhood);
		click_price = (LinearLayout) findViewById(R.id.click_price);
		click_whowithyou = (LinearLayout) findViewById(R.id.click_whowithyou);
		btn_getrecommandation = (ImageView) findViewById(R.id.btn_getrecommandation);
	}

	private void handle() {
		// TODO Auto-generated method stub
		click_Ambience.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mock();
			}
		});
		click_cuisine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mock();
			}
		});
		click_neighborhood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mock();
			}
		});
		click_price.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mock();
			}
		});
		click_whowithyou.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mock();
			}
		});
		btn_getrecommandation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mock();
			}
		});

	}

	public void mock() {
		Intent mIntent = new Intent(this, mockActivity.class);
		startActivity(mIntent);
	}

}
