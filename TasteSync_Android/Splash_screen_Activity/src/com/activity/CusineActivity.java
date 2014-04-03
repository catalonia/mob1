package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterNeighbor;
import com.model.neighbor;
import com.tastesync.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CusineActivity extends Activity {

	ListView lv;
	Button btn_done;
	String kq = "";
	EditText mEditText;
	public ArrayList<neighbor> list_cusine, searchResults;
	public AdapterNeighbor listneighboradapter;
	Boolean check = false;
	public ArrayList<String> mStrings = new ArrayList<String>();
	public ArrayList<String> mStrings_recive = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neighbor);
		getWindow().setSoftInputMode(
				   WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		lv = (ListView) findViewById(R.id.list);
		lv.setClickable(true);
		mEditText = (EditText) findViewById(R.id.edt_neighbor);
		btn_done = (Button) findViewById(R.id.btn_done_neighbor);
		mEditText.setHint("Search Cusine");

		list_cusine = new ArrayList<neighbor>();
		setlist();
		recivedata();
		refreshData();

		listneighboradapter = new AdapterNeighbor(this, list_cusine);
		lv.setAdapter(listneighboradapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (list_cusine.get(position).isVisible()) {
					list_cusine.get(position).setVisible(false);
					kq = kq.replace("/" + list_cusine.get(position).getName(),
							"");
					kq = kq.replace(list_cusine.get(position).getName(), "");
					if (mStrings.size() > 0) {
						for (int i = 0; i < mStrings.size(); i++) {
							if (mStrings.get(i).equals(
									list_cusine.get(position).getName())) {
								mStrings.remove(i);
							}
						}
					}
				} else {
					list_cusine.get(position).setVisible(true);
					if (kq.length() != 0) {
						kq += "/" + list_cusine.get(position).getName();
						mStrings.add(list_cusine.get(position).getName());
					} else {
						kq += list_cusine.get(position).getName();
						mStrings.add(list_cusine.get(position).getName());
					}
				}
				listneighboradapter.notifyDataSetChanged();
			}
		});
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent();
				Log.d(STORAGE_SERVICE, "" + kq);
				if (mStrings.size() == 0) {
					check = true;
				} else {
					check = false;
				}
				mIntent.putExtra("data", kq);
				mIntent.putStringArrayListExtra("array", mStrings);
				mIntent.putExtra("invi", check);
				setResult(RESULT_OK, mIntent);

				finish();
			}
		});
		mEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
//				InputMethodManager imm = (InputMethodManager)getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String searchString = mEditText.getText().toString();
				int textLength = searchString.length();
				searchResults = new ArrayList<neighbor>();

				// clear the initial data set
				searchResults.clear();

				for (int i = 0; i < list_cusine.size(); i++) {
					String values = list_cusine.get(i).getName().toString();

					if (textLength <= values.length()) {
						if (searchString.equalsIgnoreCase(values.substring(0,
								textLength)))
							searchResults.add(list_cusine.get(i));
						listneighboradapter = new AdapterNeighbor(
								CusineActivity.this, searchResults);
						lv.setAdapter(listneighboradapter);
					}
				}
				lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						if (searchResults.get(position).isVisible()) {
							searchResults.get(position).setVisible(false);
							kq = kq.replace("/"
									+ searchResults.get(position).getName(), "");
							kq = kq.replace(searchResults.get(position)
									.getName(), "");
							if (mStrings.size() > 0) {
								for (int i = 0; i < mStrings.size(); i++) {
									if (mStrings.get(i).equals(
											searchResults.get(position)
													.getName())) {
										mStrings.remove(i);
									}
								}
							}
						} else {
							searchResults.get(position).setVisible(true);
							if (kq.length() != 0) {
								kq += "/"
										+ searchResults.get(position).getName();
								mStrings.add(searchResults.get(position)
										.getName());
							} else {
								kq += searchResults.get(position).getName();
								mStrings.add(searchResults.get(position)
										.getName());
							}
						}
						listneighboradapter.notifyDataSetChanged();
					}
				});
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
			for (int j = 0; j < list_cusine.size(); j++) {
				String tam1 = list_cusine.get(j).getName();
				if (tam1.equals(tam)) {
					list_cusine.get(j).setVisible(true);
				}
			}
		}
	}

	public void setlist() {
		neighbor n1 = new neighbor("African ");
		neighbor n2 = new neighbor("American ");
		neighbor n3 = new neighbor("Armenian ");
		neighbor n4 = new neighbor("Barbecue ");
		neighbor n5 = new neighbor("Brazilian ");
		neighbor n6 = new neighbor("British ");
		neighbor n7 = new neighbor("Cafeteria");
		neighbor n8 = new neighbor("Cajun ");
		neighbor n9 = new neighbor("Central American ");
		neighbor n10 = new neighbor("Chicken ");
		neighbor n11 = new neighbor("Chinese ");
		neighbor n12 = new neighbor("Cuban ");
		neighbor n13 = new neighbor("Ethiopian ");
		neighbor n14 = new neighbor("French ");
		neighbor n15 = new neighbor("German ");
		neighbor n16 = new neighbor("Hamburgers ");
		neighbor n17 = new neighbor("Homestyle Cooking ");
		neighbor n18 = new neighbor("Indian ");
		neighbor n19 = new neighbor("Irish ");
		neighbor n20 = new neighbor("Italian ");
		neighbor n21 = new neighbor("Jamaican ");
		neighbor n22 = new neighbor("Japanese ");
		neighbor n23 = new neighbor("Korean ");
		neighbor n24 = new neighbor("Mexican ");
		neighbor n25 = new neighbor("Middle Eastern");
		neighbor n26 = new neighbor("Pancakes /Waffles");
		neighbor n27 = new neighbor("Pizza ");
		neighbor n28 = new neighbor("Polynesian ");
		neighbor n29 = new neighbor("Russian ");
		neighbor n30 = new neighbor("Sandwiches ");
		neighbor n31 = new neighbor("Seafood ");
		neighbor n32 = new neighbor("Scandinavian ");
		neighbor n33 = new neighbor("Spanish ");
		neighbor n34 = new neighbor("Soul Food ");
		neighbor n35 = new neighbor("South American ");
		neighbor n36 = new neighbor("Steak ");
		neighbor n37 = new neighbor("Vegetarian");
		neighbor n38 = new neighbor("Tex-Mex ");
		neighbor n39 = new neighbor("Thai ");
		neighbor n40 = new neighbor("Vietnamese ");
		neighbor n41 = new neighbor("Wild Game");
		list_cusine.add(n1);
		list_cusine.add(n2);
		list_cusine.add(n3);
		list_cusine.add(n4);
		list_cusine.add(n5);
		list_cusine.add(n6);
		list_cusine.add(n7);
		list_cusine.add(n8);
		list_cusine.add(n9);
		list_cusine.add(n10);
		list_cusine.add(n11);
		list_cusine.add(n12);
		list_cusine.add(n13);
		list_cusine.add(n14);
		list_cusine.add(n15);
		list_cusine.add(n16);
		list_cusine.add(n17);
		list_cusine.add(n18);
		list_cusine.add(n19);
		list_cusine.add(n20);
		list_cusine.add(n21);
		list_cusine.add(n22);
		list_cusine.add(n23);
		list_cusine.add(n24);
		list_cusine.add(n25);
		list_cusine.add(n26);
		list_cusine.add(n27);
		list_cusine.add(n28);
		list_cusine.add(n29);
		list_cusine.add(n30);
		list_cusine.add(n31);
		list_cusine.add(n32);
		list_cusine.add(n33);
		list_cusine.add(n34);
		list_cusine.add(n35);
		list_cusine.add(n36);
		list_cusine.add(n37);
		list_cusine.add(n38);
		list_cusine.add(n39);
		list_cusine.add(n40);
		list_cusine.add(n41);

	}
	
	
	// public void setEditTextFocus(EditText searchEditText, boolean isFocused)
	// {
	// searchEditText.setCursorVisible(isFocused);
	// searchEditText.setFocusable(isFocused);
	// searchEditText.setFocusableInTouchMode(isFocused);
	// if (isFocused) {
	// searchEditText.requestFocus();
	// } else {
	// InputMethodManager inputManager = (InputMethodManager)
	// getSystemService(Context.INPUT_METHOD_SERVICE);
	// inputManager.hideSoftInputFromWindow(searchEditText.getWindowToken(),
	// InputMethodManager.HIDE_NOT_ALWAYS );
	// }
	// }

}
