package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

public class LeaveaTipActivity extends Activity {
	String nameshop, price;
	int ratting, size, vitri;
	private TextView tvNameView, tvPriceView, tvOpen;
	private RatingBar RattingView;
	ImageView imgBack;
	Button btn_leave_tip;
	private PopupWindow pwindo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leave_tip);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		tvNameView = (TextView) findViewById(R.id.txtNameView);
		tvPriceView = (TextView) findViewById(R.id.txtPriceView);
		RattingView = (RatingBar) findViewById(R.id.small_ratingbar_view);
		tvOpen = (TextView) findViewById(R.id.txtOpen);
		imgBack = (ImageView) findViewById(R.id.imageBackLeaveTips);
		btn_leave_tip = (Button) findViewById(R.id.btn_leave_tip);
	}

	private void handle() {
		// TODO Auto-generated method stub
		imgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btn_leave_tip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater inflater = (LayoutInflater) LeaveaTipActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View layout = inflater
						.inflate(R.layout.dialog_leave_tips, null);
				pwindo = new PopupWindow(layout, 400,
						WindowManager.LayoutParams.WRAP_CONTENT, true);

				pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
				TextView OK = (TextView) layout
						.findViewById(R.id.tv_ok_leave_tips);
				OK.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pwindo.dismiss();

					}
				});

			}

		});

		Intent i = getIntent();

		nameshop = i.getStringExtra("nameshop");
		price = i.getStringExtra("price");
		ratting = i.getIntExtra("ratting", -1);
		size = i.getIntExtra("size", -1);

		Bundle bundle = i.getBundleExtra("sendname");
		vitri = bundle.getInt("vitri");
		for (int j = 0; j <= size; j++) {
			if (vitri == j) {
				tvNameView.setText("" + nameshop);
				tvPriceView.setText("" + price);
				RattingView.setRating(ratting);
			}

		}
	}

}
