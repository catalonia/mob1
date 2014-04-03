package com.activity;

import java.util.ArrayList;

import com.adapter.RecommendationsAdapter;
import com.google.android.gms.internal.p;
import com.model.Profile;
import com.model.Recommendations;
import com.tastesync.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class RecommendationsActivity extends Activity implements
		OnClickListener {
	private ListView mLvRecommendations;
	static RecommendationsAdapter mAdapter;
	private ArrayList<Recommendations> mArray;
	private Intent mIntent;
	private View mView;
	private ImageView mImageProfile;
	private Button btnInbox, btnShuffle;
	private boolean check = true;
	int SEND12 = 12;
	boolean replyre;
	int positionre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recomend);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImageProfile = (ImageView) findViewById(R.id.imageProfile);
		mImageProfile.setOnClickListener(this);

		// icon_reply = (ImageView) findViewById(R.id.icon_reply);

		btnInbox = (Button) findViewById(R.id.btnInbox);
		btnInbox.setOnClickListener(this);

		btnShuffle = (Button) findViewById(R.id.btnShuffle);
		btnShuffle.setOnClickListener(this);

		mLvRecommendations = (ListView) findViewById(R.id.lv_recommendations);
		mLvRecommendations.setDividerHeight(0);
		mLvRecommendations.setClickable(true);
		mArray = new ArrayList<Recommendations>();

		Profile pf = new Profile();
		pf.setAvatar("");
		pf.setEmail("");
		pf.setImage("");
		pf.setLocation("");
		pf.setUsername("Hip Thai");
		Recommendations rec = new Recommendations();
		rec.setUsername("Hip Thai");
		rec.setAction(" needs a recommendation");
		rec.setType(1);
		rec.setAvatar("");
		rec.setDescription("I am looking for a American restaurant in New York");
		rec.setProfile(pf);
		mArray.add(rec);
		Recommendations rec1 = new Recommendations();
		rec1.setUsername("Lien");
		rec1.setAction(" Restaurant recommendation for you ");
		rec1.setType(2);
		rec1.setAvatar("");
		rec1.setDescription("I am looking for a American restaurant in New York");
		rec1.setProfile(pf);
		mArray.add(rec1);
		Recommendations rec2 = new Recommendations();
		rec2.setUsername("Vuong Trieu");
		rec2.setAction(" sent  you a message");
		rec2.setType(3);
		rec2.setAvatar("");
		rec2.setDescription("I am looking for a American restaurant in New York");
		rec2.setProfile(pf);
		mArray.add(rec2);
		Recommendations rec3 = new Recommendations();
		rec3.setUsername("An");
		rec3.setAction(" Did you like any of these recommendations?");
		rec3.setType(4);
		rec3.setAvatar("");
		rec3.setDescription("I am looking for a American restaurant in New York");
		rec3.setProfile(pf);
		mArray.add(rec3);
		Recommendations rec4 = new Recommendations();
		rec4.setUsername("Mr HipVip");
		rec4.setAction(" needs a recommendation");
		rec4.setType(1);
		rec4.setAvatar("");
		rec4.setDescription("I am looking for a American restaurant in New York");
		rec4.setProfile(pf);
		mArray.add(rec4);
		Recommendations rec5 = new Recommendations();
		rec5.setUsername("Van Luong");
		rec5.setAction(" Welcom to TasteSync");
		rec5.setType(5);
		rec5.setAvatar("");
		rec5.setDescription("I am looking for a American restaurant in New York");
		rec5.setProfile(pf);
		mArray.add(rec5);

		mAdapter = new RecommendationsAdapter(this, mArray);
		mLvRecommendations.setAdapter(mAdapter);
		mLvRecommendations.setOnItemClickListener(new OnItemClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onItemClick(AdapterView<?> lv, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				if (((Recommendations) mAdapter.getItem(position)).getType() == 1) {
					mIntent = new Intent(RecommendationsActivity.this,
							Recommendations1Activity.class);
					// Bundle bundle = new Bundle();
					Recommendations rs = (Recommendations) mAdapter
							.getItem(position);
					mIntent.putExtra("usename", rs.getUsername());
					mIntent.putExtra("action", rs.getAction());
					mIntent.putExtra("description", rs.getDescription());
					mIntent.putExtra("Position", position);
					mIntent.putExtra("Reply", rs.getReply());
					// mIntent.putExtra("BUNDLE_RECOMMENDATION", bundle);

					// RecommendationsGroupActivity parent =
					// (RecommendationsGroupActivity) getParent();
					// parent.startChildActivity("Recommendations1Activity",
					// mIntent);

					startActivityForResult(mIntent, SEND12);

				}
				if (((Recommendations) mAdapter.getItem(position)).getType() == 2) {
					mIntent = new Intent(RecommendationsActivity.this,
							Recommendations2Activity.class);
					// Recommendations rs = (Recommendations) mAdapter
					// .getItem(position);
					// mIntent.putExtra("usename", rs.getUsername());
					// mIntent.putExtra("action", rs.getAction());
					// mIntent.putExtra("description", rs.getDescription());
					// mIntent.putExtra("Position", position);
					// // mIntent.putExtra("BUNDLE_RECOMMENDATION", bundle);
					// TabGroupActivity parent = (TabGroupActivity) getParent();
					// parent.startChildActivity("Recommendations2Activity",
					// mIntent);
					View view = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"Recommendations2Activity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view);
				}
				if (((Recommendations) mAdapter.getItem(position)).getType() == 3) {
					mIntent = new Intent(RecommendationsActivity.this,
							Recommendations3Activity.class);
					Recommendations rs = (Recommendations) mAdapter
							.getItem(position);
					mIntent.putExtra("usename", rs.getUsername());
					mIntent.putExtra("action", rs.getAction());
					mIntent.putExtra("description", rs.getDescription());
					mIntent.putExtra("Position", position);
					// TabGroupActivity parent = (TabGroupActivity) getParent();
					// parent.startChildActivity("Recommendations3Activity",
					// mIntent);
					View view = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"Recommendations3Activity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view);

				}
				if (((Recommendations) mAdapter.getItem(position)).getType() == 4) {
					mIntent = new Intent(RecommendationsActivity.this,
							Recommendations4Activity.class);
					Recommendations rs = (Recommendations) mAdapter
							.getItem(position);
					mIntent.putExtra("usename", rs.getUsername());
					mIntent.putExtra("action", rs.getAction());
					mIntent.putExtra("description", rs.getDescription());
					mIntent.putExtra("Position", position);
					// TabGroupActivity parent = (TabGroupActivity) getParent();
					// parent.startChildActivity("Recommendations4Activity",
					// mIntent);
					View view = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"Recommendations4Activity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view);
				}
				if (((Recommendations) mAdapter.getItem(position)).getType() == 5) {
					mIntent = new Intent(RecommendationsActivity.this,
							Recommendations5Activity.class);
					// Recommendations rs = (Recommendations) mAdapter
					// .getItem(position);
					// mIntent.putExtra("usename", rs.getUsername());
					// mIntent.putExtra("action", rs.getAction());
					// mIntent.putExtra("description", rs.getDescription());
					// mIntent.putExtra("Position", position);
					// TabGroupActivity parent = (TabGroupActivity) getParent();
					// parent.startChildActivity("Recommendations5Activity",
					// mIntent);
					View view = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"Recommendations5Activity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view);
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageProfile:
			// mIntent = new Intent(v.getContext(), ProfileActivity.class);
			// TabGroupActivity parentProfile = (TabGroupActivity) getParent();
			// parentProfile.startChildActivity("ProfileActivity", mIntent);
			Intent t = new Intent(RecommendationsActivity.this,
					ProfileActivity.class);
			View view1 = RecommendationsGroupActivity.group
					.getLocalActivityManager()
					.startActivity("ProfileActivity",
							t.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
					.getDecorView();
			RecommendationsGroupActivity.group.replaceView(view1);
			break;
		// case R.id.btnInbox:
		// if (check) {
		// v.setBackgroundResource(R.drawable.shape);
		// btnShuffle.setBackgroundResource(R.drawable.shape_off);
		// mIntent = new Intent(v.getContext(),
		// RecommendationsActivity.class);
		// RecommendationsGroupActivity parentRecommendations =
		// (RecommendationsGroupActivity) getParent();
		// parentRecommendations.startChildActivity(
		// "RecommendationsActivity", mIntent);
		// check = false;
		// } else {
		// check = true;
		// }
		//
		// break;
		case R.id.btnShuffle:
			for (int i = 0; i < RecommendationsActivity.mAdapter.getCount(); i++) {
				if (((Recommendations) mAdapter.getItem(i)).getType() == 1) {
					mIntent = new Intent(v.getContext(),
							RecommendationsShuffleActivity.class);
					Recommendations rs = (Recommendations) mAdapter.getItem(i);
					mIntent.putExtra("usename", rs.getUsername());
					mIntent.putExtra("action", rs.getAction());
					mIntent.putExtra("description", rs.getDescription());
					mIntent.putExtra("Position", i);
					mIntent.putExtra("Reply", rs.getReply());
					// TabGroupActivity parentRecommendations =
					// (TabGroupActivity) getParent();
					// parentRecommendations.startChildActivity(
					// "RecommendationsShuffleActivity", mIntent);
					View view2 = RecommendationsGroupActivity.group
							.getLocalActivityManager()
							.startActivity(
									"RecommendationsShuffleActivity",
									mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView();
					RecommendationsGroupActivity.group.replaceView(view2);
				}
			}
			break;
		default:
			break;
		}
	}

	// public void toActivity(int position, Class<?> cl) {
	// mIntent = new Intent(RecommendationsActivity.this, cl);
	// //Bundle bundle = new Bundle();
	// //Recommendations rs = (Recommendations) mAdapter.getItem(position);
	// //bundle.putSerializable("Recommendation", rs);
	// //bundle.putInt("Position", position);
	// //mIntent.putExtra("bundlerecommendation", bundle);
	// mView = RecommendationsGroupActivity.group
	// .getLocalActivityManager()
	// .startActivity("GET",
	// mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	// .getDecorView();
	// RecommendationsGroupActivity.group.replaceView(mView);
	// }
	@SuppressLint("ShowToast")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (SEND12 == requestCode && resultCode == RESULT_OK) {
			Bundle mydata = data.getExtras();
			replyre = mydata.getBoolean("Reply");
			positionre = mydata.getInt("Position");
			String hh = mydata.getString("ABC");
			Log.d(STORAGE_SERVICE, "" + hh);
			Toast.makeText(RecommendationsActivity.this, "" + hh, 5000).show();
			// Toast.makeText(RecommendationsActivity.this,
			// ""+String.valueOf(positionre), Toast.LENGTH_SHORT).show();
			// ((Recommendations) mAdapter.getItem(0)).setReply(true);
			// ((Recommendations)
			// mAdapter.getItem(positionre)).setReply(replyre);
			// mAdapter.notifyDataSetChanged();
			// mLvRecommendations.getAdapter();
		}
	}

	public void reloadData() {
		// TODO Auto-generated method stub		
			mLvRecommendations.setAdapter(mAdapter);	
	}
}
