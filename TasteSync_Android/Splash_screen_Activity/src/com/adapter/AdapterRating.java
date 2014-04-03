package com.adapter;

import java.util.ArrayList;

import com.model.Rating;
import com.model.neighbor;
import com.tastesync.R;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterRating extends BaseAdapter {

	public Context context;
	public ArrayList<Rating> listrating;
	public Resources res;

	public AdapterRating(Context context, ArrayList<Rating> items,Resources resLocal) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listrating = items;
		this.res=resLocal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listrating.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listrating.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Rating item = listrating.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_rating, null);

		}

		ImageView itemrow = (ImageView) convertView
				.findViewById(R.id.img_rating_label);
		ImageView itemck = (ImageView) convertView
				.findViewById(R.id.tick_rating);

		//itemtext.setText(item.getName());
		itemrow.setBackgroundResource(res.getIdentifier(
				"com.tastesync:drawable/"
						+ item.getImage(), null, null));
		if (item.isVisible() == false) {
			Log.d("test", "" + item.isVisible());
			itemck.setVisibility(View.INVISIBLE);
		} else {
			itemck.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

}
