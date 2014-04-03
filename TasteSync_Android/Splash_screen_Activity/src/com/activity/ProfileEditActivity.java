package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ProfileEditActivity extends Activity implements OnClickListener {
	private ImageView mImgBack;
	private RelativeLayout layout_body_profile_edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_edit);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_edit_back);
		mImgBack.setOnClickListener(this);
		layout_body_profile_edit = (RelativeLayout) findViewById(R.id.layout_body_profile_edit);
		layout_body_profile_edit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_edit_back:
			finish();
			// TabGroupActivity parent = (TabGroupActivity) getParent();
			// parent.onBackPressed();
			break;
		case R.id.layout_body_profile_edit:
			InputMethodManager imm = (InputMethodManager) getSystemService(v
					.getContext().INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(
					layout_body_profile_edit.getWindowToken(), 0);
			break;
		default:
			break;
		}
	}
}
