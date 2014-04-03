package com.activity;

import java.util.ArrayList;

import test.test1Activity;

import com.adapter.Adapter_tips;
import com.model.Recommendations;
import com.model.Tips;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class TipsActivity extends Activity {
	ListView list;
	LinearLayout layout_back;
	ArrayList<Tips> mArrayList;
	Adapter_tips mAdapter_tips;
	ImageView img_back;
	String nameshop, price;
	int ratting, size, vitri;
	private TextView tvNameView, tvPriceView, tvOpen;
	private RatingBar RattingView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		list = (ListView) findViewById(R.id.lv_tips);
		img_back = (ImageView) findViewById(R.id.imageBack3);
		layout_back = (LinearLayout) findViewById(R.id.layout_back);

		tvNameView = (TextView) findViewById(R.id.txtName);
		tvPriceView = (TextView) findViewById(R.id.txtPrice);
		RattingView = (RatingBar) findViewById(R.id.ratingbar);
	}

	private void handle() {
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

		layout_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mArrayList = new ArrayList<Tips>();
		mArrayList
				.add(new Tips(
						"Time out New York left a tip.",
						"On weekend, $20 scores you two hours of all-you-can-drink boozing(even Foster and Moo Juice cocktails"));
		mArrayList
				.add(new Tips("Village Voice left a tip.",
						"Their Traditional Australian Mutton Stew was a featured dish at choice Eats!"));
		mArrayList
				.add(new Tips(
						"Time out New York left a tip.",
						"On weekend, $20 scores you two hours of all-you-can-drink boozing(even Foster and Moo Juice cocktails"));
		mArrayList
				.add(new Tips("Village Voice left a tip.",
						"Their Traditional Australian Mutton Stew was a featured dish at choice Eats!"));
		mArrayList
				.add(new Tips(
						"Time out New York left a tip.",
						"On weekend, $20 scores you two hours of all-you-can-drink boozing(even Foster and Moo Juice cocktails"));
		mArrayList
				.add(new Tips("Village Voice left a tip.",
						"Their Traditional Australian Mutton Stew was a featured dish at choice Eats!"));
		mAdapter_tips = new Adapter_tips(TipsActivity.this, mArrayList);
		list.setAdapter(mAdapter_tips);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(TipsActivity.this,
						test1Activity.class);
				Bundle bundle = new Bundle();

				bundle.putInt("vitri", vitri);

				mIntent.putExtra("sendname", bundle);
				mIntent.putExtra("nameshop", nameshop);
				mIntent.putExtra("price", price);
				mIntent.putExtra("ratting", ratting);
				mIntent.putExtra("size", size);
				
				Tips tip = (Tips) mAdapter_tips.getItem(position);
				mIntent.putExtra("title", tip.getTitle());
				mIntent.putExtra("content", tip.getContent());

				startActivity(mIntent);

			}
		});
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
