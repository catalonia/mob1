package test;

import java.util.ArrayList;

import com.adapter.AdapterNeighbor;
import com.model.Tips;
import com.model.neighbor;
import com.tastesync.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class test1Activity extends Activity {
	ImageView Back;
	String nameshop, price,title,content;
	int ratting, size, vitri;
	private TextView tvNameView, tvPriceView, tvTittle, tvContent;
	private RatingBar RattingView;
	Tips tip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_and_tip_item);

		tvNameView = (TextView) findViewById(R.id.txtName);
		tvPriceView = (TextView) findViewById(R.id.txtPrice);
		RattingView = (RatingBar) findViewById(R.id.ratingbar);
		tvTittle = (TextView) findViewById(R.id.tv_title_item);
		tvContent = (TextView) findViewById(R.id.tv_content_item);

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
		title=i.getStringExtra("title");
		content=i.getStringExtra("content");
		
		tvTittle.setText(title);
		tvContent.setText(content);
		

		Back = (ImageView) findViewById(R.id.imageBack3);
		Back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
