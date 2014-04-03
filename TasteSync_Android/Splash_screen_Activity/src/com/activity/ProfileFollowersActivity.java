package com.activity;

import java.util.ArrayList;

import com.adapter.FriendAdapter;
import com.model.Profile;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileFollowersActivity extends Activity implements
		OnClickListener {
	private ImageView mImgBack;
	private TextView mTittle;
	private ListView mLvFollowerFriend;
	private FriendAdapter mAdapter;
	private ArrayList<Profile> mArray;
	private Intent mIntent;
	private View mView;
	private LinearLayout layout_body_follower;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_followers);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		layout_body_follower = (LinearLayout) findViewById(R.id.layout_body_follower);
		layout_body_follower.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_follower.getWindowToken(), 0);
			}
		});

		mImgBack = (ImageView) findViewById(R.id.img_followers_back);
		mImgBack.setOnClickListener(this);
		mTittle = (TextView) findViewById(R.id.tv_followers_title);
		mTittle.setText("Users are following to An Thai");

		mLvFollowerFriend = (ListView) findViewById(R.id.lv_followers_following);
		// mLvFollowingFriend.setDividerHeight(0);
		mLvFollowerFriend.setClickable(true);
		mArray = new ArrayList<Profile>();

		Profile pf = new Profile();
		pf.setAvatar("");
		pf.setEmail("");
		pf.setImage("");
		pf.setLocation("");
		pf.setUsername("Mr Nam");
		mArray.add(pf);
		Profile pf1 = new Profile();
		pf1.setAvatar("");
		pf1.setEmail("");
		pf1.setImage("");
		pf1.setLocation("");
		pf1.setUsername("Minh Devin");
		mArray.add(pf1);

		mAdapter = new FriendAdapter(this, mArray);
		mLvFollowerFriend.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_followers_back:
			finish();
			break;
		default:
			break;
		}
	}

}
