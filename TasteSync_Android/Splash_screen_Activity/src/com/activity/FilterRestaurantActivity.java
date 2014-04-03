package com.activity;

import java.util.ArrayList;

import listview.horizontal.HorizontalListView;

import com.adapter.AdapterLVhorizantal;
import com.model.Itemhorizantal;
import com.model.Itemhorizantal;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class FilterRestaurantActivity extends Activity {

	TextView tv_try_later, tv_favos, tv_include_chains;
	// RatingBar mRatingBar;
	ImageView img_try_later, img_favos, img_include_chains;
	boolean check = false, test = false;
	Button mButton;
	private RelativeLayout layout_fiter_cusine, layout_fiter_ambience,
			layout_fiter_neighborhood, layout_fiter_who, layout_fiter_rating,
			layout_fiter_price;
	ArrayList<String> array_ambien = new ArrayList<String>();
	ArrayList<String> array_ranting = new ArrayList<String>();
	ArrayList<String> array_whowithyou = new ArrayList<String>();
	ArrayList<String> array_price = new ArrayList<String>();
	ArrayList<String> array_cusine = new ArrayList<String>();
	ArrayList<String> array_neighbor = new ArrayList<String>();
	int SEND6 = 6, SEND7 = 7, SEND8 = 8, SEND9 = 9, SEND10 = 10, SEND11 = 11;
	String neighbor, ambience, price, whowithyou, cusine, rating;

	ImageView img_tick_cusine, img_tick_ambience, img_tick_neighborhood,
			img_tick_who, img_tick_rating, img_tick_price;
	boolean visible, visible1, visible2, visible3, visible4;

	// HorizontalListView lv_cusine, lv_price;
	// ArrayList<Itemhorizantal> list_cusine, list_price;
	// AdapterLVhorizantal mAdapter_cusine, mAdapter_price;
	// String result="",cusine="",price="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filterrestaurant);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		img_try_later = (ImageView) findViewById(R.id.img_try_later);
		img_favos = (ImageView) findViewById(R.id.img_favos_filter);
		img_include_chains = (ImageView) findViewById(R.id.img_include_chains);

		tv_try_later = (TextView) findViewById(R.id.tv_try_later);
		tv_favos = (TextView) findViewById(R.id.tv_favos);
		tv_include_chains = (TextView) findViewById(R.id.tv_include_chains);

		mButton = (Button) findViewById(R.id.btn_done_filters);
		layout_fiter_cusine = (RelativeLayout) findViewById(R.id.layout_fiter_cusine);
		layout_fiter_ambience = (RelativeLayout) findViewById(R.id.layout_fiter_ambience);
		layout_fiter_neighborhood = (RelativeLayout) findViewById(R.id.layout_fiter_neighborhood);
		layout_fiter_who = (RelativeLayout) findViewById(R.id.layout_fiter_who);
		layout_fiter_rating = (RelativeLayout) findViewById(R.id.layout_fiter_rating);
		layout_fiter_price = (RelativeLayout) findViewById(R.id.layout_fiter_price);

		img_tick_cusine = (ImageView) findViewById(R.id.img_tick_cusine);
		img_tick_ambience = (ImageView) findViewById(R.id.img_tick_ambience);
		img_tick_neighborhood = (ImageView) findViewById(R.id.img_tick_neighborhood);
		img_tick_who = (ImageView) findViewById(R.id.img_tick_who);
		img_tick_rating = (ImageView) findViewById(R.id.img_tick_rating);
		img_tick_price = (ImageView) findViewById(R.id.img_tick_price);

		// lv_cusine = (HorizontalListView)
		// findViewById(R.id.lv_horizantal_cusine);
		// lv_price = (HorizontalListView)
		// findViewById(R.id.lv_horizantal_price);
		// mRatingBar=(RatingBar)findViewById(R.id.rating_restaurant);
	}

	private void handle() {
		// TODO Auto-generated method stub
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			neighbor = mBundle.getString("neighbor");
			visible1 = mBundle.getBoolean("visible1", false);
			array_neighbor = mBundle.getStringArrayList("array_neighbor");
			check = visible1;
			if (check == false) {
				img_tick_neighborhood.setVisibility(View.VISIBLE);
			} else {
				img_tick_neighborhood.setVisibility(View.GONE);
			}

			ambience = mBundle.getString("ambience");
			visible = mBundle.getBoolean("visible", false);
			array_ambien = mBundle.getStringArrayList("array_ambien");
			check = visible;
			if (check == false) {
				img_tick_ambience.setVisibility(View.VISIBLE);
			} else {
				img_tick_ambience.setVisibility(View.GONE);
			}

			price = mBundle.getString("price");
			visible2 = mBundle.getBoolean("visible2", false);
			array_price = mBundle.getStringArrayList("array_price");
			check = visible2;
			if (check == false) {
				img_tick_price.setVisibility(View.VISIBLE);
			} else {
				img_tick_price.setVisibility(View.GONE);
			}

			whowithyou = mBundle.getString("whowithyou");
			visible3 = mBundle.getBoolean("visible3", false);
			array_whowithyou = mBundle.getStringArrayList("array_whowithyou");
			check = visible3;
			if (check == false) {
				img_tick_who.setVisibility(View.VISIBLE);
			} else {
				img_tick_who.setVisibility(View.GONE);
			}

			cusine = mBundle.getString("cusine");
			visible4 = mBundle.getBoolean("visible4", false);
			array_cusine = mBundle.getStringArrayList("array_cusine");
			check = visible4;
			if (check == false) {
				img_tick_cusine.setVisibility(View.VISIBLE);
			} else {
				img_tick_cusine.setVisibility(View.GONE);
			}
		}
		// -----------------------------------------------------------------------------------------------------------

		layout_fiter_cusine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						CusineActivity.class);
				mIntent.putStringArrayListExtra("array1", array_cusine);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND10);
			}
		});
		layout_fiter_ambience.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						AmbienceActivity.class);
				mIntent.putStringArrayListExtra("array1", array_ambien);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND6);
			}
		});
		layout_fiter_neighborhood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						NeighborActivity.class);
				mIntent.putStringArrayListExtra("array1", array_neighbor);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND7);
			}
		});
		layout_fiter_who.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						WhowithyouActivity.class);
				mIntent.putStringArrayListExtra("array1", array_whowithyou);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND8);
			}
		});
		layout_fiter_price.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						PriceActivity.class);
				mIntent.putStringArrayListExtra("array1", array_price);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND9);
			}
		});
		layout_fiter_rating.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						RatingActivity.class);
				mIntent.putStringArrayListExtra("array1", array_ranting);
				TabGroupActivity parentActivity = (TabGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND11);
			}
		});

		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// result = "Search : cusine = " + cusine + ". price = "
				// + price.trim() + " rating = " + mRatingBar.getRating();
				// finish();
				// RestaurantGroupActivity.group.onBackPressed();
				Intent mIntent = new Intent(FilterRestaurantActivity.this,
						RestaurantsActivity.class);
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

				RestaurantGroupActivity.group.arrList.clear();
				View view1 = RestaurantGroupActivity.group
						.getLocalActivityManager()
						.startActivity(
								"RestaurantsActivity",
								mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();

				RestaurantGroupActivity.group.arrList.add(view1);
				RestaurantGroupActivity.group.replaceViewDoubleClick(view1);
			}
		});
		img_try_later.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (test) {

					img_try_later
							.setBackgroundResource(R.drawable.ic_saved_black);
					tv_try_later.setText("Try Later");
					test = false;
				} else {

					img_try_later.setBackgroundResource(R.drawable.ic_saved);
					tv_try_later.setText("Try Later");
					test = true;
				}
			}
		});
		img_favos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (test) {

					img_favos
							.setBackgroundResource(R.drawable.ic_bt_addtomyfaves_black);
					tv_favos.setText("Favs");
					test = false;
				} else {

					img_favos
							.setBackgroundResource(R.drawable.ic_bt_addtomyfaves);
					tv_favos.setText("Favs");
					test = true;
				}
			}
		});
		img_include_chains.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (test) {

					img_include_chains
							.setBackgroundResource(R.drawable.include_chains_black);
					// tv_include_chains.setText("Add to Favs");
					test = false;
				} else {

					img_include_chains
							.setBackgroundResource(R.drawable.include_chains);
					// tv_favos.setText("Added to Favs");
					test = true;
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (SEND10 == requestCode && resultCode == RESULT_OK) {
			visible4 = data.getBooleanExtra("invi", false);
			cusine = data.getStringExtra("data");
			array_cusine = data.getStringArrayListExtra("array");
			if (array_cusine.size() > 0) {
				cusine = "";
				for (int i = 0; i < array_cusine.size(); i++) {
					if (cusine.length() != 0) {
						cusine += "/" + array_cusine.get(i);
					} else {
						cusine += array_cusine.get(i);
					}
				}
			}
			Log.d("cusine", cusine);
			check = visible4;
			if (check == false) {
				img_tick_cusine.setVisibility(View.VISIBLE);
			} else {
				img_tick_cusine.setVisibility(View.GONE);
			}
		}
		if (SEND6 == requestCode && resultCode == RESULT_OK) {
			visible = data.getBooleanExtra("invi", false);
			ambience = data.getStringExtra("data");
			array_ambien = data.getStringArrayListExtra("array");
			if (array_ambien.size() > 0) {
				ambience = "";
				for (int i = 0; i < array_ambien.size(); i++) {
					if (ambience.length() != 0) {
						ambience += "/" + array_ambien.get(i);
					} else {
						ambience += array_ambien.get(i);
					}
				}
			}
			Log.d("ambience", ambience);
			check = visible;
			if (check == false) {
				img_tick_ambience.setVisibility(View.VISIBLE);
			} else {
				img_tick_ambience.setVisibility(View.GONE);
			}
		}
		if (SEND7 == requestCode && resultCode == RESULT_OK) {
			visible1 = data.getBooleanExtra("invi", false);
			neighbor = data.getStringExtra("data");
			array_neighbor = data.getStringArrayListExtra("array");
			if (array_neighbor.size() > 0) {
				neighbor = "";
				for (int i = 0; i < array_neighbor.size(); i++) {
					if (neighbor.length() != 0) {
						neighbor += "/" + array_neighbor.get(i);
					} else {
						neighbor += array_neighbor.get(i);
					}
				}
			}
			Log.d("neighbor", neighbor);
			check = visible1;
			if (check == false) {
				img_tick_neighborhood.setVisibility(View.VISIBLE);
			} else {
				img_tick_neighborhood.setVisibility(View.GONE);
			}
		}
		if (SEND8 == requestCode && resultCode == RESULT_OK) {
			visible3 = data.getBooleanExtra("invi", false);
			whowithyou = data.getStringExtra("data");
			array_whowithyou = data.getStringArrayListExtra("array");
			if (array_whowithyou.size() > 0) {
				whowithyou = "";
				for (int i = 0; i < array_whowithyou.size(); i++) {
					if (whowithyou.length() != 0) {
						whowithyou += "/" + array_whowithyou.get(i);
					} else {
						whowithyou += array_whowithyou.get(i);
					}
				}
			}
			Log.d("whowithyou", whowithyou);
			check = visible3;
			if (check == false) {
				img_tick_who.setVisibility(View.VISIBLE);
			} else {
				img_tick_who.setVisibility(View.GONE);
			}
		}
		if (SEND9 == requestCode && resultCode == RESULT_OK) {
			visible2 = data.getBooleanExtra("invi", false);
			price = data.getStringExtra("data");
			array_price = data.getStringArrayListExtra("array");
			if (array_price.size() > 0) {
				price = "";
				for (int i = 0; i < array_price.size(); i++) {
					if (price.length() != 0) {
						price += "/" + array_price.get(i);
					} else {
						price += array_price.get(i);
					}
				}
			}
			Log.d("price", price);
			check = visible2;
			if (check == false) {
				img_tick_price.setVisibility(View.VISIBLE);
			} else {
				img_tick_price.setVisibility(View.GONE);
			}
		}
		if (SEND11 == requestCode && resultCode == RESULT_OK) {
			boolean visible = data.getBooleanExtra("invi", false);
			rating = data.getStringExtra("data");
			array_ranting = data.getStringArrayListExtra("array");
			if (array_ranting.size() > 0) {
				rating = "";
				for (int i = 0; i < array_ranting.size(); i++) {
					if (rating.length() != 0) {
						rating += "/" + array_ranting.get(i);
					} else {
						rating += array_ranting.get(i);
					}
				}
			}
			Log.d("rating", rating);
			check = visible;
			if (check == false) {
				img_tick_rating.setVisibility(View.VISIBLE);
			} else {
				img_tick_rating.setVisibility(View.GONE);
			}
		}
	}
}
