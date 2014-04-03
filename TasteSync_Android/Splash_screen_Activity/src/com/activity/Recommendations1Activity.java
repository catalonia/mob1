package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Recommendations1Activity extends Activity {
	private TextView tvUsername, tvDescription, tvFollow;
	private ImageView mImgBack;
	private Button btn_send_reply_recom1;
	Boolean check = false;
	Bundle data;
	String username, action, description;
	int position;
	boolean reply;
	private LinearLayout layout_body_recom1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations1);
		init();
		handler();
	}

	private void init() {
		// TODO Auto-generated method stub
		layout_body_recom1 = (LinearLayout) findViewById(R.id.layout_body_recom1);

		mImgBack = (ImageView) findViewById(R.id.img_rec_type1_back);
		tvUsername = (TextView) findViewById(R.id.username);

		tvDescription = (TextView) findViewById(R.id.description);
		tvFollow = (TextView) findViewById(R.id.tv_type1_follow);

		btn_send_reply_recom1 = (Button) findViewById(R.id.btn_send_reply_recom1);

	}

	private void handler() {
		// TODO Auto-generated method stub
		data = getIntent().getExtras();
		username = data.getString("usename");
		action = data.getString("action");
		description = data.getString("description");
		position = data.getInt("Position");
		reply = data.getBoolean("Reply");

		layout_body_recom1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_recom1.getWindowToken(), 0);
			}
		});

		mImgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				// RecommendationsGroupActivity.group.onBackPressed();

			}
		});

		btn_send_reply_recom1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (reply == true) {
					reply = false;
				} else {
					reply = true;
				}
				Intent mIntent = new Intent(Recommendations1Activity.this,
						RecommendationsActivity.class);
				mIntent.putExtra("Reply", reply);
				mIntent.putExtra("Position", position);

				String kq = "ABC";
				Log.d(STORAGE_SERVICE, "" + kq);
				mIntent.putExtra("ABC", kq);
				setResult(RESULT_OK, mIntent);
				// Toast.makeText(v.getContext(), ""+String.valueOf(position),
				// Toast.LENGTH_SHORT).show();
				finish();

			}
		});

		tvFollow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check == true) {
					tvFollow.setText("Following");
					check = false;
				} else {
					tvFollow.setText("Follow");
					check = true;
				}

			}
		});

		// Toast.makeText(this, "" + username, 2000).show();
		tvUsername.setText("" + username + " " + action);
		tvDescription.setText("" + description);
	}
}
