package com.adapter;

import java.util.List;

import test.test1Activity;

import com.model.Contacts;
import com.tastesync.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.sax.StartElementListener;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterContact extends ArrayAdapter<Contacts> {

	private Activity activity;
	private List<Contacts> items;
	private int row;
	private Contacts objBean;

	public AdapterContact(Activity act, int row, List<Contacts> items) {
		super(act, row, items);

		this.activity = act;
		this.row = row;
		this.items = items;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((items == null) || ((position + 1) > items.size()))
			return view;

		objBean = items.get(position);

		holder.tvname = (TextView) view.findViewById(R.id.tvname);
		holder.img_phone = (ImageView) view.findViewById(R.id.img_phone);
		//holder.img_taste = (ImageView) view.findViewById(R.id.img_check);
		holder.img_email = (ImageView) view.findViewById(R.id.img_email);

		if (holder.tvname != null && null != objBean.getName()
				&& objBean.getName().trim().length() > 0) {
			holder.tvname.setText(Html.fromHtml(objBean.getName()));
		}
		if (objBean.getVisible() == false) {
			Log.d("test", "" + objBean.getVisible());
			//holder.img_taste.setVisibility(View.INVISIBLE);
		} else {
			//holder.img_taste.setVisibility(View.VISIBLE);
		}
		if (objBean.getPhone().length() > 0) {
			holder.img_phone.setVisibility(View.VISIBLE);
			holder.img_phone.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent smsIntent = new Intent(Intent.ACTION_VIEW);

					smsIntent.putExtra("sms_body", "I am looking for a restaurant in NewYork.");
					smsIntent.putExtra("address", "0905660373");
					smsIntent.setType("vnd.android-dir/mms-sms");
					getContext().startActivity(smsIntent);
				}
			});
		} else {

			holder.img_phone.setVisibility(View.INVISIBLE);
		}

		return view;
	}

	public class ViewHolder {
		public TextView tvname;
		ImageView img_phone, img_taste, img_email;
	}

}
