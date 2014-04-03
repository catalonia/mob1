package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterNeighbor;
import com.model.neighbor;
import com.tastesync.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class NeighborActivity extends Activity {

	ListView lv;
	Button btn_done;
	String kq = "";
	EditText mEditText;
	public ArrayList<neighbor> listNeighbor, searchResults;
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

		listNeighbor = new ArrayList<neighbor>();
		setlist();
		recivedata();
		refreshData();

		listneighboradapter = new AdapterNeighbor(this, listNeighbor);
		lv.setAdapter(listneighboradapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (listNeighbor.get(position).isVisible()) {
					listNeighbor.get(position).setVisible(false);
					kq = "";
					if (mStrings.size() > 0) {
						mStrings.remove(0);
					}
				} else {
					for (int i = 0; i < listNeighbor.size(); i++) {
						if (listNeighbor.get(i).isVisible()) {
							listNeighbor.get(i).setVisible(false);
							kq = "";
							if (mStrings.size() > 0) {
								mStrings.remove(0);
							}
						}
						listNeighbor.get(position).setVisible(true);
					}
					kq += listNeighbor.get(position).getName();
					mStrings.add(listNeighbor.get(position).getName());
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
					kq = "New York";
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

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String searchString = mEditText.getText().toString();
				int textLength = searchString.length();
				searchResults = new ArrayList<neighbor>();

				// clear the initial data set
				searchResults.clear();

				for (int i = 0; i < listNeighbor.size(); i++) {
					String values = listNeighbor.get(i).getName().toString();

					if (textLength <= values.length()) {
						if (searchString.equalsIgnoreCase(values.substring(0,
								textLength)))
							searchResults.add(listNeighbor.get(i));
						listneighboradapter = new AdapterNeighbor(
								NeighborActivity.this, searchResults);
						lv.setAdapter(listneighboradapter);
					}
				}
				lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// if (searchResults.get(position).isVisible()) {
						// searchResults.get(position).setVisible(false);
						// kq = "";
						// if (mStrings.size() > 0) {
						// mStrings.remove(0);
						// }
						// } else {
						// for (int i = 0; i < searchResults.size(); i++) {
						// if (searchResults.get(i).isVisible()) {
						// searchResults.get(i).setVisible(false);
						// kq = "";
						// if (mStrings.size() > 0) {
						// mStrings.remove(0);
						// }
						// }
						// searchResults.get(position).setVisible(true);
						// }
						// kq += searchResults.get(position).getName();
						// mStrings.add(searchResults.get(position).getName());
						// }
						// listneighboradapter.notifyDataSetChanged();
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
			for (int j = 0; j < listNeighbor.size(); j++) {
				String tam1 = listNeighbor.get(j).getName();
				if (tam1.equals(tam)) {
					listNeighbor.get(j).setVisible(true);
				}
			}
		}
	}

	public void setlist() {
		neighbor n1 = new neighbor("New York, NY");
		neighbor n2 = new neighbor("Alphabet City");
		neighbor n3 = new neighbor("Ansonia");
		neighbor n4 = new neighbor("Battery Park City");
		neighbor n5 = new neighbor("Bedford-Stuyvesant");
		neighbor n6 = new neighbor("Beekman");
		neighbor n7 = new neighbor("Bellevue");
		neighbor n8 = new neighbor("Bowery");
		neighbor n9 = new neighbor("Briarwood");
		neighbor n10 = new neighbor("Brooklyn Heights");
		neighbor n11 = new neighbor("Bushwick");
		neighbor n12 = new neighbor("Carnegie Hill");
		neighbor n13 = new neighbor("Central Harlem");
		neighbor n14 = new neighbor("Chelsea");
		neighbor n15 = new neighbor("Chinatown");
		neighbor n16 = new neighbor("Chinatown/Little Italy");
		neighbor n17 = new neighbor("City Hall");
		neighbor n18 = new neighbor("Civic Center");
		neighbor n19 = new neighbor("Clinton");
		neighbor n20 = new neighbor("Corona");
		neighbor n21 = new neighbor("Downtown Brooklyn");
		neighbor n22 = new neighbor("Downtown Flushing");
		neighbor n23 = new neighbor("Downtown New York");
		neighbor n24 = new neighbor("Dumbo");
		neighbor n25 = new neighbor("Dutch Kills");
		neighbor n26 = new neighbor("East 30s");
		neighbor n27 = new neighbor("East 40s");
		neighbor n28 = new neighbor("East 50s");
		neighbor n29 = new neighbor("East 60s");
		neighbor n30 = new neighbor("East 70s");
		neighbor n31 = new neighbor("East 80s");
		neighbor n32 = new neighbor("East 90s");
		neighbor n33 = new neighbor("East Flatbush");
		neighbor n34 = new neighbor("East Harlem");
		neighbor n35 = new neighbor("East Harlem (El Barrio)");
		neighbor n36 = new neighbor("East Side");
		neighbor n37 = new neighbor("East Village");
		neighbor n38 = new neighbor("Elmhurst");
		neighbor n39 = new neighbor("Financial District");
		neighbor n40 = new neighbor("Flatbush");
		neighbor n41 = new neighbor("Flatiron");
		neighbor n42 = new neighbor("Flushing");
		neighbor n43 = new neighbor("Fort George");
		neighbor n44 = new neighbor("Fort Greene");
		neighbor n45 = new neighbor("Fulton Ferry");
		neighbor n46 = new neighbor("Garment District");
		neighbor n47 = new neighbor("Gov. Alfred e Smith Houses");
		neighbor n48 = new neighbor("Gowanus");
		neighbor n49 = new neighbor("Gramercy");
		neighbor n50 = new neighbor("Greenpoint");
		neighbor n51 = new neighbor("Greenwich Village");
		neighbor n52 = new neighbor("Hamilton Grange");
		neighbor n53 = new neighbor("Hamilton Heights");
		neighbor n54 = new neighbor("Harlem");
		neighbor n55 = new neighbor("Hell's Kitchen");
		neighbor n56 = new neighbor("Highbridge");
		neighbor n57 = new neighbor("Hudson Heights");
		neighbor n58 = new neighbor("Hunters Point");
		neighbor n59 = new neighbor("Inwood");
		neighbor n60 = new neighbor("Jackson Heights");
		neighbor n61 = new neighbor("Jamaica");
		neighbor n62 = new neighbor("Kingsbridge Heights");
		neighbor n63 = new neighbor("Kips Bay");
		neighbor n64 = new neighbor("Knickerbocker Village");
		neighbor n65 = new neighbor("Koreatown");
		neighbor n66 = new neighbor("LeFrak City");
		neighbor n67 = new neighbor("Lenox Hill");
		neighbor n68 = new neighbor("Lincoln Center");
		neighbor n69 = new neighbor("Lincoln Square");
		neighbor n70 = new neighbor("Little Germany");
		neighbor n71 = new neighbor("Little Italy");
		neighbor n72 = new neighbor("LoDel");
		neighbor n73 = new neighbor("LoHo");
		neighbor n74 = new neighbor("Loisaida");
		neighbor n75 = new neighbor("Long Island City");
		neighbor n76 = new neighbor("Lower East Side");
		neighbor n77 = new neighbor("Lower Manhattan");
		neighbor n78 = new neighbor("Manhattan Valley");
		neighbor n79 = new neighbor("Manhattanville");
		neighbor n80 = new neighbor("Meatpacking District");
		neighbor n81 = new neighbor("Medical Centre");
		neighbor n82 = new neighbor("Midtown");
		neighbor n83 = new neighbor("Midtown Center");
		neighbor n84 = new neighbor("Midtown East");
		neighbor n85 = new neighbor("Midtown South");
		neighbor n86 = new neighbor("Midtown South Chelsea");
		neighbor n87 = new neighbor("Midtown West");
		neighbor n88 = new neighbor("Morningside Heights");
		neighbor n89 = new neighbor("Morningside Hts - Harlem");
		neighbor n90 = new neighbor("Morris Heights");
		neighbor n91 = new neighbor("Murray Hill");
		neighbor n92 = new neighbor("NoHo");
		neighbor n93 = new neighbor("NoLita");
		neighbor n94 = new neighbor("North Corona");
		neighbor n95 = new neighbor("North Side");
		neighbor n96 = new neighbor("N. Williamsburg - North Side");
		neighbor n97 = new neighbor("Ocean Parkway");
		neighbor n98 = new neighbor("Park Slope");
		neighbor n99 = new neighbor("Queensboro Hills");
		neighbor n100 = new neighbor("Queensbridge");
		neighbor n101 = new neighbor("Ravenswood");
		neighbor n102 = new neighbor("Rockefeller Center Midtown");
		neighbor n103 = new neighbor("Roosevelt Island");
		neighbor n104 = new neighbor("Rose Hill");
		neighbor n105 = new neighbor("San Juan Hill");
		neighbor n106 = new neighbor("Seaport");
		neighbor n107 = new neighbor("SOHO");
		neighbor n108 = new neighbor("South Brooklyn");
		neighbor n109 = new neighbor("South Side");
		neighbor n110 = new neighbor("South Slope");
		neighbor n111 = new neighbor("South Street Seaport");
		neighbor n112 = new neighbor("South Village");
		neighbor n113 = new neighbor("Spanish Harlem");
		neighbor n114 = new neighbor("SPURA");
		neighbor n115 = new neighbor("St. Nicholas Terrace");
		neighbor n116 = new neighbor("Steinway");
		neighbor n117 = new neighbor("Stuyvesant Town");
		neighbor n118 = new neighbor("Sugar Hill");
		neighbor n119 = new neighbor("Sunnyside");
		neighbor n120 = new neighbor("Sutton Place");
		neighbor n121 = new neighbor("Tenderloin");
		neighbor n122 = new neighbor("Theatre District");
		neighbor n123 = new neighbor("Tribeca");
		neighbor n124 = new neighbor("Tudor City");
		neighbor n125 = new neighbor("Tulton Ferry");
		neighbor n126 = new neighbor("Turtle Bay");
		neighbor n127 = new neighbor("Two Bridges");
		neighbor n128 = new neighbor("Undercliff");
		neighbor n129 = new neighbor("Union Square");
		neighbor n130 = new neighbor("Upper East Side");
		neighbor n131 = new neighbor("Upper West Side");
		neighbor n132 = new neighbor("Uptown");
		neighbor n133 = new neighbor("Wall Street");
		neighbor n134 = new neighbor("Washington Heights");
		neighbor n135 = new neighbor("Washington Hts - Inwood");
		neighbor n136 = new neighbor("West 30s");
		neighbor n137 = new neighbor("West 40s");
		neighbor n138 = new neighbor("West 50s");
		neighbor n139 = new neighbor("West 80s");
		neighbor n140 = new neighbor("West Side");
		neighbor n141 = new neighbor("West Village");
		neighbor n142 = new neighbor("Willets Point");
		neighbor n143 = new neighbor("Williamsburg");
		neighbor n144 = new neighbor("Windsor Terrace");
		neighbor n145 = new neighbor("Woodside");

		listNeighbor.add(n1);
		listNeighbor.add(n2);
		listNeighbor.add(n3);
		listNeighbor.add(n4);
		listNeighbor.add(n5);
		listNeighbor.add(n6);
		listNeighbor.add(n7);
		listNeighbor.add(n8);
		listNeighbor.add(n9);
		listNeighbor.add(n10);
		listNeighbor.add(n11);
		listNeighbor.add(n12);
		listNeighbor.add(n13);
		listNeighbor.add(n14);
		listNeighbor.add(n15);
		listNeighbor.add(n16);
		listNeighbor.add(n17);
		listNeighbor.add(n18);
		listNeighbor.add(n19);
		listNeighbor.add(n20);
		listNeighbor.add(n21);
		listNeighbor.add(n22);
		listNeighbor.add(n23);
		listNeighbor.add(n24);
		listNeighbor.add(n25);
		listNeighbor.add(n26);
		listNeighbor.add(n27);
		listNeighbor.add(n28);
		listNeighbor.add(n29);
		listNeighbor.add(n30);
		listNeighbor.add(n31);
		listNeighbor.add(n32);
		listNeighbor.add(n33);
		listNeighbor.add(n34);
		listNeighbor.add(n35);
		listNeighbor.add(n36);
		listNeighbor.add(n37);
		listNeighbor.add(n38);
		listNeighbor.add(n39);
		listNeighbor.add(n40);
		listNeighbor.add(n41);
		listNeighbor.add(n42);
		listNeighbor.add(n43);
		listNeighbor.add(n44);
		listNeighbor.add(n45);
		listNeighbor.add(n46);
		listNeighbor.add(n47);
		listNeighbor.add(n48);
		listNeighbor.add(n49);
		listNeighbor.add(n50);
		listNeighbor.add(n51);
		listNeighbor.add(n52);
		listNeighbor.add(n53);
		listNeighbor.add(n54);
		listNeighbor.add(n55);
		listNeighbor.add(n56);
		listNeighbor.add(n57);
		listNeighbor.add(n58);
		listNeighbor.add(n59);
		listNeighbor.add(n60);
		listNeighbor.add(n61);
		listNeighbor.add(n62);
		listNeighbor.add(n63);
		listNeighbor.add(n64);
		listNeighbor.add(n65);
		listNeighbor.add(n66);
		listNeighbor.add(n67);
		listNeighbor.add(n68);
		listNeighbor.add(n69);
		listNeighbor.add(n70);
		listNeighbor.add(n71);
		listNeighbor.add(n72);
		listNeighbor.add(n73);
		listNeighbor.add(n74);
		listNeighbor.add(n75);
		listNeighbor.add(n76);
		listNeighbor.add(n77);
		listNeighbor.add(n78);
		listNeighbor.add(n79);
		listNeighbor.add(n80);
		listNeighbor.add(n81);
		listNeighbor.add(n82);
		listNeighbor.add(n83);
		listNeighbor.add(n84);
		listNeighbor.add(n85);
		listNeighbor.add(n86);
		listNeighbor.add(n87);
		listNeighbor.add(n88);
		listNeighbor.add(n89);
		listNeighbor.add(n90);
		listNeighbor.add(n91);
		listNeighbor.add(n92);
		listNeighbor.add(n93);
		listNeighbor.add(n94);
		listNeighbor.add(n95);
		listNeighbor.add(n96);
		listNeighbor.add(n97);
		listNeighbor.add(n98);
		listNeighbor.add(n99);
		listNeighbor.add(n100);
		listNeighbor.add(n101);
		listNeighbor.add(n102);
		listNeighbor.add(n103);
		listNeighbor.add(n104);
		listNeighbor.add(n105);
		listNeighbor.add(n106);
		listNeighbor.add(n107);
		listNeighbor.add(n108);
		listNeighbor.add(n109);
		listNeighbor.add(n110);
		listNeighbor.add(n111);
		listNeighbor.add(n112);
		listNeighbor.add(n113);
		listNeighbor.add(n114);
		listNeighbor.add(n115);
		listNeighbor.add(n116);
		listNeighbor.add(n117);
		listNeighbor.add(n118);
		listNeighbor.add(n119);
		listNeighbor.add(n120);
		listNeighbor.add(n121);
		listNeighbor.add(n122);
		listNeighbor.add(n123);
		listNeighbor.add(n124);
		listNeighbor.add(n125);
		listNeighbor.add(n126);
		listNeighbor.add(n127);
		listNeighbor.add(n128);
		listNeighbor.add(n129);
		listNeighbor.add(n130);
		listNeighbor.add(n131);
		listNeighbor.add(n132);
		listNeighbor.add(n133);
		listNeighbor.add(n134);
		listNeighbor.add(n135);
		listNeighbor.add(n136);
		listNeighbor.add(n137);
		listNeighbor.add(n138);
		listNeighbor.add(n139);
		listNeighbor.add(n140);
		listNeighbor.add(n141);
		listNeighbor.add(n142);
		listNeighbor.add(n143);
		listNeighbor.add(n144);
		listNeighbor.add(n145);
	}

}
