package com.activity;

import com.model.Recommendations;
import com.tastesync.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Recommendations1Type2Activity extends Activity {
	private TextView tvUsername, tvDescription;
	private boolean check = false;
	private Button btn_send_reply_recom1, btn_sys_shuffle2, btnInbox_type2,
			btnShuffle_type2;
	private Intent mIntent;
	private LinearLayout layout_body_recom1_type1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations1_type2);
		init();
		handler();
	}

	private void init() {
		// TODO Auto-generated method stub
		tvUsername = (TextView) findViewById(R.id.username);

		tvDescription = (TextView) findViewById(R.id.description);

		btnInbox_type2 = (Button) findViewById(R.id.btnInbox_type2);
		// btnShuffle_type2 = (Button) findViewById(R.id.btnShuffle_type2);

		btn_send_reply_recom1 = (Button) findViewById(R.id.btn_send_reply_recom1);
		btn_sys_shuffle2 = (Button) findViewById(R.id.btn_sys_shuffle2);

		layout_body_recom1_type1 = (LinearLayout) findViewById(R.id.layout_body_recom1_type1);

	}

	private void handler() {
		// TODO Auto-generated method stub

		layout_body_recom1_type1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_recom1_type1.getWindowToken(), 0);
			}
		});

		btnInbox_type2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent = new Intent(v.getContext(),
						RecommendationsActivity.class);
				// TabGroupActivity parent2 = (TabGroupActivity) getParent();
				// parent2.startChildActivity("RecommendationsActivity",
				// mIntent);
				View view3 = RecommendationsGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"RecommendationsActivity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				RecommendationsGroupActivity.group.replaceView(view3);

			}
		});

		// btnShuffle_type2.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// mIntent = new Intent(v.getContext(),
		// RecommendationsShuffleActivity.class);
		// TabGroupActivity parent2 = (TabGroupActivity) getParent();
		// parent2.startChildActivity("RecommendationsShuffleActivity",
		// mIntent);
		//
		// }
		// });

		btn_send_reply_recom1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent = new Intent(v.getContext(),
						RecommendationsActivity.class);
				// TabGroupActivity parent2 = (TabGroupActivity) getParent();
				// parent2.startChildActivity("RecommendationsActivity",
				// mIntent);
				View view2 = RecommendationsGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"RecommendationsActivity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				RecommendationsGroupActivity.group.replaceView(view2);

			}
		});

		btn_sys_shuffle2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((Recommendations) RecommendationsActivity.mAdapter
						.getItem(0)).getType() == 1) {
					mIntent = new Intent(v.getContext(),
							RecommendationsShuffleActivity.class);
					// Bundle bundle = new Bundle();
					Recommendations rs2 = (Recommendations) RecommendationsActivity.mAdapter
							.getItem(0);
					mIntent.putExtra("usename", rs2.getUsername());
					mIntent.putExtra("action", rs2.getAction());
					mIntent.putExtra("description", rs2.getDescription());
					mIntent.putExtra("Position", 0);
					// mIntent.putExtra("BUNDLE_RECOMMENDATION", bundle);
					// TabGroupActivity parent2 = (TabGroupActivity)
					// getParent();
					// parent2.startChildActivity(
					// "RecommendationsShuffleActivity", mIntent);
					View view = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"RecommendationsShuffleActivity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view);
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
		tvDescription.setText("" + description);
	}
}
