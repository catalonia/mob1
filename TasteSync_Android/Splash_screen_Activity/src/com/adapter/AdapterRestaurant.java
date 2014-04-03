package com.adapter;

import java.util.ArrayList;

import com.model.Restaurant;
import com.tastesync.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdapterRestaurant extends BaseAdapter implements Filterable {

	public Context context;
	public ArrayList<Restaurant> arrayList;

	private ArrayFilter mFilter;
	private ArrayList<Restaurant> arrayListSearch;
	private ArrayList<Restaurant> arrayListOld;

	private final Object mLock = new Object();

	public AdapterRestaurant(Context context, ArrayList<Restaurant> arrayList) {
		this.context = context;
		this.arrayList = arrayList;
		this.arrayListOld = arrayList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Restaurant item = arrayList.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_restaurant, null);
		}

		TextView itemName = (TextView) convertView.findViewById(R.id.txtName);
		TextView itemPrice = (TextView) convertView.findViewById(R.id.txtPrice);

		RatingBar itemRatting = (RatingBar) convertView
				.findViewById(R.id.small_ratingbar);

		itemName.setText(item.getName());
		itemPrice.setText(item.getPrice());
		itemRatting.setRating(item.getRatting());

		return convertView;

	}

	public void updateData(ArrayList<Restaurant> update) {
		arrayList.clear();
		for (int i = 0; i < update.size(); i++) {
			arrayList.add(update.get(i));
		}
		notifyDataSetChanged();
	}

	public Filter getFilter() {
		if (mFilter == null) {
			mFilter = new ArrayFilter();
		}
		return mFilter;
	}

	private class ArrayFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			FilterResults results = new FilterResults();

			if (arrayListSearch == null) {
				synchronized (mLock) {
					arrayListSearch = new ArrayList<Restaurant>();
				}
			}

			if (prefix == null || prefix.length() == 0) {
				synchronized (mLock) {
					results.values = arrayListOld;
					results.count = arrayListOld.size();
				}
			} else {
				String prefixString = prefix.toString().toLowerCase();
				final int count = arrayListOld.size();

				final ArrayList<Restaurant> newValues = new ArrayList<Restaurant>(count);

				for (int i = 0; i < count; i++) {
					final Restaurant value = arrayListOld.get(i);
					if (value.getName().toLowerCase().trim()
							.contains(prefixString)) {
						newValues.add(value);
					}
				}

				results.values = newValues;
				results.count = newValues.size();
			}

			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			// noinspection unchecked
			arrayList = (ArrayList<Restaurant>) results.values;
			if (results.count > 0) {
				notifyDataSetChanged();
			} else {
				notifyDataSetInvalidated();
			}
		}
	}
}
