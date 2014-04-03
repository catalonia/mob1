package com.adapter;

import java.util.ArrayList;

import com.model.Restaurant;
import com.tastesync.R;

import android.R.bool;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdapterProfileRestaurant extends BaseAdapter implements Filterable {

	public Context context;
	public ArrayList<Restaurant> arraylist;

	// private ArrayFilter mFilter;
	private ArrayList<Restaurant> arrayListSearch;
	private ArrayList<Restaurant> arrayListOld;

	private final Object mLock = new Object();
	private boolean check = false;

	public AdapterProfileRestaurant(Context context,
			ArrayList<Restaurant> arrayList) {
		this.context = context;
		this.arraylist = arrayList;
		this.arrayListOld = arrayList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arraylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arraylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Restaurant item = arraylist.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_profile_restaurant,
					null);
		}
		LinearLayout itemIcon = (LinearLayout) convertView
				.findViewById(R.id.layout_profile_res_like);
		TextView itemName = (TextView) convertView
				.findViewById(R.id.txt_profile_res_name);
		TextView itemPrice = (TextView) convertView
				.findViewById(R.id.txt_profile_res_price);

		if (item.isVisible() == true) {
			itemIcon.setBackgroundResource(R.drawable.ic_saved_on);
		} else {
			itemIcon.setBackgroundResource(R.drawable.ic_bt_addedtomyfaves);
		}

		itemName.setText(item.getName());
		itemPrice.setText(item.getPrice());
		// itemRatting.setRating(item.getRatting());

		return convertView;

	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}
}