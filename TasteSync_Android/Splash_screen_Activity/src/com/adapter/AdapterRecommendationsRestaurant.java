package com.adapter;

import java.util.ArrayList;

import com.model.Profile;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdapterRecommendationsRestaurant extends BaseAdapter implements
		Filterable {

	public Context context;
	public ArrayList<Restaurant> arraylistRes;

	// private ArrayFilter mFilter;
	// private ArrayList<Restaurant> arrayListSearch;
	private ArrayList<Restaurant> arrayListOld;

	private final Object mLock = new Object();
	private boolean check = false;

	public AdapterRecommendationsRestaurant(Context context,
			ArrayList<Restaurant> arraylistRes) {
		this.context = context;
		this.arraylistRes = arraylistRes;
		//this.arrayListOld = arrayList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arraylistRes.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arraylistRes.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Restaurant item = arraylistRes.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(
					R.layout.item_recommendations_restaurant, null);
		}		
		TextView itemNameRes = (TextView) convertView
				.findViewById(R.id.tv_recom_res_nameRes);
		TextView itemPriceRes = (TextView) convertView
				.findViewById(R.id.tv_recom_res_priceRes);
		TextView itemUsername = (TextView) convertView
				.findViewById(R.id.tv_recom_res_username);
		TextView itemRecom = (TextView) convertView
				.findViewById(R.id.tv_recom_res_recom);
		ImageView itemAvatar=(ImageView)convertView.findViewById(R.id.img_recom_res_avatar);
		
		itemNameRes.setText(item.getName());
		itemPriceRes.setText(item.getPrice());
		//itemUsername.setText(item.getRecommendations().getProfile().getUsername());
		//itemRecom.setText(item.getRecommendations().getDescription());
		itemAvatar.setImageResource(R.drawable.avatar);
		// itemRatting.setRating(item.getRatting());

		return convertView;

	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}
}