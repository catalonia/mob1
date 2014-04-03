package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterAmbience;
import com.adapter.AdapterRating;
import com.model.Ambience;
import com.model.Rating;
import com.tastesync.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;

public class RatingActivity extends Activity {
	ImageView img_profile;
	Button btn_done;
	ListView list;
	String kq = "", test = "";
	AdapterRating adapter;
	public ArrayList<Rating> listRating = new ArrayList<Rating>();
	Boolean check = false;
	public ArrayList<String> mStrings = new ArrayList<String>();
	public ArrayList<String> mStrings_recive = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		getWindow().setSoftInputMode(
				   WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		/******** Take some data in Arraylist ( mArrayList ) ***********/
		setListData();
		recivedata();
		refreshData();

		Resources res = getResources();
		list = (ListView) findViewById(R.id.list_rating);
		img_profile = (ImageView) findViewById(R.id.imageProfile_rating);
		btn_done = (Button) findViewById(R.id.btn_done_rating);
		/**************** Create Custom Adapter *********/
		adapter = new AdapterRating(this, listRating, res);
		list.setAdapter(adapter);
		img_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(RatingActivity.this,
						ProfileActivity.class);
				startActivity(mIntent);
			}
		});
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent mIntent = new Intent();
				// Intent mIntent = new Intent();
				// Log.d(STORAGE_SERVICE, "" + kq);
				// mIntent.putExtra("data", kq);
				// kq = kq.replace(" ", "");
				// if (mStrings.size() == 0) {
				// check = true;
				// } else {
				// check = false;
				// }
				// mIntent.putStringArrayListExtra("array", mStrings);
				// mIntent.putExtra("invi", check);
				// setResult(RESULT_OK, mIntent);

				Intent mIntent = new Intent(RatingActivity.this,
						FilterRestaurantActivity.class);
				Log.d(STORAGE_SERVICE, "" + kq);
				mIntent.putExtra("data", kq);
				kq = kq.replace(" ", "");
				if (mStrings.size() == 0) {
					check = true;
				} else {
					check = false;
				}
				mIntent.putStringArrayListExtra("array", mStrings);
				mIntent.putExtra("invi", check);
				setResult(RESULT_OK, mIntent);

				finish();
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// if (listRating.get(position).isVisible()) {
				// listRating.get(position).setVisible(false);
				// kq = kq.replace("/" + listRating.get(position).getName(),
				// "");
				// kq = kq.replace(listRating.get(position).getName(), "");
				// if (mStrings.size() > 0) {
				// for (int i = 0; i < mStrings.size(); i++) {
				// if (mStrings.get(i).equals(
				// listRating.get(position).getName())) {
				// mStrings.remove(i);
				// }
				// }
				// }
				//
				// } else {
				// listRating.get(position).setVisible(true);
				// if (kq.length() != 0) {
				// kq += "/" + listRating.get(position).getName();
				// mStrings.add(listRating.get(position).getName());
				// } else {
				// kq += listRating.get(position).getName();
				// mStrings.add(listRating.get(position).getName());
				// }
				// }
				// adapter.notifyDataSetChanged();

				if (listRating.get(position).isVisible()) {
					listRating.get(position).setVisible(false);
					kq = "";
					if (mStrings.size() > 0) {
						mStrings.remove(0);
					}
				} else {
					for (int i = 0; i < listRating.size(); i++) {
						if (listRating.get(i).isVisible()) {
							listRating.get(i).setVisible(false);
							kq = "";
							if (mStrings.size() > 0) {
								mStrings.remove(0);
							}
						}
						listRating.get(position).setVisible(true);
					}
					kq += listRating.get(position).getName();
					mStrings.add(listRating.get(position).getName());
				}
				adapter.notifyDataSetChanged();
			}
		});

	}

	public void recivedata() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			mStrings_recive = mBundle.getStringArrayList("array1");
			for (int i = 0; i < mStrings_recive.size(); i++) {
				String tam = mStrings_recive.get(i);
				mStrings.add(tam);
			}
		}
	}

	public void refreshData() {
		for (int i = 0; i < mStrings_recive.size(); i++) {
			String tam = mStrings_recive.get(i);
			for (int j = 0; j < listRating.size(); j++) {
				String tam1 = listRating.get(j).getName();
				if (tam1.equals(tam)) {
					listRating.get(j).setVisible(true);
				}
			}
		}
	}

	/****** Function to set data in ArrayList *************/
	public void setListData() {
		final Rating item1 = new Rating();
		item1.setName("One Star");
		item1.setImage("rating_1star");
		listRating.add(item1);

		final Rating item2 = new Rating();
		item2.setName("Two Star");
		item2.setImage("rating_2star");
		listRating.add(item2);

		final Rating item3 = new Rating();
		item3.setName("Three Star");
		item3.setImage("rating_3star");
		listRating.add(item3);

		final Rating item4 = new Rating();
		item4.setName("Fwo Star");
		item4.setImage("rating_4star");
		listRating.add(item4);

		final Rating item5 = new Rating();
		item5.setName("Five Star");
		item5.setImage("rating_5star");
		listRating.add(item5);

	}

}
