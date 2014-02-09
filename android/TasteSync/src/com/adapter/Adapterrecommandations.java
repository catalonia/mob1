package com.adapter;

import java.util.ArrayList;

import com.activity.FistLoginActivity;
import com.activity.RecommendActivity;
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
import android.widget.TextView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class Adapterrecommandations extends BaseAdapter implements
		OnClickListener {

	/*********** Declare Used Variables *********/
	private Activity activity;
	private ArrayList data;
	private static LayoutInflater inflater = null;
	public Resources res;
	recommandations tempValues = null;
	int i = 0;

	/************* CustomAdapter Constructor *****************/
	public Adapterrecommandations(Activity a, ArrayList d, Resources resLocal) {

		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;

		/*********** Layout inflator to call external xml layout () **********************/
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {

		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	/********* Create a holder to contain inflated xml file elements ***********/
	public static class ViewHolder {

		public TextView text_name;
		public TextView text_title;
		public TextView text_content;
		public TextView textWide;
		public ImageView image;

	}

	/*********** Depends upon data size called for each row , Create each ListView row ***********/
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/********** Inflate tabitem.xml file for each row ( Defined below ) ************/
			vi = inflater.inflate(R.layout.item_recommandations, null);

			/******** View Holder Object to contain tabitem.xml file elements ************/
			holder = new ViewHolder();
			holder.text_title = (TextView)vi.findViewById(R.id.tv_item_title);
			holder.text_name = (TextView) vi.findViewById(R.id.tv_name);
			holder.text_content = (TextView) vi.findViewById(R.id.tv_content);
			holder.image = (ImageView) vi.findViewById(R.id.avatar);

			/************ Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) {
			holder.text_name.setText("No Data");

		} else {
			tempValues = null;
			tempValues = (recommandations) data.get(position);

			holder.text_name.setText(tempValues.getName());
			holder.text_title.setText(tempValues.gettitle());
			holder.text_content.setText(tempValues.getconttent());
			holder.image.setImageResource(res.getIdentifier(
					"com.tastesync:drawable/" + tempValues.getImage(), null,
					null));

			vi.setOnClickListener(new OnItemClickListener(position));
		}
		return vi;
	}

	@Override
	public void onClick(View v) {
		Log.v("CustomAdapter", "=====Row button clicked");
	}

	/********* Called when Item click in ListView ************/
	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;
		}

		@Override
		public void onClick(View arg0) {
			RecommendActivity sct = (RecommendActivity) activity;
			sct.onItemClick(mPosition);
		}
	}
}