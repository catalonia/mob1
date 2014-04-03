package com.activity;

import javax.xml.transform.Source;

import com.tastesync.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Recommendations4Activity extends Activity {
	private ImageView mImgBack;
	private ImageView mImgLike;
	private boolean check = false;
	private LinearLayout layout_body_recom4;

	// private TextView tvUsername,tvDescription,tvAction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations4);
		init();
		handler();
	}

	private void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_rec_type4_back);
		mImgLike = (ImageView) findViewById(R.id.img_type4_like);
		layout_body_recom4 = (LinearLayout) findViewById(R.id.layout_body_recom4);
		// tvUsername=(TextView)findViewById(R.id.username);
		// tvDescription=(TextView)findViewById(R.id.description);
		// tvAction=(TextView)findViewById(R.id.action);
	}

	private void handler() {
		// TODO Auto-generated method stub
		layout_body_recom4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_recom4.getWindowToken(), 0);
			}
		});
		
		mImgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				RecommendationsGroupActivity.group.onBackPressed();

			}
		});
		mImgLike.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Toast.makeText(v.getContext(),
				// "" + v.getBackground().toString(), 2000).show();
				// v.setBackgroundResource(R.drawable.ic_like_on);
				if (check == false) {
					v.setBackgroundResource(R.drawable.ic_like);
					check = true;
				} else {
					v.setBackgroundResource(R.drawable.ic_like_on);
					check = false;
				}

			}
		});

		Bundle data = getIntent().getExtras();
		String username = data.getString("usename");
		String action = data.getString("action");
		String description = data.getString("description");
		int position = data.getInt("Position");
		// Toast.makeText(this, "" + username, 2000).show();
		// tvUsername.setText("" + username);
		// tvAction.setText("" + action);
		// tvDescription.setText("" + description);
	}
}
