package com.activity;

import java.util.ArrayList;

import com.tastesync.R;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class AskActivity extends Activity {
	LinearLayout click_cuisine, click_Ambience, click_whowithyou, click_price,
			click_neighborhood;
	ImageView tick, tick1, tick2, tick3, tick4;
	Button btn_ask_foodies;
	boolean check = false, visible = true, visible1 = true, visible2 = true,
			visible3 = true, visible4 = true;
	int SEND = 1, SEND1 = 2, SEND2 = 3, SEND3 = 4, SEND4 = 5;
	String neighbor, ambience, price, whowithyou, cusine;
	ArrayList<String> array_ambien = new ArrayList<String>();
	ArrayList<String> array_whowithyou = new ArrayList<String>();
	ArrayList<String> array_price = new ArrayList<String>();
	ArrayList<String> array_cusine = new ArrayList<String>();
	ArrayList<String> array_neighbor = new ArrayList<String>();
	ImageView img_profile;
	private Intent mIntent;
	private PopupWindow pwindo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask);

		click_Ambience = (LinearLayout) findViewById(R.id.click_Ambience);
		click_cuisine = (LinearLayout) findViewById(R.id.click_cuisine);
		click_neighborhood = (LinearLayout) findViewById(R.id.click_neighborhood);
		click_price = (LinearLayout) findViewById(R.id.click_price);
		click_whowithyou = (LinearLayout) findViewById(R.id.click_whowithyou);
		btn_ask_foodies = (Button) findViewById(R.id.btn_ask_foodies);
		tick = (ImageView) findViewById(R.id.img_Ambience);
		tick1 = (ImageView) findViewById(R.id.img_neighbor);
		tick2 = (ImageView) findViewById(R.id.img_price);
		tick3 = (ImageView) findViewById(R.id.img_whowithyou);
		tick4 = (ImageView) findViewById(R.id.img_cusine);
		img_profile = (ImageView) findViewById(R.id.imageProfile);

		img_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						ProfileActivity.class);
				TabGroupActivity parent = (TabGroupActivity) getParent();
				parent.startChildActivity("ProfileActivity", mIntent);

			}
		});
		click_Ambience.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						AmbienceActivity.class);
				mIntent.putStringArrayListExtra("array1", array_ambien);
				AskGroupActivity parentActivity = (AskGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND);
			}
		});
		click_cuisine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						CusineActivity.class);
				mIntent.putStringArrayListExtra("array1", array_cusine);
				AskGroupActivity parentActivity = (AskGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND4);
			}
		});
		click_neighborhood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						NeighborActivity.class);
				mIntent.putStringArrayListExtra("array1", array_neighbor);
				AskGroupActivity parentActivity = (AskGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND1);
			}
		});
		click_price.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						PriceActivity.class);
				mIntent.putStringArrayListExtra("array1", array_price);
				AskGroupActivity parentActivity = (AskGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND2);
			}
		});
		click_whowithyou.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AskActivity.this,
						WhowithyouActivity.class);
				mIntent.putStringArrayListExtra("array1", array_whowithyou);
				AskGroupActivity parentActivity = (AskGroupActivity) getParent();
				parentActivity.startActivityForResult(mIntent, SEND3);
			}
		});
		btn_ask_foodies.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater inflater = (LayoutInflater) AskActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View layout = inflater.inflate(R.layout.dialog_ask_foodies,
						null);
				pwindo = new PopupWindow(layout,
						WindowManager.LayoutParams.WRAP_CONTENT,
						WindowManager.LayoutParams.WRAP_CONTENT, true);

				pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
				TextView OK = (TextView) layout.findViewById(R.id.tv_ok);
				OK.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pwindo.dismiss();
						Intent mIntent = new Intent(AskActivity.this,
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
						// startActivity(mIntent);
						// AskGroupActivity parent = (AskGroupActivity)
						// getParent();
						// parent.startChildActivity("RestaurantsActivity",
						// mIntent);

						// RestaurantGroupActivity.group.replaceView(view1);

						TabActivity tabActivity = (TabActivity) getParent()
								.getParent();
						tabActivity.getTabHost().setCurrentTab(2);
						// View view = RestaurantGroupActivity.arrList.get(0);
						RestaurantGroupActivity.group.arrList.clear();
						View view1 = RestaurantGroupActivity.group
								.getLocalActivityManager()
								.startActivity(
										"RestaurantsActivity",
										mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
								.getDecorView();

						RestaurantGroupActivity.group.arrList.add(view1);
						RestaurantGroupActivity.group
								.replaceViewDoubleClick(view1);
					}
				});

			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (SEND == requestCode && resultCode == RESULT_OK) {
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
				tick.setVisibility(View.VISIBLE);
			} else {
				tick.setVisibility(View.GONE);
			}
		}
		if (SEND1 == requestCode && resultCode == RESULT_OK) {
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
				tick1.setVisibility(View.VISIBLE);
			} else {
				tick1.setVisibility(View.GONE);
			}
		}
		if (SEND2 == requestCode && resultCode == RESULT_OK) {
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
			Log.d("price", "" + price.length());
			check = visible2;
			if (check == false) {
				tick2.setVisibility(View.VISIBLE);
			} else {
				tick2.setVisibility(View.GONE);
			}
		}
		if (SEND3 == requestCode && resultCode == RESULT_OK) {
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
				tick3.setVisibility(View.VISIBLE);
			} else {
				tick3.setVisibility(View.GONE);
			}
		}
		if (SEND4 == requestCode && resultCode == RESULT_OK) {
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
				tick4.setVisibility(View.VISIBLE);
			} else {
				tick4.setVisibility(View.GONE);
			}
		}
	}

}
