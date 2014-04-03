package com.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.adapter.SearchFriendAdapter;
import com.model.Profile;
import com.tastesync.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileFollowingActivity extends Activity implements
		OnClickListener {
	private ImageView mImgBack;
	private ListView mLvFollowingFriend;
	// SearchFriendAdapter mAdapter;
	private ArrayList<Profile> mArray;
	// private Intent mIntent;
	// private View mView;
	private TextView mTittle;
	EditText mEditTextSearch;
	LayoutInflater inflater;
	private LinearLayout layout_body_following;

	ArrayList<HashMap<String, Object>> searchResults;
	ArrayList<HashMap<String, Object>> originalValues;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_following);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		layout_body_following = (LinearLayout) findViewById(R.id.layout_body_following);
		layout_body_following.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_following.getWindowToken(), 0);
			}
		});

		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mImgBack = (ImageView) findViewById(R.id.img_following_back);
		mImgBack.setOnClickListener(this);

		mTittle = (TextView) findViewById(R.id.tv_following_title);
		mTittle.setText("An Thai are following");
		mEditTextSearch = (EditText) findViewById(R.id.auto_following_friend);

		mLvFollowingFriend = (ListView) findViewById(R.id.lv_following_following);
		// mLvFollowingFriend.setDividerHeight(0);
		mLvFollowingFriend.setClickable(true);
		mArray = new ArrayList<Profile>();
		originalValues = new ArrayList<HashMap<String, Object>>();

		Profile pf = new Profile();
		pf.setAvatar("");
		pf.setEmail("");
		pf.setImage("");
		pf.setLocation("");
		pf.setUsername("Giang Ho");
		mArray.add(pf);

		Profile pf1 = new Profile();
		pf1.setAvatar("");
		pf1.setEmail("");
		pf1.setImage("");
		pf1.setLocation("");
		pf1.setUsername("Mr An");
		mArray.add(pf1);

		HashMap<String, Object> temp;
		for (int i = 0; i < mArray.size(); i++) {
			temp = new HashMap<String, Object>();
			temp.put("username", mArray.get(i).getUsername());
			originalValues.add(temp);
		}

		searchResults = new ArrayList<HashMap<String, Object>>(originalValues);

		// mAdapter = new FriendAdapter(this, mArray);
		// mLvFollowingFriend.setAdapter(mAdapter);
		final SearchFriendAdapter mAdapter = new SearchFriendAdapter(this,
				R.layout.item_friend, searchResults);
		mLvFollowingFriend.setAdapter(mAdapter);

		mEditTextSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				String searchString = mEditTextSearch.getText().toString();
				int textLength = searchString.length();

				searchResults.clear();

				for (int i = 0; i < originalValues.size(); i++) {
					String username = originalValues.get(i).get("username")
							.toString();
					if (textLength <= username.length()) {
						// compare the String in EditText with Names in the
						// ArrayList
						if (searchString.equalsIgnoreCase(username.substring(0,
								textLength)))
							searchResults.add(originalValues.get(i));
					}
				}

				mAdapter.notifyDataSetChanged();

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_following_back:
			finish();
			break;
		default:
			break;
		}
	}
}
