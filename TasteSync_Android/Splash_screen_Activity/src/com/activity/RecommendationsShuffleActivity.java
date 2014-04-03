package com.activity;

import com.adapter.RecommendationsAdapter;
import com.model.Recommendations;
import com.tastesync.R;

import android.app.Activity;
import android.app.ProgressDialog;
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

public class RecommendationsShuffleActivity extends Activity implements
		OnClickListener {
	private Intent mIntent;
	private ImageView mImageProfile;
	private Button btnInbox, btnShuffle, btnSendReply, btnSys;
	private boolean check = true;
	ProgressDialog mProgressDialog;
	String username, action, description;
	int position;
	boolean reply;
	Bundle data;
	private TextView tvUsername, tvDescription;
	private LinearLayout layout_body_shuffle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendations_shuffle);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		data = getIntent().getExtras();
		username = data.getString("usename");
		action = data.getString("action");
		description = data.getString("description");
		position = data.getInt("Position");
		reply = data.getBoolean("Reply");

		mImageProfile = (ImageView) findViewById(R.id.imageProfile);
		mImageProfile.setOnClickListener(this);

		btnInbox = (Button) findViewById(R.id.btnInbox2);
		btnInbox.setOnClickListener(this);

		btnSendReply = (Button) findViewById(R.id.btn_send_reply_shuffle);
		btnSendReply.setOnClickListener(this);

		btnSys = (Button) findViewById(R.id.btn_sys_shuffle);
		btnSys.setOnClickListener(this);

		btnShuffle = (Button) findViewById(R.id.btnShuffle2);
		btnShuffle.setOnClickListener(this);

		tvUsername = (TextView) findViewById(R.id.username);
		tvUsername.setText("" + username + " " + action);

		tvDescription = (TextView) findViewById(R.id.description);
		tvDescription.setText("" + description);

		layout_body_shuffle = (LinearLayout) findViewById(R.id.layout_body_shuffle);
		layout_body_shuffle.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageProfile:
			mIntent = new Intent(v.getContext(), ProfileActivity.class);
			// RecommendationsGroupActivity parentProfile =
			// (RecommendationsGroupActivity) getParent();
			// parentProfile.startChildActivity("ProfileActivity", mIntent);
			View view1 = RecommendationsGroupActivity.group
					.getLocalActivityManager()
					.startActivity("ProfileActivity",
							mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
					.getDecorView();
			RecommendationsGroupActivity.group.replaceView(view1);
			break;
		case R.id.layout_body_shuffle:
			InputMethodManager imm = (InputMethodManager) getSystemService(v
					.getContext().INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(layout_body_shuffle.getWindowToken(), 0);
			break;
		case R.id.btnInbox2:
			mIntent = new Intent(v.getContext(), RecommendationsActivity.class);
//			TabGroupActivity parentRecommendations = (TabGroupActivity) getParent();
//			parentRecommendations.startChildActivity("RecommendationsActivity",
//					mIntent);
			View view3 = RecommendationsGroupActivity.group
					.getLocalActivityManager()
					.startActivity("RecommendationsActivity",
							mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
					.getDecorView();
			RecommendationsGroupActivity.group.replaceView(view3);
			break;
		case R.id.btn_send_reply_shuffle:
			// mProgressDialog = new ProgressDialog(
			// RecommendationsShuffleActivity.this);
			// mProgressDialog.show();
			// Thread BamGio = new Thread() {
			// public void run() {
			// try {
			// sleep(4000);
			// } catch (Exception e) {
			//
			// }
			//
			// }
			// };
			// BamGio.start();
			mIntent = new Intent(v.getContext(), RecommendationsActivity.class);
//			TabGroupActivity parent = (TabGroupActivity) getParent();
//			parent.startChildActivity("RecommendationsActivity", mIntent);
			View view4 = RecommendationsGroupActivity.group
					.getLocalActivityManager()
					.startActivity("RecommendationsActivity",
							mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
					.getDecorView();
			RecommendationsGroupActivity.group.replaceView(view4);
			break;
		case R.id.btn_sys_shuffle:
			for (int i = 0; i < RecommendationsActivity.mAdapter.getCount(); i++) {
				if (((Recommendations) RecommendationsActivity.mAdapter
						.getItem(i)).getType() == 1) {
					mIntent = new Intent(v.getContext(),
							Recommendations1Type2Activity.class);
					// Bundle bundle = new Bundle();
					Recommendations rs2 = (Recommendations) RecommendationsActivity.mAdapter
							.getItem(i);
					mIntent.putExtra("usename", rs2.getUsername());
					mIntent.putExtra("action", rs2.getAction());
					mIntent.putExtra("description", rs2.getDescription());
					mIntent.putExtra("Position", i);
					// mIntent.putExtra("BUNDLE_RECOMMENDATION", bundle);
//					TabGroupActivity parent2 = (TabGroupActivity) getParent();
//					parent2.startChildActivity("Recommendations1Type2Activity",
//							mIntent);
					View view5 = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity("Recommendations1Type2Activity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view5);
				}
			}

			break;
		default:
			break;
		}
	}

}
