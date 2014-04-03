package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterRestaurant;
import com.model.Database_Taste;
import com.model.Restaurant;
import com.tastesync.R;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class RestaurantsActivity extends Activity {

	public ListView lsData;
	public AdapterRestaurant arrayAdapter;
	public ArrayList<Restaurant> arrayList;
	private Database_Taste dbManager;
	private AutoCompleteTextView edSearch;
	String nameshop, price_res;
	int ratting, size;
	TextView tv_filter;
	ImageView img_profile, img_share;
	private Intent mIntent;
	private TextView tvTittleRes;
	private String neighbor, ambience, price, whowithyou, cusine;
	ArrayList<String> array_ambien = new ArrayList<String>();
	ArrayList<String> array_whowithyou = new ArrayList<String>();
	ArrayList<String> array_price = new ArrayList<String>();
	ArrayList<String> array_cusine = new ArrayList<String>();
	ArrayList<String> array_neighbor = new ArrayList<String>();
	String neighbor_, ambience_, price_, whowithyou_, cusine_;
	private LinearLayout layout_body_restaurant;
	boolean visible, visible1, visible2, visible3, visible4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurants);

		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			neighbor = mBundle.getString("neighbor");
			visible1 = mBundle.getBoolean("visible1", false);
			array_neighbor = mBundle.getStringArrayList("array_neighbor");
			if (neighbor == null || neighbor == "" || neighbor == ",") {
				neighbor = "";
			} else {
				neighbor = neighbor + ",";
			}

			ambience = mBundle.getString("ambience");
			visible = mBundle.getBoolean("visible", false);
			array_ambien = mBundle.getStringArrayList("array_ambien");
			if (ambience == null || ambience == "" || ambience == ",") {
				ambience = "";
			} else {
				ambience = ambience + ",";
			}
			price = mBundle.getString("price");
			visible2 = mBundle.getBoolean("visible2", false);
			array_price = mBundle.getStringArrayList("array_price");
			if (price == null || price == "" || price == ",") {
				price = "";
			} else {
				price = price + ",";
			}
			whowithyou = mBundle.getString("whowithyou");
			visible3 = mBundle.getBoolean("visible3", false);
			array_whowithyou = mBundle.getStringArrayList("array_whowithyou");
			if (whowithyou == null || whowithyou == "" || whowithyou == ",") {
				whowithyou = "";
			} else {
				whowithyou = whowithyou + ",";
			}
			cusine = mBundle.getString("cusine");
			visible4 = mBundle.getBoolean("visible4", true);
			array_cusine = mBundle.getStringArrayList("array_cusine");
			if (cusine == null || cusine == "" || cusine == ",") {
				cusine = "";
			} else {
				cusine = cusine + ",";
			}
		}

		layout_body_restaurant = (LinearLayout) findViewById(R.id.layout_body_restaurant);
		layout_body_restaurant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(v
						.getContext().INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(
						layout_body_restaurant.getWindowToken(), 0);
			}
		});

		img_profile = (ImageView) findViewById(R.id.imageProfile);
		img_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent = new Intent(RestaurantsActivity.this,
						ProfileActivity.class);
				// TabGroupActivity parent = (TabGroupActivity) getParent();
				// parent.startChildActivity("ProfileActivity", mIntent);
				View view1 = RestaurantGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"ProfileActivity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				RestaurantGroupActivity.group.replaceView(view1);
			}
		});

		img_share = (ImageView) findViewById(R.id.img_share);
		img_share.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent = new Intent(RestaurantsActivity.this,
						Askfreind2Activity.class);
				// TabGroupActivity parent = (TabGroupActivity) getParent();
				// parent.startChildActivity("Askfreind2Activity", mIntent);
				View view1 = RestaurantGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"Askfreind2Activity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				RestaurantGroupActivity.group.replaceView(view1);
			}
		});

		tvTittleRes = (TextView) findViewById(R.id.tv_tittle_restaurant);
		tvTittleRes.setText("" + neighbor + ambience + price + whowithyou
				+ cusine);
		if ((tvTittleRes.getText()).equals("nullnullnullnullnull")) {
			tvTittleRes.setText("NYK,Trendy");
		}

		dbManager = new Database_Taste(this);
		final ArrayList<Restaurant> list = getAllList();
		lsData = (ListView) findViewById(R.id.lv_find_restaurant);
		edSearch = (AutoCompleteTextView) findViewById(R.id.auto_restaurant_name);
		arrayAdapter = new AdapterRestaurant(this, list);
		lsData.setAdapter(arrayAdapter);
		setListViewHeightBasedOnChildren(lsData);
		lsData.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				nameshop = list.get(position).getName();
				price_res = list.get(position).getPrice();
				ratting = list.get(position).getRatting();
				size = list.size();

				Intent myIntent = new Intent(RestaurantsActivity.this,
						ViewRestaurantItemActivity.class);

				Bundle bundle = new Bundle();

				bundle.putInt("vitri", position);
				myIntent.putExtra("sendname", bundle);

				myIntent.putExtra("nameshop", nameshop);
				myIntent.putExtra("price", price_res);
				myIntent.putExtra("ratting", ratting);
				myIntent.putExtra("size", size);
				startActivity(myIntent);
			}
		});

		tv_filter = (TextView) findViewById(R.id.tv_click_find_restaurant);
		tv_filter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(RestaurantsActivity.this,
						FilterRestaurantActivity.class);

				Bundle bundle = new Bundle();

				mIntent.putExtra("neighbor", neighbor);
				mIntent.putExtra("array_neighbor", array_neighbor);
				mIntent.putExtra("visible1", visible1);

				mIntent.putExtra("ambience", ambience);
				mIntent.putExtra("array_ambien", array_ambien);
				mIntent.putExtra("visible", visible);

				mIntent.putExtra("price", price);
				mIntent.putExtra("array_price", array_price);
				mIntent.putExtra("visible2", visible2);

				mIntent.putExtra("whowithyou", whowithyou);
				mIntent.putExtra("array_whowithyou", array_whowithyou);
				mIntent.putExtra("visible3", visible3);

				mIntent.putExtra("cusine", cusine);
				mIntent.putExtra("array_cusine", array_cusine);
				mIntent.putExtra("visible4", visible4);
				// TabGroupActivity parent = (TabGroupActivity) getParent();
				// parent.startChildActivity("FilterRestaurantActivity",
				// mIntent);
				RestaurantGroupActivity.group.arrList.clear();
				View view1 = RestaurantGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"FilterRestaurantActivity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				RestaurantGroupActivity.group.replaceView(view1);
			}
		});
		edSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				arrayAdapter.getFilter().filter(s);

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

	public ArrayList<Restaurant> getAllList() {
		ArrayList<Restaurant> list = dbManager.getnamelist();
		return list;
	}

	public void reloadData() {
		lsData.setAdapter(arrayAdapter);
	}

	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

}
