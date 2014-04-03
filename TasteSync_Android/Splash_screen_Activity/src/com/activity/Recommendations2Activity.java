package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterRecommendationsRestaurant;
import com.adapter.AdapterRestaurant;
import com.model.Database_Taste;
import com.model.Restaurant;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Recommendations2Activity extends Activity {
	private ImageView mImgBack;
	private Database_Taste dbManager;
	private AdapterRecommendationsRestaurant arrayAdapter;
	private ListView mLvRes;
	String nameshop, price;
	int ratting, size;
	private Intent mIntent;
	private LinearLayout layout_body_recom2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommandations2);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		layout_body_recom2 = (LinearLayout) findViewById(R.id.layout_body_recom2);
		layout_body_recom2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_recom2.getWindowToken(), 0);
			}
		});
		
		mImgBack = (ImageView) findViewById(R.id.img_rec_type2_back);
		mImgBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RecommendationsGroupActivity.group.onBackPressed();

			}
		});
		
		dbManager = new Database_Taste(this);
		final ArrayList<Restaurant> list =  dbManager.getnamelist();
		mLvRes = (ListView) findViewById(R.id.lv_recom_restaurant);
		arrayAdapter = new AdapterRecommendationsRestaurant(this, list);
		mLvRes.setAdapter(arrayAdapter);
		mLvRes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				nameshop = list.get(position).getName();
				price = list.get(position).getPrice();
				ratting = list.get(position).getRatting();
				size = list.size();

				Intent myIntent = new Intent(Recommendations2Activity.this,
						ViewRestaurantItemActivity.class);

				Bundle bundle = new Bundle();

				bundle.putInt("vitri", position);
				myIntent.putExtra("sendname", bundle);

				myIntent.putExtra("nameshop", nameshop);
				myIntent.putExtra("price", price);
				myIntent.putExtra("ratting", ratting);
				myIntent.putExtra("size", size);

				startActivity(myIntent);

			}
		});

	}

}
