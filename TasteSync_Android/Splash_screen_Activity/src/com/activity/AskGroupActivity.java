package com.activity;

import java.util.ArrayList;


import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class AskGroupActivity extends TabGroupActivity {
	private Handler handler = new Handler();
	public static AskGroupActivity group;
	public static ArrayList<View> arrList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AskGroupActivity.arrList = new ArrayList<View>();
		group = this;

		View view = getLocalActivityManager().startActivity(
				"AskActivity",
				new Intent(this, AskActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView();
		replaceView(view);
	}

	public void replaceView(View view) {

		arrList.add(view);
		setContentView(view);
	}

	public void back() {
		if (arrList.size() > 1) {
			arrList.remove(arrList.size() - 1);
			/*if (arrList.size() == 1) {
				View view = getLocalActivityManager().startActivity(
						"Setting",
						new Intent(this, AskActivity.class)
								.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
						.getDecorView();
				setContentView(view);
			} else {*/
				View view = arrList.get(arrList.size() - 1);
				setContentView(view);
			//}
		} else {
			this.finish();
		}
	}

//	public void onActivityResultRecommendation() {
//		AskGroupActivity.group.back();
//		handler.postDelayed(actionTab3, 2000);
//		
//	}
//	private Runnable actionTab3 = new Runnable() {
//		public void run() {
//			GlobalVariable.isSwitchToRes = true;
//			TabActivity tabActivity = (TabActivity) getParent();
//			tabActivity.getTabHost().setCurrentTab(2);
//			AskGroupActivity.group.back();
//		}
//	};
	@Override
	public void onBackPressed() {
		AskGroupActivity.group.back();
	}
}




//package com.activity;
//
//import com.tastesync.R;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TabHost;
//
//public class AskGroupActivity extends TabGroupActivity {
//	String neighbor, ambience, price, whowithyou, cusine;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		startChildActivity("AskActivity", new Intent(this, AskActivity.class));
//		// recivedata();
//		// Intent askIntent = new Intent(this, AskActivity.class);
//		// askIntent.putExtra("neighbor", neighbor);
//		// askIntent.putExtra("ambience", ambience);
//		// askIntent.putExtra("price", price);
//		// askIntent.putExtra("whowithyou", whowithyou);
//		// askIntent.putExtra("cusine", cusine);
//		// startChildActivity("AskActivity", askIntent);
//	}
//
//	
//
//	// public void recivedata() {
//	// Bundle mBundle = getIntent().getExtras();
//	// if (mBundle != null) {
//	// neighbor = mBundle.getString("neighbor");
//	// ambience = mBundle.getString("ambience");
//	// price = mBundle.getString("price");
//	// whowithyou = mBundle.getString("whowithyou");
//	// cusine = mBundle.getString("cusine");
//	// }
//	// }
//}
//// }
////
//// public void senddata() {
////
//// }
//

