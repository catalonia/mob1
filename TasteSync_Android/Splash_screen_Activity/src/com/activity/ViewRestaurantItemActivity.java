package com.activity;

import test.test1Activity;

import com.tastesync.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class ViewRestaurantItemActivity extends Activity {

	private TextView tvNameView, tvPriceView, tvOpen, tv_save, tv_favos,
			tv_tips1, tv_tips2;
	private RatingBar RattingView;
	private LinearLayout layout_tip, layout_restphoto, layout_tip1,
			layout_back;
	boolean check = false, check1 = false;
	ImageView img_leave_a_tip, img_save, img_addtofavos, img_menu, img_more,
			img_ask, img_back, img_tips, img_photos, img_next_tips,
			img_share_view_res;
	String nameshop, price;
	int ratting, size, vitri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_restaurant);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		img_share_view_res = (ImageView) findViewById(R.id.img_share_view_res);
		tv_save = (TextView) findViewById(R.id.tv_save);
		tv_favos = (TextView) findViewById(R.id.tv_favos);
		tvNameView = (TextView) findViewById(R.id.txtNameView);
		tvPriceView = (TextView) findViewById(R.id.txtPriceView);
		RattingView = (RatingBar) findViewById(R.id.small_ratingbar_view);
		img_leave_a_tip = (ImageView) findViewById(R.id.img_leave);
		img_save = (ImageView) findViewById(R.id.img_save);
		img_menu = (ImageView) findViewById(R.id.img_menu);
		img_more = (ImageView) findViewById(R.id.img_more);
		img_ask = (ImageView) findViewById(R.id.img_ask);
		img_tips = (ImageView) findViewById(R.id.img_tips);
		img_next_tips = (ImageView) findViewById(R.id.img_next_tips);
		img_photos = (ImageView) findViewById(R.id.img_photos);
		img_addtofavos = (ImageView) findViewById(R.id.img_favos);
		img_back = (ImageView) findViewById(R.id.imageBack);
		tvOpen = (TextView) findViewById(R.id.txtOpen);
		layout_tip = (LinearLayout) findViewById(R.id.layout_tips);
		layout_tip1 = (LinearLayout) findViewById(R.id.layout_tips1);
		layout_restphoto = (LinearLayout) findViewById(R.id.layout_restphoto);
		img_tips = (ImageView) findViewById(R.id.img_tips);
		tv_tips1 = (TextView) findViewById(R.id.txt_tips1);
		tv_tips2 = (TextView) findViewById(R.id.txt_tips2);
		layout_back = (LinearLayout) findViewById(R.id.layout_back);
	}

	private void handle() {
		// TODO Auto-generated method stub
		Intent i = getIntent();

		nameshop = i.getStringExtra("nameshop");
		price = i.getStringExtra("price");
		ratting = i.getIntExtra("ratting", -1);
		size = i.getIntExtra("size", -1);

		Bundle bundle = i.getBundleExtra("sendname");
		vitri = bundle.getInt("vitri");
		for (int j = 0; j <= size; j++) {
			if (vitri == j) {
				tvNameView.setText("" + nameshop);
				tvPriceView.setText("" + price);
				RattingView.setRating(ratting);
			}

		}
		img_tips.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		img_next_tips.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		tv_tips1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		tv_tips2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		img_share_view_res.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(ViewRestaurantItemActivity.this,
						AskfreindActivity.class);
				// View view1 = RestaurantGroupActivity.group
				// .getLocalActivityManager()
				// .startActivity("Askfreind2Activity",
				// mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				// .getDecorView();
				// RestaurantGroupActivity.group.replaceView(view1);
				startActivity(mIntent);
			}
		});
		img_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check) {
					img_save.setImageResource(android.R.color.transparent);
					img_save.setBackgroundResource(R.drawable.ic_saved);
					tv_save.setText("Tried Later");
					check = false;
				} else {
					img_save.setImageResource(android.R.color.transparent);
					img_save.setBackgroundResource(R.drawable.ic_saved_on);
					check = true;
					tv_save.setText("Try Later");
				}
			}
		});
		img_addtofavos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check1) {
					img_addtofavos
							.setImageResource(android.R.color.transparent);
					img_addtofavos
							.setBackgroundResource(R.drawable.ic_bt_addtomyfaves);
					tv_favos.setText("Add to Favs");
					check1 = false;
				} else {
					img_addtofavos
							.setImageResource(android.R.color.transparent);
					img_addtofavos
							.setBackgroundResource(R.drawable.ic_bt_addedtomyfaves);
					tv_favos.setText("Added to Favs");
					check1 = true;
				}
			}
		});
		img_menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(ViewRestaurantItemActivity.this,
						RestaurantmenuActivity.class);
				startActivity(mIntent);
			}
		});
		img_ask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(ViewRestaurantItemActivity.this,
						RestaurantaskActivity.class);
				startActivity(mIntent);
			}
		});
		img_more.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(ViewRestaurantItemActivity.this,
						RestaurantmoreActivity.class);
				Bundle bundle = new Bundle();

				bundle.putInt("vitri", vitri);

				mIntent.putExtra("sendname", bundle);
				mIntent.putExtra("nameshop", nameshop);
				mIntent.putExtra("price", price);
				mIntent.putExtra("ratting", ratting);
				mIntent.putExtra("size", size);
				startActivity(mIntent);
			}
		});
		img_leave_a_tip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(ViewRestaurantItemActivity.this,
						LeaveaTipActivity.class);
				Bundle bundle = new Bundle();

				bundle.putInt("vitri", vitri);

				mIntent.putExtra("sendname", bundle);
				mIntent.putExtra("nameshop", nameshop);
				mIntent.putExtra("price", price);
				mIntent.putExtra("ratting", ratting);
				mIntent.putExtra("size", size);

				startActivity(mIntent);
			}
		});
		layout_tip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		layout_tip1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listtip();
			}
		});
		img_photos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				list_restphoto();
			}
		});
		layout_restphoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				list_restphoto();
			}
		});
		layout_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void listtip() {
		Intent mIntent = new Intent(this, TipsActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("vitri", vitri);
		mIntent.putExtra("sendname", bundle);
		mIntent.putExtra("nameshop", nameshop);
		mIntent.putExtra("price", price);
		mIntent.putExtra("ratting", ratting);
		mIntent.putExtra("size", size);
		startActivity(mIntent);
	}

	public void list_restphoto() {
		Intent mIntent = new Intent(this, Restaurant_photo_Activity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("vitri", vitri);
		mIntent.putExtra("sendname", bundle);
		mIntent.putExtra("nameshop", nameshop);
		mIntent.putExtra("price", price);
		mIntent.putExtra("ratting", ratting);
		mIntent.putExtra("size", size);
		startActivity(mIntent);
	}
}
