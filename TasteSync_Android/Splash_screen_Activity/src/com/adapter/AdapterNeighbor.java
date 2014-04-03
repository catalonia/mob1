package com.adapter;

import java.util.ArrayList;

import com.model.neighbor;
import com.tastesync.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterNeighbor extends BaseAdapter {

	public Context context;
	public ArrayList<neighbor> listneighbor;

	public AdapterNeighbor(Context context, ArrayList<neighbor> items) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listneighbor = items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listneighbor.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listneighbor.get(position);
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
		final neighbor item = listneighbor.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_neighbor, null);
			
		}

		TextView itemtext = (TextView) convertView.findViewById(R.id.label);
		ImageView itemck = (ImageView) convertView
				.findViewById(R.id.tick_neighbor);

		itemtext.setText(item.getName());
		if (item.isVisible() == false) {
			Log.d("test",""+ item.isVisible());
			itemck.setVisibility(View.INVISIBLE);
		} else {
			itemck.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

}
