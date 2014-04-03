package com.activity;

import javax.xml.transform.Source;

import com.tastesync.R;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageView;

public class Recommendations5Activity extends Activity {
	private ImageView mImgBack;

	// private TextView tvUsername,tvDescription,tvAction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations5);
		init();
		handler();
	}

	private void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_rec_type5_back);

		// tvUsername=(TextView)findViewById(R.id.username);
		// tvDescription=(TextView)findViewById(R.id.description);
		// tvAction=(TextView)findViewById(R.id.action);
	}

	private void handler() {
		// TODO Auto-generated method stub
		mImgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				RecommendationsGroupActivity.group.onBackPressed();

			}
		});

	}
}
