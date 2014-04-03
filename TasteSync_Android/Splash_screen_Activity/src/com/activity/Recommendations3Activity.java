package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Recommendations3Activity extends Activity {
	private ImageView mImgBack, mAvatar;
	private TextView tvUsername, tvDescription, tvAction, tvFollow;
	private Button send_reply3;
	private boolean check = false;
	private LinearLayout layout_body_recom3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations3);
		init();
		handler();
	}

	private void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_rec_type3_back);
		tvUsername = (TextView) findViewById(R.id.username);
		tvDescription = (TextView) findViewById(R.id.description);
		tvFollow = (TextView) findViewById(R.id.tv_type3_follow);
		// tvAction=(TextView)findViewById(R.id.action);
		send_reply3 = (Button) findViewById(R.id.send_reply3);
		layout_body_recom3 = (LinearLayout) findViewById(R.id.layout_body_recom3);

	}

	private void handler() {
		// TODO Auto-generated method stub
		layout_body_recom3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_recom3.getWindowToken(), 0);
			}
		});

		mImgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RecommendationsGroupActivity.group.onBackPressed();

			}
		});

		send_reply3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				RecommendationsGroupActivity.group.onBackPressed();
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
		Bundle data = getIntent().getExtras();
		String username = data.getString("usename");
		String action = data.getString("action");
		String description = data.getString("description");
		int position = data.getInt("Position");
		// Toast.makeText(this, "" + username, 2000).show();
		tvUsername.setText("" + username + " " + action);
		// tvAction.setText("" + action);
		tvDescription.setText("" + description);
	}
}
