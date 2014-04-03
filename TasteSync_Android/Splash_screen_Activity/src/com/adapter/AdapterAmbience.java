package com.adapter;

import java.util.ArrayList;

import com.activity.AmbienceActivity;
import com.activity.CusineActivity;
import com.activity.PriceActivity;
import com.activity.WhowithyouActivity;
import com.model.Ambience;
import com.model.neighbor;
import com.tastesync.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class AdapterAmbience extends BaseAdapter {

	/*********** Declare Used Variables *********/
	public Context context;
	private ArrayList<Ambience> mArrayList;
	Ambience tempValues = null;
	public Resources res;
	int i = 0;

	/************* CustomAdapter Constructor *****************/
	public AdapterAmbience(Context context, ArrayList<Ambience> items,Resources resLocal) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.mArrayList = items;
		this.res=resLocal;
	}

	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {

		if (mArrayList.size() <= 0)
			return 1;
		return mArrayList.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		tempValues = (Ambience) mArrayList.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_ambience, null);
		}

		LinearLayout mLayout = (LinearLayout) convertView
				.findViewById(R.id.layout_test);
		TextView itemtext = (TextView) convertView.findViewById(R.id.tv_ambien);
		ImageView tick = (ImageView) convertView
				.findViewById(R.id.img_ambien);
		mLayout.setBackgroundResource(res.getIdentifier(
				"com.tastesync:drawable/"
						+ tempValues.getImage(), null, null));
		itemtext.setText(tempValues.getCompanyName());
		if (tempValues.isVisible() == false) {
			Log.d("test",""+ tempValues.isVisible());
			tick.setVisibility(View.INVISIBLE);
		} else {
			tick.setVisibility(View.VISIBLE);
		}
		return convertView;
	}
}