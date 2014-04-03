package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterProfileRestaurant;
import com.adapter.AdapterRestaurant;
import com.google.android.gms.internal.br;
import com.model.Database_Taste;
import com.model.Restaurant;
import com.tastesync.R;

import android.R.bool;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileRestaurantActivity extends Activity implements
		OnClickListener {
	private ImageView mImgBack, mImgFilter;
	private ListView mLvResList;
	private AdapterProfileRestaurant Adapter;
	private ArrayList<Restaurant> arrayList;
	private Database_Taste dbManager;
	private LinearLayout mLayoutFilter;
	private TextView mTvFilter;
	String nameshop, price;
	int ratting, size;
	private Intent mIntent;
	private boolean check = true;
	boolean visiable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_restaurant);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mImgBack = (ImageView) findViewById(R.id.img_restaurant_back);
		mImgBack.setOnClickListener(this);

		mLayoutFilter = (LinearLayout) findViewById(R.id.layout_click_find_res);
		mLayoutFilter.setOnClickListener(this);
		mImgFilter = (ImageView) findViewById(R.id.img_click_find_res);
		mImgFilter.setOnClickListener(this);
		mTvFilter = (TextView) findViewById(R.id.tv_click_find_res);
		mTvFilter.setOnClickListener(this);

		dbManager = new Database_Taste(this);
		final ArrayList<Restaurant> list = dbManager.getnamelist();
		mLvResList = (ListView) findViewById(R.id.lv_find_frofile_res);
		mLvResList.setDividerHeight(0);
		Adapter = new AdapterProfileRestaurant(this, list);
		mLvResList.setAdapter(Adapter);
		mLvResList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				nameshop = list.get(position).getName();
				price = list.get(position).getPrice();
				ratting = list.get(position).getRatting();
				size = list.size();
				visiable = list.get(position).isVisible();
				// Toast.makeText(ProfileRestaurantActivity.this,
				// ""+String.valueOf(visiable), 5000).show();

				Intent myIntent = new Intent(ProfileRestaurantActivity.this,
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

	private PopupWindow pwindo;

	private void initiatePopupWindow() {
		// TODO Auto-generated method stub
		try {
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) ProfileRestaurantActivity.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.filter_profile_restaurant,
					null);
			pwindo = new PopupWindow(layout,
					WindowManager.LayoutParams.MATCH_PARENT,
					WindowManager.LayoutParams.WRAP_CONTENT, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 50);

			Button btnRecommended = (Button) layout
					.findViewById(R.id.btn_pro_res_filter_recommended);
			btnRecommended.setOnClickListener(this);
			Button btnFavs = (Button) layout
					.findViewById(R.id.btn_pro_res_filter_fav);
			btnFavs.setOnClickListener(this);

			Button btnTips = (Button) layout
					.findViewById(R.id.btn_pro_res_filter_tip);
			btnTips.setOnClickListener(this);

			Button btnSaved = (Button) layout
					.findViewById(R.id.btn_pro_res_filter_save);
			btnSaved.setOnClickListener(this);

			Button btnDone = (Button) layout
					.findViewById(R.id.btn_pro_res_filter_done);
			btnDone.setOnClickListener(this);

			// @Override
			// public void onClick(View view) {
			// // TODO Auto-generated method stub
			// finish();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_restaurant_back:
			finish();
			break;
		case R.id.img_click_find_res:
			initiatePopupWindow();
			break;
		case R.id.layout_click_find_res:
			initiatePopupWindow();
			break;
		case R.id.tv_click_find_res:
			initiatePopupWindow();
			break;
		case R.id.btn_pro_res_filter_recommended:
			if (check) {
				v.setBackgroundResource(R.drawable.ic_bt_recommended);
				check = false;
			} else {
				v.setBackgroundResource(R.drawable.ic_bt_recommended_on);
				check = true;
			}
			break;
		case R.id.btn_pro_res_filter_fav:
			if (check) {
				v.setBackgroundResource(R.drawable.ic_bt_favs);
				check = false;
			} else {
				v.setBackgroundResource(R.drawable.ic_bt_favs_on);
				check = true;
			}
			break;
		case R.id.btn_pro_res_filter_tip:
			if (check) {
				v.setBackgroundResource(R.drawable.ic_bt_tips);
				check = false;
			} else {
				v.setBackgroundResource(R.drawable.ic_bt_tips_on);
				check = true;
			}
			break;
		case R.id.btn_pro_res_filter_save:
			if (check) {
				v.setBackgroundResource(R.drawable.ic_bt_saved125_off);
				check = false;
			} else {
				v.setBackgroundResource(R.drawable.ic_bt_saved125_on);
				check = true;
			}
			break;
		case R.id.btn_pro_res_filter_done:
			pwindo.dismiss();
			break;
		default:
			break;
		}
	}

}
